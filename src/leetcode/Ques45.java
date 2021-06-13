package leetcode;

public class Ques45 {
	
	
	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4};
		System.out.println(new Ques45().jump(arr));
	}
	
	public int jump(int[] nums) {

        int res = 0;
        int cur = 0;
        int max_step = 0;
        int max_index = 0;
        while(cur<nums.length-1){
        	if(cur+nums[cur] == nums.length-1) {
        		res++;
        		break;
        	}
            max_step = 0;
            for(int i=cur+1;i<=cur+nums[cur];i++){
                if(i < nums.length && (i + nums[i])>max_step){
                    max_step = i + nums[i];
                    max_index = i;
                }
            }
            cur = max_index;
            res++;
        }
        return res;
    }
}
