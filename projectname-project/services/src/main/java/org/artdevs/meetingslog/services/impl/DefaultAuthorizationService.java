package org.artdevs.meetingslog.services.impl;

import org.artdevs.meetingslog.core.dao.AuthorizationDAO;
import org.artdevs.meetingslog.core.data.User;
import org.artdevs.meetingslog.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public class DefaultAuthorizationService implements AuthorizationService {

    @Autowired
    private AuthorizationDAO authorizationDAO;

    @Deprecated
    @Override
    public boolean register(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return authorizationDAO.insertUserToDB(user);
    }

    @Override
    public boolean register(User user) {
        return authorizationDAO.insertUserToDB(user);
    }

    @Override
    public boolean login(User user) {
        try {
            authorizationDAO.login(user);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    @Deprecated
    public boolean login(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        return login(user);
    }

    @Override
    public boolean remove(User user) {
        return authorizationDAO.removeUser(user);
    }

    @Override
    public boolean removeUserByEmail(String email) {

        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return authorizationDAO.getAllUsers();
    }

    @Override
    public User getLogedInUser() {
        return authorizationDAO.getLogedInUser();
    }

    @Override
    public void logout() {
        User user = new User();
        authorizationDAO.getLogedInUser();
    }
}