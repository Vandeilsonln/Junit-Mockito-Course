package com.testing.tests.order.bo;

import com.testing.tests.order.dto.OrderDTO;
import com.testing.tests.order.exceptions.BOException;

public interface OrderBO {

    boolean placeOrder(OrderDTO orderDTO) throws BOException;

    boolean cancelOrder(int orderId) throws BOException;

    boolean deleteOrder(int orderId) throws BOException;
}
