# PRISM Document 5: Implementation / Split Plan


---

## Overview

The implementation is split into 5 phases over ~12 weeks (3 months). Each phase delivers a working vertical slice that builds on the previous one. Teams can work in parallel across frontend and backend within each phase.

---

## Phase 1 — Foundation (Weeks 1–2)

Goal: Project scaffolding, infrastructure baseline, and CI/CD pipeline in place.

| # | Task | Owner | Output |
|---|---|---|---|
| 1.1 | Set up Kubernetes namespace `wheels-ai` on GPU cluster | Infra | Running K8s environment |
| 1.2 | Deploy PostgreSQL StatefulSet with initial schema | Backend | DB with `tenants`, `models`, `subscriptions`, `api_keys`, `usage_daily_rollups` tables |
| 1.3 | Deploy Redis StatefulSet | Backend | Redis instance running |
| 1.4 | Scaffold FastAPI project structure with health check endpoint | Backend | `GET /health` returns 200 |
| 1.5 | Scaffold React + Tailwind frontend project | Frontend | Blank app served via Nginx pod |
| 1.6 | Set up CI/CD pipeline (build, test, deploy to K8s) | Infra | Automated deploys on merge |
| 1.7 | Configure Auth0 or Clerk tenant with Google + GitHub OAuth | Backend | OAuth app credentials ready |

**Exit criteria:** All services deploy cleanly; health checks pass; CI/CD pipeline runs end-to-end.

---

## Phase 2 — Authentication & Model Catalog (Weeks 3–4)

Goal: Users can register, log in, and browse available models.

| # | Task | Owner | Output |
|---|---|---|---|
| 2.1 | Implement `POST /auth/token` — OAuth code exchange, JWT issuance | Backend | Working login flow |
| 2.2 | Add JWT middleware to Platform API (validate on all protected routes) | Backend | Unauthorized requests return 401 |
| 2.3 | Implement `GET /catalog/models` — return active models from DB | Backend | Model list endpoint |
| 2.4 | Implement `POST /admin/models` — operator adds model to catalog | Backend | Admin can add models without code deploy |
| 2.5 | Build Login screen (OAuth buttons, email/password) | Frontend | Working login UI |
| 2.6 | Build Model Catalog screen (list models, metadata display) | Frontend | Browsable catalog |
| 2.7 | Build Admin Panel — add/deactivate model form | Frontend | Operator can manage catalog |

**Exit criteria:** Tenant can log in via Google/GitHub; browse model catalog; operator can add a model via admin UI.

---

## Phase 3 — Subscriptions & API Key Management (Weeks 5–6)

Goal: Tenants can subscribe to models and generate API keys.

| # | Task | Owner | Output |
|---|---|---|---|
| 3.1 | Implement `POST /subscriptions` — create subscription | Backend | Subscription stored in DB |
| 3.2 | Implement `DELETE /subscriptions/{id}` — cancel + revoke keys | Backend | Cancellation cascades to key revocation |
| 3.3 | Implement `POST /keys` — generate cryptographically random key, store hash | Backend | Key returned once in plaintext |
| 3.4 | Implement `DELETE /keys/{id}` — revoke key, invalidate Redis cache | Backend | Key rejected within 60s |
| 3.5 | Implement Redis key cache (TTL 60s, invalidate on revoke) | Backend | Hot-path key validation via Redis |
| 3.6 | Build Subscription screen (subscribe/unsubscribe, active list) | Frontend | Tenant manages subscriptions |
| 3.7 | Build API Key Management screen (create, name, revoke; show metadata only) | Frontend | Tenant manages keys |

**Exit criteria:** Tenant can subscribe to a model, generate a key, revoke it, and confirm revocation within 60 seconds.

---

## Phase 4 — Inference Gateway & Model Invocation (Weeks 7–9)

Goal: Tenants can invoke models via OpenAI-compatible API endpoints.

| # | Task | Owner | Output |
|---|---|---|---|
| 4.1 | Deploy llm-d operator to K8s cluster | Infra | llm-d running |
| 4.2 | Create `ModelDeployment` CRs for Granite, LLaMA-3, Qwen | Infra | vLLM pods running per model |
| 4.3 | Deploy LiteMaaS as Inference Gateway base | Backend | Gateway service running |
| 4.4 | Implement API key validation in gateway (Redis cache + DB fallback) | Backend | Invalid keys return 401 |
| 4.5 | Implement subscription scope check (key must cover requested model) | Backend | Out-of-scope requests return 403 |
| 4.6 | Implement per-key rate limiting via Redis counters | Backend | Rate limit exceeded returns 429 |
| 4.7 | Implement request routing to correct vLLM pod via llm-d | Backend | Requests reach correct model |
| 4.8 | Implement streaming responses via Server-Sent Events | Backend | SSE streaming works for chat/completions |
| 4.9 | Publish usage events to Redis Stream `usage:events` on response | Backend | Events flowing to Redis |
| 4.10 | Build Playground screen (model + key selector, chat UI, streaming display) | Frontend | Tenant can chat with a model |
| 4.11 | Validate OpenAI Python + Node.js SDK compatibility (base URL swap only) | QA | SDK integration confirmed |

**Exit criteria:** Tenant can call `/v1/chat/completions` with their API key and receive a streamed response; existing OpenAI SDK works with base URL change only.

---

## Phase 5 — Usage Tracking, Dashboard & Hardening (Weeks 10–12)

Goal: Usage is tracked and visible; platform is production-ready.

| # | Task | Owner | Output |
|---|---|---|---|
| 5.1 | Build Usage Consumer service (reads Redis Stream, upserts to PostgreSQL) | Backend | Token counts persisted |
| 5.2 | Implement `GET /usage` — per-key usage for authenticated tenant | Backend | Usage data available via API |
| 5.3 | Implement `PATCH /admin/tenants/{id}` — suspend/unsuspend tenant | Backend | Suspended tenant keys rejected within 60s |
| 5.4 | Implement `GET /admin/usage` — aggregate usage across all tenants | Backend | Operator usage view |
| 5.5 | Build Dashboard screen (subscriptions overview, per-key usage by day) | Frontend | Tenant sees real-time usage |
| 5.6 | Add TLS termination at Ingress for `app.willstart.ai` | Infra | HTTPS enforced end-to-end |
| 5.7 | Load test: 50 concurrent inference requests, p95 first token < 2s | QA | Performance baseline confirmed |
| 5.8 | Security review: tenant isolation, key hashing, rate limiting | QA | No cross-tenant leakage confirmed |
| 5.9 | Operator runbook: add model, suspend tenant, monitor usage | Docs | Ops documentation complete |

**Exit criteria:** New tenant completes full flow (sign up → subscribe → generate key → first inference call) in under 10 minutes; usage visible on dashboard within 60 seconds.

---

## Summary Timeline

| Phase | Focus | Weeks |
|---|---|---|
| 1 | Foundation & Infrastructure | 1–2 |
| 2 | Auth & Model Catalog | 3–4 |
| 3 | Subscriptions & API Keys | 5–6 |
| 4 | Inference Gateway & Model Invocation | 7–9 |
| 5 | Usage Tracking, Dashboard & Hardening | 10–12 |

---

## Dependencies & Risks

| Risk | Mitigation |
|---|---|
| llm-d / vLLM integration complexity | Spike in Phase 1; use LiteMaaS PoC as reference |
| GPU cluster availability from third-party partner | Confirm access before Phase 1 starts |
| Auth0/Clerk cost at scale | Evaluate Keycloak migration post-MVP if needed |
| OpenAI SDK compatibility gaps | Validate in Phase 4 with real SDK calls early |
