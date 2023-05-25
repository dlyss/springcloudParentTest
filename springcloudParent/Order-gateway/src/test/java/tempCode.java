import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class tempCode {
    public static void main(String[] args) {
     // int res =   numWays(2);
       // System.out.println(res);
        tempCode.firstU("leecode");
    }
    public static int numWays(int n){
        HashMap tempHm = new HashMap();
        return fib(n,tempHm);

    }
    public static int fib(int n,HashMap tempHm) {
        if(n<2){
            tempHm.put(0,1);
            tempHm.put(1,1);
            return 1;
        }
        int f1,f2;
        if(tempHm.containsKey(n-1)){
            f2=(int)tempHm.get(n-1);
        }else{
            f2=fib(n-1,tempHm);
        }
        tempHm.put(n-1,f2);



        int res = (f2+1)/1000000007;
        // tempHm.put(n,res);
        return res;
    }
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] +=Math.max(nums[i-1],0);
            res = Math.max(nums[i],res);
        }
        return res;

    }
    public static char firstU(String s){
        char res = ' ';
        char[]tempChar = s.toCharArray();
        HashMap tempHm = new LinkedHashMap();
        for(int i=0;i<tempChar.length;i++){
            if(tempHm.containsKey(tempChar[i])){
                tempHm.remove(tempChar[i]);//put(tempChar[i],2);
            }else{
                tempHm.put(tempChar[i],1);
            }

        }
        Iterator tempIt = tempHm.keySet().iterator();
        while(tempIt.hasNext()){
            char temp = (char)tempIt.next();
            if((int)tempHm.get(temp)==1){
                res= temp;
                break;
            }
        }
        return res;
    }
    public static int moreHalf(int [] nums){
        int base = nums.length/2;
        HashMap tempHm = new HashMap();
        int returnres=0;
        for(int i=0;i<nums.length;i++){
            if(tempHm.containsKey(nums[i])){
                int tempCount = (int)tempHm.get(nums[i]);
                if (tempCount==base){
                    returnres= (int)tempHm.get(nums[i]);
                    break;
                }else{
                    tempHm.put(nums[i],tempCount+1);
                }

            }else{
                tempHm.put(nums[i],1);
            }

        }
        return returnres;
    }
}
