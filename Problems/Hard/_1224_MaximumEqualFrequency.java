/** 1224. Maximum Equal Frequency
 * https://leetcode.com/problems/maximum-equal-frequency/
 */

 package Problems.Hard;

import java.util.*;

import javax.lang.model.element.Element;

public class _1224_MaximumEqualFrequency {
    /**
     * Returns the length of the longest possible subarray wherein all unique numbers within the 
     * subarray have the same amount of occurrences once one element of the subarray is removed.
     * @param nums Array of positive integers (between 1 and 10^5, inclusively). Length is at least 
     * 2 and at most 10^5
     * @return Integer value for the subarray length
     */
    public int maxEqualFreq2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
        }
    }

    public int maxEqualFreq(int[] nums) {
        int min = 1, max = 1;
        int maxElement = nums[0];
        int subarrayStart = 0;
        int longestSubarray = 0;
        HashMap<Integer, Integer> elementCount = new HashMap<Integer, Integer>();
        elementCount.put(nums[0], 1);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            elementCount.merge(num, 1, Integer::sum);
            int count = elementCount.get(num);
            boolean subarrayValid = true;
            if (count > max) {
                if (max != min) {
                    subarrayValid = false;
                }

                max = count;
                maxElement = num;
            } else if (count < min) {
                min = count;
                //minElement = num;

                if (max - min > 1) { // Any existing valid subarray now ends
                    int subArrayRange = (i - 1) - subarrayStart;

                    // Update longest known subarray length if needed
                    if (longestSubarray < subArrayRange) longestSubarray = subArrayRange;

                    /* Identify all of the unique numbers in the subarray that need to have their 
                       counts reduce to accomodate the element in the new index */
                    //List<Integer> elementsToReduce = new ArrayList<Integer>();
                    int numberOfElementsToReduce = 0;
                    for (Map.Entry<Integer, Integer> entry : elementCount.entrySet()) {
                        if (entry.getValue() - min > 1) numberOfElementsToReduce++;//elementsToReduce.add(entry.getKey());
                    }
                    
                    /* Walk from the front of the subarray until the remaining subarray is now 
                       valid again */
                    for (int j = subarrayStart; j <= i; j++) {
                        //if (elementsToReduce.size() == 0) {
                        if (numberOfElementsToReduce == 0) {
                            subarrayStart = j;
                            break;
                        }

                        int tempNum = nums[j];

                        boolean neededReducing 
                                = (elementCount.get(tempNum) - min > 1) ? true : false;
                        
                        int newElementCount = elementCount.get(tempNum) - 1;
                        elementCount.replace(tempNum, newElementCount);

                        if (neededReducing && (newElementCount - min <= 1)) {
                            numberOfElementsToReduce--;
                        }

                        if (newElementCount == 0) elementCount.remove(tempNum);
                    }
                }
            }
        }

        return longestSubarray;
    }
}
