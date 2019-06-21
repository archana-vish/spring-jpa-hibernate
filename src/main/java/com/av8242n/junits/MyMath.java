package com.av8242n.junits;

import java.util.Arrays;

public class MyMath {

    // Method to accept an array of numbers and return the sum

    public int addAll(int[] nums) {
       return Arrays.stream(nums).sum();
    }

}
