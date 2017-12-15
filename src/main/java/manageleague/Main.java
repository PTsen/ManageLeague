package manageleague;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		League test = League.getInstance();
		test.init("Champion's League", "01/01/2001", "01/07/2001");
		
		test.addTeams("Belgium");
		test.addTeams("Holland");
		test.addTeams("France");
		test.addTeams("Germany");
		
		test.addMatch("Belgium", "France", "01/01/2001");
		System.out.println(test.getNbr_teams());

		Date tst = test.convertToDate("01/01/2001");
		System.out.println(tst);

	}

}
