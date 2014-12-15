package org.artdevs.meetingslog.core.dao;

import org.artdevs.meetingslog.core.data.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public interface AuthorizationDAO {

    public boolean insertUserToDB (User user);

    public List<User> getAllUsers ();

    public boolean removeUser (User user);

    public boolean removeUserByEmail (String email) throws NullPointerException;

    @Deprecated
    public boolean checkPassword (User user, String password);

    public boolean checkPassword(User user);

    public void login (User user) throws Exception;

    public User getLogedInUser();

    public void logout();

}
