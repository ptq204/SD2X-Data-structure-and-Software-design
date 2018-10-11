import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		/* IMPLEMENT THIS METHOD! */
		List<Sentence> listSen = new ArrayList<>();
		if(filename == null)
			return listSen;
		Charset charset = Charset.forName("US-ASCII");
		Path file = Paths.get(filename);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	int score;
		    	String text = null;
		    	if(!line.equals("")) {
			    	if(line.charAt(0) == '-') {
			    		String strScore = line.trim().split("\\s+")[0];
			    		if(strScore.equals("-1") || strScore.equals("-2"))
			    			score = Integer.valueOf(strScore);
			    		else continue;
			    		if(line.length() <= 2) continue;
			    		text = line.substring(3);
			    	}
			    	else {
			    		String strScore = line.trim().split("\\s+")[0];
			    		if(strScore.equals("1") || strScore.equals("0") || strScore.equals("2"))
			    			score = Integer.valueOf(strScore);
			    		else continue;
			    		if(line.length() <= 1) continue;
			    		text = line.substring(2);
			    	}
			    	listSen.add(new Sentence(score, text));
			        System.out.println(line);
		    	}
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return listSen; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		/* IMPLEMENT THIS METHOD! */
		Set<Word> words = new HashSet<>();
		if(sentences != null) {
			Set<String> word_check = new HashSet<>();
			for(Sentence sentence : sentences) {
				if(sentence != null) {
					StringTokenizer st = new StringTokenizer(sentence.getText());
					while(st.hasMoreTokens()) {
						String word = st.nextToken().toLowerCase();
						char start = word.charAt(0);
						if(((start > 64 && start < 91) || (start > 96 && start < 123))) {
							if(!word_check.contains(word)) {
								Word w = new Word(word);
								w.increaseTotal(sentence.getScore());
								words.add(w);
								word_check.add(word);
							}
							else {
								for(Word w : words) {
									if(w.getText().equals(word)) {
										w.increaseTotal(sentence.getScore());
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		return words; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		Map<String, Double> word_scores = new HashMap<>();
		if(words == null)
			return word_scores;
		for(Word word : words) {
			if(word != null) {
				word_scores.put(word.getText(), word.calculateScore());
			}
		}
		return word_scores; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		if(wordScores == null || wordScores.isEmpty() || sentence == null || sentence.equals("")) {
			return 0;
		}
		StringTokenizer st = new StringTokenizer(sentence.toLowerCase());
		int cnt = 0;
		double s = 0.0;
		while(st.hasMoreTokens()) {
			String word = st.nextToken();
			char start = word.charAt(0);
			if(((start > 64 && start < 91) || (start > 96 && start < 123))) {
				if(wordScores.containsKey(word)) {
					s+=wordScores.get(word).doubleValue();
				}
			}
			cnt++;
		}
		return s/cnt; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
