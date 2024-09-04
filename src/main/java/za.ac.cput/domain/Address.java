package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;

    @Column(name = "user_id")
    private Long userId;
    private String addressLine;
    private String city;
    private String country;
    private String zipCode;
    private String phoneNumber;
    private LocalDate createdAt;
    private LocalDate deletedAt;


    public Address() {
    }

    private Address(Builder builder) {
        this.addressID = builder.addressID;
        this.userId = builder.userId;
        this.addressLine = builder.addressLine;
        this.city = builder.city;
        this.country = builder.country;
        this.zipCode = builder.zipCode;
        this.phoneNumber = builder.phoneNumber;
        this.createdAt = builder.createdAt;
        this.deletedAt = builder.deletedAt;

    }

    public Long getAddressID() {return addressID;}

    public Long getUserId() {return userId;}

    public String getAddressLine() {return addressLine;}

    public String getCity() {return city;}

    public String getCountry() {return country;}

    public String getZipCode() {return zipCode;}

    public String getPhoneNumber() {return phoneNumber;}

    public LocalDate getCreatedAt() {return createdAt;}

    public LocalDate getDeletedAt() {return deletedAt;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressID, address.addressID) && Objects.equals(userId, address.userId) && Objects.equals(addressLine, address.addressLine) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(zipCode, address.zipCode) && Objects.equals(phoneNumber, address.phoneNumber) && Objects.equals(createdAt, address.createdAt) && Objects.equals(deletedAt, address.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressID, userId, addressLine, city, country, zipCode, phoneNumber, createdAt, deletedAt);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", userId=" + userId +
                ", addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }

    public static class Builder {
        private Long addressID;
        private Long userId;
        private String addressLine;
        private String city;
        private String country;
        private String zipCode;
        private String phoneNumber;
        private LocalDate createdAt;
        private LocalDate deletedAt;

        public Builder setAddressID(Long addressID) {this.addressID = addressID;return this;}

        public Builder setUserId(Long userId) {this.userId = userId; return this;}

        public Builder setAddressLine(String addressLine) {
            this.addressLine = addressLine; return this;
        }

        public Builder setCity(String city) {this.city = city;return this;}

        public Builder setCountry(String country) {
            this.country = country;return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;return this;
        }

        public Builder setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;return this;
        }

        public Builder setDeletedAt(LocalDate deletedAt) {
            this.deletedAt = deletedAt;return this;
        }


        public Builder copy(Address address) {
            this.addressID = address.addressID;
            this.userId = address.userId;
            this.addressLine = address.addressLine;
            this.city = address.city;
           this.country = address.country;
            this.zipCode = address.zipCode;
            this.phoneNumber = address.phoneNumber;
            this.createdAt = address.createdAt;
            this.deletedAt = address.deletedAt;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}


