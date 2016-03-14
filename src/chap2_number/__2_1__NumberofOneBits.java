package chap2_number;

public class __2_1__NumberofOneBits {
	
	public int numberOfOneBits(byte b) {
		int cnt = 0;
		while (b > 0) {
			b &= (b - 1);
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(new __2_1__NumberofOneBits()
				.numberOfOneBits((byte) 100));

	}
}
