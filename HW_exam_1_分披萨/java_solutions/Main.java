import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = stringToInt(in.nextLine()); // 总的披萨 数量
        int[] store = new int[n];
        for (int i = 0; i < store.length; i++) {
            store[i] = stringToInt(in.nextLine());
        }

        int result = 0;
        for (int i = 0; i < store.length; i++) {
            result = Math.max(result, count(store, i));
        }
        System.out.println(result);
    }

    private static int count(int[] store, int start){
        int left = start - 1 >= 0 ? start - 1 : store.length - 1;
        int right = start + 1 < store.length ? start + 1 : 0;

        return store[start] + countMax(store, left, right);
    }

    private static int countMax(int[] store, int left, int right) {
        if(left == right){
            return 0;
        }

        if(store[left] > store[right]) {
            left = left - 1 >= 0 ? left - 1 : store.length - 1;
        }else{
            right = right + 1 < store.length ? right + 1 : 0;
        }

        if (left == right) {
            return store[left];
        }

        int leftValue = store[left] + countMax(store, left - 1 >= 0 ? left - 1 : store.length - 1, right);
        int rightValue = store[right] + countMax(store, left, right + 1 < store.length ? right + 1 : 0);

        return Math.max(leftValue, rightValue);
    }

    private static int stringToInt(String input){
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum = sum * 10 + (input.charAt(i) - '0');
        }
        return sum;
    }
}