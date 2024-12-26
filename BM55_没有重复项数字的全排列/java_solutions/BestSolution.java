package BM55_没有重复项数字的全排列.java_solutions;

import java.util.ArrayList;

public class BestSolution {
    private ArrayList<Integer> convertIntArrayToArrayList(int[] nums){
        ArrayList<Integer> result = new ArrayList<>();
        for (int n : nums) {
            result.add(n);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> numbers = convertIntArrayToArrayList(num);

        recursion(result, numbers, 0);

        return result;
    }

    private void recursion(ArrayList<ArrayList<Integer>> container, ArrayList<Integer> numbers, int index){
        if(index == numbers.size() -1){
            container.add(new ArrayList<>(numbers));
            return;
        }

        for (int i = index; i < numbers.size(); i++) {
            move(numbers, i, index);
            recursion(container, numbers, index+1);
            back(numbers, i, index);
        }
    }

    private void move(ArrayList<Integer> numbers, int i, int index){
        Integer num = numbers.remove(i);
        numbers.add(index, num);
    }

    private void back(ArrayList<Integer> numbers, int i, int index){
        Integer num = numbers.remove(index);
        numbers.add(i, num);
    }
}
