package cn.springbootxianhualemaster.pojo;

import java.util.Date;

public class Provider {
    private Integer id;

    private String proCode;

    private String proName;

    private String proDesc;

    private String proContact;

    private String proPhone;

    private String proAddress;

    private String proFax;

    private int createdBy;

    private Date creationDate;

    private Date modifyDate;

    private int modifyBy;


    public Provider(Integer id, String proCode, String proName, String proDesc, String proContact, String proPhone,
			String proAddress, String proFax, int createdBy, Date creationDate, Date modifyDate, int modifyBy) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
	}

	public Provider() {
        super();
    }

	public void setProcode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    
   

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode== null ? null : proCode.trim();
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName== null ? null : proName.trim();
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc== null ? null : proDesc.trim();
	}

	public String getProContact() {
		return proContact;
	}

	public void setProContact(String proContact) {
		this.proContact = proContact== null ? null : proContact.trim();
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone== null ? null : proPhone.trim();
	}

	public String getProAddress() {
		return proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress== null ? null : proAddress.trim();
	}

	public String getProFax() {
		return proFax;
	}

	public void setProFax(String proFax) {
		this.proFax = proFax== null ? null : proFax.trim();
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	
}