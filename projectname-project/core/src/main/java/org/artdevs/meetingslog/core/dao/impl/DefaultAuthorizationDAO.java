package org.artdevs.meetingslog.core.dao.impl;

import org.artdevs.meetingslog.core.dao.AuthorizationDAO;
import org.artdevs.meetingslog.core.data.User;
import org.artdevs.meetingslog.core.data.db.UserSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public class DefaultAuthorizationDAO implements AuthorizationDAO {

    @Autowired
    private UserSpace userspace;

    @Override
    public boolean insertUserToDB(User user) {
        if (userspace.isPresent(user))
            return false;

        userspace.userDatabase.add(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<User>(userspace.userDatabase);
        return result;
    }

    @Override
    public boolean removeUser(User user) {
        if (userspace.isPresent(user)) {
            userspace.userDatabase.remove(userspace.getUserByLogin(user.getLogin()));
            return true;
        }
        return false;
    }

    @Override
    public boolean removeUserByEmail(String email) throws NullPointerException{

        for (User user: getAllUsers()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                userspace.userDatabase.remove(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPassword(User user) throws NullPointerException {
        return checkPassword(user, null);
    }

    @Override
    @Deprecated
    public boolean checkPassword(User user, String password) throws NullPointerException{
        for (User dbUser: getAllUsers()) {
            if (user.getLogin() != null && user.getLogin().equalsIgnoreCase(dbUser.getLogin())) {
                if (user.getPassword().equals(dbUser.getPassword()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void login(User user) throws Exception{
        if (checkPassword(user)) {
            userspace.setLogedInUser(user);
            return;
        }

        throw new Exception("Wrong credentials!");
    }

    @Override
    public User getLogedInUser() {
        return userspace.getLogedInUser();
    }

    @Override
    public void logout() {
        userspace.setLogedInUser(null);
    }
}
