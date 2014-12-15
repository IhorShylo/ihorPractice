package org.artdevs.meetingslog.core.dao;

import org.artdevs.meetingslog.core.data.Comment;
import org.artdevs.meetingslog.core.data.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 15.12.2014.
 */
@Component
public interface CommentsDAO {

    public void addMessage(User user, Comment comment);

    public boolean removeMessages(User user, List<Comment> comments);

    public List<Comment> getMessagesForUser(User user);

    public void purgeUser(User user);
}