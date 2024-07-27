package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {
    @Id
    private String id;
    private String orderItemId;
    private int quantity;
    private double price;

    protected OrderItem() {}

    public OrderItem(Builder builder) {
        this.id = builder.id;
        this.orderItemId = builder.orderItemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public String getId() {
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
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Double.compare(price, orderItem.price) == 0 && Objects.equals(id, orderItem.id) && Objects.equals(orderItemId, orderItem.orderItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderItemId, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", orderItemId='" + orderItemId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private String id;
        private String orderItemId;
        private int quantity;
        private double price;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

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
            this.id = orderItem.getId();
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

