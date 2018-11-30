package mogodb;

import com.mongodb.MongoClient;

/***
 * mogodb 连接
 */
public class MogoDB {

    public static MongoClient getMogoClient(){
        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        return  getMogoClient();
    }
}
