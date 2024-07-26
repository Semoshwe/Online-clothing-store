package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Add this if userID is auto-generated
    private String userID;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String addressID;
    private String customerID;

    protected User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.addressID = builder.addressID;
        this.customerID = builder.customerID;
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddressID() {
        return addressID;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return (userID != null ? userID.equals(user.userID) : user.userID == null) &&
               (firstName != null ? firstName.equals(user.firstName) : user.firstName == null) &&
               (lastName != null ? lastName.equals(user.lastName) : user.lastName == null) &&
               (password != null ? password.equals(user.password) : user.password == null) &&
               (email != null ? email.equals(user.email) : user.email == null) &&
               (addressID != null ? addressID.equals(user.addressID) : user.addressID == null) &&
               (customerID != null ? customerID.equals(user.customerID) : user.customerID == null);
    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (addressID != null ? addressID.hashCode() : 0);
        result = 31 * result + (customerID != null ? customerID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", addressID='" + addressID + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }

    public static class Builder {
        private String userID;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private String addressID;
        private String customerID;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder copy(User user){
            this.userID = user.userID;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.password = user.password;
            this.email = user.email;
            this.addressID = user.addressID;
            this.customerID = user.customerID;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
