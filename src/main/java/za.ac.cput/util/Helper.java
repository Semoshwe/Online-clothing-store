package za.ac.cput.util;
/*
 *Product:java
 *Product: Helper Class
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import za.ac.cput.domain.Orders;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }


    public static boolean isOrderNullorEmpty(Double s) {
        return s == null || Double.isNaN(s);
    }

    public static boolean isNullOrEmpty(List<Orders> s) {
        return s == null || s.isEmpty();
    }

    public static boolean isValidRange(int rating) {
        return rating >= 1 && rating <= 5;
    }

    public static boolean isEmailValid(String email, String regex) {
        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }

    public static boolean isNullOrEmpty(Long l) {
        return l == null;
    }
}