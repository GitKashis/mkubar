package ru.job4j.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.parser.dbconnect.DBconnect;
import ru.job4j.parser.parse.ParseSQLru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Calendar;

public class StartUI {

    /**
     * Parse object.
     */
    private final ParseSQLru parseSQLru = new ParseSQLru();

    /**
     * Object to save data in db.
     */
    private final DBconnect dBconnect = new DBconnect();

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(StartUI.class);

    /**
     * Launch frequency in Day.
     */
    private final long launchFrequency;

    /**
     * Constructor.
     * @param launchFrequency
     */
    public StartUI(int launchFrequency) throws SQLException {
        this.launchFrequency = milsCount(launchFrequency);
    }

    /**
     * Count miles while.
     * @param launchFrequency in day.
     * @return miles for count.
     */
    private long milsCount(int launchFrequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0 , 2, 0, 0, 0);
        return calendar.getTimeInMillis() / launchFrequency;
    }

    /**
     * Execute method.
     */
    private void execute() {
        long nextParseTime = Calendar.getInstance().getTimeInMillis();
        while (true) {
            Calendar calendar = Calendar.getInstance();
            while (calendar.getTimeInMillis() < nextParseTime) {
                Calendar nextTime = Calendar.getInstance();
                nextTime.setTimeInMillis(nextParseTime);
                String info = String.format("Next parse time:  %s", nextTime.getTime().toString());
                this.logger.info(info);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    this.logger.error(e.getMessage(), e);
                }
                calendar = Calendar.getInstance();
            }
            nextParseTime = calendar.getTimeInMillis() + this.launchFrequency;
            this.logger.info("Start parse!");
            this.dBconnect.addNodeInDB(this.parseSQLru.execute());
        }
    }

    /**
     * Start program.
     * @param args arguments
     */
    public static void main(String[] args) throws  SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter launch frequency in day:    ");
        int launch = 1;
        try {
            launch = Integer.valueOf(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StartUI startUI = new StartUI(launch);
        startUI.execute();
    }
}
