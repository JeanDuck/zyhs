package com.example.lhx.recovery;

public class addresslistview {

    private String realname;//真实姓名
    private String phonenumber;//电话
    private String address;//详细地址

    public String getAddress() {
        return address;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public String getRealname() {
        return realname;
    }
    public addresslistview(String realname,String phonenumber,String address)
    {
        this.realname=realname;
        this.phonenumber=phonenumber;
        this.address=address;
    }
}
