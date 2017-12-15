package manageleague;

import  java.util.*;
import manageleague.Match;

public class DisplayScore
{

    public static void ScanScore(Match score )
    {
        int score_team_a = 0;
        int score_team_b = 0;

        System.out.println("Bienvenu dans la remise des scores");
        Scanner sc = new Scanner (System.in);
        System.out.println("Veuillez entrer le Score de l'equipe A");

        // scan score equipe A avec test si test si la saisie est bien un entier
        try
        {
            score_team_a = sc.nextInt();
        }
        catch(InputMismatchException ime)
        {
            System.out.println("Valeur saisie non numérique\n"
                    + "ou hors des limites int.");
        }
        System.out.println("Score Equipe A = " + score_team_a);

        // scan score equipe B avec test si test si la saisie est bien un entier
        System.out.println("Veuillez entrer le Score de l'equipe B");
        try{
            score_team_b = sc.nextInt();
        }
        catch(InputMismatchException ime)
        {
            System.out.println("Valeur saisie non numérique\n"
                    + "ou hors des limites int.");
        }
        System.out.println("Score Equipe B = " + score_team_b);

        // set score dans l'objet match
        score.setScores(score_team_a,score_team_b);


    }
}