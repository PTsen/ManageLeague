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

    public static void displayMatchGeneration(Match[] match){
        System.out.println("Les équipes sont générés. Voici la liste :");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf( "|         HOME          |         AWAY          |         DATE         |");
        System.out.println("------------------------------------------------------------------------");
        for(int i=0; i<match.length;i++){
            System.out.println( match[i].getHome_team()+"     "+match[i].getAway_team()+"     "+match[i].getMatch_date());
        }

    }
}
