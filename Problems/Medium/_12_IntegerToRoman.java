/** 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 */

package Problems.Medium;

public class _12_IntegerToRoman {
    /**
     * Converts a decimal integer into a roman numeral string
     * @param num Integer value. 1 <= num <= 3999
     * @return String representation of the roman numeral value.
     */
    public String intToRoman(int num) {
        StringBuilder strBuilder = new StringBuilder();
        
        while (num > 0) {
            String numeral;
            int frequency = 1;
            
            if (num >= 1000) {
                numeral = "M";
                frequency = num / 1000;
                num %= 1000;
            } else if (num >= 500) {
                if (num >= 900) {
                    numeral = "CM";
                    num -= 900;
                } else {
                    numeral = "D";
                    frequency = num / 500;
                    num %= 500;
                }
            } else if (num >= 100) {
                if (num >= 400) {
                    numeral = "CD";
                    num -= 400;
                } else {
                    numeral = "C";
                    frequency = num / 100;
                    num %= 100;
                }
            } else if (num >= 50) {
                if (num >= 90) {
                    numeral = "XC";
                    num -= 90;
                } else {
                    numeral = "L";
                    frequency = num / 50;
                    num %= 50;
                }
            } else if (num >= 10) {
                if (num >= 40) {
                    numeral = "XL";
                    num -= 40;
                } else {
                    numeral = "X";
                    frequency = num / 10;
                    num %= 10;
                }
            } else if (num >= 5) {
                if (num == 9) {
                    numeral = "IX";
                    num -= 9;
                } else {
                    numeral = "V";
                    frequency = num / 5;
                    num %= 5;
                }
            } else {
                if (num == 4) {
                    numeral = "IV";
                } else {
                    numeral = "I";
                    frequency = num;
                }
                num = 0;
            }
            
            if (!numeral.isEmpty()) {
                while (frequency > 0) {
                    strBuilder.append(numeral);
                    
                    frequency--;
                }
            }
        }
        
        return strBuilder.toString();
    }
}
