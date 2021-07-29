package alibaba;

import java.util.Scanner;
import java.util.Stack;

public class Ques202109_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        int n = 0;
        int m = 0;
        String str = null;
        for (int i = 0; i < t; i++) {
            String[] numStr = sc.nextLine().split(" ");
            n = Integer.valueOf(numStr[0]);
            m = Integer.valueOf(numStr[1]);
            str = sc.nextLine();
            System.out.println(solve(str.toCharArray(), n, m));
        }

    }


    /*
    链接：https://www.nowcoder.com/questionTerminal/8951775b97d949628675398b6639d79c
来源：牛客网

要想字典序小，那么字符串中的字母应该尽可能满足升序。因此只需遵循一个原则，当前字母的ASCII码不能比前面字母的小，如果出现这种情况，就要把前面的字母删除掉，
从当前字母重新开始算字符串。最后需要注意，返回的字符串长度应该为n-m。
     */
    public static String solve(char[] str,int n,int m){

        Stack<Character> stack = new Stack<>();
        int removeCharNums = 0;
        for(int i = 0; i < n; i++){
            char c = str[i];
            while(!stack.isEmpty() && c < stack.peek() && removeCharNums < m){
                stack.pop();
                removeCharNums += 1;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString().substring(0, n - m);
    }

}
