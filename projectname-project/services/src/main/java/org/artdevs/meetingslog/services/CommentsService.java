package org.artdevs.meetingslog.services;

import org.artdevs.meetingslog.core.data.Comment;

import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
public interface CommentsService {

    public void addComment (String login, String message) throws NullPointerException;

    public void removeComments (String login);

    public List<Comment> getAllCommentsForUser (String login)throws NullPointerException;
}
