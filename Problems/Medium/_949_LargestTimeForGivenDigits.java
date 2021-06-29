/** 949. Largest Time for Given Digits
 * https://leetcode.com/problems/largest-time-for-given-digits/
 * 
 * (two different solutions)
 */

package Problems.Medium;

import java.util.*;

public class _949_LargestTimeForGivenDigits {
    /**
     * Calculates the largest possible time using 4 single digit numbers.
     * 
     * @param arr Array of 4 digits, all between 0 and 9, inclusively.
     * @return A string represenation of the largest time.  Returns an empty string if there are no 
     * valid times
     */
    public String largestTimeFromDigits1(int[] arr) {
        String hour = "", minutes = "";
        int[] digitCount = new int[10];
        List<Integer> digits = new ArrayList<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            digitCount[arr[i]]++;
            digits.add(arr[i]);
        }
        
        for (int i = 23; i >= 0; i--) {
            String iToString = String.format("%02d", i);
            int leftDigit = Character.getNumericValue(iToString.charAt(0));
            int rightDigit = Character.getNumericValue(iToString.charAt(1));
            
            if (digitCount[leftDigit] < 1) {
                continue;
            }
            
            if (digitCount[rightDigit] < 1) {
                continue;
            }
            
            if (iToString.charAt(0) == iToString.charAt(1) 
                && digitCount[leftDigit] < 2) {
                continue;
            }
            
            hour = iToString;
            digits.remove(Integer.valueOf(leftDigit));
            digits.remove(Integer.valueOf(rightDigit));

            String minutes1 = "" + digits.get(0) + digits.get(1);
            int min1 = Integer.parseInt(minutes1);
            String minutes2 = "" + digits.get(1) + digits.get(0);
            int min2 = Integer.parseInt(minutes2);
            
            if (min1 > min2) {
                if (min1 < 60) {
                    minutes = minutes1;
                    break;
                } else if (min2 < 60) {
                    minutes = minutes2;
                    break;
                }
            } else {
                if (min2 < 60) {
                    minutes = minutes2;
                    break;
                } else if (min1 < 60) {
                    minutes = minutes1;
                    break;
                }
            }

            digits.add(Integer.valueOf(leftDigit));
            digits.add(Integer.valueOf(rightDigit));
        }

        if (hour.equals("") || minutes.equals("")) {
            return "";
        } else {
            return hour + ":" + minutes;
        }
    }

    /**
     * Calculates the largest possible time using 4 single digit numbers.
     * 
     * @param arr Array of 4 digits, all between 0 and 9, inclusively.
     * @return A string represenation of the largest time.  Returns an empty string if there are no 
     * valid times
     */
    public String largestTimeFromDigits2(int[] arr) {
        List<Integer> times = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i) continue;
                
                for (int k = 0; k < arr.length; k++) {
                    if (k == j || k == i) continue;

                    for (int m = 0; m < arr.length; m++) {
                        if (m == k || m == j || m == i) continue;

                        times.add(Integer.valueOf("" + arr[i] + arr[j] + arr[k] + arr[m]));
                    }
                }
            }
        }

        Collections.sort(times);

        for (int i = times.size() - 1; i >= 0; i--) {
            if (isValidTime(times.get(i))) {
                String time = String.format("%04d", times.get(i));
                sb.append(time);
                sb.insert(2, ":");

                break;
            }
        }

        return sb.toString();
    }

    /**
     * Verifies if a given int value is a valid time (military time).
     * 
     * @param timeInt Any integer value
     * @return True if a valid time.
     */
    private boolean isValidTime(int timeInt) {
        if (timeInt <= 2359 && timeInt >= 2300) return true;
        else if (timeInt <= 2259 && timeInt >= 2200) return true;
        else if (timeInt <= 2159 && timeInt >= 2100) return true;
        else if (timeInt <= 2059 && timeInt >= 2000) return true;
        else if (timeInt <= 1959 && timeInt >= 1900) return true;
        else if (timeInt <= 1859 && timeInt >= 1800) return true;
        else if (timeInt <= 1759 && timeInt >= 1700) return true;
        else if (timeInt <= 1659 && timeInt >= 1600) return true;
        else if (timeInt <= 1559 && timeInt >= 1500) return true;
        else if (timeInt <= 1459 && timeInt >= 1400) return true;
        else if (timeInt <= 1359 && timeInt >= 1300) return true;
        else if (timeInt <= 1259 && timeInt >= 1200) return true;
        else if (timeInt <= 1159 && timeInt >= 1100) return true;
        else if (timeInt <= 1059 && timeInt >= 1000) return true;
        else if (timeInt <= 959 && timeInt >= 900) return true;
        else if (timeInt <= 859 && timeInt >= 800) return true;
        else if (timeInt <= 759 && timeInt >= 700) return true;
        else if (timeInt <= 659 && timeInt >= 600) return true;
        else if (timeInt <= 559 && timeInt >= 500) return true;
        else if (timeInt <= 459 && timeInt >= 400) return true;
        else if (timeInt <= 359 && timeInt >= 300) return true;
        else if (timeInt <= 259 && timeInt >= 200) return true;
        else if (timeInt <= 159 && timeInt >= 100) return true;
        else if (timeInt <= 59 && timeInt >= 0) return true;
        else return false;
    }
}
