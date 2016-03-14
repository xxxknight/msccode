package chap2_number;

public class __2_9__Fibonacci {
	/**
	 * 斐波拉切数列 方法一：递归，效率低
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci1(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci1(n - 1) + fibonacci1(n - 2);
		}
	}

	/**
	 * 方法二：暂存值，类似动态规划O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci2(int n) {
		if (n <= 0) {
			return 0;
		}else if (n <= 2){
			return 1;
		}else {
			int a = 1;
			int b = 1;
			int res = 0;
			for (int i = 3; i <= n; i++) {
				res = a + b;
				a = b;
				b = res;
			}
			return res;
		}
	}
	
	

	public static void main(String[] args) {
		System.out.println(new __2_9__Fibonacci().fibonacci1(10));
		System.out.println(new __2_9__Fibonacci().fibonacci2(10));
	}
}
