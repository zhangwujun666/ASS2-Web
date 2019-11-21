package com.yq.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.UserDao;
import com.yq.entity.User;

@Service
public class UserService{
	@Autowired
	private UserDao userDao;
	
	public int insert(Map<String,Object> map ){
		return userDao.insert(map);
	}
	
	public int update(Map<String,Object> map ){
		return userDao.update(map);
	}
	
	public int uparea(Map<String,Object> map ){
		return userDao.uparea(map);
	}
	
	public int upstatus(Map<String,Object> map){
		return userDao.upstatus(map);
	}
	
	public int upmbertime(Map<String,Object> map){
		return userDao.upmbertime(map);
	}


	public List<User> list(User user){
		return userDao.list(user);
	}
	public int count(User user){
		return userDao.count(user);
	}
	
	public List<User> listById(User user){
		return userDao.listById(user);
	}
	
	public int isMember(User user){
		return userDao.isMember(user);
	}

	public  int updatepoint (Map<String, String> map){
		return userDao.updatepoint(map);
	}

	public int findPointByOppenId(String oppen_id){
		return userDao.findPointByOppenId(oppen_id);
	}

	public int findCouponsByOppenId(String oppen_id){
		return  userDao.findCouponsByOppenId(oppen_id);
	}

	public int updateCoupons(Map<String, String> map) {
		return userDao.updateCoupons(map);
	}
}
