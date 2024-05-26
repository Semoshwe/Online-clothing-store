package za.ac.cput.repository;
/**
 * E-Commerce Web Application for selling clothes
 * ICartItemRepository.java
 * This class provides the interface for the CartItem entity
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 16 May 2024
 * */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CartItem;

import java.util.List;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, String> {
    CartItem findCartItemByCartID(String cartId);
}
