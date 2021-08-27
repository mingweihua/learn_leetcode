package leetcode;

import java.util.PriorityQueue;

public class Ques295 {
	

	public static void main(String[] args) {

	}

	class MedianFinder {

		/** initialize your data structure here. */
		PriorityQueue<Integer> minHeap;
		PriorityQueue<Integer> maxHeap;
		int size;
		double median;
		public MedianFinder() {
			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>((Integer o1,Integer o2) -> {
				return o2 - o1;
			});
			size = 0;
			median = 0.0;
		}

		public void addNum(int num) {
			if(size == 0){
				maxHeap.add(num);
				median = num;
				size++;
				return;
			}

			if(size %2 == 0){
				minHeap.add(num);
				maxHeap.add(minHeap.remove());
				median = maxHeap.peek();
			} else {
				maxHeap.add(num);
				minHeap.add(maxHeap.remove());
				median = (maxHeap.peek()+minHeap.peek())/2.0;
			}
			size++;
		}

		public double findMedian() {
			return median;
		}
	}
}