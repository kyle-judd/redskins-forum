package com.kylejudd.football.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kylejudd.football.dao.RoleDao;
import com.kylejudd.football.dao.UserDao;
import com.kylejudd.football.entity.Role;
import com.kylejudd.football.entity.User;
import com.kylejudd.football.user.CustomUser;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Cannot find user with name: " + username);
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}

	@Override
	@Transactional
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	@Override
	@Transactional
	public void save(CustomUser customUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUsername(customUser.getUsername());
		user.setPassword(passwordEncoder.encode(customUser.getPassword()));
		user.setFirstName(customUser.getFirstName());
		user.setLastName(customUser.getLastName());
		user.setEmail(customUser.getEmail());

		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

		 // save user in the database
		userDao.save(user);
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getType())).collect(Collectors.toList());
	}

}
