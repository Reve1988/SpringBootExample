package org.geniurd.springboot.services;

import org.geniurd.springboot.model.MyUser;

import java.util.List;

public interface MyUserService {
	List<MyUser> getAll();

	MyUser get(Long id);

	MyUser saveOrUpdate(MyUser myUser);

	void delete(Long id);
}
