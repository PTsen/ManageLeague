package manageleague;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Display {

    int NB_TEAMS_MIN = 2;
    int NB_TEAMS_MAX = 8;

    public static void Display() {

        Scanner sc = new Scanner(System.in);
        String entry;
        String teams[];
        System.out.println("Bienvenue au championnat ! ");
        System.out.print("Commencez par l'ajout des équipes. \n > Combien d'équipes participe au tournois? (2, 4 ou 8) ");
        int nb_teams = 0;

        try{
            nb_teams = sc.nextInt();
        }
        catch(InputMismatchException ime)
        {
            System.out.println("Valeur saisie non numérique "
                    + "ou hors des limites int.");
        }

        int test_pair = (nb_teams%2);
        boolean notOK = true;
        while(notOK){
            if((nb_teams!=2) && (nb_teams!=4) && (nb_teams!=8)) {
                System.out.println("*!* Il faut 2, 4 ou 8 équipes *!*");
                nb_teams = sc.nextInt();
            }else{
                notOK = false;
            }
        }
        teams = new String[nb_teams];
        System.out.println("> Inscriptions des équipes. ");

        for(int i=1; i<=nb_teams; i++){
            System.out.print("Equipe "+i+" : ");
            //Attention tab[0] est vide inutile (a gerer apres si assez de tps)
            teams[i] = sc.next();
        }
/*
        int nb_date = 1;
        if(nb_teams == 8){
            nb_date = 4;
        }else if(nb_teams==4){
            nb_date = 2;
        }
*/
        System.out.println("> Décision de la période du tournois.");
        System.out.print("Date de début (dd/MM/yyyy) : ");
        String start_date = sc.next();

        System.out.print("Date de fin (dd/MM/yyyy) : ");
        String end_date = sc.next();

        //Methode generate

        System.out.println("Les équipes ont bien été enregitrées ! ");
    }
 /*
    public Match generateMatch(String[] teams, int nb_teams){
        int random_for_team1 = 0;
        int random_for_team2 = 0;
        int[] selected_team = new int[nb_teams];

        for(int i=1; i<=nb_teams; i++){
            selected_team[i] = 0;
        }

        for(int i=1; i<=nb_teams; i++) {
            random_for_team1 = NB_TEAMS_MIN + (int) (Math.random() * ((nb_teams - NB_TEAMS_MIN) + 1));
            random_for_team2 = NB_TEAMS_MIN + (int) (Math.random() * ((nb_teams - NB_TEAMS_MIN) + 1));

            boolean notOK = true;
            while(notOK) {
                //random_for_team2 == random_for_team1) &&
                if((isFill(selected_team, random_for_team1)) && (isFill(selected_team, random_for_team2))) {
                    random_for_team1 = NB_TEAMS_MIN + (int) (Math.random() * ((nb_teams - NB_TEAMS_MIN) + 1));
                    random_for_team2 = NB_TEAMS_MIN + (int) (Math.random() * ((nb_teams - NB_TEAMS_MIN) + 1));
                }else{
                    selected_team[random_for_team1] = 1;
                    selected_team[random_for_team2] = 1;

                    Team t1 = new Team(teams[random_for_team1]);
                    Team t2 = new Team(teams[random_for_team2]);
                    Match match = new Match(t1,t2,);
                }
            }




        }



    }

    public boolean isFill(int[] selected_teams, int random){
        if(selected_teams[random] != 0){
            return true;
        }else{
            return false;
        }
    }
    */
}
