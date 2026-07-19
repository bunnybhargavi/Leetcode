class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
       boolean[] visited = new boolean[26];
       Stack<Character> stack = new Stack<>();
       for(char c : s.toCharArray()){
            freq[c-'a']--;
             if(visited[c-'a'])
                continue;
            while(!stack.isEmpty() && stack.peek() > c && freq[stack.peek()-'a'] > 0){
                visited[stack.pop()-'a'] = false;
            }

            stack.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : stack)
            ans.append(ch);
        return ans.toString();
    }
}