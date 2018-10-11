import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks(){
		Path file = Paths.get(fileName);
		Charset charset = Charset.forName("US-ASCII");
		
		List<Book> allBooks = new ArrayList<>();
		
		try(BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line = null;
			while((line=reader.readLine()) != null) {
				if(!line.equals("")) {
					String[] data = line.split("\t");
					String title = data[0];
					String author = data[1];
					int year = Integer.valueOf(data[2]);
					allBooks.add(new Book(title, author, year));
				}
			}
		}catch(IOException ioe) {
			
		}
		return allBooks;
	}
}
