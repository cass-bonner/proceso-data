package sa.data.dao;

import org.apache.log4j.Logger;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.gson.Gson;
import sa.data.model.ResourceDetail;

/**
 * Created by bonnerca on 26/03/2017.
 */
public class ResourceDao {

    private static ResourceDao instance = null;
    private static Logger logger = Logger.getLogger(ResourceDao.class);

    // credentials for the client come from the environment variables
    // pre-configured by Lambda. These are tied to the
    // Lambda function execution role.
    private static AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient();

    /**
     * Returns the initialized default instance of the OrderDao
     * <p>
     * Not threadsafe but ok since contained instantiation
     *
     * @return An initialized OrderDao instance
     */
    public static ResourceDao getInstance() {
        if (instance == null) {
            instance = new ResourceDao();
        }
        return instance;
    }

    protected ResourceDao() {
        // protect instantiation
    }

    public void createResource(ResourceDetail resourceDetail) {

        logger.debug("resourceDetail: " + resourceDetail);

        getMapper().save(resourceDetail);

    }

    /**
     * Returns a DynamoDBMapper object initialized with the default DynamoDB
     * client
     *
     * @return An initialized DynamoDBMapper
     */
    protected DynamoDBMapper getMapper() {
        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));
        return new DynamoDBMapper(ddbClient);
    }

}