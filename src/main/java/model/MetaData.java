
package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaData {

    @SerializedName("SourceEntityType")
    @Expose
    private String sourceEntityType;
    @SerializedName("SourceEntityId")
    @Expose
    private String sourceEntityId;
    @SerializedName("TargetEntityType")
    @Expose
    private String targetEntityType;
    @SerializedName("TargetEntityId")
    @Expose
    private String targetEntityId;
    @SerializedName("ReportingValue")
    @Expose
    private Integer reportingValue;
    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;
    @SerializedName("UserToken")
    @Expose
    private String userToken;
    @SerializedName("UserId")
    @Expose
    private String userId;
    @SerializedName("EventSource")
    @Expose
    private String eventSource;
    @SerializedName("EventProvider")
    @Expose
    private String eventProvider;
    @SerializedName("AdId")
    @Expose
    private Integer adId;
    @SerializedName("ListingStatisticsFactType")
    @Expose
    private String listingStatisticsFactType;

    public String getSourceEntityType() {
        return sourceEntityType;
    }

    public void setSourceEntityType(String sourceEntityType) {
        this.sourceEntityType = sourceEntityType;
    }

    public String getSourceEntityId() {
        return sourceEntityId;
    }

    public void setSourceEntityId(String sourceEntityId) {
        this.sourceEntityId = sourceEntityId;
    }

    public String getTargetEntityType() {
        return targetEntityType;
    }

    public void setTargetEntityType(String targetEntityType) {
        this.targetEntityType = targetEntityType;
    }

    public String getTargetEntityId() {
        return targetEntityId;
    }

    public void setTargetEntityId(String targetEntityId) {
        this.targetEntityId = targetEntityId;
    }

    public Integer getReportingValue() {
        return reportingValue;
    }

    public void setReportingValue(Integer reportingValue) {
        this.reportingValue = reportingValue;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventProvider() {
        return eventProvider;
    }

    public void setEventProvider(String eventProvider) {
        this.eventProvider = eventProvider;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getListingStatisticsFactType() {
        return listingStatisticsFactType;
    }

    public void setListingStatisticsFactType(String listingStatisticsFactType) {
        this.listingStatisticsFactType = listingStatisticsFactType;
    }

}