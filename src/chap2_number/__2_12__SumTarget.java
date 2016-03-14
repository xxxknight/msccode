package chap2_number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中两个数，使其和为给定的值。
 * 
 * @author founder
 * 
 */
public class __2_12__SumTarget {

	/**
	 * 空间复杂度为O(n), 时间复杂度为O(n)
	 * 
	 * @param nums
	 * @param sum
	 * @return
	 */
	public int[] find(int[] nums, int sum) {
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(sum - nums[i])) {
				if (map.get(sum - nums[i]) == map.get(nums[i])) {
					continue;
				} else {
					res[0] = sum - nums[i];
					res[1] = nums[i];
				}
			}
		}
		// System.out.println(res[0]);
		// System.out.println(res[1]);
		return res;
	}

	/**
	 * 双指针，时间复杂度为O(nlogn)
	 * 
	 * @param nums
	 * @param sum
	 * @return
	 */
	public int[] find2(int[] nums, int sum) {
		int[] res = new int[2];
		Arrays.sort(nums);
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			if (nums[low] + nums[high] == sum) {
				res[0] = nums[high];
				res[1] = nums[low];
//				System.out.println(res[0]);
//				System.out.println(res[1]);
				return res;
			} else if (nums[low] + nums[high] < sum) {
				low++;
			} else {
				high--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 6, 1, 4, 7, 9, 8 };
		System.out.println(new __2_12__SumTarget().find(nums, 10));
		System.out.println(new __2_12__SumTarget().find2(nums, 10));
	}
}
