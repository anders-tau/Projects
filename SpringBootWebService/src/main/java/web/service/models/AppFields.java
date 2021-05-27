package web.service.models;

import web.service.misc.AppDateTimeProcessing;
import web.service.misc.AppGetRandomValue;

public class AppFields {

    private long id;
    private final long dateTime;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;

    public AppFields() {

        long longYearMonthDay = Long.parseLong(new AppDateTimeProcessing().getDateTimeString());

        this.id = new AppGetRandomValue().getRandom();
        this.dateTime = longYearMonthDay;
        this.param1 = "Param1";
        this.param2 = "Param2";
        this.param3 = "Param3";
        this.param4 = "Param4";
        this.param5 = "Param5";
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) { this.param1 = param1; }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    public long getDateTime() { return dateTime; }
}
