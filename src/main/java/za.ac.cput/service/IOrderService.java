package za.ac.cput.service;

import za.ac.cput.domain.Order;

/*
 *orderService interface
 * Rethabile Ntsekhe
 * 17 May 2024
 * Student Number 220455430
 */

public interface IOrderService extends IService<Order, String >{

    Order read(Long id);
}
