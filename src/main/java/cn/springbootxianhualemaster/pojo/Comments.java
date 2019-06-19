package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Comments {
    private Integer id;

    private Integer userid;

    private String commentscontent;

    private Date commentsdate;

    private String productname;

    public Comments(Integer id, Integer userid, String commentscontent, Date commentsdate, String productname) {
        this.id = id;
        this.userid = userid;
        this.commentscontent = commentscontent;
        this.commentsdate = commentsdate;
        this.productname = productname;
    }

    public Comments() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCommentscontent() {
        return commentscontent;
    }

    public void setCommentscontent(String commentscontent) {
        this.commentscontent = commentscontent == null ? null : commentscontent.trim();
    }

    public Date getCommentsdate() {
        return commentsdate;
    }

    public void setCommentsdate(Date commentsdate) {
        this.commentsdate = commentsdate;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }
}