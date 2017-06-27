package com.kshrd.spring.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kshrd.spring.model.Dashboard;
import com.kshrd.spring.model.User;

@Repository
public interface UserRepository {
	
	@Select("select "
			+"COUNT(*) as total, "
			+"COUNT(case when users.gender='Male' then 1 end) as male, "
			+"COUNT(case when users.gender='Female' then 1 end) as female "
			+"from users" )
	@Results(value={
			@Result(property="total" , column="total"),
			@Result(property="male" , column="male"),
			@Result(property="female" , column="female"),
	})
	public List<Dashboard> countGender();
	
	@Select("SELECT count(id)"
			+ " FROM "
			+ "	users WHERE status='true' and gender='Male'")
	public int findMale();

	@Select("SELECT "
			+ "	id, "
			+ " username, "
			+ "	email, "
			+ "	gender, "
			+ "	phonenumber, "
			+ " status, "
			+ "	user_hash,"
			+ "	created_date"
			+ " FROM "
			+ "	users WHERE status='true' ORDER BY id")
	public List<User> findAll();
	
	@Select("SELECT "
			+ "	id, "
			+ " username, "
			+ "	email, "
			+ "	gender, "
			+ "	phonenumber, "
			+ " status, "
			+ "	user_hash,"
			+ "	created_date"
			+ " FROM "
			+ "	users WHERE user_hash=#{user_hash}")
	User fineOne(@Param("user_hash") String user_hash);
	
	/**
	 * Save user to database
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO users ("
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ "	phonenumber, "
			+ "	user_hash,"
			+ " created_date"
			+ "	) VALUES ("
			+ "	#{user.username},"
			+ "	#{user.email},"
			+ "	#{user.gender},"
			+ "	#{user.phonenumber},"
			+ "	#{user.user_hash}, "
			+ "	#{user.created_date} "
			+ ")")
	@SelectKey(
			statement="SELECT last_value FROM users_id_seq",
			keyProperty="user.id", keyColumn="last_value",
			before=false,
			resultType=int.class
	)
	public boolean save(@Param("user") User user);
	
	@Delete("UPDATE users SET status='false' WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String user_hash);
	
	
	@Update("UPDATE users SET "
			+ "username=#{user.username},"
			+ "email=#{user.email},"
			+ "gender=#{user.gender},"
			+ "phonenumber=#{user.phonenumber},"
			+ "created_date=#{user.created_date}"
			+ " WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);








}
