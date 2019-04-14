package test;

public class RegularExpressionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sName = "TestLeaf 2013 CHENNAI";
		
		if(sName.matches("Test[A-Z]... 201[0-9].*"))
			System.out.println("true");
		else
			System.out.println(false);

	}

}
