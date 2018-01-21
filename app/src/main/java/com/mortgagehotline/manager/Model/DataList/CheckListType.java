package com.mortgagehotline.manager.Model.DataList;

/**
 * Created by yaptzeyang on 07/01/2018.
 */

public class CheckListType {

    private String checklistTitle;
    private String checklistDate;
    private Boolean isExpanded;
    private String checklistData;

    public CheckListType(String checklistTitle, String checklistDate, Boolean isExpanded, String checklistData) {
        this.checklistTitle = checklistTitle;
        this.checklistDate = checklistDate;
        this.isExpanded = isExpanded;
        this.checklistData = checklistData;
    }

    public String getChecklistTitle() {
        return checklistTitle;
    }

    public void setChecklistTitle(String checklistTitle) {
        this.checklistTitle = checklistTitle;
    }

    public String getChecklistDate() {
        return checklistDate;
    }

    public void setChecklistDate(String checklistDate) {
        this.checklistDate = checklistDate;
    }

    public Boolean getExpanded() {
        return isExpanded;
    }

    public void setExpanded(Boolean expanded) {
        isExpanded = expanded;
    }

    public String getChecklistData() {
        return checklistData;
    }

    public void setChecklistData(String checklistData) {
        this.checklistData = checklistData;
    }
}
