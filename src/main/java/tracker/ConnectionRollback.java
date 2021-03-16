package tracker;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection, which rollback all commits.
 * It is used for integration test.
 *
 * Теперь нам нужно решить проблему управления
 * методами Connection.close()
 * Мы можем пойти двумя путями и использовать
 * шаблон декоратор или использовать шаблон Proxy.
 *
 * Если мы используем шаблон декоратор. то нам нужно будет
 * переопределить более 30 методов. Это очень избыточно.
 * Поэтому мы будет использовать проксирование.
 *
 * Проксирование - по сути это фильтр между нашими методами.
 * С помощью прокси мы можем добавлять, создавать, изменять поведение.
 *
 * В JDK 1.8 ввели новый класс Proxy.
 * Он позволяет создаеть объект на основании интерфейса.
 *
 * Давайте сделаем фабричный метод, который создает Connection,
 * в котором метод close работает с вызовом rollback.
 *
 */
public class ConnectionRollback {

    /**
     * Create connection with autocommit=false mode and rollback call,
     * when conneciton is closed.
     *
     *
     *
     */
    public static Connection create(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        return (Connection) Proxy.newProxyInstance(
                ConnectionRollback.class.getClassLoader(),
                new Class[] {Connection.class},
                (proxy, method, args) -> {
                    Object rsl = null;
                    if ("close".equals(method.getName())) {
                        connection.rollback();
                        connection.close();
                    } else {
                        rsl = method.invoke(connection, args);
                    }
                    return rsl;
                }
        );
    }
}