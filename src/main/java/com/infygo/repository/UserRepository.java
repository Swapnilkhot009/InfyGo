package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infygo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

	@Query(value="select user_id from user where name like ?1",nativeQuery = true)
	public String getuserIdByName(String name);
	
	
	@Query
	public User findByUserId(String userId);
	

}
