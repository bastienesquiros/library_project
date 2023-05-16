package dao;

public interface DAO<T> {

    public T findAll();

    public T find(int id);

    public T create(T obj);

    public T delete(T obj);

    public T update(T obj);

}
