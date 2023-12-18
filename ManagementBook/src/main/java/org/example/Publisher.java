package org.example;

public class Publisher {

    protected int id;
    protected String publisherName;


    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    public Publisher(int id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName=" + publisherName +
                '}';
    }
}
