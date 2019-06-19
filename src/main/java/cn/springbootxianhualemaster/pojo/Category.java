package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Category {
    private Integer id;

    private String name;

    private String status;

    private Date creationdate;

    private Date modifydate;

    public Category(Integer id, String name, String status, Date creationdate, Date modifydate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.creationdate = creationdate;
        this.modifydate = modifydate;
    }

    public Category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}