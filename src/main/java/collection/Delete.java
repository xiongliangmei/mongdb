package collection;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import mogodb.Collection;
import org.bson.Document;

import javax.sql.rowset.FilteredRowSet;

/***
 * 删除文档
 */
public class Delete {
    public static void main(String[] args) {
        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost",27017);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        MongoCollection<Document> collection = mongoDatabase.getCollection("test");//得到集合

       // collection.deleteOne(Filters.eq("likes",100));
        collection.deleteMany(Filters.eq("likes",200));

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }
}
