package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Liu
 */
public class Sum3
{
  public static void main(String[] args)
  {
    final List<List<Integer>> lists = threeSum(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 });
  }
  public static List<List<Integer>> threeSum(int[] nums) {
    ArrayList<List<Integer>> res = new ArrayList();
    if(nums == null || nums.length == 0) return res;

    Arrays.sort(nums);

    for(int i = 0; i < nums.length - 2; i++){
      if(i > 0 && nums[i - 1] == nums[i]) continue;
      int target = 0 - nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      while(left < right){
        if(nums[left] + nums[right] == target){
          List<Integer> tmp = new ArrayList();
          tmp.add(nums[i]);
          tmp.add(nums[left]);
          tmp.add(nums[right]);
          res.add(tmp);
          while(left < right && nums[left] == tmp.get(1))left++;
          while(left < right && nums[right] == tmp.get(2))right--;
        } else if(nums[left] + nums[right] < target){
          left++;
        } else if(nums[left] + nums[right] > target){
          right--;
        }
      }
    }

    return res;
  }
}
