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

    @Test()
    public void placeOrderShouldthrowBOException() throws  SQLException{
        OrderDTO orderDTO = new OrderDTO();
        when(dao.create(orderDTO))
                .thenThrow(SQLException.class);

        assertThrows(BOException.class, () ->{
            bo.placeOrder(orderDTO);
        } );

    }

    @Test
    public void cancelOrderShouldCancelTheOrder() throws SQLException, BOException {
        OrderDTO orderDTO = new OrderDTO();
        when(dao.read(123))
                .thenReturn(orderDTO);

        when(dao.update(orderDTO))
                .thenReturn(1);

        boolean result = bo.cancelOrder(123);
        assertTrue(result);

        verify(dao).read(123);
        verify(dao).update(orderDTO);
    }

    @Test
    public void cancelOrderShouldNotCancelTheOrder() throws SQLException, BOException {
        OrderDTO orderDTO = new OrderDTO();
        when(dao.read(123))
                .thenReturn(orderDTO);

        when(dao.update(orderDTO))
                .thenReturn(0);

        boolean result = bo.cancelOrder(123);
        assertFalse(result);

        verify(dao).read(123);
        verify(dao).update(orderDTO);
    }

    @Test
    public void cancelOrderShouldThrowBOExceptionOnUpdate() throws SQLException {
        OrderDTO orderDTO = new OrderDTO();
        when(dao.read(123))
                .thenReturn(orderDTO);

        when(dao.update(orderDTO))
                .thenThrow(SQLException.class);

        assertThrows(BOException.class, () -> {
            bo.cancelOrder(123);
        });

        verify(dao).read(123);
        verify(dao).update(orderDTO);
    }

    @Test
    public void cancelOrderShouldThrowBOExceptionOnRead() throws SQLException {
        OrderDTO orderDTO = new OrderDTO();
        when(dao.read(123))
                .thenThrow(SQLException.class);

        when(dao.update(orderDTO))
                .thenReturn(0);

        assertThrows(BOException.class, () -> {
            bo.cancelOrder(123);
        });

        verify(dao).read(123);
    }
}