package chap2_number;

import java.util.ArrayList;
import java.util.List;

public class __2_3__Majority {

	/**
	 * 问题：查找数组中超过一半的数
	 * 
	 * @author founder
	 * 
	 */
	public int findMajority(int[] nums) {
		int cnt = 0;
		int majority = 0;
		for (int num : nums) {
			if (cnt == 0) {
				majority = num;
				cnt = 1;
			} else {
				if (majority == num) {
					cnt++;
				} else {
					cnt--;
				}
			}
		}
		return majority;
	}

	/**
	 * 问题：查找数组中超过三分之一的数
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findMajority2(int[] nums) {
		List<Integer> rst = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return rst;
		int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
		for (int num : nums) {
			if (num == candidate1)
				count1++;
			else if (num == candidate2)
				count2++;
			else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == candidate1)
				count1 += 2;
			else
				count1--;
			if (num == candidate2)
				count2 += 2;
			else
				count2--;
		}
		if (count1 > 0)
			rst.add(candidate1);
		if (count2 > 0)
			rst.add(candidate2);
		return rst;
	}

	/**
	 * 问题：查找数组中超过四分之一的数
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findMajority3(int[] nums) {
		List<Integer> rst = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return rst;
		int count1 = 0, count2 = 0, count3 = 0, candidate1 = 0, candidate2 = 1, candidate3 = 2;
		for (int num : nums) {
			if (num == candidate1)
				count1++;
			else if (num == candidate2)
				count2++;
			else if (num == candidate3)
				count3++;
			else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else if (count3 == 0) {
				candidate3 = num;
				count3 = 1;
			} else {
				count1--;
				count2--;
				count3--;
			}
		}
		count1 = 0;
		count2 = 0;
		count3 = 0;
		for (int num : nums) {
			if (num == candidate1)
				count1 += 3;
			else
				count1--;
			if (num == candidate2)
				count2 += 3;
			else
				count2--;
			if (num == candidate3)
				count3 += 3;
			else
				count3--;
		}
		if (count1 > 0)
			rst.add(candidate1);
		if (count2 > 0)
			rst.add(candidate2);
		if (count3 > 0)
			rst.add(candidate3);
		return rst;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 2, 2, 2, 3, 2 };
		System.out.println(new __2_3__Majority().findMajority(nums1));

		int[] nums2 = { 1, 1, 1, 2, 2, 2, 3, 3 };
		System.out.println(new __2_3__Majority().findMajority2(nums2));

		int[] nums3 = {1,1,1,2,2,2,3,3,3,4};
		System.out.println(new __2_3__Majority().findMajority3(nums3));
	}

}
