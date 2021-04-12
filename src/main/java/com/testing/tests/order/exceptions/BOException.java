package com.testing.tests.order.exceptions;

import java.sql.SQLException;

public class BOException extends Exception{

    public BOException(SQLException throwables) {
        super(throwables);
    }
}
