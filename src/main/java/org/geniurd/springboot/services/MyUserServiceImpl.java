package org.geniurd.springboot.services;

import org.geniurd.springboot.model.MyUser;
import org.geniurd.springboot.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {
	private MyUserRepository myUserRepository;

	@Autowired
	public MyUserServiceImpl(
			MyUserRepository myUserRepository) {
		this.myUserRepository = myUserRepository;
	}

	@Override
	public List<MyUser> getAll() {
		List<MyUser> myUserList = new ArrayList<>();
		myUserRepository.findAll().forEach(myUserList::add);
		return myUserList;
	}

	@Override
	public MyUser get(Long id) {
		return myUserRepository.findOne(id);
	}

	@Override
	public MyUser saveOrUpdate(MyUser myUser) {
		myUserRepository.save(myUser);
		return myUser;
	}

	@Override
	public void delete(Long id) {
		myUserRepository.delete(id);
	}
}
