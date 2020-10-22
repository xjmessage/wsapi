package com.mkx.wsapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mkx.wsapi.extension.Constant;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工任职集团关系表
 * */
public class EmployeeGroupAttribution implements Serializable {
    private Integer unique_id;
    //集团序号
    private Integer group_no;
    //员工登录名称
    private String login_name;
    //最后一次编辑日期
    @DateTimeFormat(pattern= Constant.DDFormat)
    @JsonFormat(pattern=Constant.DDFormat,timezone = Constant.TIME_ZONE,locale=Constant.LOCALE)
    private Date modify_datetime;
    //最后一次编辑操作人
    private String modify_user;
    /*
     *构造函数
    //无参数构造器
    public EmployeeGroupAttribution(){
        super();
    }
    //有参数构造器
    public EmployeeGroupAttribution(Integer unique_id, Integer group_no, String login_name, Date modify_datetime, String modify_user){
        super();
        this.unique_id = unique_id;
        this.group_no = group_no;
        this.login_name = login_name;
        this.modify_datetime = modify_datetime;
        this.modify_user = modify_user;
    }
    */

    //重写toString()
    @Override
    public String toString(){
        return this.group_no + "-" + this.login_name + "-" + this.modify_user + "-" + this.modify_datetime;
    }

    //setter和getter方法
    public Integer getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(Integer unique_id) {
        this.unique_id = unique_id;
    }

    public Integer getGroup_no(){
        return group_no;
    }
    public  void setGroup_no(Integer group_no){
        this.group_no = group_no;
    }
    public String getLogin_name(){
        return login_name;
    }
    public void setLogin_name(String login_name){
        this.login_name = login_name;
    }
    @DateTimeFormat(pattern= Constant.DDFormat)
    @JsonFormat(pattern=Constant.DDFormat,timezone = Constant.TIME_ZONE,locale=Constant.LOCALE)
    public Date getModify_datetime() {
        return modify_datetime;
    }

    public void setModify_datetime(Date modify_datetime) {
        this.modify_datetime = modify_datetime;
    }

    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }
}

