package com.yq.dao;

import java.util.List;
import java.util.Map;

import com.yq.entity.User;


public interface UserDao {
	
	public int insert(Map<String,Object> map);
	
	public int update(Map<String,Object> map);

	public int uparea(Map<String,Object> map);

	public int upstatus(Map<String,Object> map);

	public int upmbertime(Map<String,Object> map);

	public List<User> list(User user);

	public int count(User user);

	public List<User> listById(User user);

	public int isMember(User user);

	public int updatepoint(Map<String, String> map);

	public int findPointByOppenId(String oppen_id);

	public int findCouponsByOppenId(String oppen_id);

	public int updateCoupons(Map<String, String> map);
	
}
