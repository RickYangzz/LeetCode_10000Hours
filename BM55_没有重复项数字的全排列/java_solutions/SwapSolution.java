package BM55_没有重复项数字的全排列.java_solutions;

import java.util.ArrayList;

public class SwapSolution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        recursion(result, num, 0);

        return result;
    }

    private void recursion(ArrayList<ArrayList<Integer>> container, int[] num, int index){
        if(index == num.length -1){
            container.add(convertIntArrayToArrayList(num));
            return;
        }

        for (int i = index; i < num.length; i++) {
            swap(num, i, index);
            recursion(container, num, index+1);
            swap(num, i, index);
        }
    }

    private void swap(int[] numbers, int i, int index){
        Integer temp = numbers[index];
        numbers[index] = numbers[i];
        numbers[i] = temp;
    }

    private ArrayList<Integer> convertIntArrayToArrayList(int[] nums){
        ArrayList<Integer> result = new ArrayList<>();
        for (int n : nums) {
            result.add(n);
        }
        return result;
    }
}
