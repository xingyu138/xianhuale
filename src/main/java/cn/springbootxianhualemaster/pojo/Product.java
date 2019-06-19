package cn.springbootxianhualemaster.pojo;

public class Product {
	//商品id
    private Integer id;
    //类别
    private Integer category_id;
    //用途
    private Integer purpose_id;
    //花材
    private Integer flowers_id;
    //单价
    private Double price;
    //颜色
    private Integer color_id;
    //包装
    private Integer packing_id;
    //枝数
    private Integer amount;
    //商品名称
    private String productName;
    //商品图片	
    private String productPic;
    //已销售
    private Integer sold;
    //商品状态		
    private String status;
    //创建时间	
    private String  creationDate;
    //修改时间
    private String modifyDate;
    //库存
    private Integer stock;

    private Integer provider_id;
    
    private String cName;//类别名称
    private String coName;//颜色
    private String fName;//花材名
    private String paName;//包装名称
    private String puName;//用途
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getPurpose_id() {
		return purpose_id;
	}
	public void setPurpose_id(Integer purpose_id) {
		this.purpose_id = purpose_id;
	}
	public Integer getFlowers_id() {
		return flowers_id;
	}
	public void setFlowers_id(Integer flowers_id) {
		this.flowers_id = flowers_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getColor_id() {
		return color_id;
	}
	public void setColor_id(Integer color_id) {
		this.color_id = color_id;
	}
	public Integer getPacking_id() {
		return packing_id;
	}
	public void setPacking_id(Integer packing_id) {
		this.packing_id = packing_id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String  getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(Integer provider_id) {
		this.provider_id = provider_id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getPaName() {
		return paName;
	}
	public void setPaName(String paName) {
		this.paName = paName;
	}
	public String getPuName() {
		return puName;
	}
	public void setPuName(String puName) {
		this.puName = puName;
	}

    
    
    
    
    
    
}