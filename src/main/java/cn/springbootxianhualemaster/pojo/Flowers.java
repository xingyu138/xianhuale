package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Flowers {
    private Integer id;

    private String flower_name;

    private Date creationdate;

    private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlower_name() {
		return flower_name;
	}

	public void setFlower_name(String flower_name) {
		this.flower_name = flower_name;
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

	public Flowers(Integer id, String flower_name, Date creationdate, Date modifydate) {
		super();
		this.id = id;
		this.flower_name = flower_name;
		this.creationdate = creationdate;
		this.modifydate = modifydate;
	}

   
}