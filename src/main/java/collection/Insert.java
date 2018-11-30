package collection;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/***
 * 增加文档
 */
public class Insert {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
        //插入文档
        /***
         * 1.创建文档  org.bson.Document 参数为 key-value
         */

        Document document = new Document("id","1")
                .append("user","lin")
                .append("password","123456")
                .append("test","sdfdsfds");

        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents); //增加文档

        /***
         * 遍历查看
         */
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }
}
