package mvc.DAO.repository;

import java.sql.SQLException;

public interface Auth<T> {
    boolean login(T t) throws Exception;

    boolean register(T t);
}
