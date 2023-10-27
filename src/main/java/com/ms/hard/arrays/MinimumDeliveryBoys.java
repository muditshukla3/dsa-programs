package com.ms.hard.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * A newspaper vendor wants to employ delivery boys. There are N houses in the locality arranged in one dimensional
 * lanes present at 1,2,3...N. There are M delivery boys. The ith delivery boy can deliver to house from ai to bi.
 * Given 1st input as number of houses, 2nd input as number of delivery boys and rd input a two-dimensional array
 * representing each delivery boy's delivery range, find out the minimum number of delivery boys newspaper vendor
 * needs to cover all house.
 *
 * Example: noOfHouse- 6, noOfBoys- 4, range: [{1,2},{2,4},{1,4},{5,6}]
 * Output - 2
 *
 * Example: noOfHouse- 5, noOfBoys- 2, range: [{1,4},{1,3}]
 * Output: -1
 */
public class MinimumDeliveryBoys {

    public static int minDeliveryBoys(int noOfHouses, int noOfBoys, int[][] ranges) {
        // Sort the delivery ranges by their starting point
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize variables
        int boysNeeded = 0;
        int maxRangeCovered = 0;

        int i = 0;
        while (i < noOfBoys) {
            // Find the maximum range that can be covered by the current delivery boy
            int maxRange = -1;

            while (i < noOfBoys && ranges[i][0] <= maxRangeCovered + 1) {
                maxRange = Math.max(maxRange, ranges[i][1]);
                i++;
            }

            if (maxRange == -1) {
                // There is a gap in the houses that cannot be covered
                return -1;
            }

            maxRangeCovered = maxRange;
            boysNeeded++;

            if (maxRangeCovered >= noOfHouses) {
                // All houses are covered
                return boysNeeded;
            }
        }

        // If we haven't covered all houses, return -1
        return -1;
    }
}
