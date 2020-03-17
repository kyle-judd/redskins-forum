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

		user.setUsername(customUser.getUsername());
		user.setPassword(passwordEncoder.encode(customUser.getPassword()));
		user.setFirstName(customUser.getFirstName());
		user.setLastName(customUser.getLastName());
		user.setEmail(customUser.getEmail());
		user.setProfilePicture(customUser.getProfilePicture());
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

		userDao.save(user);
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getType())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void updateUserProfile(CustomUser customUser, User currentUser) {

		currentUser.setUsername(customUser.getUsername());
		currentUser.setPassword(passwordEncoder.encode(customUser.getPassword()));
		currentUser.setFirstName(customUser.getFirstName());
		currentUser.setLastName(customUser.getLastName());
		currentUser.setEmail(customUser.getEmail());
		currentUser.setProfilePicture(customUser.getProfilePicture());
		currentUser.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

		userDao.updateUserProfile(currentUser);
		
	}

}
