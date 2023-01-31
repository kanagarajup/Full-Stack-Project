package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="customer_id")
private long cid;
@Column(name="customer_name")
private String cname;
@Column(name="balance")
private double cbalance;
@Column(name="branch_id")
private String bid;
public long getCid() {
	return cid;
}
public void setCid(long cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public double getCbalance() {
	return cbalance;
}
public void setCbalance(double cbalance) {
	this.cbalance = cbalance;
}
public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
}
@Override
public String toString() {
	return "Customer [cid=" + cid + ", cname=" + cname + ", cbalance=" + cbalance + ", bid=" + bid + "]";
}

}
