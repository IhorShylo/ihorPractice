package org.artdevs.meetingslog.core.data.db;

import org.artdevs.meetingslog.core.data.Comment;
import org.artdevs.meetingslog.core.data.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 15.12.2014.
 */
@Component
public class CommentsSpace {
    public Map<User, List<Comment>> usersComments = new HashMap<User, List<Comment>>();

    public boolean isPresent(String login) {
        //Do we have some comments
        return getUserByLogin(login) != null? true : false;
    }

    public User getUserByLogin(String login) {
        for (User user: usersComments.keySet()) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                return user;
            }
        }
        return null;
    }
}
