
import java.util.Date;

public abstract class Document {
	private String title;
	private String author;
	private Date date;
	private PublishingLocation location;
	
	public Document(String title, String author, Date date, String city, String state, String postCode) {
		this.title = title;
		this.author = author;
		this.location = new PublishingLocation(city, state, postCode);
	}
	public String getTitle() {
		return title;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getCity() {
		return location.getCity();
	}
	
	public String getState() {
		return location.getState();
	}
	
	public String getPostCode() {
		return location.getPostCode();
	}
	
	public boolean sameAuthor(Document article){
		return author.equals(article.getAuthor());
	}
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}
	
	public int compareDates(Document article) {
		return this.date.compareTo(article.getDate());
	}
}
