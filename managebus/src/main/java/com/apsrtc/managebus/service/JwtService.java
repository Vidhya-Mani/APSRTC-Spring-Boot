package com.apsrtc.managebus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.apsrtc.managebus.dao.UserDao;
import com.apsrtc.managebus.entity.JwtRequest;
import com.apsrtc.managebus.entity.JwtResponse;
import com.apsrtc.managebus.entity.User;
import com.apsrtc.managebus.impl.JwtImpl;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtImpl jwtImpl;
	
	@Autowired
    private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 User user = userDao.findById(name).get();

	        if (user != null) {
	            return new org.springframework.security.core.userdetails.User(
	                    user.getName(),
	                    user.getPassword(),
	                    getAuthority(user)
	            );
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + name);
	        }
	}

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
		// TODO Auto-generated method stub
		String userName = jwtRequest.getName();
        String userPassword = jwtRequest.getPassword();
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        
        String newGeneratedToken = jwtImpl.generateToken(userDetails);

        User user = userDao.findById(userName).get();
        
        return new JwtResponse(user, newGeneratedToken);
	}
	
	private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        });
        return authorities;
    }
	
	private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
