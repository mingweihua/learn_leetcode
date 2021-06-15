package leetcode;

public class Ques825 {

    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        System.out.println(new Ques825().peakIndexInMountainArray2(arr));
    }

    //O(n)
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }


    //时间o(logn)，但是空间也是o(logn)
    public int peakIndexInMountainArray2(int[] arr) {
        if (arr.length == 3) {
            return arr[1];
        }

        return solve(arr, 0, arr.length - 1);
    }

    public int solve(int[] arr, int left, int right) {
        if (left == right) {
            return right;
        }
        int mid = left + ((right - left) >> 1);
        if (arr[mid] >= arr[left] && arr[mid] >= arr[right]) {
            int l = solve(arr, left, mid);
            int r = solve(arr, mid + 1, right);
            return arr[l] >= arr[r] ? l : r;
        } else if (arr[mid] < arr[left]) {
            return solve(arr, left, mid);
        } else {
            return solve(arr, mid + 1, right);
        }
    }

    /***
     * 分析，目标索引是target
     * 当i<target ： 必有arr[i]<arr[i+1]
     * 当i>=target：必有arr[i]>arr[i+1]
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray3(int[] arr) {
        if (arr.length == 3) {
            return arr[1];
        }
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while(left<right){
            mid = left + ((right-left)>>1);
            if(arr[mid]<arr[mid+1]){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
