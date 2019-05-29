package com.example.lhx.recovery;

public class Orderlistview {
    private int num;
    private String time;//订单时间
    private String state;//订单状态
    private String address;
    private String salepeople;// 卖家
    private String buypeople;//买家
    private String orderdes;//订单描述
    private String sum;//订单总价

    public int getNum() { return num; }
    public String getTime() {
        return time;
    }
    public String getState() {
        return state;
    }
    public String getAddress(){ return address; }
    public String getSalepeople(){ return salepeople; }
    public String getBuypeople(){ return buypeople; }
    public String getOrderdes() {
        return orderdes;
    }
    public String getSum() {
        return sum;
    }

    public Orderlistview(int num,String time, String state,String address, String salepeople, String buypeople, String orderdes, String sum)
    {
        this.num = num;
        this.time = time;
        this.state = state;
        this.address = address;
        this.salepeople = salepeople;
        this.buypeople = buypeople;
        this.orderdes = orderdes;
        this.sum = sum;
    }
}
