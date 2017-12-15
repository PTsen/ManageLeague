package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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

}
