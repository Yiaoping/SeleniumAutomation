package sikuli;

import org.sikuli.script.Pattern;

public class test {
	private static final Pattern expectedResult = new Pattern("..\\..\\..\\..\\..\\src\\sikuli\\careers.png").similar(0.8);
	
	public static void main(String args[]) {
		if(s.exists(expectedResult)!=null) {
			System.out.println("Successful");
		}else
			System.out.println("Failed");
	}

	
}
