/*
 * Copyright 2013-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Amazon Software License (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/asl/
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import model.GroupStatsMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.segment.analytics.Analytics;
import com.segment.analytics.messages.TrackMessage;
import com.amazonaws.services.kinesis.connectors.UnmodifiableBuffer;
import com.amazonaws.services.kinesis.connectors.interfaces.IEmitter;

import com.google.gson.Gson;

/**
 * This implementation of IEmitter is used to send 'Track' events to Segment. The use of
 * this class requires the configuration of a Segment workspace with a valid Write Key.
 */

public class SegmentEmitter implements IEmitter<byte[]> {
    private static final Log LOG = LogFactory.getLog(SegmentEmitter.class);
    protected final String segmentWriteKey;
    protected final Analytics analytics;

    public SegmentEmitter(SegmentConnectorConfiguration configuration) {
        this.segmentWriteKey = configuration.SEGMENT_WRITE_KEY;

        analytics = Analytics.builder(this.segmentWriteKey).build();

        LOG.info("SEGMENT WRITE KEY: " + this.segmentWriteKey);
    }

    @Override
    public List<byte[]> emit(final UnmodifiableBuffer<byte[]> buffer) throws IOException {
        List<byte[]> records = buffer.getRecords();
        Gson gsonObject = new Gson();
        GroupStatsMessage myGroupStatsMessage;

        for (byte[] record : records)
            try {
                myGroupStatsMessage = gsonObject.fromJson(new String(record, "ISO-8859-1"), GroupStatsMessage.class);

                analytics.enqueue(TrackMessage.builder(myGroupStatsMessage.getData().getEventType())
                        .userId(myGroupStatsMessage.getData().getMetaData().getUserId())
                        .properties(
                                ImmutableMap.<String, String>builder()
                                        .put("clientType", myGroupStatsMessage.getData().getClientType())
                                        .put("eventVersion", myGroupStatsMessage.getData().getEventVersion())
                                        .put("eventSource", myGroupStatsMessage.getData().getMetaData().getEventSource())
                                        .put("eventProvider", myGroupStatsMessage.getData().getMetaData().getEventProvider())
                                        .put("userToken", myGroupStatsMessage.getData().getMetaData().getUserToken())
                                        .build()
                        )
                );

                LOG.info("Event sent to Segment: " + myGroupStatsMessage.getData().getEventType());

                return Collections.emptyList();
            } catch (Exception e) {
                LOG.error(e);

                return buffer.getRecords();
            }

        return Collections.emptyList();
    }

    @Override
    public void fail(List<byte[]> records) {
        for (byte[] record : records) {
            LOG.error("Record failed: " + new String(record));
        }
    }

    @Override
    public void shutdown() {
        analytics.flush();
    }
}
