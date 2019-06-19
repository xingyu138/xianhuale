package cn.springbootxianhualemaster.pojo;

public class Collections {
    private Integer id;

    private Integer userId;

    private Integer productid;
    
    private String commentsContent;//留言内容
    private String productName;
    private String commentsDate;
    private String nickName;
    
    
    
  



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCommentsContent() {
		return commentsContent;
	}

	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCommentsDate() {
		return commentsDate;
	}

	public void setCommentsDate(String commentsDate) {
		this.commentsDate = commentsDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Collections(Integer id, Integer userId, Integer productid) {
        this.id = id;
        this.userId = userId;
        this.productid = productid;
    }

    public Collections() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}