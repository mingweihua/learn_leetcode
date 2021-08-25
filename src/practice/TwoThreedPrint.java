package practice;

public class TwoThreedPrint {

    static volatile int num = 0;
    static volatile boolean flag = true;

    public static void main(String[] args) {
        //使用synchronized上锁，效率低
        /*TwoThreedPrint test = new TwoThreedPrint();
        new Thread(() -> {
            test.print1();
        }).start();
        new Thread(() -> {
            test.print2();
        }).start();*/

        new Thread(() -> {
            while (num<=100){
                if(flag && num %2 ==0){
                    System.out.println(Thread.currentThread().getName()+ "输出："+num);
                    num++;
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (num<=100){
                if((!flag) && num %2 ==1){
                    System.out.println(Thread.currentThread().getName()+ "输出："+num);
                    num++;
                    flag = true;
                }
            }
        }).start();
    }

    public synchronized void print1(){
        for (int i = 0; i <= 100; i+=2) {
            System.out.println(Thread.currentThread().getName()+ "输出："+i);
            this.notify();
            try {
                this.wait();
                //Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void print2(){
        for (int i = 1; i <= 99; i+=2) {
            System.out.println(Thread.currentThread().getName()+ "输出："+i);
            this.notify();
            try {
                this.wait();
                //Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
