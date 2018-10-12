
package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("ClientType")
    @Expose
    private String clientType;
    @SerializedName("EventType")
    @Expose
    private String eventType;
    @SerializedName("EventGeneratedTimestamp")
    @Expose
    private String eventGeneratedTimestamp;
    @SerializedName("MetaData")
    @Expose
    private MetaData metaData;
    @SerializedName("EventVersion")
    @Expose
    private String eventVersion;

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventGeneratedTimestamp() {
        return eventGeneratedTimestamp;
    }

    public void setEventGeneratedTimestamp(String eventGeneratedTimestamp) {
        this.eventGeneratedTimestamp = eventGeneratedTimestamp;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public String getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

}

//
