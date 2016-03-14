package chap2_number;

public class __2_7__GCD {
	/**
	 * ʹ��ȡ��շת�����Ч�ʽϵ�
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int gcd1(int x, int y) {
		return y == 0 ? x : gcd1(y, x % y);
	}

	/**
	 * ʹ�ü���ʵ��շת�����Ч����ߡ����ڲ��㣺����������ȡ��ķ�ʽ���˲��١� ��������(10 000 000 000
	 * 000,1)����������ͻ�Ч�ʺܵ͡�
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int gcd2(int x, int y) {
		if (x < y) {
			return gcd2(y, x);
		}
		if (y == 0) {
			return x;
		} else {
			return gcd2(x - y, y);
		}
	}

	/**
	 * ���ǰ���ֵķ�ʽ
	 * @param x
	 * @param y
	 * @return
	 */
	public int gcd3(int x, int y) {
		if (x < y) {
			return gcd3(y, x);
		}
		if (y == 0) {
			return x;
		} else {
			if (x % 2 == 0) {
				if (y % 2 == 0) {
					return gcd3(x >> 1, y >> 1) << 1;
				} else {
					return gcd3(x >> 1, y);
				}
			} else {
				if (y % 2 == 0) {
					return gcd3(x, y >> 1);
				} else {
					return gcd3(y, x - y);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new __2_7__GCD().gcd1(42, 30));
		System.out.println(new __2_7__GCD().gcd2(42, 30));
		System.out.println(new __2_7__GCD().gcd3(42, 30));
	}
}
