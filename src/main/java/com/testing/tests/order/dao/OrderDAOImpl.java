package com.testing.tests.order.dao;

import com.testing.tests.order.dto.OrderDTO;

import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO{

    @Override
    public int create(OrderDTO orderDTO) throws SQLException {
        return 0;
    }

    @Override
    public OrderDTO read(int id) throws SQLException {
        return null;
    }

    @Override
    public int update(OrderDTO orderDTO) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
