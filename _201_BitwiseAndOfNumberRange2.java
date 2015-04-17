package leo.algorithms;

/**
 * 
 * @author zyongbo
 * @problem Given a range [m,n] where 0<=m<=n<=2147483647, return the bitwise AND of all numbers in this range, inclusive
 * @problem For example, given the range [5,7], you should return 4
 * 
 */

public class _201_BitwiseAndOfNumberRange2 {

	public int rangeBitwiseAnd(int m, int n) {
		final int result = m & n;
		
		int diff = n - m;
		int mask = 0;
		
		while(diff>0) {
			mask = mask << 1 | 1;
			diff >>>= 1;
		}
		return result & ~mask;
	}
}
