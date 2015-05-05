package com.ekocaman.todo.entity;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {

    private String id;
    private String title;
    private boolean done;
    private Date createdOn = new Date();

    public Todo(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.title = dbObject.getString("title");
        this.done = dbObject.getBoolean("done");
        this.createdOn = dbObject.getDate("createdOn");
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}