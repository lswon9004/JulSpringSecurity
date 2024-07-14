package user.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import user.security.dao.UsersDao;
import user.security.domain.Role;
import user.security.domain.Users;

@Service
public class UserService {
	
	@Autowired
	UsersDao dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public int insertUser(Users users) {
		
		//암호화(BCrypt 알고리즘 )
		users.setPassword(encoder.encode(users.getPassword()));
	
		users.setRole(Role.ROLE_ADMIN);
		
		int i = dao.insertUser(users);
		System.out.println(i);
		
		return i;
	}
}