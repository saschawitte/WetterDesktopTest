package test;

public class RegularExpressionsTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sName = "blablablbal unnötiges \n zeug und so weiter abver hauptsache keine special chars Tmax und dann noch mer blablabla Tmax bla bal bla";

		if (sName.matches("(?sm).*Tmax.*"))
			System.out.println("true");
		else
			System.out.println(false);

	}

}
