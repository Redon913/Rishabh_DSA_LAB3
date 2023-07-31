
import java.util.Scanner;
import java.util.Stack;

public class Bracket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String Bracket Expression:");
		String bracketExpression = sc.nextLine();
		boolean result;

		result = isBracketBalanced(bracketExpression);
		if (result)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets ");
	}

	private static boolean isBracketBalanced(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < bracketExpression.length(); i++) {
			Character ch = bracketExpression.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[')
				stack.push(ch);
			else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}

		}
		return stack.isEmpty() ? true : false;
	}

}
