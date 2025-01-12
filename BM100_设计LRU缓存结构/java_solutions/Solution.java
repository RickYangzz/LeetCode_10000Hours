package BM100_设计LRU缓存结构.java_solutions;

import java.util.*;

/**
 * 描述
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 capacity ，操作次数是 n ，并有如下功能:
 * 1. Solution(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * 2. get(key)：如果关键字 key 存在于缓存中，则返回key对应的value值，否则返回 -1 。
 * 3. set(key, value)：将记录(key, value)插入该结构。
 *    如果关键字 key 已经存在，则变更其数据值 value，
 *    如果不存在，则向缓存中插入该组 key-value ，
 *    如果key-value的数量超过capacity，弹出最久未使用的key-value
 * 
 * 提示:
 * 1.某个key的set或get操作一旦发生，则认为这个key的记录成了最常使用的，然后都会刷新缓存。
 * 2.当缓存的大小超过capacity时，移除最不经常使用的记录。
 * 3.返回的value都以字符串形式表达，如果是set，则会输出"null"来表示(不需要用户返回，系统会自动输出)，方便观察
 * 4.函数set和get必须以O(1)的方式运行
 * 5.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 */
public class Solution {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node trail;
    private int size = 0;

    public Solution(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>(capacity);

        this.head = new Node(-1, -1);
        this.trail = new Node(-1, -1);
        this.head.next = this.trail;
        this.trail.pre = this.head;
    }

    public int get(int key) {
        if(this.map.containsKey(key)) {
            Node target = this.map.get(key);
            moveToHead(target);
            return target.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        if(this.map.containsKey(key)){
            Node target = this.map.get(key);
            target.value = value;
            moveToHead(target);
        } else {
            if(this.size == 0) {
                removeTrial();
            } else {
                this.size--;
            }

            Node target = new Node(key, value);
            insertToHead(target);
            this.map.put(key, target);
        }
    }

    // 将target节点移动到链表头
    private void moveToHead(Node target){
        // 断开target节点的左右连接
        target.pre.next = target.next;
        target.next.pre = target.pre;

        insertToHead(target);
    }

    // 将target节点插入到链表头
    private void insertToHead(Node target){
        // 将新节点插入到头部
        target.pre = this.head;
        target.next = this.head.next;

        this.head.next.pre = target;
        this.head.next = target;
    }

    // 移除掉尾节点
    private void removeTrial(){
        Node lastNode = this.trail.pre;
        lastNode.pre.next = this.trail;
        this.trail.pre = lastNode.pre;
        this.map.remove(lastNode.key);
    }
}