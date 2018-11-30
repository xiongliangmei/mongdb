package collection;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/***
 * 修改文档
 */
public class Update {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");

        /***
         * 更新文档
         */
        collection.updateMany(Filters.eq("likes",100),new Document("$set",new Document("likes",200)));

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }
}
