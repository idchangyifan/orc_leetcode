import java.util.HashMap;

/**
 * @Auther: orchard.chang
 * @Date: 2018/12/6
 * @Description: 第1题Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *思路：用空间换时间。这类问题要想只遍历一次数组，通常是循环到数组后面之后，在和前面的组合。这里利用了hashmap查询只需要O(1)时间的特点，
 * 即hashMap.containsKey的时间复杂度为O(1)。若把hashmap更改为ArrayList，则整体时间复杂度退化为O(n^2)
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new RuntimeException("no result");
    }
}
