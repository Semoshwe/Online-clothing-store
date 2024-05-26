package za.ac.cput.repository;
/*
 *Product:java
 *Product: Repository Interface
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

@Deprecated
public interface IRepository<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);
}