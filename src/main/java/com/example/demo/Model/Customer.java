package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int customer_id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer ()
    {
    }

    public int getCustomer_id ()
    {
        return customer_id;
    }

    public void setCustomer_id (int customer_id)
    {
        this.customer_id = customer_id;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString ()
    {
        return "Customer{" + "customer_id=" + customer_id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + '}';
    }
}
