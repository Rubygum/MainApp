package com.rubyko.mainapp.login.validation;

/**
 * Created by alex on 18.02.16.
 */
public abstract class LocalValidator {

    private LocalValidator localValidator;

    protected boolean isValid;

    protected static final int MIN_PASSWORD_LENGTH = 6;
    protected static final int MIN_USERNAME_LENGTH = 4;

    protected class PasswordException extends LocalValidatorException {
        public PasswordException(String pDetailMessage){
            super(pDetailMessage);
        }
    }

    protected class EmailException extends LocalValidatorException {
        public EmailException(String pDetailMessage){
            super(pDetailMessage);
        }
    }

    protected class UserNameException extends LocalValidatorException {
        public UserNameException(String pDetailMessage){
            super(pDetailMessage);
        }
    }

    protected abstract void svalidate() throws LocalValidatorException;

    public void validate() throws LocalValidatorException {
        try{
            this.svalidate();
        } catch (LocalValidatorException e){
            isValid = false;
            throw e;
        }
        isValid = true;
    }

    public boolean isValid() {
        if(localValidator!=null)
            return isValid && localValidator.isValid();
        else
            return isValid;
    }

    public LocalValidator and(LocalValidator localValidator) {
        localValidator.localValidator = this;
        return localValidator;
    }

    protected abstract void update();

    public void updateAll(){
        this.update();
        if(localValidator!=null)
            localValidator.updateAll();
    }

}