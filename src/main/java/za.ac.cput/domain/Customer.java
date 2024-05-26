package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    private String customerId;
    private String privileges;

    private String userID;

    @OneToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressID", insertable = false, updatable = false)
    private Address address;

    public Customer() {
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.privileges = builder.privileges;
        this.userID = builder.userID;
        this.orders = builder.orders;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (privileges != null ? !privileges.equals(customer.privileges) : customer.privileges != null) return false;
        return userID != null ? userID.equals(customer.userID) : customer.userID == null;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", privileges='" + privileges + '\'' +
                ", userID='" + userID + '\'' +
                ", user=" + user +
                ", orders=" + orders +
                ", address=" + address +
                '}';
    }

    public static class Builder {
        private String customerId;
        private String privileges;
        private String userID;
        private List<Order> orders;

        public Builder setCustomerId(String  customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setPrivileges(String privileges) {
            this.privileges = privileges;
            return this;
        }

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setOrders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.privileges = customer.privileges;
            this.userID = customer.userID;
            this.orders = customer.orders;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
