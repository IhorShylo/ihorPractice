package org.artdevs.meetingslog.core.data.db;

import org.artdevs.meetingslog.core.data.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public class UserSpace {
    private User logedInUser;
    public List<User> userDatabase = new ArrayList<User>();

    public boolean isPresent(User user) {
        return getUserByLogin(user.getLogin()) != null? true : false;
    }

    public User getUserByLogin(String login) {
        for (User user : userDatabase) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                return user;
            }
        }
        return null;
    }

    public User getLogedInUser() {
        return logedInUser;
    }

    public void setLogedInUser(User logedInUser) {
        this.logedInUser = logedInUser;
    }
}
