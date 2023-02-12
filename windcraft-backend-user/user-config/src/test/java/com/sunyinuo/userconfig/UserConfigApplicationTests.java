package com.sunyinuo.userconfig;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserConfigApplicationTests {

    @Test
    void contextLoads() {
        MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("userCoverPicture");
        MongoCollection<Document> collection = mongoDatabase.getCollection("fileUpload");

    }

}
