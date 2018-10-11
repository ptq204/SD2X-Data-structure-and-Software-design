

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {

		/* IMPLEMENT THIS METHOD! */
		if(list == null) {
			return;
		}
		Iterator<Integer> iterator = list.iterator();
		int index = 0;
		boolean added = false;
		while(iterator.hasNext()) {
			if(iterator.next() >= value) {
				list.add(index, value);
				added = true;
				break;
			}
			index++;
		}
		if(!added || list.isEmpty()) list.addLast(value);
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		/* IMPLEMENT THIS METHOD! */
		if(list == null || N < 0) {
			return;
		}
		else {
			LinkedList<String> list_tmp = new LinkedList<>(list);
			Collections.sort(list_tmp, Collections.reverseOrder());
			String prev = null;
			int cnt = 0;
			ArrayList<String> removeList = new ArrayList<>();
			
			for(int i = 0; i < list_tmp.size(); i++) {
				String tmp = list_tmp.get(i);
				if(!tmp.equals(prev)) {
					removeList.add(tmp);
					prev = tmp;
					cnt++;
					if(cnt == N) break;
				}
			}
			
			for(int i = 0; i < list.size(); i++) {
				if(removeList.contains(list.get(i))) {
					list.remove(i);
				}
			}
		}
			
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */
		if(one == null || two == null || one.isEmpty() || two.isEmpty() || two.size() > one.size())
			return false;
		
		for(int i = 0; i < one.size(); i++) {
			int cnt = 0;
			if(i + two.size() > one.size())
				break;
			for(int j = 0; j < two.size(); j++)
			{
				if(!one.get(i+j).equals(two.get(j))) {
					break;
				}
				else cnt++;
			}
			if(cnt == two.size()) return true;
		}
		return false; // this line is here only so this code will compile if you don't modify it
	}
}
