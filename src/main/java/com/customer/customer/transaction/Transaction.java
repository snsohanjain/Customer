package com.customer.customer.transaction;

import com.customer.customer.customers.Customer;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Transaction {
    @Id
    private Long id;
    private String order_Name;
    private Date date;

    @ManyToOne
    private Customer customer;

    public Transaction() {
    }

    public Transaction(Long id, String order_Name, Date date, Customer customer) {
        this.id = id;
        this.order_Name = order_Name;
        this.date = date;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_Name() {
        return order_Name;
    }

    public void setOrder_Name(String order_Name) {
        this.order_Name = order_Name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", order_Name='" + order_Name + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
