package com.duant.rcpy.service.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duant.rcpy.domain.User;
import com.duant.rcpy.mapper.UserMapper;
import com.duant.rcpy.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService ,Serializable{
	
	private static final long serialVersionUID = -7305434960669604234L;
	@Autowired
	private UserMapper userMapper;	
	
	@Override
	public User selectByPrimaryKey(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

}
