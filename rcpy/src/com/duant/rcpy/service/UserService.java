package com.duant.rcpy.service;

import com.duant.rcpy.domain.User;

public interface UserService {
	
	/**
	 * ͨ��userid��ѯUser
	 * @param userid
	 * @return User
	 */
	public User selectByPrimaryKey(Integer userid);
}
