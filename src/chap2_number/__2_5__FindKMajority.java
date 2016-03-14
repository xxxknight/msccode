package chap2_number;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;


public class __2_5__FindKMajority {
	public int[] findKth(int[] nums , int K){
		int[] res = new int[K];
		PriorityQueue<Integer> queue = new PriorityQueue<>(K);
		for (int i = 0; i < nums.length; i++) {
			if (queue.size() < K) {
				queue.add(nums[i]);
			}else{
				if (nums[i] > queue.peek()) {
					queue.poll();
					queue.add(nums[i]);
				}
			}
		}
		int index = 0;
		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()) {
			res[index++] = iterator.next();
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(new __2_5__FindKMajority().findKth(nums, 3)));
		
	}

}
