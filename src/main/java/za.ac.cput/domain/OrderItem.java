package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Embeddable
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderItemId;
    private int quantity;
    private double price;

    public OrderItem() {}

    private OrderItem(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public Long getId() {
        return id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;

        if (getQuantity() != orderItem.getQuantity()) return false;
        if (Double.compare(getPrice(), orderItem.getPrice()) != 0) return false;
        if (getId() != null ? !getId().equals(orderItem.getId()) : orderItem.getId() != null) return false;
        return getOrderItemId() != null ? getOrderItemId().equals(orderItem.getOrderItemId()) : orderItem.getOrderItemId() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOrderItemId() != null ? getOrderItemId().hashCode() : 0);
        result = 31 * result + getQuantity();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderItemId='" + orderItemId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private String orderItemId;
        private int quantity;
        private double price;

        public Builder setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(OrderItem orderItem) {
            this.orderItemId = orderItem.orderItemId;
            this.quantity = orderItem.quantity;
            this.price = orderItem.price;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}

