package com.project275.service;

import javax.persistence.Query;

import com.project275.entity.User;
import com.project275.util.PersistenceUtil;

public class UserService {
	
	private static String FIND_USER_BY_USERNAME = "select model from User model where model.userName='";
	public static User getUserById(Integer id ) {
		User user = PersistenceUtil.getEntityManager().find(User.class, id);
		
		return user;
	}
	
	public static User getUserByUserName(String userName){
		Query query = PersistenceUtil.getEntityManager().createQuery(FIND_USER_BY_USERNAME + userName + "'");
		User user = (User) query.getResultList().get(0);
		return user;
	}

}
