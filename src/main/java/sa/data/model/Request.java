package sa.data.model;

/**
 * Created by bonnerca on 26/03/2017.
 */
public class Request {

    private String correlationId;
    private String s3Path;
    private String hashtags;
    private String processingInstructions;
    private Res res;


    public class Res {
        private String processingType;
        private String s3Key;
        private String objectID;

        @Override
        public String toString() {
            return "Res{" +
                    "processingType='" + processingType + '\'' +
                    ", s3Key='" + s3Key + '\'' +
                    ", objectID='" + objectID + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Res res = (Res) o;

            if (processingType != null ? !processingType.equals(res.processingType) : res.processingType != null)
                return false;
            if (s3Key != null ? !s3Key.equals(res.s3Key) : res.s3Key != null) return false;
            return objectID != null ? objectID.equals(res.objectID) : res.objectID == null;

        }

        @Override
        public int hashCode() {
            int result = processingType != null ? processingType.hashCode() : 0;
            result = 31 * result + (s3Key != null ? s3Key.hashCode() : 0);
            result = 31 * result + (objectID != null ? objectID.hashCode() : 0);
            return result;
        }

        public String getProcessingType() {

            return processingType;
        }

        public void setProcessingType(String processingType) {
            this.processingType = processingType;
        }

        public String getS3Key() {
            return s3Key;
        }

        public void setS3Key(String s3Key) {
            this.s3Key = s3Key;
        }

        public String getObjectID() {
            return objectID;
        }

        public void setObjectID(String objectID) {
            this.objectID = objectID;
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "correlationId='" + correlationId + '\'' +
                ", s3Path='" + s3Path + '\'' +
                ", hashtags='" + hashtags + '\'' +
                ", procxessingInstructions='" + processingInstructions + '\'' +
                ", res=" + res +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (correlationId != null ? !correlationId.equals(request.correlationId) : request.correlationId != null)
            return false;
        if (s3Path != null ? !s3Path.equals(request.s3Path) : request.s3Path != null) return false;
        if (hashtags != null ? !hashtags.equals(request.hashtags) : request.hashtags != null) return false;
        if (processingInstructions != null ? !processingInstructions.equals(request.processingInstructions) : request.processingInstructions != null)
            return false;
        return res != null ? res.equals(request.res) : request.res == null;

    }

    @Override
    public int hashCode() {
        int result = correlationId != null ? correlationId.hashCode() : 0;
        result = 31 * result + (s3Path != null ? s3Path.hashCode() : 0);
        result = 31 * result + (hashtags != null ? hashtags.hashCode() : 0);
        result = 31 * result + (processingInstructions != null ? processingInstructions.hashCode() : 0);
        result = 31 * result + (res != null ? res.hashCode() : 0);
        return result;
    }

    public String getCorrelationId() {

        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getS3Path() {
        return s3Path;
    }

    public void setS3Path(String s3Path) {
        this.s3Path = s3Path;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public String getProcessingInstructions() {
        return processingInstructions;
    }

    public void setProcessingInstructions(String processingInstructions) {
        this.processingInstructions = processingInstructions;
    }

    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }
}
