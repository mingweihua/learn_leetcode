package leetcode;

public class Ques470 {
	
	
	public static void main(String[] args) {

	}


	public int rand10() {
		//0-48
		int n = (rand7()-1) * 7 + (rand7()-1);
		while (n>39){
			n = (rand7()-1) * 7 + (rand7()-1);
		}
		return n%10+1;
	}

	public int rand7() {
		return 0;
	}
}
