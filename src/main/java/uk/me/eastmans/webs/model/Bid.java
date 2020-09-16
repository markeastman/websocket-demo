package uk.me.eastmans.webs.model;

import java.util.Date;

public class Bid {

    private Date dateTime;

    private Integer value;

    private String id;

    public Bid(String id, Integer value) {
        this.id = id;
        this.dateTime = new Date();
        this.value = value;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Integer getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

}
