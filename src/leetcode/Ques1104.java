package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Ques1104 {

	public static void main(String[] args) {
		System.out.println(new Ques1104().pathInZigZagTree(26));
	}

	public List<Integer> pathInZigZagTree(int label) {
		LinkedList<Integer> res = new LinkedList<>();
		if(label == 1){
			res.addFirst(label);
			return res;
		}
		int n = 0;
		int preSum = 0;
		int curLayerNums = 1;
		int left = label;
		while (left > curLayerNums){
			left -= curLayerNums;
			preSum += curLayerNums;
			curLayerNums *= 2;
			n++;
		}

		res.addFirst(label);
		//preLeft上层（父节点）距离左侧的距离，范围是[1,curLayerNums]
		int preLeft = left;

		int preLayerNums = curLayerNums / 2;

		if(n % 2 == 0){
			preLeft = (preLeft+1)/2;
		} else {
			preLeft = ((preLayerNums * 2 - preLeft+1)+1)/2;
		}
		n--;
		preSum -= preLayerNums;
		preLayerNums /= 2;

		while (n >= 0){
			if(n % 2 == 0){
				res.addFirst(preSum + preLeft);
				preLeft = (preLeft+1)/2;
			} else {
				res.addFirst(preSum + (preLayerNums * 2 - preLeft + 1));
				preLeft = (preLeft+1)/2;
			}

			n--;
			preSum -= preLayerNums;
			preLayerNums /= 2;
		}
		return res;
	}
}
