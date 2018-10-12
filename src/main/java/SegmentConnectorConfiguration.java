import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;

import java.util.Properties;

public class SegmentConnectorConfiguration extends KinesisConnectorConfiguration {
    /**
     * Configure the connector application with any set of properties that are unique to the application. Any
     * unspecified property will be set to a default value.
     *
     * @param properties          the System properties that will be used to configure KinesisConnectors
     * @param credentialsProvider
     */

    public static final String PROP_SEGMENT_WRITE_KEY = "segmentWriteKey";
    public static final String DEFAULT_SEGMENT_WRITE_KEY = "";
    public final String SEGMENT_WRITE_KEY;

    public SegmentConnectorConfiguration(Properties properties, AWSCredentialsProvider credentialsProvider) {
        super(properties, credentialsProvider);

        SEGMENT_WRITE_KEY = properties.getProperty(PROP_SEGMENT_WRITE_KEY, DEFAULT_SEGMENT_WRITE_KEY);
    }
}