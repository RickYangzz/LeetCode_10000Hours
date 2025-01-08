package BM89_合并区间.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start) return o1.end - o2.end;
                
                return o1.start - o2.start;
            }
        });

        ArrayList<Interval> result = new ArrayList<Interval>();

        int start = -1;
        int end = -1;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
                continue;
            }

            if (start >= 0 && end >= 0) {
                result.add(new Interval(start, end));
            }
            start = interval.start;
            end = interval.end;
        }

        if (start >= 0 && end >= 0) {
            result.add(new Interval(start, end));
        }

        return result;
    }
}