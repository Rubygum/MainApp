package com.rubyko.mainapp.login.server;

import com.rubyko.mainapp.login.server.model.AuthedUser;
import com.rubyko.mainapp.login.server.exception.DataFormatException;
import com.rubyko.mainapp.login.server.exception.DataLimitException;
import com.rubyko.mainapp.login.server.exception.EmailDoesntExistException;
import com.rubyko.mainapp.login.server.exception.UserAlreadyExistsException;
import com.rubyko.mainapp.login.server.model.NoAuthedUser;

/**
 * Created by alex on 23.02.16.
 */
public interface RegisterUserService {

    String objectName1 = "REGISTER_USER_SERVICE";

    AuthedUser register(NoAuthedUser pUser) throws DataFormatException, DataLimitException, UserAlreadyExistsException, EmailDoesntExistException;

}
