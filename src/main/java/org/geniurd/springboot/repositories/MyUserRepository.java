package org.geniurd.springboot.repositories;

import org.geniurd.springboot.model.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface MyUserRepository extends CrudRepository<MyUser, Long> {
}
