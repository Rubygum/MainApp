package com.rubyko.mainapp.login.server;

import com.rubyko.mainapp.login.server.exception.DataFormatException;
import com.rubyko.mainapp.login.server.exception.DataLimitException;
import com.rubyko.mainapp.login.server.exception.UserDoesntExistException;
import com.rubyko.mainapp.login.server.model.AuthedUser;
import com.rubyko.mainapp.login.server.model.NoAuthedUser;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public interface LoginUserService extends Serializable {

    String objectName1 = "LOGIN_USER_SERVICE";

    AuthedUser login(NoAuthedUser pUser) throws UserDoesntExistException, DataFormatException, DataLimitException;

}
