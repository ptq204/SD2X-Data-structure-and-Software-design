/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> movies = new LinkedList<>();
		if(movieRatings != null && !movieRatings.isEmpty()) {
			movies = new LinkedList<>(movieRatings.keySet());
			Collections.sort(movies);
		}
		return movies; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> movies = new LinkedList<>();
		if(movieRatings != null && !movieRatings.isEmpty()) {
			for(Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
				if(entry.getValue().peek() > rating) {
					movies.add(entry.getKey());
				}
			}
		}
		return movies; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, Integer> removedMovies = new TreeMap<>();
		List<String> removeFromInput = new LinkedList<>();
		if(movieRatings != null && !movieRatings.isEmpty()) {
			for(Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
				PriorityQueue<Integer> ratings = entry.getValue();
				Integer tmp = ratings.peek();
				int cnt = 0;
				while(tmp != null && tmp < rating) {
					ratings.remove();
					cnt++;
					if(ratings.isEmpty()) {
						break;
					}
					tmp = ratings.peek();
				}
				if(cnt != 0) {
					removedMovies.put(entry.getKey(), cnt);
				}
				if(ratings.isEmpty()) {
					removeFromInput.add(entry.getKey());
				}
			}
		}
		if(!removeFromInput.isEmpty()) {
			for(int i = 0; i < removeFromInput.size(); i++)
				movieRatings.remove(removeFromInput.get(i));
		}
		return removedMovies; // this line is here only so this code will compile if you don't modify it
	}
}
