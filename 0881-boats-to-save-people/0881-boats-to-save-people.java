class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int c =0;
        int i=0;
        int j = n-1;
        while(i <= j){
            if(people[i]+people[j] <= limit){
                c++;
                i++;
                j--;
            }else{
                c++;
                j--;
            }
        }
        return c;
    }
}