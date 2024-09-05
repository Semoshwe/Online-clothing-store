package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

@Entity
public class ProductImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageID;
    private Long productID;
    @Lob
    @Column(length=100000)
    private byte[] image;

    protected ProductImage() {

    }

    private ProductImage(Builder builder){
        this.imageID = builder.imageID;
        this.productID = builder.productID;
        this.image = builder.image;
    }

    public Long getImageID() {
        return imageID;
    }

    public Long getProductID() {
        return productID;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImage that = (ProductImage) o;
        return Objects.equals(imageID, that.imageID) && Objects.equals(productID, that.productID) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageID, productID, image);
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "imageID=" + imageID +
                ", productID=" + productID +
                ", image=" + image +
                '}';
    }

    public static class Builder{
        private Long imageID;
        private Long productID;
        private byte[] image;

        public Builder setImageID(Long imageID){
            this.imageID = imageID;
            return this;
        }

        public Builder setProductID(Long productID){
            this.productID = productID;
            return this;
        }

        public Builder setImage(byte[] image){
            this.image = image;
            return this;
        }

        public Builder copy(ProductImage productImage){
            this.imageID = productImage.imageID;
            this.productID = productImage.productID;
            this.image = productImage.image;
            return this;
        }

        public ProductImage build(){
            return new ProductImage(this);
        }
    }
}
