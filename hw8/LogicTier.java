import java.util.LinkedList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	public List<String> findBookTitlesByAuthor(String authorName) {
		List<Book> allBooks = dataTier.getAllBooks();
		List<String> titles = new LinkedList<>();
		for (Book book: allBooks) {
			if (book.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
				titles.add(book.getTitle());
			}
		}
		return titles;
	}
	
	public int findNumberOfBooksInYear(int year) {
		List<Book> allBooks = dataTier.getAllBooks();
		int count = 0;
		for(int i = 0; i < allBooks.size(); i++) {
			Book current = allBooks.get(i);
			if(current.getPublicationYear() == year)
				count++;
		}
		return count;
	}
}
