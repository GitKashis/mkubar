package ru.job4j.parser.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ParseSQLru {

    /**
     * Basic page URL Job www.sql.ru
     */
    private String url;

    /**
     * Object Document.
     */
    private Document sqlRU;

    /**
     * List order Node where order contains data from topic.
     */
    private List<Node> listNode = new ArrayList<>(100);

    /**
     * Base param.
     */
    private Properties properties = new Properties();

    /**
     * Map for fast interpretation month in topics.
     */
    private Map<String, Integer> month = new HashMap<>();

    /**
     * Logger object.
     */
    private final Logger logger = LoggerFactory.getLogger(ParseSQLru.class);

    /**
     * Constructor.
     */
    public ParseSQLru() {
        this.url = initializeUrlOfProp();
        putMonth();
    }

    /**
     * Initialize properties.
     * @return Object Properties
     */
    private String initializeUrlOfProp() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        try {
            properties.load(new FileInputStream("C:\\Projects\\mkubar\\chapter_007\\src\\main\\Java\\ru\\job4j\\parser\\resources\\parse.properties"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return this.properties.getProperty("urlParse");
    }

    /**
     * Save new data in properties file.
     */
    private void saveProp() {
        try (FileOutputStream os = new FileOutputStream("C:\\Projects\\mkubar\\chapter_007\\src\\main\\Java\\ru\\job4j\\parser\\resources\\parse.properties")) {
            this.properties.store(os, "No commit");
        } catch (IOException e) {
            this.logger.error(e.getMessage(), e);
        }
    }

    /**
     * Initialize Document object.
     * @param url site.
     */
    private void connectUrl(String url) {
        try {
            this.sqlRU = Jsoup.connect(url).get();
        } catch (IOException e) {
            this.logger.error(e.getMessage(), e);
        }
    }

    /**
     * Initialize interpretation month in topics.
     */
    private void putMonth() {
        this.month.put("янв", 0);
        this.month.put("фев", 1);
        this.month.put("мар", 2);
        this.month.put("апр", 3);
        this.month.put("май", 4);
        this.month.put("июн", 5);
        this.month.put("июл", 6);
        this.month.put("авг", 7);
        this.month.put("сен", 8);
        this.month.put("окт", 9);
        this.month.put("ноя", 10);
        this.month.put("дек", 11);
    }

    /**
     * This method check max page in site(Job) and save in properties file this value.
     * @return how many need check page.
     */
    private int getMaxNumberPageJob() {
        int lastPageCheck = Integer.valueOf(this.properties.getProperty("lastNumberPage"));
        this.connectUrl(this.url);
        Elements elements = sqlRU.getElementsByAttributeValue("style", "text-align:left");
        String[] maxNumberPage = elements.get(0).text().split(" ");
        properties.setProperty("lastNumberPage", maxNumberPage[maxNumberPage.length - 1]);
        this.saveProp();
        lastPageCheck = Integer.valueOf(maxNumberPage[maxNumberPage.length - 1]) - lastPageCheck;
        if (lastPageCheck == 0) {
            lastPageCheck = 1;
        }
        return lastPageCheck;
    }

    /**
     * Check topic in page where contains job for Java developer.
     * @param numberPage number page need check in site
     * @return list All find topic in page where contains job
     */
    private List<String> getAllURLTopicOfPage(Integer numberPage) {
        List<String> result = new ArrayList<>(100);
        if (numberPage <= Integer.valueOf(properties.getProperty("lastNumberPage"))) {
            this.connectUrl(this.url + numberPage);
            Elements pageListJob = sqlRU.getElementsByClass("postslisttopic");
            for (Element next : pageListJob) {
                Element tmp = next.child(0);
                String[] nameTopic = tmp.text().split(" ");
                boolean addInList = false;
                for (String nextWord : nameTopic) {
                    if (nextWord.equals("Java") || nextWord.equals("JAVA") || nextWord.equals("java")) {
                        addInList = true;
                    }
                    if (nextWord.equals("JavaScript") || nextWord.equals("Script") || nextWord.equals("script")) {
                        addInList = false;
                        break;
                    }
                }
                if (tmp.attr("href").equals(this.properties.getProperty("lastTopicPageURL"))) {
                    break;
                }
                if (addInList) {
                    result.add(tmp.attr("href"));
                }
            }
        }
        if (numberPage == 1 && result.size() > 0) {
            this.properties.setProperty("lastTopicPageURL", result.get(0));
            this.saveProp();
        }
        return result;
    }

    /**
     * Interpretation date in topic in Date object Java.
     * @param time in topic.
     * @return Date topic.
     */
    private Date getTime(String[] time) {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        if (time[0].length() > 6 && "сегодня".equals(time[0].substring(0, 7))) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            hour = Integer.valueOf(time[1].substring(0, 2));
            minute = Integer.valueOf(time[1].substring(3, 5));
        } else if (time[0].length() == 6 && "вчера".equals(time[0].substring(0, 5))) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
            hour = Integer.valueOf(time[1].substring(0, 2));
            minute = Integer.valueOf(time[1].substring(3, 5));
        } else {
            year = Integer.valueOf("20" + time[2].substring(0, 2));
            month = this.month.get(time[1]);
            day = Integer.valueOf(time[0]);
            hour = Integer.valueOf(time[3].substring(0, 2));
            minute = Integer.valueOf(time[3].substring(3, 5));
        }
        return new GregorianCalendar(year, month, day, hour, minute).getTime();
    }

    /**
     * Getting data from topic and create Node job.
     * @param urlTopic Job
     */
    private void getDataOnTopic(String urlTopic) {
        this.connectUrl(urlTopic);
        Element element = sqlRU.getElementsByClass("msgTable").get(0);
        String nameTopic = element.getElementsByClass("messageHeader").last().text();
        String bodyTopic = element.getElementsByClass("msgBody").last().text();
        String[] date = element.getElementsByClass("msgFooter").first().ownText().split(" ");
        Date dateObj = this.getTime(date);
        Calendar calendar = Calendar.getInstance();
        Calendar dataTopic = new GregorianCalendar();
        dataTopic.setTime(dateObj);
        if (calendar.get(Calendar.YEAR) == dataTopic.get(Calendar.YEAR)) {
            listNode.add(new Node(urlTopic, nameTopic, bodyTopic, dateObj));
        }
    }

    /**
     * Execute method for getting all last job in site.
     * @return List Node Job.
     */
    public List<Node> execute() {
        int lastPageTopicsJob = this.getMaxNumberPageJob();
        for (int i = 1; i <= lastPageTopicsJob; i++) {
            List<String> topicJob = getAllURLTopicOfPage(i);
            for (String next : topicJob) {
                getDataOnTopic(next);
            }
        }
        return this.listNode;
    }
}
