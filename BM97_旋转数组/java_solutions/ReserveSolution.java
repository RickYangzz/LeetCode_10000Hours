
package BM97_旋转数组.java_solutions;

public class ReserveSolution {
    /**
     * 一个数组A中存有 n 个整数，在不允许使用另外数组的前提下，
     * 将每个整数循环向右移 M（ M >=0）个位置，
     * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）
     * （最后 M 个数循环移至最前面的 M 个位置）。
     * 如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
     *
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        if(n==0) return a;
        
        m = m % n;
        if(m==n || m==0) return a;

        reverse(a, 0, n-1);
        reverse(a, 0, m-1);
        reverse(a, m, n-1);

        return a;
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[end];
            a[end] = a[start];
            a[start] = temp;

            start++;
            end--;
        }
    }
}
