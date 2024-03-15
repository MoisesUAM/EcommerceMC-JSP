package net.mcoto.app.repositories;

import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface IGenericRepository<T, ID> {

    List<T> getAll();

    Optional<T> findById(ID id);

    List<T> findByFieldName(String fieldName, Object value);

    void save(T t);

    void update(T t);

    void delete(T t);

}
