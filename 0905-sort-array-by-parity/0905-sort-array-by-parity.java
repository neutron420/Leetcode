class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int column = 0;
    int rows = nums.length - 1;
    while (column < rows) {
      if (nums[column] % 2 == 1 && nums[rows] % 2 == 0) {
        int temp = nums[column];
        nums[column] = nums[rows];
        nums[rows] = temp;
      }
      if (nums[column] % 2 == 0)
        column++;
      if (nums[rows] % 2 == 1)
        rows--;
    }
    return nums;
  }
}