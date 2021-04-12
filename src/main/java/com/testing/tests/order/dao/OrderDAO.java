package com.testing.tests.order.dao;

import com.testing.tests.order.dto.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO {

    int create(OrderDTO orderDTO) throws SQLException;

    OrderDTO read(int id) throws SQLException;

    int update(OrderDTO orderDTO) throws SQLException;

    int delete(int id) throws SQLException;
}
