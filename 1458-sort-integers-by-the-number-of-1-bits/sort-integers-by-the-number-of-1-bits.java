//space-n
// time-nlogn(sorting)*logn(for set bits count it will run for no. of bits needed to represent a number)

class Solution {
    public int countSetBits(int num){
        int count=0;
        while(num!=0){
            count+=num&1;
            num>>=1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] array=new Integer[n];// can't have comparator in int values premitives we need objs like Intger 
        //No comparator version for primitive arrays.
        for(int i=0;i<n;i++)
        {
         array[i]=arr[i];   
        }
        Arrays.sort(array, (a,b)-> {// sorting nlogn
            int countA=countSetBits(a);//o(logn)
            int countB=countSetBits(b);//o(logn)
            if(countA==countB)
            {
                return a.compareTo(b);
            }
            return Integer.compare(countA,countB);

        });
        for(int i=0;i<n;i++)
        {
         arr[i]=array[i];   
        }
        return arr;
    }
}


//space=n-array conversion to Integer array
//time=nlogn

// class Solution {
//     public int[] sortByBits(int[] arr) {
//         int n=arr.length;
//         Integer[] array=new Integer[n];// can't have comparator in int values premitives we need objs like Intger 
//         //No comparator version for primitive arrays.
//         for(int i=0;i<n;i++)
//         {
//          array[i]=arr[i];   
//         }
//         Arrays.sort(array, (a,b)-> {// sorting nlogn
//             int countA=Integer.bitCount(a);o(1)
//             int countB=Integer.bitCount(b);//o(1)
//             if(countA==countB)
//             {
//                 return a.compareTo(b);
//             }
//             return Integer.compare(countA,countB);

//         });
//         for(int i=0;i<n;i++)
//         {
//          arr[i]=array[i];   
//         }
//         return arr;
//     }
// }