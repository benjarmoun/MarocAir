package mvc.DAO.repository;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(int id) throws SQLException, ClassNotFoundException;

    List<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T t) throws SQLException, ClassNotFoundException;

    void update(T t, int i);

    boolean delete(int id) throws SQLException, ClassNotFoundException;

}