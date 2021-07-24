package leetcode;

public class Ques1736 {

	public static void main(String[] args) {

	}

	public String maximumTime(String time) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i)=='?'){
				if(i==0 && (time.charAt(1)=='?' || time.charAt(1)-'0'<4)){
					sb.append('2');
				} else if(i==0){
					sb.append('1');
				}
				if(i==1 && sb.charAt(0) == '2'){
					sb.append('3');
				} else if(i==1){
					sb.append('9');
				}
				if(i==3){
					sb.append('5');
				}
				if(i==4){
					sb.append('9');
				}
			} else {
				sb.append(time.charAt(i));
			}
		}

		return sb.toString();
	}

}
