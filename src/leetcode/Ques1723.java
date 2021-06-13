package leetcode;

import java.util.Arrays;

public class Ques1723 {

	public static void main(String[] args) {
		
	}

	public int minimumTimeRequired(int[] jobs, int k) {
		Arrays.sort(jobs);
        int low = 0, high = jobs.length - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }
        int l = jobs[0], r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
	
	private boolean check(int[] jobs, int k, int limit) {
		int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
	}

	private boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
		if(i>=jobs.length) {
			return true;
		}
		boolean flag = false;
		for(int j=0;j<workloads.length;j++) {
			if(workloads[j] + jobs[i] <= limit) {
				workloads[j] += jobs[i];
				flag = backtrack(jobs, workloads, i+1, limit);
				if(flag) {
					return true;
				}
				workloads[j] -= jobs[i];
			}
			
			if(workloads[j] == 0 || workloads[j] + jobs[i] == limit) {
				break;
			}
		}
		
		return false;
	}

}
