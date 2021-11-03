package repository;

import exceptions.NullValueException;

import java.util.List;

/**
 * CRUD operations repository interface
 *
 * @param <T> generic class
 */
public interface ICrudRepository<T> {

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null - if there is no entity with the given id
     */
    T findOne(Long id) throws NullValueException;

    /**
     * @return all entities
     */
    List<T> findAll();

    /**
     * @param entity entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    T save(T entity) throws NullValueException;

    /**
     * removes the entity with the specified id
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id
     */
    T delete(Long id) throws NullValueException;

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    T update(T entity) throws NullValueException;

    /**
     * @return the number of elements from the repoList
     */
    int size();
}
