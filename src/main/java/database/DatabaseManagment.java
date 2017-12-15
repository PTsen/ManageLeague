package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import manageleague.League;
import manageleague.Match;
import manageleague.Team;
import org.bson.Document;
import java.util.List;

/**
 * Created by Salim on 08/12/2017.
 */
public class DatabaseManagment {

    private MongoClient mongoClient_;
    private MongoClientURI mongoUri_;
    private MongoDatabase mongoDatabase_;
    private MongoCollection<Document> matchsCollection;
    private MongoCollection<Document> leagueCollection;
    private MongoCollection<Document> teamsCollection;
    private static String MATCH_COLLECTION ="Matches";
    private static String LEAGUE_COLLECTION= "League";
    private static String TEAM_COLLECTION = "Teams";
    private Document league_;

    private static DatabaseManagment ourInstance = new DatabaseManagment();

    public static DatabaseManagment getInstance() {
        return ourInstance;
    }

    private DatabaseManagment() {
        mongoUri_ = new MongoClientURI("mongodb://tdd_groupe5:hello2017@ds129386.mlab.com:29386/alcohols");
        mongoClient_ = new MongoClient(mongoUri_);
        mongoDatabase_ = mongoClient_.getDatabase(mongoUri_.getDatabase());
        matchsCollection = mongoDatabase_.getCollection(MATCH_COLLECTION);
        leagueCollection = mongoDatabase_.getCollection(LEAGUE_COLLECTION);
        teamsCollection = mongoDatabase_.getCollection(TEAM_COLLECTION);
    }

    public void putData(League league){

        creatMatch(league.getList_of_matches());
        creatTeam(league.getList_of_teams());
        this.league_ = new Document ("Name",league.getName());
        leagueCollection.insertOne(league_);

    }

    private void creatMatch (List <Match> m) {

        for (Match match:m) {
            String team = match.getHome_team()+" - "+match.getAway_team();
            String point = match.getScore_t1() + " - "+match.getScore_t2();
            Document match_ = new Document (" Match ",team)
                    .append(" Date ", match.getMatch_date())
                    .append(" Score",point);
            this.league_.put("Match",match_);
            matchsCollection.insertOne(match_);
        }
    }

    private void creatTeam (List <Team> t){

        for (Team team: t){
            Document team_ = new Document(" Position", team.getPosition())
                    .append(" Name", team.getName())
                    .append( " Score", team.getPoints());
            teamsCollection.insertOne(team_);
        }
    }
}
