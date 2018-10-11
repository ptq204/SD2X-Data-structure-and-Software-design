import java.util.List;
import java.util.Set;

public class drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Analyzer analyzer = new Analyzer();
		List<Sentence> arr = analyzer.readFile("D:\\Courses\\Data structures and Software design\\hw3\\test6.txt");
		Set<Word> set = analyzer.allWords(arr);
		System.out.println(arr.get(0).getText());
	}

}
