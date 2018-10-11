/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, PriorityQueue<Integer>> movies = new TreeMap<>();
		if(allUsersRatings == null)
			return movies;
		for(UserMovieRating movie : allUsersRatings) {
			if(movie != null) {
				String tmp = movie.getMovie();
				if(tmp != null && !tmp.equals("") && movie.getUserRating() >= 0){
					String title = tmp.toLowerCase();
					if(movies.containsKey(title)) {
						PriorityQueue<Integer> rating = movies.get(title);
						rating.add(movie.getUserRating());
					}
					else {
						PriorityQueue<Integer> heap = new PriorityQueue<>();
						heap.add(movie.getUserRating());
						movies.put(title, heap);
					}
				}
			}
		}
		return movies; // this line is here only so this code will compile if you don't modify it
	}

}
