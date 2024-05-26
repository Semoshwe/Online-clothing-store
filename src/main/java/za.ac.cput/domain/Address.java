package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class Address  {

    @Id
    private String addressID;
    private String street;
    private String city;
    private String province;
    private String zipCode;
    @OneToOne
    private User user;

    protected Address() {
    }

    private Address(Builder builder) {
        this.addressID = builder.addressID;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;
    }

    public String getAddressID() {
        return addressID;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressID, address.addressID) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(province, address.province) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressID, street, city, province, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID='" + addressID + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }



    public static class Builder {
        private String addressID;
        private String street;
        private String city;
        private String province;
        private String zipCode;

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder copy(Address address) {
            this.addressID = address.addressID;
            this.street = address.street;
            this.city = address.city;
            this.province = address.province;
            this.zipCode = address.zipCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}


