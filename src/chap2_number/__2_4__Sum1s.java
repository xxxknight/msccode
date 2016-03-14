package chap2_number;

public class __2_4__Sum1s {
	public long sum1s(long n){
		long cnt = 0;
		long factor = 1;
		int lowBit = 0;
		int curBit = 0;
		int highBit = 0;
		
		while (n / factor != 0) {
			lowBit = (int) (n - (n / factor) * factor);
			curBit = (int) ((n / factor) % 10);
			highBit = (int) (n / (factor * 10));
			
			switch (curBit) {
			case 0:
				cnt += highBit * factor;
				break;

			case 1:
				cnt += highBit * factor + lowBit + 1;
				break;
				
			default:
				cnt += (highBit + 1) * factor;
				break;
			}
			
			factor *= 10;
		}
		
		return cnt;
	}
	
	public long countN(){
		for (long i = 99999999999L; i > 0; i--) {
			if (sum1s(i) == i) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(new __2_4__Sum1s().sum1s(99999999998L));
		System.out.println(new __2_4__Sum1s().countN());
	}

}
