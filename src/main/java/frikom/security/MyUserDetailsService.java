package frikom.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
//import frikom.jpa.User;
import frikom.repos.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String password = (String) jdbcTemplate.queryForObject("SELECT password FROM USERS WHERE username = '" + username + "'", String.class);
		return new User(username, password, new ArrayList<>());
	}
	
}
