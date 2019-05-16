package com.example.lhx.recovery;

public class Orderlistview {
    private String time;//订单时间
    private String state;//订单状态
    private String orderdes;//订单描述
    private String sum;//订单总价
    private int imageid;//物品照片

    public String getTime() {
        return time;
    }

    public String getState() {
        return state;
    }

    public String getOrderdes() {
        return orderdes;
    }

    public String getSum() {
        return sum;
    }

    public int getImageid() {
        return imageid;
    }
    public Orderlistview(String time, String state, String orderdes, String sum, int imageid)
    {
        this.time=time;
        this.state=state;
        this.orderdes=orderdes;
        this.sum=sum;
        this.imageid=imageid;


    }
}
