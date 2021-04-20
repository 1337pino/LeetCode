package Problems.Easy;

class _7_ReverseInteger {
    /**
     * Returns the reversed digits of a given signed integer
     * @param x Signed 32-bit integer
     * @return Reversed version of X; will return 0 if the reverse of X isn't a valid 
     * integer
     */
    public int reverse(int x) {
        String xString = "" + x;
        String xReverseString = "";
        
        int end = 0;
        if (xString.charAt(0) == '-') {
            end = 1;
            xReverseString += '-';
        }
        
        for (int i = xString.length() - 1; i >= end; i--) {
            xReverseString += xString.charAt(i);
        }
        
        long xLong = Long.parseLong(xReverseString);
        
        if (xLong > Integer.MAX_VALUE || xLong < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)xLong;
        }
    }
}