import java.util.ArrayList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static int result = 0;
    static int target = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstRow = in.nextLine(); 
        int k = stringToInt(in.nextLine());
        target = stringToInt(in.nextLine());
        in.close();

        String[] strArr = firstRow.split(" ");
        ArrayList<Integer> arr = new ArrayList(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            arr.add(i, stringToInt(strArr[i]));
        }
        arr.sort((a,b) -> a-b);

        result = 0;
        sum(arr, 0, k, 0);
        System.out.println(result);
    }

    private static void sum(ArrayList<Integer> arr, int index, int k, int num){
        if(k == 0){
            if(num == target) result += 1;
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if(i > 0 && arr.get(i) == arr.get(i-1)) continue;

            int value = arr.remove(i);
            sum(arr, i, k-1, num + value);
            arr.add(i, value);
        }
    }

    private static int stringToInt(String input){
        if(input.charAt(0) == '-') {
            int sum = 0;
            for (int i = 1; i < input.length(); i++) {
                sum = sum * 10 + (input.charAt(i) - '0');
            }
            return -sum;
        }

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum = sum * 10 + (input.charAt(i) - '0');
        }
        return sum;
    }

}