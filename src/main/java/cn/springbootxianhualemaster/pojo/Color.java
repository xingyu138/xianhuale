package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Color {
    private Integer id;

    private String color_name;

    private Date creationdate;

    private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor_name() {
		return color_name;
	}

	public void setColor_name(String color_name) {
		this.color_name = color_name;
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

	public Color(Integer id, String color_name, Date creationdate, Date modifydate) {
		super();
		this.id = id;
		this.color_name = color_name;
		this.creationdate = creationdate;
		this.modifydate = modifydate;
	}

   
}