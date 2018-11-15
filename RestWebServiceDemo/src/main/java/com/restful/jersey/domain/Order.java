package com.restful.jersey.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "order")
public class Order {
 
     
    private int orderNo;
    private String custmer;
    private String address;
    private String amount;
     
    @XmlAttribute(name = "order-no")
    public int getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
     
    @XmlElement
    public String getCustmer() {
        return custmer;
    }
    public void setCustmer(String custmer) {
        this.custmer = custmer;
    }
     
    @XmlElement
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
     
    @XmlElement(name = "bill-amount")
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
}