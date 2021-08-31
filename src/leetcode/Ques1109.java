package leetcode;

public class Ques1109 {

	public static void main(String[] args) {


	}

	//时间复杂度是n * m，还能更优，官方答案是差分数组
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] res = new int[n];
		for (int[] booking: bookings) {
			int start = booking[0];
			int end = booking[1];
			int temp = booking[2];
			for (int i = start-1; i < end; i++) {
				res[i] += temp;
			}
		}
		return res;
	}


	//差分数组，时间复杂度是n + m；
	//差分数组的性质是，当我们希望对原数组的某一个区间 [l,r] 施加一个增量\inc 时，差分数组 d 对应的改变是：d[l]增加 inc，d[r+1]减少 inc。
	// 这样对于区间的修改就变为了对于两个位置的修改。并且这种修改是可以叠加的，即当我们多次对原数组的不同区间施加不同的增量，我们只要按规则修改差分数组即可。
	//

	public int[] corpFlightBookings2(int[][] bookings, int n) {
		int[] res = new int[n];
		for (int[] booking: bookings) {
			int start = booking[0];
			int end = booking[1];
			int temp = booking[2];
			res[start-1] +=  temp;
			if(end<n){
				res[end] -=  temp;
			}
		}
		for (int i = 1; i < n; i++) {
			res[i] += res[i-1];
		}
		return res;
	}
}
