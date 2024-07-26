package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Orders implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderID;
    private String customerID;
    private String addressID;
    private LocalDate orderDate;
    private double totalPrice;
    private String status;
    private String orderItemsID;

    public Orders() {}

    public Orders(Builder builder) {
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderItemsID() {
        return orderItemsID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders orders)) return false;

        if (getOrderID() != orders.getOrderID()) return false;
        if (Double.compare(getTotalPrice(), orders.getTotalPrice()) != 0) return false;
        if (getCustomerID() != null ? !getCustomerID().equals(orders.getCustomerID()) : orders.getCustomerID() != null)
            return false;
        if (getAddressID() != null ? !getAddressID().equals(orders.getAddressID()) : orders.getAddressID() != null)
            return false;
        if (getOrderDate() != null ? !getOrderDate().equals(orders.getOrderDate()) : orders.getOrderDate() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(orders.getStatus()) : orders.getStatus() != null) return false;
        return getOrderItemsID() != null ? getOrderItemsID().equals(orders.getOrderItemsID()) : orders.getOrderItemsID() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getOrderID() != null ? getOrderID().hashCode() : 0;
        result = 31 * result + (getCustomerID() != null ? getCustomerID().hashCode() : 0);
        result = 31 * result + (getAddressID() != null ? getAddressID().hashCode() : 0);
        result = 31 * result + (getOrderDate() != null ? getOrderDate().hashCode() : 0);
        temp = Double.doubleToLongBits(getTotalPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getOrderItemsID() != null ? getOrderItemsID().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID='" + orderID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", addressID='" + addressID + '\'' +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", orderItemsID='" + orderItemsID + '\'' +
                '}';
    }

    public static class Builder {
        private String orderID;
        private String customerID;
        private String addressID;
        private LocalDate orderDate;
        private double totalPrice;
        private String status;
        private String orderItemsID;

        public Builder setOrderID(String orderID) {
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

        public Builder setOrderDate(LocalDate orderDate) {
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

        public Builder copy(Orders orders) {
            this.orderID = orders.orderID;
            this.customerID = orders.customerID;
            this.addressID = orders.addressID;
            this.orderDate = orders.orderDate;
            this.totalPrice = orders.totalPrice;
            this.status = orders.status;
            this.orderItemsID = orders.orderItemsID;
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }
    }
}
