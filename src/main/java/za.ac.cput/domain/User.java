package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a user in the system.
 * <p>
 * This entity class is mapped to the "users" table in the database.
 *
 * @author Rethabile Ntsekhe
 * @date 25-Aug-24
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String avatar;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate birthDate;
    private String password;
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> role = new HashSet<>();

    public User() {
    }

    // Private constructor to be used by the builder
    private User(Builder builder) {
        this.userID = builder.userID;
        this.avatar = builder.avatar;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.birthDate = builder.birthDate;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.role.addAll(builder.role);
    }

    // Getters
    public Long getUserID() {
        return userID;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<String> getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "'\n'+User{" +
                "id=" + userID +
                ", avatar='" + avatar + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, avatar, firstName, lastName, email, birthDate, password, phoneNumber, role);
    }

    public static class Builder {
        private Long userID;
        private String avatar;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate birthDate;
        private String password;
        private String phoneNumber;
        private Set<String> role = new HashSet<>();

        public Builder setId(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setAvatar(String avatar) {
            this.avatar = avatar;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setRole(Set<String> role) {
            this.role = role;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.getUserID();
            this.avatar = user.getAvatar();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.email = user.getEmail();
            this.birthDate = user.getBirthDate();
            this.password = user.getPassword();
            this.phoneNumber = user.getPhoneNumber();
            this.role = new HashSet<>(user.getRole());
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
