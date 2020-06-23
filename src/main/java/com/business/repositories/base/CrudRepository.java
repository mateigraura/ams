package com.business.repositories.base;

import java.util.List;

public interface CrudRepository<TEntity, TKey> {
    TEntity get(TKey key) throws Exception;

    TEntity insert(TEntity entity) throws Exception;

    TEntity update(TEntity entity) throws Exception;

    TEntity remove(TEntity entity) throws Exception;

    List<TEntity> getMany() throws Exception;
}
