package chap2_number;

/**
 * 1> 第一个问题不难，只要认真分析程序，就能看出来程序求的是这样的数，这个数不能被 rg[k]和rg[k+1]整除(0 <= k <
 * n-1)，同时能被其余所有数(即rg[0],…,rg[k-1]和r[k+2],…,r[n-1])整除。 2>
 * 该问的入手点是寻找rg[k]和rg[k+1]。 首先，rg[k]肯定大于15。若rg[k]<=15的话，那么rg[k]*2也在rg数组中，并且不能被 i
 * 整除，所以这样的 i 肯定找不到。
 * 
 * 其次，rg[k]和rg[k+1]不能由其余的rg数组中的数组合相乘而得，比如18，可以由2乘上9得到，所以若 i 能整除 2 和 9, 则必能整除18.
 * 由此，我们可以得到：
 * 
 * 16=2*8, 18 = 2*9, 20 = 4*5, 22 = 2*11, 24 = 3*8, 26 = 2*13, 28 = 4*7, 30 =
 * 2*15。
 * 
 * 这样乍一看，似乎没有满足条件的rg[k]和rg[k+1]，但是我们注意在上述一串等式中，16=2*8，其中的2是8的因子，所以只要 i
 * 能整除8，就必能整除2，因此没有必要要求 i 能整除 2*8。 而其余的等式中，两个乘数没有因子关系，所以i 若能整除两个乘数，则肯定能整除其乘积。
 * 
 * 由此，我们得到了唯一满足条件的rg[k]和rg[k+1]，即16,17。
 * 
 * 这样，剩下的问题就是求不能整除16,17，却能整除其余所有数的整数中最小的那一个。我们先把2到31中的素数都列出来(17除外)：{2,3,5,7,11,
 * 13
 * ,19,23,29,31}。而2到31中(16,17除外)的数都是由这些素数作为因子组合相乘得到的，其中，要得到8，至少要3个2，要得到27至少要3个3
 * ，要得到25，至少要2个5，其余的素因子都只需一个就够了。
 * 
 * 因此，这个最小的数就是 2^3, 3^3, 5^2, 7, 11, 13, 19, 23, 29,
 * 31的乘积，答案为：2123581660200。（因为题目要求不借助电脑，所以我手算了两次，竟然都算错了，最后只好拿计算器算） 。
 * 
 * 3> 要估算时间，我们先确定一个原子操作（或者说原子过程更合适），这里我们取内层for循环里的整个if语句块，该段程序主要包括一个取模操作和一个判断，
 * 如果进入if语句的话，还包括1次加法操作，1~2次判断和一次赋值操作。
 * 我们知道加法、判断等操作基本都在几个时钟周期内就可以完成，而除法操作却需要数十个时钟周期
 * ，而取模操作也是通过除法操作得到的(还记得汇编语言里，执行除法操作之后
 * ，一个寄存器里存结果，另一个寄存器里存余数)，另外，对64位整数的除法明显要慢于32位整数
 * ，综合这些因素，我们可以假设该原子操作需要100个时钟周期。因此2GHz的CPU在1秒内能跑2*10^9 / 100 = 2*10^7
 * 即2000万次原子操作，做过ACM的同学就会有一个直观概念，这和我们通常做时限为1S的题时估算的计算次数差不多。
 * 
 * 接下来估算原子操作执行的次数：外层循环跑了2123581660200次，内层循环取决于 i
 * 的情况，当i为奇数的时候，内层最多跑5次即可结束，因为2，4，6
 * 都不能整除奇数；当i为偶数的时候，情况要复杂一些，但是也可以一个一个的详细分析。这里我们粗略估计
 * ，就算内层循环平均可以跑10次，外层循环少跑一些，去掉零头，总的原子操作执行了2*10^13次。
 * 
 * 所以需要 2*10^13 / (2*10^7) = 10^6秒约为277个小时。
 * 
 * @author founder
 * 
 */
public class _2_20_FindTheNumber {
	public static void main(String[] args) {
		int[] rg = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
		for (int i = 0; i < Long.MAX_VALUE; i++) {
			int hit = 0;
			int hit1 = -1;
			int hit2 = -1;
			for (int j = 0; (j < rg.length) && (hit <= 2); j++) {
				if ((i % rg[j]) != 0) {
					hit++;
					if (hit == 1) {
						hit1 = j;
					} else if (hit == 2) {
						hit2 = j;
					} else {
						break;
					}
				}
			}
			if ((hit == 2) && (hit1 + 1 == hit2)) {
				System.out.println("found: " + i);
			}
		}
	}

}
