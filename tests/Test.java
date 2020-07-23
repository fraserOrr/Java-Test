

import WordLengthPackage.*;


public class Test{
	public static void main(String[] args)throws Exception{
		WordLength wordLengthFinder = new WordLength();
		wordLengthFinder.Evaluate("tests/" + args[0]);
	}
}