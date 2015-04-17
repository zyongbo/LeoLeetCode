package leo.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author zyongbo
 * @problem Given a string, find the length of the longest substring without repeating characters. For example, the longest substring
 * @problem without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbbb" the longest substring is "b", with the length of 1.
 * 
 */

public class _3_LongestSubstringWithoutRepeatingCharacters<Char> {

	//very slow, O(n^3)
	public int lengthOfLongestSubstring(String s) {
		char[] arr = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>(); 
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(map.containsValue(arr[i])) {
				max = Math.max(max, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
			map.put(arr[i], i);
		}
		return Math.max(max, map.size());
	}
	
	//256 size can cover the complete reference for ASCII symbols
	public int lengthOfLongestSubstring2(String s) {
		int len = s.length();
		if(len==0)
			return 0;
		
		int[] countTable = new int[256];
		Arrays.fill(countTable, -1);
		int max = 1;
		int start = 0;
		int end = 1;
		
		countTable[s.charAt(0)] = 0;
		while(end<len) {
			if(countTable[s.charAt(end)]>=start)
				start = countTable[s.charAt(end)] + 1;
			max = Math.max(max, end-start+1);
			countTable[s.charAt(end)] = end;
			end++;
		}
		return max;
	}
	
	//fasted one
	public int lengthOfLongestSubstring4(String s) {
		int len = s.length();
		if(len==0) return 0;
		
		int[] flag = new int[256];
		Arrays.fill(flag, -1);
		int start = 0;
		int end = 1;
		int max = 1;
		
		flag[s.charAt(start)] = start;
		while(end<len) {
			if(flag[s.charAt(end)]>=start) {
				max = Math.max(max, end-start);
				start = flag[s.charAt(end)] + 1;
			}
			flag[s.charAt(end)] = end;
			end++;
		}
		return Math.max(max, len-start);
	}
	
	public int lengthOfLongestSubstring3(String s) {
		boolean[] flag = new boolean[256];
		
		int start = 0;
		char[] arr = s.toCharArray();
		int max = 1;
		
		for(int i=0; i<arr.length; i++) {
			if(flag[arr[i]]) {
				max = Math.max(max, i-start);
				for(int j=start; j<i; j++) {
					if(arr[j]==arr[i]) {
						start = j + 1;
						break;
					}
					flag[arr[j]] = false;
				}
			}
			flag[arr[i]] = true;
		}
		return Math.max(arr.length-start, max);
	}
	
	public static void main(String[] agrs) {
		String s = "thisisatest";
		char[] arr = s.toCharArray();
		
		boolean[] flag = new boolean[256];
		System.out.println(flag[arr[5]]);
	}
}
