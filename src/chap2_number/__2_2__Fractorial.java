package chap2_number;

public class __2_2__Fractorial {

	/**
	 * ������һ��N�Ľ׳�N!ĩβ�ж��ٸ�0.
	 * 
	 * @param N
	 * @return
	 */
	public int tailZero(int N) {
		int cnt = 0;
		while (N > 0) {
			N /= 5;
			cnt += N;
		}
		return cnt;
	}

	/**
	 * �������N!�к���������2�ĸ���
	 * 
	 * @param N
	 * @return
	 */
	public int lowestOne(int N) {
		int ret = 0;
		while (N > 0) {
			N >>= 1;
			ret += N;
		}
		return ret;
	}

	/**
	 * N!�к���������2�ĸ�����������N��ȥN�Ķ����Ʊ�ʾ��1����Ŀ��
	 * 
	 * @param N
	 * @return
	 */
	public int lowestOne2(int N) {
		int b = N;
		int cnt = 0;
		while (b > 0) {
			b &= (b - 1);
			cnt++;
		}
		return N - cnt;
	}

	public static void main(String[] args) {
		System.out.println(new __2_2__Fractorial().tailZero(25));
		System.out.println(new __2_2__Fractorial().lowestOne(5));
		System.out.println(new __2_2__Fractorial().lowestOne2(5));
		System.out.print(Integer.toBinaryString(5 * 4 * 3 * 2));
	}
}
