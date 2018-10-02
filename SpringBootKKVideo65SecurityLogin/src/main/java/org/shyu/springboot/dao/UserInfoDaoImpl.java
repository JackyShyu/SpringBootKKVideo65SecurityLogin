package org.shyu.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.shyu.springboot.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public UserInfo getActiveUser(String userName) {
		UserInfo userInfo = new UserInfo();
		String HQL = "from UserInfo u where u.username = ? and u.enabled = ?";
		List<?> users = entityManager.createQuery(HQL)
						.setParameter(0, userName)
						.setParameter(1, 1)
						.getResultList();
		if (users.size() > 0) {
			userInfo = (UserInfo) users.get(0);
		}
		return userInfo;
	}

}
