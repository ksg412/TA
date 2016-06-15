package org.springframework.source.common;

import java.util.Date;

/**
 * Created by sg on 2016-06-06.
 */
public class BaseVo {

    private String registId;
    private String registDate;
    private String updateId;
    private String updateDate;

    private String viewType;
    private String target01;
    private String target02;
    private String tableData01;
    private String tableData02;


    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getTarget01() {
        return target01;
    }

    public void setTarget01(String target01) {
        this.target01 = target01;
    }

    public String getTarget02() {
        return target02;
    }

    public void setTarget02(String target02) {
        this.target02 = target02;
    }

    public String getTableData01() {
        return tableData01;
    }

    public void setTableData01(String tableData01) {
        this.tableData01 = tableData01;
    }

    public String getTableData02() {
        return tableData02;
    }

    public void setTableData02(String tableData02) {
        this.tableData02 = tableData02;
    }
}
