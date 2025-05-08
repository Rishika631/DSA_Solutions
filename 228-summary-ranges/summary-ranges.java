class Solution {
    public List<String> summaryRanges(int[] nums) {
      ArrayList<String> list = new ArrayList<>();
        
        if(nums.length==0)
        return list;
        
        int start=nums[0];
        int end=start;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
               end=nums[i+1];
            }
           else {
                if(start == end) 
                   list.add(start+"");// made it string by adding empty string
                if(start < end)
                    list.add(start + "->" +end);
              start=nums[i+1];
              end=start;
          }
        }
        if (start == end)
    list.add(start + "");
else
    list.add(start + "->" + end);

        return list;
    }
}