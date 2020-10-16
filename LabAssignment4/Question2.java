package com.company;

public class Question2 {

    public static void main(String[] args) {

        int Value = -1;
        byte byteValue = (byte) Value;
        // Here when int is typeCasted to byte, no change occurs and -1 is assigned to it.
        // This is because byte in java is signed and has a range of -2^7 to 2^7 +1 and the value being
        // casted was in the range only so no overflow occurs.
        char charValue = (char) byteValue;
        // Here the byte is first converted to int and then int is converted to char.
        int intValue = (int) charValue;
        // In the third part, since int is of 32 bits and char is of 16 bits. Thus, the result is 2^16 - value of char

        System.out.println("Int: " + Value);            // -1
        System.out.println("Byte: " + byteValue);       // -1
        System.out.println("Char: " + charValue);       // ￿
        System.out.println("Int: " + intValue);         // 65535

        if (Value == intValue) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
        // Output: Not Equal
    }
}


