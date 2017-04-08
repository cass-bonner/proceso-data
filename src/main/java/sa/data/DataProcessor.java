package sa.data;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.apache.commons.io.IOUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import sa.data.dao.ResourceDao;
import sa.data.model.Request;
import sa.data.model.ResourceDetail;

public class DataProcessor implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        context.getLogger().log("Input: " + inputStream);


        String body = IOUtils.toString(inputStream);


        context.getLogger().log("Stream body: " + body);
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();

        Request request = getGson().fromJson(body, Request.class);

        String s3Path = request.getS3Path();
        String objectID =  request.getRes().getObjectID();
        String s3Key =  request.getRes().getS3Key();

        context.getLogger().log("s3Path: " + s3Path + " : " + "objectId: " + objectID);

        String revised = s3Path.replace("//s3.amazonaws.com/","//");
          System.out.println("Revised: " + revised);
          //
          String revised3 = revised.replace("wqxcd/us-west","wqxcd.s3.amazonaws.com/us-west");try (InputStream stream = new URL(revised3).openStream()) {
          System.out.println("Revised last: " + revised3);    //LambdaFunctionHandler.class.getResourceAsStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            System.out.println("Metadata: " + metadata);
        } catch (Exception e) {
            System.out.println("e: " + e.getMessage());
        }

        BodyContentHandler contentHandler = new BodyContentHandler();

        AutoDetectParser contentParser = new AutoDetectParser();
        Metadata contentMetadata = new Metadata();
        try (InputStream stream = new URL(revised3).openStream()) {
            contentParser.parse(stream, contentHandler, contentMetadata);
            System.out.println("Content  Metadata: " + contentHandler.toString());

        } catch (Exception e) {

            System.out.println("e: " + e.getMessage());
        }

        // we'll store a generic icon for each application name type.
        String imageId = metadata.get("Application-Name");
        if (imageId == null) {
            imageId = metadata.get("Content-Type").replaceAll("/","");
        }
        if (imageId == null) {
            imageId = "UnknownType";
        }
        context.getLogger().log("image id: " + imageId);

        Set<String> tags =  new HashSet<String>() ;
        tags.add("Resource ID: " + objectID);
        tags.add("s3Key: " + s3Key);
        String paragraphCount = metadata.get("paragraph-count");
        if (paragraphCount == null)    {
            paragraphCount = "N/A";
        }
        tags.add("paragraph-count: " + paragraphCount);
        String wordCount = metadata.get("word-count");
        if (wordCount == null)     {
            wordCount = "N/A";
        }
        tags.add("word-count: " + wordCount);
        tags.add("Extracted-Content: " +   contentHandler.toString());

        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setImageID(System.currentTimeMillis() + "-" + imageId.replaceAll(" ","") + ".png");
        resourceDetail.setAlbumID("aminalz/photos");
        resourceDetail.setUserID("aminalz");
        resourceDetail.setImageFormat(metadata.get("Content-Type"));
        resourceDetail.setTags(tags);
        resourceDetail.setUploadTime(Math.round(System.currentTimeMillis()/1000));

        context.getLogger().log("Resource detail: " +resourceDetail);

//        ResourceDao resourceDao = ResourceDao.getInstance();
//        resourceDao.createResource(resourceDetail);

        outputStream.write(getGson().toJson(resourceDetail,ResourceDetail.class).getBytes());




    }

    protected Gson getGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}

