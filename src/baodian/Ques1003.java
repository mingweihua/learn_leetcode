package baodian;

public class Ques1003 {


    public int search(int[] arr, int target) {
        if(arr.length == 1){
            return arr[0] == target?0:-1;
        }
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left<right){
            if(arr[left] == target){
                return left;
            }
            mid = left + ((right - left) >>1);
            if(arr[left] == arr[right] && arr[left] == arr[right]){
                left++;
                continue;
            }

            if(arr[left] < arr[right]){
                if(target<=arr[mid]){
                    right = mid;
                } else {
                    left = mid + 1;
                }
                continue;
            }

            if(arr[left] <= arr[mid]){
                //左侧单调不减
                if(target>arr[left] && target<=arr[mid]){
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                //右侧单调不减
                if(target>arr[mid] && target<=arr[right]){
                    left = mid +1;
                } else {
                    right = mid;
                }
            }
        }

        return arr[left] == target?left:-1;
    }
}
