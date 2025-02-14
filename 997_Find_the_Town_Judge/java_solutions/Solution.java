class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n];

        for (int[] arr : trust) {
            count[arr[0]] -= 1;
            count[arr[1]] += 1;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] == n-1) return i;
        }

        return -1;
    }
}