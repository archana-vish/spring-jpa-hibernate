package com.av8242n.junits;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {


    @Test
    public void testAdd() {
        MyMath myMath = new MyMath();
        assertEquals(15, myMath.addAll(new int[]{1,2,3,4,5}));

    }


}
