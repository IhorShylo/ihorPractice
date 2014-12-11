package org.artdevs.meetingslog.dao;

import org.artdevs.meetingslog.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Slava on 10.12.2014.
 */
public interface UserDAO {
    public List<User> getAll();
    public List<User> getByEmail(String email);
    public User findById(int id);
    public User findByLogin(String login);
    public void insert(User user);
    public void update(User user);
    public void remove(User user);
    public boolean checkPassword(String login);

}
