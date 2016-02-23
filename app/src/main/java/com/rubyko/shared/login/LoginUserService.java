package com.rubyko.shared.login;

import com.rubyko.shared.login.exception.DataFormatException;
import com.rubyko.shared.login.exception.DataLimitException;
import com.rubyko.shared.login.exception.UserDoesntExistException;
import com.rubyko.shared.login.model.AuthedUser;
import com.rubyko.shared.login.model.NoAuthedUser;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public interface LoginUserService extends Serializable {

    String objectName1 = "LOGIN_USER_SERVICE";

    AuthedUser login(NoAuthedUser pUser) throws UserDoesntExistException, DataFormatException, DataLimitException;

}
