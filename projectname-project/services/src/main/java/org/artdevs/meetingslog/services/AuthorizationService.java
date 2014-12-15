package org.artdevs.meetingslog.services;

import org.artdevs.meetingslog.core.data.User;

import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
public interface AuthorizationService {

    @Deprecated
    public boolean register(String login, String password);

    public boolean register(User user);

    public boolean login(String login, String password);

    public boolean login(User user);

    public boolean remove(User user);

    public boolean removeUserByEmail(String email);

    public List<User> getAllUsers();

    public User getLogedInUser();

    public void logout();
}
