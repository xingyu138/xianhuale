package cn.springbootxianhualemaster.pojo;


import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class Products implements Serializable {
    //商品id
    @Field("id")
    private Integer id;
    //商品名称
    @Field("productName")
    private String productName;
    @Field("name")
    private String name;

    @Field("purpose_name")
    private String purpose_name;
    @Field("color_name")
    private String color_name;
    @Field("flower_name")
    private String flower_name;
    @Field("packing_name")
    private String packing_name;
    @Field("productPic")
    private String productPic;
    @Field("category_id")
    private int category_id;
    @Field("purpose_id")
    private int purpose_id;
    @Field("flowers_id")
    private int flowers_id;
    @Field("price")
    private int price;
    @Field("color_id")
    private int color_id;
    @Field("packing_id")
    private int packing_id;
    @Field("amount")
    private int amount;
    @Field("sold")
    private int sold;
    @Field("status")
    private int status;
    @Field("stock")
    private int stock;
    @Field("provider_id")
    private int provider_id;










    public String getPurpose_name() {
        return name;
    }

    public void setPurpose_name(String Purpose_name) {
        this.purpose_name = purpose_name;
    }
    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.name = flower_name;
    }
    public String getPacking_name() {
        return packing_name;
    }

    public void setPacking_name(String packing_name) {
        this.packing_name = packing_name;
    }
    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public int getPurpose_id() {
        return purpose_id;
    }

    public void setPurpose_id(int purpose_id) {
        this.purpose_id = purpose_id;
    }
    public int getFlowers_id() {
        return flowers_id;
    }

    public void setFlowers_id(int flowers_id) {
        this.flowers_id = flowers_id;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }
    public int getPacking_id() {
        return packing_id;
    }

    public void setPacking_id(int packing_id) {
        this.packing_id = packing_id;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}