class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int ans = 1;
        if (mp.containsKey(1)) {
            int cnt = mp.get(1);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }
        for (int start : mp.keySet()) {
            if (start == 1)
               continue;
            int len = 0;
            int cur = start;
            while (mp.containsKey(cur) && mp.get(cur) >= 2) {
                len += 2;
                cur = cur * cur;
            }
            if (mp.containsKey(cur) && mp.get(cur) == 1)
                len++;
            else
                len--;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}