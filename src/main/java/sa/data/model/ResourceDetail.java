package sa.data.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

import java.util.Set;

/**
 * Created by bonnerca on 26/03/2017.
 */

@DynamoDBTable(tableName = "photo-sharing-backend-ImageMetadataDDBTable-1BGNMQLEZKR60")
public class ResourceDetail {


    @DynamoDBHashKey(attributeName = "imageID")
    private String imageID;
    @DynamoDBAttribute(attributeName = "albumID")
    private String albumID;
    @DynamoDBAttribute(attributeName = "dimensions")
    private String dimensions;
    @DynamoDBAttribute(attributeName = "fileSize")
    private String fileSize;
    @DynamoDBAttribute(attributeName = "imageFormat")
    private String imageFormat; //Content-type from metadata
    @DynamoDBAttribute(attributeName = "tags")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
    private Set tags;
    @DynamoDBAttribute(attributeName = "extractedContent")
    private String extractedContent;
    @DynamoDBAttribute(attributeName = "userID")
    private String userID; //aminalz

    public long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(long uploadTime) {
        this.uploadTime = uploadTime;
    }

    @DynamoDBAttribute(attributeName = "uploadTime")
    private long uploadTime; //aminalz

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public Set getTags() {
        return tags;
    }

    public void setTags(Set tags) {
        this.tags = tags;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceDetail that = (ResourceDetail) o;

        if (uploadTime != that.uploadTime) return false;
        if (imageID != null ? !imageID.equals(that.imageID) : that.imageID != null) return false;
        if (albumID != null ? !albumID.equals(that.albumID) : that.albumID != null) return false;
        if (dimensions != null ? !dimensions.equals(that.dimensions) : that.dimensions != null) return false;
        if (fileSize != null ? !fileSize.equals(that.fileSize) : that.fileSize != null) return false;
        if (imageFormat != null ? !imageFormat.equals(that.imageFormat) : that.imageFormat != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (extractedContent != null ? !extractedContent.equals(that.extractedContent) : that.extractedContent != null)
            return false;
        return userID != null ? userID.equals(that.userID) : that.userID == null;

    }

    @Override
    public int hashCode() {
        int result = imageID != null ? imageID.hashCode() : 0;
        result = 31 * result + (albumID != null ? albumID.hashCode() : 0);
        result = 31 * result + (dimensions != null ? dimensions.hashCode() : 0);
        result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
        result = 31 * result + (imageFormat != null ? imageFormat.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (extractedContent != null ? extractedContent.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (int) (uploadTime ^ (uploadTime >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ResourceDetail{" +
                "imageID='" + imageID + '\'' +
                ", albumID='" + albumID + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", imageFormat='" + imageFormat + '\'' +
                ", tags='" + tags + '\'' +
                ", extractedContent='" + extractedContent + '\'' +
                ", userID='" + userID + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
