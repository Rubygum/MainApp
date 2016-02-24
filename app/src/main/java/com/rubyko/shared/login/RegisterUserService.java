package com.rubyko.shared.login;

import com.rubyko.shared.login.model.AuthedUser;
import com.rubyko.shared.login.exception.DataFormatException;
import com.rubyko.shared.login.exception.DataLimitException;
import com.rubyko.shared.login.exception.EmailDoesntExistException;
import com.rubyko.shared.login.exception.UserAlreadyExistsException;
import com.rubyko.shared.login.model.NoAuthedUser;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public interface RegisterUserService extends Serializable {

    String objectName1 = "REGISTER_USER_SERVICE";

    AuthedUser register(NoAuthedUser pUser) throws DataFormatException, DataLimitException, UserAlreadyExistsException, EmailDoesntExistException;

}
