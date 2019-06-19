package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Purpose {
    private Integer id;

    private String purpose_name;

    private Date creationdate;

    private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPurpose_name() {
		return purpose_name;
	}

	public void setPurpose_name(String purpose_name) {
		this.purpose_name = purpose_name;
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

	public Purpose(Integer id, String purpose_name, Date creationdate, Date modifydate) {
		super();
		this.id = id;
		this.purpose_name = purpose_name;
		this.creationdate = creationdate;
		this.modifydate = modifydate;
	}

   
}