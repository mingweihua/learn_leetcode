package test.bigo;

import java.util.LinkedList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        MySortApi<Double> mySortApi = new MySortApi<>();
        mySortApi.addEle(1.0);
        mySortApi.addEle(22.0);;
        mySortApi.addEle(34.1);
        mySortApi.addEle(32.2);
        mySortApi.addEle(0.7);
        LinkedList<Double> list = mySortApi.getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }



    static class MySortApi<T extends Comparable<T>> {

        LinkedList<T> list = new LinkedList<>();

        public void addEle(List<T> addList){
            for (int i = 0; i < addList.size(); i++) {
                this.addEle(addList.get(i));
            }
        }

        public void addEle(T ele){
            int n = list.size();
            if(n == 0){
                list.add(ele);
                return;
            }
            int cur = -1;
            for (int i = n-1; i >=0; i--) {
                if(list.get(i).compareTo(ele)>0){
                    cur = i;
                    break;
                }
            }
            list.add(cur+1,ele);
        }

        public LinkedList<T> getList(){
            return list;
        }
    }

}
