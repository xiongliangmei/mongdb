package mogodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Collection {

    public static void main(String[] args) {
        MongoClient mongoClient = MogoDB.getMogoClient();
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        System.out.println("Connect to database successfully");

        //创建集合
        MongoCollection<Document> collection =mongoDatabase.getCollection("tests");
        System.out.println("集合 test 选择成功");
    }
}
