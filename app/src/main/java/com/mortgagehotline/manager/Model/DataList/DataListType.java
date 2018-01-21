package com.mortgagehotline.manager.Model.DataList;

/**
 * Created by yaptzeyang on 06/01/2018.
 */

public class DataListType {

    public static final int TITLE_TYPE =  0;
    public static final int UPDOWN_TYPE = 1;
    public static final int LEFTRIGHT_TYPE = 2;

    private String title;
    private String data;
    private int type;

    public DataListType(int type, String title, String data) {
        this.title = title;
        this.data = data;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
