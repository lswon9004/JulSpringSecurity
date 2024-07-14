package user.security.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import user.security.domain.Users;

@Mapper
public interface UsersDao {
	@Select("select * from users where id = #{id}")
	Users findById(String id);
	@Insert("insert into users values (#{id}, #{password}, #{name}, #{role}, 'T')")
	int insertUser(Users user);
}