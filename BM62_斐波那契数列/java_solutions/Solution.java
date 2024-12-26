package BM62_斐波那契数列.java_solutions;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @return int整型
     */
    public int Fibonacci (int n) {
        if( n==1 || n==2 ){
            return 1;
        }

        return this.Fibonacci(n-1) + this.Fibonacci(n-2);
    }
}