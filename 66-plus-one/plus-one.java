// if not 9 then add one and return if 9 then make it zero and reduce i as it will go to next num and if not return in while loop means [9,9,9] case so add 1 at beginning of array and return
// time=n(loop)+n(insert)
//space=const
class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while(i>=0)
        {
            if(digits[i]<9)
            {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
            i--;
        }
        ArrayList<Integer> arr= new ArrayList<>();
        for(int a: digits)
        {
            arr.add(a);
        }
        arr.add(0, 1);//n in worst case
        int[] res= new int[arr.size()];
        for(int j=0;j<arr.size();j++)
        {
            res[j]=arr.get(j);
        }
        return res;
    }
}