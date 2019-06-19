package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class orderstauts {
    private Integer id;

    private String statusDes;

    private Date createdate;

    private Date modifydate;

    public orderstauts(Integer id, String statusDes, Date createdate, Date modifydate) {
        this.id = id;
        this.statusDes = statusDes;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

    public orderstauts() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusDes() {
        return statusDes;
    }

    public void setStatusDes(String statusDes) {
        this.statusDes = statusDes == null ? null : statusDes.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}