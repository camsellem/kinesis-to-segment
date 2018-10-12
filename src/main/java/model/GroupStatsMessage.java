
package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupStatsMessage {

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("PartitionKey")
    @Expose
    private String partitionKey;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

}
