package space.eliseev.iplatform.core.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AbstractMessage {
    private ZonedDateTime created;
    private UUID uuid;

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
