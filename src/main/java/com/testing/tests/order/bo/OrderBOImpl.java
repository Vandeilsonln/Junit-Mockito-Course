package com.testing.tests.order.bo;

import com.testing.tests.order.dao.OrderDAO;
import com.testing.tests.order.dto.OrderDTO;
import com.testing.tests.order.exceptions.BOException;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO{

    private OrderDAO dao;

    public OrderBOImpl(OrderDAO dao){
        this.dao = dao;
    }

    public OrderBOImpl() {

    }

    public OrderDAO getDao (){
        return dao;
    }

    public void setDao(OrderDAO dao){
        this.dao = dao;
    }

    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws BOException {
        try {
            int result = dao.create(orderDTO);

            if (verifyIfResultIsNotZero(result)) return false;
        } catch (SQLException throwables) {
            throw new BOException(throwables);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int orderId) throws BOException {
        try {
            OrderDTO order = dao.read(orderId);
            order.setStatus("cancelled");
            int result = dao.update(order);

            if (verifyIfResultIsNotZero(result)) return false;
        } catch (SQLException throwables) {
            throw new BOException(throwables);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int orderId) throws BOException {
        try {
            int result = dao.delete(orderId);
            if (verifyIfResultIsNotZero(result)) return false;
        } catch (SQLException throwables) {
            throw new BOException(throwables);
        }

        return true;
    }

    private boolean verifyIfResultIsNotZero(int result) {
        if (result == 0) {
            return true;
        }
        return false;
    }
}
