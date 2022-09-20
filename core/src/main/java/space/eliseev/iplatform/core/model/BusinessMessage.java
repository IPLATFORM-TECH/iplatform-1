package space.eliseev.iplatform.core.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessMessage extends AbstractMessage {
    private final long messageGuid;
    private final Map<Long, Object> payload = new LinkedHashMap<>();

    BusinessMessage(long messageGuid) {
        this.messageGuid = messageGuid;
    }

    public long getMessageGuid() {
        return messageGuid;
    }

    public Map<Long, Object> getPayload() {
        return payload;
    }
}
