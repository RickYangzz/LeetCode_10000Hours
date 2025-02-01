package BM48_数据流中的中位数.java_solutions;

import java.util.*;

public class Solution {
    private ArrayList<Integer> arr = new ArrayList<Integer>();

    public void Insert(Integer num) {
        if (arr.isEmpty()) {
            arr.add(num);
        } else {
            int i = 0;
            for (; i < arr.size(); i++) {
                if (num <= arr.get(i)) {
                    break;
                }
            }
            arr.add(i, num);
        }
    }

    public Double GetMedian() {
        int size = this.arr.size();
        if(size%2 == 0){
            double first = this.arr.get(size/2);
            double second = this.arr.get(size/2 - 1);

            return (first + second) / 2;
        }else{
            return (double)(this.arr.get(size/2));
        }
    }
}
