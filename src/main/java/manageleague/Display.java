package manageleague;
import java.util.*;

public class Display {

    public static void Display() {

        Scanner sc = new Scanner(System.in);
        String entry;
        String les_equipes[];
        System.out.println("Bienvenue au championnat ! ");
        System.out.print("Commencez par l'ajout des équipes. \n > Combien d'équipes participe au tournois? ");
        int nb_equipes = 0;
        try{
            nb_equipes = sc.nextInt();
        }
        catch(InputMismatchException ime)
        {
            System.out.println("Valeur saisie non numérique\n"
                    + "ou hors des limites int.");
        }
        les_equipes = new String[nb_equipes];
        System.out.println("> Inscriptions des équipes. ");
        for(int i=1; i<nb_equipes+1; i++){
            System.out.print("Equipe "+i+" : ");
            les_equipes[i-1] = sc.next();
        }

        System.out.println("Les équipes ont bien été enregitrées ! ");
    }
}
