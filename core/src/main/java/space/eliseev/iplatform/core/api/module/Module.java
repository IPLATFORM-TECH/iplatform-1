package space.eliseev.iplatform.core.api.module;

import java.io.InputStream;

public interface Module {

    void onLoadConfig(InputStream in);

    void onSetInputQueue(BlockingQueue<AbstractMessage> input);

    void onSetOutputQueue(BlockingQueue<AbstractMessage> out);

    void onSetName(String name);

    boolean onStart() throws Exception;

    boolean onStop();

    State onGetState();
}
