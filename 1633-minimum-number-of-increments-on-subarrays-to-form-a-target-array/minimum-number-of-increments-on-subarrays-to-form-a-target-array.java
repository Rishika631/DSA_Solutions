class Solution {
    public int minNumberOperations(int[] target) {
        int steps=target[0];
        
        for(int i=0;i<target.length-1;i++){

            int diff = target[i+1]-target[i];

            if(diff>0) steps+=diff;
        }
        return steps;
    }
}