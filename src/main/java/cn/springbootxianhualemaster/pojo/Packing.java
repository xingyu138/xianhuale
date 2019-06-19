package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Packing {
    private Integer id;

    private String packing_name;

    private Date creationdate;

    private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPacking_name() {
		return packing_name;
	}

	public void setPacking_name(String packing_name) {
		this.packing_name = packing_name;
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

	public Packing(Integer id, String packing_name, Date creationdate, Date modifydate) {
		super();
		this.id = id;
		this.packing_name = packing_name;
		this.creationdate = creationdate;
		this.modifydate = modifydate;
	}

    
}