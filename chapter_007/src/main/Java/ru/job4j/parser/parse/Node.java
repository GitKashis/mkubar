package ru.job4j.parser.parse;

import java.util.Date;

public class Node {

    /**
     * URL topic Job.
     */
    private String url;

    /**
     * Name topic.
     */
    private String nameTopic;

    /**
     * Body topic.
     */
    private String body;

    /**
     * Create date topic.
     */
    private Date date;

    /**
     * Constructor.
     * @param url URL topic Job.
     * @param nameTopic Name topic.
     * @param body Body topic.
     * @param date Create date topic.
     */
    public Node(String url, String nameTopic, String body, Date date) {
        this.url = url;
        this.nameTopic = nameTopic;
        this.body = body;
        this.date = date;
    }

    /**
     * Getter.
     * @return URL topic Job.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Getter.
     * @return Name topic.
     */
    public String getNameTopic() {
        return nameTopic;
    }

    /**
     * Getter.
     * @return Body topic.
     */
    public String getBody() {
        return body;
    }

    /**
     * Getter.
     * @return Create date topic.
     */
    public Date getDate() {
        return date;
    }
}
