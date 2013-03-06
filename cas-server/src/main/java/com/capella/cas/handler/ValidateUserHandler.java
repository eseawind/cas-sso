package com.capella.cas.handler;

import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.capella.database.repositories.UserDao;

@Service
public class ValidateUserHandler extends
		AbstractJdbcUsernamePasswordAuthenticationHandler {
	@Autowired
	private UserDao userDao;
	
	@Override
	protected boolean authenticateUsernamePasswordInternal(
			UsernamePasswordCredentials credentials)
			throws AuthenticationException {
        final String username = getPrincipalNameTransformer().transform(credentials.getUsername());
        final String password = credentials.getPassword();
        final String encryptedPassword = this.getPasswordEncoder().encode(
            password);
        System.out.println("encryptedPassword :" + encryptedPassword);
        try {
            final String dbPassword = userDao.getPassword(username);
            System.out.println("dbPassword : " + dbPassword);
            return dbPassword.equals(encryptedPassword);
        } catch (final IncorrectResultSizeDataAccessException e) {
            return false;
        }
    
	}

}