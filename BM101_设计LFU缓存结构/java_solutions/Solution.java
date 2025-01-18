package BM101_设计LFU缓存结构.java_solutions;

import java.util.*;

/**
 * lfu design
 * 
 * 一个缓存结构需要实现如下功能。
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * 但是缓存结构中最多放K条记录，
 * 如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。
 * 这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，
 * 被调用set或者get的次数最少，就删掉这个key的记录；
 * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
 * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
 * 
 */
public class Solution {
    private HashMap<Integer, Node> mainMap;
    private HashMap<Integer, LinkedList<Node>> timesMap;
    private int minTimes;
    private int capacity;

    class Node {
        int val = 0;
        int key = 0;
        int times = 0;

        public Node(int _key, int _val) {
            key = _key;
            val = _val;
            times = 1;
        }
    }

    /**
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     * 
     * @param operators int整型二维数组 ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LFU(int[][] operators, int k) {
        if (operators == null || operators.length == 0 || k == 0) {
            return new int[0];
        }

        this.mainMap = new HashMap<Integer, Node>();
        this.timesMap = new HashMap<Integer, LinkedList<Node>>();
        this.minTimes = 0;
        this.capacity = k;

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int[] opt : operators) {
            if (opt[0] == 1)
                this.set(opt[1], opt[2]);
            if (opt[0] == 2)
                result.add(this.get(opt[1]));
        }
        return convertArrayListToIntArray(result);
    }

    private int[] convertArrayListToIntArray(ArrayList<Integer> list) {
        // Create an int array of the same size
        int[] result = new int[list.size()];

        // Fill the int array with values from the ArrayList
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public void set(int key, int value) {
        if (!mainMap.containsKey(key)) {
            // 第一次插入 key不存在于mainMap和timesMap
            Node target = new Node(key, value);
            insertMainMap(target);
            insertTimesMap(target);
            this.minTimes = 1;
        } else {
            // 第n次插入，key存在, 需要更新 mainMap 和 timesMap
            Node target = this.mainMap.get(key);
            target.val = value;

            updateTimesMap(target);
        }
    }

    private void insertMainMap(Node target) {
        if (mainMap.size() < this.capacity) {
            mainMap.put(target.key, target);
        } else {
            removeLFU();
            mainMap.put(target.key, target);
        }
    }

    private void removeLFU() {
        LinkedList<Node> linkedList = timesMap.get(this.minTimes);
        Node target = linkedList.removeLast();
        if (linkedList.isEmpty()) {
            timesMap.remove(this.minTimes);
        }
        mainMap.remove(target.key);
    }

    private void updateTimesMap(Node target) {
        // 删除旧位置上的链接
        LinkedList linkedList = timesMap.get(target.times);
        linkedList.remove(target);

        if (target.times == this.minTimes && linkedList.isEmpty()) {
            this.minTimes++;
        }

        // 操作次数 +1
        target.times++;

        // 建立新链接
        insertTimesMap(target);
    }

    private void insertTimesMap(Node target) {
        LinkedList linkedList = this.timesMap.getOrDefault(target.times, new LinkedList<Node>());
        linkedList.addFirst(target);

        this.timesMap.put(target.times, linkedList);
    }

    public int get(int key) {
        // 直接从mainMap中获取对应的值，并且更新 timesMap
        if (this.mainMap.containsKey(key)) {
            Node target = this.mainMap.get(key);
            updateTimesMap(target);
            return target.val;
        }

        return -1;
    }

}