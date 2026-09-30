package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cartid;

    private long userid;

    private long pid;
    @ManyToOne
    @JoinColumn(
        name = "pid",
        referencedColumnName = "ProductId",
        insertable = false,
        updatable = false
    )
    private OrderModel product;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

	public OrderModel getProduct() {
		// TODO Auto-generated method stub
		return product;
	}
}