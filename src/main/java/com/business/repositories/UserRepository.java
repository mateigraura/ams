package com.business.repositories;

import com.business.repositories.base.CrudRepository;
import com.domain.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getByEmail(String email) throws Exception;
}
