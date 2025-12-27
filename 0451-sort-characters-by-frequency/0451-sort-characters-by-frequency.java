class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character,Integer> set = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;i++){
            char ch = s.charAt(i);
            if(set.containsKey(ch)){
                set.put(ch,set.get(ch)+1);
            }else{
                set.put(ch,1);
            }
        }
        List<Character> ele = new ArrayList<>(set.keySet());
        Collections.sort(ele,(a,b) -> set.get(b) - set.get(a));
        for(Character c : ele ){
            for(int i=0; i<set.get(c);i++) sb.append(c);
        }
        return sb.toString();
    }
}