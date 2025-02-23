class Solution {
    public int jump(int[] nums) {
        int near = 0, far = 0, jump = 0;

        while(far < nums.length){
            int farthest = 0;
            for (int i = near; i < far+1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            near = far + 1;
            far = farthest;
            jump += 1;
        }

        return jump;
    }
}