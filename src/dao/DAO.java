package dao;

import java.util.List;

public interface DAO<T> {

    public List<T> findAll();

    public T find(int id);

    public T create(T obj);

    public String delete(int id);

    public String update(T obj);

}
