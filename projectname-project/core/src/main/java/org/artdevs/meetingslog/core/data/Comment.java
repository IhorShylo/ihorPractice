package org.artdevs.meetingslog.core.data;

import java.util.Date;

/**
 * Created by User on 15.12.2014.
 */
public class Comment {
    private static long idCounter = 0;
    private long id = idCounter;
    private Date date;
    private String message;

    public Comment() {
        idCounter++;
        date = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }
}
