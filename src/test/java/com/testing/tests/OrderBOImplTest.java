package com.testing.tests;

import com.testing.tests.order.bo.OrderBOImpl;
import com.testing.tests.order.dao.OrderDAO;
import com.testing.tests.order.dto.OrderDTO;
import com.testing.tests.order.exceptions.BOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderBOImplTest {

    @Mock
    OrderDAO dao;
    private OrderBOImpl bo;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        bo = new OrderBOImpl();
        bo.setDao(dao);
    }

    @Test
    public void placeOrderShouldCreateAnOrder() throws SQLException, BOException {

        OrderDTO orderDTO = new OrderDTO();

        when(dao.create(orderDTO))
                .thenReturn(1);

        boolean result = bo.placeOrder(orderDTO);
        assertTrue(result);
        verify(dao).create(orderDTO);   // Make sure this method is getting called
    }

    @Test
    public void placeOrderShouldNotCreateAnOrder() throws SQLException, BOException {
        OrderDTO orderDTO = new OrderDTO();

        when(dao.create(orderDTO))
                .thenReturn(0);

        boolean result = bo.placeOrder(orderDTO);
        assertFalse(result);
        verify(dao).create(orderDTO);   // Make sure this method is getting called
    }
}
