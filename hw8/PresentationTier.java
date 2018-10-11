import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void showBookTitlesByAuthor() {
		Scanner reader = new Scanner(System.in);
		String author = reader.nextLine();
		reader.close();
		List<String> titles = logicTier.findBookTitlesByAuthor(author);
		if(!titles.isEmpty()) {
			for(String title : titles) {
				System.out.println(title);
			}
		}
	}
	
	public void showNumberOfBooksInYear() {
		Scanner reader = new Scanner(System.in);
		int year = reader.nextInt();
		reader.close();
		int cnt = logicTier.findNumberOfBooksInYear(year);
		System.out.println(cnt);
	}
	
	public void start() {
		
		/* IMPLEMENT THIS METHOD */
		showBookTitlesByAuthor();
		showNumberOfBooksInYear();
	}
	

}
