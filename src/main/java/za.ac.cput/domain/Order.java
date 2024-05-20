package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    private String orderID;
    private String customerID;
    private String addressID;
    private LocalDateTime orderDate;
    private double totalPrice;
    private String status;
    private String orderItemsID;

    public Order() {}

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.customerID = builder.customerID;
        this.addressID = builder.addressID;
        this.orderDate = builder.orderDate;
        this.totalPrice = builder.totalPrice;
        this.status = builder.status;
        this.orderItemsID = builder.orderItemsID;
    }

    public String  getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAddressID() {
        return addressID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String  getOrderItems() {
        return orderItemsID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        if (Double.compare(order.totalPrice, totalPrice) != 0) return false;
        if (orderID != null ? !orderID.equals(order.orderID) : order.orderID != null) return false;
        if (customerID != null ? !customerID.equals(order.customerID) : order.customerID != null) return false;
        if (addressID != null ? !addressID.equals(order.addressID) : order.addressID != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderID != null ? orderID.hashCode() : 0;
        result = 31 * result + (customerID != null ? customerID.hashCode() : 0);
        result = 31 * result + (addressID != null ? addressID.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", addressID='" + addressID + '\'' +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", orderItemsID=" + orderItemsID +
                '}';
    }

    public static class Builder {
        private String  orderID;
        private String customerID;
        private String addressID;
        private LocalDateTime orderDate;
        private double totalPrice;
        private String status;
        private String orderItemsID;


        public Builder setOrderID(String  orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }


        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setOrderItemsID(String orderItemsID) {
            this.orderItemsID = orderItemsID;
            return this;
        }
        public Builder copy(Order order) {
            this.orderID = order.orderID;
            this.customerID = order.customerID;
            this.addressID = order.addressID;
            this.orderDate = order.orderDate;
            this.totalPrice = order.totalPrice;
            this.orderItemsID = order.orderItemsID;
            this.status = order.status;
            return this;
        }
        public Order build() {
            return new Order(this);
        }
    }
}
