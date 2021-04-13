package com.testing.tests;

import com.testing.tests.scrapbook.A;
import com.testing.tests.scrapbook.B;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Atest {

    @Mock
    B b;
    private  A a;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        a = new  A(b);
    }

    @Test
    public void usesVoidMethodShouldCallVoidMethod() throws Exception {
        doNothing().when(b).voidMethod();
        assertEquals(1, a.usesVoidMethod());
        verify(b, times(1)).voidMethod();
    }
    
}
