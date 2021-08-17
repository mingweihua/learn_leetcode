package baodian;


import java.util.LinkedList;

public class Ques0302 {



    class MinStack {

        LinkedList<Integer> dataStack;
        LinkedList<Integer> minStack;

        public MinStack() {
            dataStack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            dataStack.addLast(x);
            if(minStack.isEmpty()){
                minStack.addLast(x);
            } else {
                minStack.addLast(Math.min(minStack.getLast(),x));
            }
        }

        public void pop() {
            dataStack.removeLast();
            minStack.removeLast();
        }

        public int top() {
            return dataStack.getLast();
        }

        public int getMin() {
            return minStack.getLast();
        }
    }
}
