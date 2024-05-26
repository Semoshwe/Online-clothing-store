package za.ac.cput.util;
/*
 *Product:java
 *Product: Helper Class
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import za.ac.cput.domain.Order;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    private static String EMAIL_REGEX ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
    private static Pattern EMAIL_PATTERN =  Pattern.compile(EMAIL_REGEX);


    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }


    public static boolean isOrderNullorEmpty(Double s) {
        return s == null || Double.isNaN(s);
    }

    public static boolean isNullOrEmpty(List<Order> s) {
        return s == null || s.isEmpty();
    }

    public static boolean isValidRange(int rating) {
        return rating >= 1 && rating <= 5;
    }
    public static boolean isEmailValid(String emailAddress){
        return EMAIL_PATTERN.matcher(emailAddress).matches();
    }


    public static boolean isNullOrEmpty(Long l) {
        return l == null;
    }
}