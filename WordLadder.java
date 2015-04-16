package leo.algorithms;

import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {

	//this method cannot find the optimal path ...
	public int ladderLength1(String start, String end, HashSet<String> dict) {
		int len = 0;
		for(int i=0; i<start.length(); i++) {
			char[] startArr = start.toCharArray();
			
			for(char c='a'; c<='z'; c++) {
				if(c==startArr[i])
					continue;
				startArr[i] = c;
				String tmp = new String(startArr);
				if(dict.contains(tmp)) {
					len++;
					start = tmp;
					if(tmp.equals(end))
						return len;
				}
			}
		}
		return len;
	}
	
	//can only find the first valid path
	public int ladderLength2(String start, String end, HashSet<String> dict) {
		if(dict.size()==0)
			return 0;
		dict.add(end);
		
		LinkedList<String> wordQueue = new LinkedList<>();
		LinkedList<Integer> distanceQueue = new LinkedList<>();
		
		wordQueue.add(start);
		distanceQueue.add(1);
		
		int result = Integer.MAX_VALUE;
		while(!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
			
			if(currWord.equals(end))
				result = Math.min(result, currDistance);
			for(int i=0; i<currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for(char c='a'; c<='z'; c++) {
					currCharArr[i] = c;
					
					String newWord = new String(currCharArr);
					if(dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance+1);
						dict.remove(newWord);
					}
				}
			}
		}
		if(result<Integer.MAX_VALUE)
			return result;
		else
			return 0;
	}
}
