package za.ac.cput.service;
/*
 * Order: java
 * Order: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 18 May 2024
 */
import java.util.List;
public interface IService<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    List<T> getAll();
}