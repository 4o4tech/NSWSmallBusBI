package com.business.system.model;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class QueryCollectionService {
    @Resource
    private MongoTemplate mongoTemplate;


    /**
     * get collection
     *
     * @return  Object [collection name]
     */
    public Object getCollectionNames() {

        return mongoTemplate.getCollectionNames();
    }

//
//    /**
//     * check collection exist
//     *
//     * @return boolean[exist or not]
//     */
//    public static boolean collectionExists() {
//        // getName
//        String collectionName = "cafe";
//        //
//        return mongoTemplate.collectionExists(collectionName);
//    }


}
