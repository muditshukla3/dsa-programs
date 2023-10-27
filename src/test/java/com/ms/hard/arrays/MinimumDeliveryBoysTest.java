package com.ms.hard.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDeliveryBoysTest {

    @Test
    void shouldReturnMinimumDeliveryBoysAsTwo(){
        assertEquals(2,
                MinimumDeliveryBoys.minDeliveryBoys(6,4,
                                                    new int[][]{{1, 2}, {2, 4}, {1, 4}, {5, 6}}));
    }

    @Test
    void shouldReturnNegativeMinimumDeliveryBoys(){
        assertEquals(-1,
                MinimumDeliveryBoys.minDeliveryBoys(5,2,
                        new int[][]{{1, 4}, {1, 3}}));
    }
}