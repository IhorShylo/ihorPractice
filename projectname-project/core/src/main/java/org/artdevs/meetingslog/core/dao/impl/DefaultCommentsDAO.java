package org.artdevs.meetingslog.core.dao.impl;

import org.artdevs.meetingslog.core.dao.CommentsDAO;
import org.artdevs.meetingslog.core.data.Comment;
import org.artdevs.meetingslog.core.data.User;
import org.artdevs.meetingslog.core.data.db.CommentsSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public class DefaultCommentsDAO implements CommentsDAO {

    @Autowired
    private CommentsSpace commentsSpace;

    @Override
    public void addMessage(User user, Comment comment) {

        List<Comment> userComments;

        if (commentsSpace.isPresent(user.getLogin())) {
            userComments = commentsSpace.usersComments.get(commentsSpace.getUserByLogin(user.getLogin()));
            if (userComments != null) {
                userComments.add(comment);
            }
            else {
                userComments = new ArrayList<Comment>();
                userComments.add(comment);
            }
            commentsSpace.usersComments.put(user, userComments);
        }
        else {
            userComments = new ArrayList<Comment>();
            userComments.add(comment);
            commentsSpace.usersComments.put(user, userComments);
        }
    }

    @Override
    public boolean removeMessages(User user, List<Comment> comments) {

        List<Comment> userComments;
        if (commentsSpace.isPresent(user.getLogin())) {
            userComments = commentsSpace.usersComments.get(commentsSpace.getUserByLogin(user.getLogin()));
            if (userComments != null) {
                userComments.removeAll(comments);
            }
            commentsSpace.usersComments.put(user, userComments);
        }

        return false;
    }

    @Override
    public List<Comment> getMessagesForUser(User user) throws NullPointerException {
        return commentsSpace.usersComments.get(commentsSpace.getUserByLogin(user.getLogin()));
    }

    @Override
    public void purgeUser(User user) {
        commentsSpace.usersComments.remove(commentsSpace.getUserByLogin(user.getLogin()));
    }
}
