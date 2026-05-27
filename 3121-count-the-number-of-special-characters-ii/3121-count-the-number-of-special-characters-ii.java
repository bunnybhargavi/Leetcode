class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lstL = new int[26];
        int[] frstU = new int[26];
        Arrays.fill(lstL , -1);
        Arrays.fill(frstU , -1);
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                lstL[ch - 'a'] = i;
            }else{
                if(frstU[ch - 'A'] == -1){
                    frstU[ch - 'A'] = i;
                }
            }
        }
        int c =0;
        for(int i=0; i<26; i++){
            if(lstL[i] != -1 && frstU[i] != -1 && lstL[i] < frstU[i]) c++;
        }
        return c;
    }
}