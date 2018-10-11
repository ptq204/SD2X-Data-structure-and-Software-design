import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		Stack<HtmlTag> TagStack = new Stack<>();
		
		while(!tags.isEmpty()) {
			HtmlTag tag = tags.poll();
			if(tag.isOpenTag()) {
				TagStack.push(tag);
			}
			else if(!tag.isSelfClosing()){
				if(!TagStack.isEmpty()) {
					HtmlTag lastTag = TagStack.peek();
					if(lastTag.matches(tag)) {
						TagStack.pop();
					}
					else {
						break;
					}
				}
				else {
					return null;
				}
			}
		}
		return TagStack; // this line is here only so this code will compile if you don't modify it
	}
	

}

