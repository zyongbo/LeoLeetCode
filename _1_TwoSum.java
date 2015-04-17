package leo.algorithms;

import java.util.HashMap;

/**
 * 
 * @author zyongbo
 * @problem 
 * 
 */

public class _1_TwoSum {

	//complexity of O(n^2)
	public int[] twoSum1(int[] numbers, int target) {
        
        int n = numbers.length;
        int[] result = new int[2];
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(numbers[i]+numbers[j]==target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }
	
	//complexity of O(n)
	public int[] twoSum2(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		
		for(int i=0; i<numbers.length; i++) {
			if(map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index + 1;
				result[1] = i + 1;
				break;
			} else
				map.put(target-numbers[i], i);
		}
		return result;
	}
}
