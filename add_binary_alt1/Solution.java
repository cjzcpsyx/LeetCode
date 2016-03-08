// A better version, took 5ms
public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0 || a == null) return b;
        if (b.length() == 0 || b == null) return a;
        int carry_bit = 0;
        StringBuilder result = new StringBuilder();
        // index used for iterating through each string
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                result.append(Integer.toString(carry_bit));
                carry_bit = 1;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                result.append(Integer.toString(carry_bit));
                carry_bit = 0;
            } else {
                if (carry_bit == 0) {
                    result.append("1");
                    carry_bit = 0;
                } else {
                    result.append("0");
                    carry_bit = 1;
                }
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (a.charAt(i) == '1') {
                if (carry_bit == 0) {
                    result.append("1");
                    carry_bit = 0;
                } else {
                    result.append("0");
                    carry_bit = 1;
                }
            } else {
                result.append(Integer.toString(carry_bit));
                carry_bit = 0;
            }
            i--;
        }
        while (j >= 0) {
            if (b.charAt(j) == '1') {
                if (carry_bit == 0) {
                    result.append("1");
                    carry_bit = 0;
                } else {
                    result.append("0");
                    carry_bit = 1;
                }
            } else {
                result.append(Integer.toString(carry_bit));
                carry_bit = 0;
            }
            j--;
        }
        if (carry_bit == 1) result.append("1");
        return result.reverse().toString();
    }
}