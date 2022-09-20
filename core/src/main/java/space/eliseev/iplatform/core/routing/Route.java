package space.eliseev.iplatform.core.routing;

public interface Route {
    /**
     * Запуск роутера
     */
    void start();

    /**
     * Остановка роутера
     */
    void stop();
}