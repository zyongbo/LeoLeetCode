package leo.algorithms;

/**
 * 
 * @author zyongbo
 * @problem Given a range [m,n] where 0<=m<=n<=2147483647, return the bitwise AND of all numbers in this range, inclusive
 * @problem For example, given the range [5,7], you should return 4
 * 
 */

public class _201_BitwiseAndOfNumberRange {

	public int rangeBitwiseAnd(int m, int n) {
		if(m==0)
			return 0;
		int result = 0;
		int tmp = m;
		int[] bits = new int[32];
		for(int i=0; i<32; i++) {
			bits[i] = (tmp&1);
			tmp >>>= 1;
		}
		
		int carry = (n-m);
		for(int i=0; i<32; i++) {
			carry = (carry + bits[i])/2;
			if(bits[i]+carry>1)
				bits[i] = 0;
		}
		
		for(int i=21; i>=0; i--) {
			result <<= 1;
			result += bits[i];
		}
		
		return result;
	}
}
