package manageleague;

public class Main {

	public static void main(String[] args) {
		League test = League.getInstance();
		test.init("Champion's League", "01/01/2001", "01/07/2001");
		
		test.addTeams("Belgium");
		test.addTeams("Holland");
		test.addTeams("France");
		test.addTeams("Germany");
	}

}
