package org.artdevs.meetingslog.services.impl;

import org.artdevs.meetingslog.core.dao.CommentsDAO;
import org.artdevs.meetingslog.core.data.Comment;
import org.artdevs.meetingslog.core.data.User;
import org.artdevs.meetingslog.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public class DefaultCommentsService implements CommentsService {

    @Autowired
    private CommentsDAO commentsDAO;

    @Override
    public void addComment(String login, String message) throws NullPointerException {
        User user = new User();
        user.setLogin(login);
        Comment newComment = new Comment();
        newComment.setMessage(message);
        commentsDAO.addMessage(user, newComment);
    }

    @Override
    public void removeComments(String login) {
        User user = new User();
        user.setLogin(login);
        List<Comment> messages = commentsDAO.getMessagesForUser(user);
        commentsDAO.removeMessages(user, messages);
        if (commentsDAO.getMessagesForUser(user) != null && commentsDAO.getMessagesForUser(user).size() == 0)
            commentsDAO.purgeUser(user);
    }

    @Override
    public List<Comment> getAllCommentsForUser(String login)throws NullPointerException {
        User user = new User();
        user.setLogin(login);
        return commentsDAO.getMessagesForUser(user);
    }
}