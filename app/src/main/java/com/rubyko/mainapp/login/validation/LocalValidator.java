package com.rubyko.mainapp.login.validation;

/**
 * Created by alex on 18.02.16.
 */
public class LocalValidator {

    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MIN_USERNAME_LENGTH = 4;
    private static final int MIN_LOGIN_LENGTH = 4;

    public void checkLogin(String pLogin) throws LoginException {
        if(pLogin.isEmpty()){
            throw new LoginException("Please type your login");
        }
        if(pLogin.length() < MIN_LOGIN_LENGTH){
            throw new LoginException("Your login must be more than " + MIN_LOGIN_LENGTH +" letters");
        }
    }

    public void checkPassword(String pPassword) throws PasswordException{
        if (!pPassword.isEmpty() && pPassword.length() < MIN_PASSWORD_LENGTH){
            throw new PasswordException("Your password must be more than " + MIN_PASSWORD_LENGTH + " letters");
        }
        if( pPassword.isEmpty()){
            throw new PasswordException("Please type your password");
        }
    }

    public void checkPasswords(String pPassword, String pRepassword) throws PasswordException {

        if (!pPassword.isEmpty() && pPassword.length() < MIN_PASSWORD_LENGTH){
            throw new PasswordException("Your password must be more than " + MIN_PASSWORD_LENGTH + " letters");
        }
        if( pPassword.isEmpty()){
            throw new PasswordException("Please type your password");
        }
        if(pRepassword.isEmpty()){
            throw new PasswordException("Please repeat your password");
        }

        if(!pPassword.equals(pRepassword)){
            throw new PasswordException("Your passwords don't mutch");
        }
    }

    public void checkUserName(String pUserName) throws  UserNameException {
        if(pUserName.isEmpty()){
            throw new UserNameException("Please type your name");
        }
        if(pUserName.length() < MIN_USERNAME_LENGTH){
            throw new UserNameException("Your name must be more than " + MIN_USERNAME_LENGTH +" letters");
        }
    }

    class PasswordException extends LocalValidatorException {
        public PasswordException(String pDetailMessage){
            super(pDetailMessage);
        }
    }

    class LoginException extends LocalValidatorException {
        public LoginException(String pDetailMessage){
            super(pDetailMessage);
        }
    }

    class UserNameException extends LocalValidatorException {
        public UserNameException(String pDetailMessage){
            super(pDetailMessage);
        }
    }

}