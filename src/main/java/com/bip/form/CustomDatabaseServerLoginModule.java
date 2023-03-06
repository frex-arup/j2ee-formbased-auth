package com.bip.form;

import org.jboss.security.auth.spi.DatabaseServerLoginModule;
import org.mindrot.jbcrypt.BCrypt;

public class CustomDatabaseServerLoginModule extends DatabaseServerLoginModule {
	
	@Override
    protected boolean validatePassword(String enteredPassword, String encrypted) {
        
        if (enteredPassword == null || encrypted == null) {
            return false;
        }

        return BCrypt.checkpw(enteredPassword, encrypted);
    }

}
