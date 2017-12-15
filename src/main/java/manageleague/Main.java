package manageleague;

import database.DatabaseManagment;

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

		Date tst = test.convertToDate("01/01/2001");
		System.out.println(test.getList_of_teams().get(1).getName());
		DatabaseManagment db = DatabaseManagment.getInstance();
		db.putData(test);
	}

}
