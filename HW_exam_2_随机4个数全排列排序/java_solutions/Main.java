import java.util.ArrayList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static int target = 0;
    static int current = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String row = in.nextLine();
        in.close();

        String[] strArr = row.split(",");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < strArr.length; i++) {
            arr.add(stringToInt(strArr[i]));
        }

        if(arr.contains(0)) {
            System.out.println(-1);
            return;
        }

        if(arr.contains(2) && arr.contains(5)){
            System.out.println(-1);
            return;
        }

        if(arr.contains(6) && arr.contains(9)){
            System.out.println(-1);
            return;
        }

        arr.sort((a,b)->a-b);
        target = arr.get(arr.size()-1);

        if(arr.contains(2)){
            arr.add(5);
        }else if(arr.contains(5)){
            arr.add(2);
        }else if(arr.contains(6)){
            arr.add(9);
        }else if(arr.contains(9)){
            arr.add(6);
        }
        arr.sort((a,b)->a-b);

        int k = 1;
        while(k <= 4){
            int result = findTarget(arr, k, 0);
            if(result != -1) {
                System.out.println(result);
                return;
            }
            k += 1;
        }

        System.out.println(-1);
    }

    private static int findTarget(ArrayList<Integer> arr, int k, int value){
        if(k==0){
            current += 1;
            if(current == target){
                return value;
            } else {
                return -1;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            int val = arr.remove(i);

            int result = findTarget(arr, k-1, value*10 + val);
            if(result != -1) return result;

            arr.add(i, val);
        }

        return -1;
    }

    private static int stringToInt(String input){
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum = sum * 10 + (input.charAt(i) - '0');
        }
        return sum;
    }
}