package cn.springbootxianhualemaster.pojo;

public class FlowerLanguage {
    private Integer id;

    private String producrtrname;

    private String content;

    public FlowerLanguage(Integer id, String producrtrname, String content) {
        this.id = id;
        this.producrtrname = producrtrname;
        this.content = content;
    }

    public FlowerLanguage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducrtrname() {
        return producrtrname;
    }

    public void setProducrtrname(String producrtrname) {
        this.producrtrname = producrtrname == null ? null : producrtrname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}