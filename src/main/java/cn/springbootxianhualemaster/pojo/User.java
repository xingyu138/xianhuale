package cn.springbootxianhualemaster.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private Integer userid;

    private String usercode;

    private String username;

    private String nickname;

    private String password;

    private String headPic;

    private String birthday;

    private Integer age;

    private String address;

    private String phone;

    private String gender;

    private Integer qq;

    private String email;

    private String paymentpassword;

    private Integer orderid;

    private Date creationgdate;

    private Date modifydate;

    private String question;

    private String answer;

    public User(Integer userid, String usercode, String username, String nickname, String password, String headPic, String birthday, Integer age, String address, String phone, String gender, Integer qq, String email, String paymentpassword, Integer orderid, Date creationgdate, Date modifydate, String question, String answer) {
        this.userid = userid;
        this.usercode = usercode;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.headPic = headPic;
        this.birthday = birthday;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.qq = qq;
        this.email = email;
        this.paymentpassword = paymentpassword;
        this.orderid = orderid;
        this.creationgdate = creationgdate;
        this.modifydate = modifydate;
        this.question = question;
        this.answer = answer;
    }

    public User() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPaymentpassword() {
        return paymentpassword;
    }

    public void setPaymentpassword(String paymentpassword) {
        this.paymentpassword = paymentpassword == null ? null : paymentpassword.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getCreationgdate() {
        return creationgdate;
    }

    public void setCreationgdate(Date creationgdate) {
        this.creationgdate = creationgdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}