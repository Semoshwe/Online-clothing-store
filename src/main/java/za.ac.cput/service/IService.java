package za.ac.cput.service;

/*
 * IService: java
 * Generic Service Interface
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 18 May 2024
 */
import java.util.List;

public interface IService<T, ID> {

    /**
     * Creates a new entity.
     *
     * @param t The entity to be created.
     * @return The created entity.
     */
    T create(T t);

    /**
     * Reads an entity by its ID.
     *
     * @param id The ID of the entity to be read.
     * @return The entity with the given ID, or null if not found.
     */
    T read(ID id);

    /**
     * Updates an existing entity.
     *
     * @param t The entity to be updated.
     * @return The updated entity.
     */
    T update(T t);

    /**
     * Finds all entities.
     *
     * @return A list of all entities.
     */
    List<T> findAll();
}
