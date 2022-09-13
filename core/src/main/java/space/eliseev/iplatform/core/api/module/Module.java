package space.eliseev.iplatform.core.api.module;

import java.io.InputStream;

/**
 * @author Chmykhalov A.
 */
public interface Module {

    /**
     * Метод, позволяющий загрузить конфигурацию из ресурса
     * @param in - ресурс с конфигурацией
     */
    void onLoadConfig(InputStream in);

    /**
     * Метод для использования предоставляемой входной очереди сообщений
     * @param input - входная очередь сообщений
     */
    void onSetInputQueue(BlockingQueue<AbstractMessage> input);

    /**
     * Метод для использования предоставляемой выходной очереди сообщений
     * @param out - выходная очередь сообщений
     */
    void onSetOutputQueue(BlockingQueue<AbstractMessage> out);

    /**
     * Метод, позволяющий установить новое имя модуля (для отображения во внутренних структурах)
     * @param name - новое имя модуля
     */
    void onSetName(String name);

    /**
     * Начать обработку сообщений
     * @return значение true/false (удалось начать или нет)
     * @throws Exception
     */
    boolean onStart() throws Exception;

    /**
     * Закончить обработку сообщений, остановить внутренние потоки
     * @return значение true/false (удалось закончить или нет)
     */
    boolean onStop();

    /**
     * Проинформировать ядро о своем текущем состоянии
     * @return информация о текущем состоянии
     */
    State onGetState();
}
