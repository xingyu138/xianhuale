package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Orderpayment_type {
    private Integer id;

    private String paymentDesc;

    private Date createdate;

    private Date modifydate;

    public Orderpayment_type(Integer id, String paymentDesc, Date createdate, Date modifydate) {
        this.id = id;
        this.paymentDesc = paymentDesc;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

    public Orderpayment_type() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc == null ? null : paymentDesc.trim();
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