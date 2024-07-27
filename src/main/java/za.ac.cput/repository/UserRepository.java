package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

    List<User> findByLastName(String lastName);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(@Param("email") String email);

    // void deleteByUserID(String userID);

}
