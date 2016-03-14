package chap2_number;

public class __2_10__FindMaxAndMin {
	
	public int[] find(int[] nums) {
		if (nums.length <= 0) {
			return null;
		}
		int[] res = new int[2];
		if (nums.length == 1) {
			res[0] = nums[0];
			res[1] = nums[0];
			return res;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int i = 0;
		for (; i < nums.length - 1; i += 2) {
			if (nums[i] > nums[i + 1]) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i + 1]);
			} else {
				max = Math.max(max, nums[i + 1]);
				min = Math.min(min, nums[i]);
			}
		}
		if (i == nums.length - 1) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		res[0] = max;
		res[1] = min;
		System.out.println(max);
		System.out.println(min);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3,2,5};
		System.out.println(new __2_10__FindMaxAndMin().find(nums));
	}

}
