package com.example.sahil.practice.data_structures_and_algorithms;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingTest {

    private static final Logger log = LoggerFactory.getLogger(SortingTest.class);

    @Test
    public void doSelectionSortTest(){
        int[] unsorted = new int[]{0, 99, 7, -21, 3, -1, 17, 21, 4};
        log.info("{}", Sorting.doSelectionSortIntAsc(unsorted));
        log.info("{}", Sorting.doSelectionSortIntDesc(unsorted));

    }
}
