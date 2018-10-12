import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;
import com.amazonaws.services.kinesis.connectors.impl.AllPassFilter;
import com.amazonaws.services.kinesis.connectors.impl.BasicMemoryBuffer;
import com.amazonaws.services.kinesis.connectors.interfaces.*;
import com.amazonaws.services.kinesis.connectors.s3.S3Emitter;
import com.amazonaws.services.kinesis.model.Record;

import java.io.IOException;

public class SegmentPipeline implements IKinesisConnectorPipeline<byte[],byte[]> {
    @Override
    public IEmitter<byte[]> getEmitter(KinesisConnectorConfiguration configuration) {
        return new SegmentEmitter((SegmentConnectorConfiguration) configuration);
    }

    @Override
    public IBuffer<byte[]> getBuffer(KinesisConnectorConfiguration configuration) {
        return new BasicMemoryBuffer<>(configuration);
    }

    @Override
    public ITransformer<byte[], byte[]> getTransformer(KinesisConnectorConfiguration configuration) {
        return new ByteArrayNoopTransformer();
    }

    @Override
    public IFilter<byte[]> getFilter(KinesisConnectorConfiguration configuration) {
        return new AllPassFilter<>();
    }

    private static class ByteArrayNoopTransformer implements ITransformer<byte[], byte[]> {
        @Override
        public byte[] toClass(Record record) throws IOException {
            return record.getData().array();
        }

        @Override
        public byte[] fromClass(byte[] record) throws IOException {
            return record;
        }
    }
}
