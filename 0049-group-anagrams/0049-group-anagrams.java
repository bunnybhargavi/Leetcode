class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int[] count = new int[26];
        HashMap<String, List<String>> mp = new HashMap();
        for(int i=0; i<n;i++){
            Arrays.fill(count, 0);
            for(int j=0; j<strs[i].length();j++){
                count[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int num: count){
                sb.append("#");
                sb.append(num);
            }
            String s = sb.toString();
            if(!mp.containsKey(s)){
                mp.put(s, new ArrayList());
            }
            mp.get(s).add(strs[i]);
        }
        return new ArrayList(mp.values());
    }
}