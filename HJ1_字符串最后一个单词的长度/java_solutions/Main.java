package HJ1_字符串最后一个单词的长度.java_solutions;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        String[] arr = str.split(" ");
        System.out.println(arr[arr.length-1].length());
    }
}
