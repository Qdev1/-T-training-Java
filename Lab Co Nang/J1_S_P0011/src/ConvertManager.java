
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Strongest
 */
public class ConvertManager {

    public static String convert(String inputNumber, int inputBase, int outputBase) {
        String result = "";
        switch (inputBase) {
            case 1:
                result = convertFromBinary(inputNumber, outputBase);
                break;
            case 2:
                result = convertFromDecimal(inputNumber, outputBase);
                break;
            case 3:
                result = convertFromHexadecimal(inputNumber, outputBase);
                break;
        }
        return result;
    }

    /**
     * convert from binary to other base
     *
     * @param inputNumber
     * @param outputBase
     * @return result when convert successfull
     */
    private static String convertFromBinary(String inputNumber, int outputBase) {
        String result = "";
        switch (outputBase) {
            //convert from 2 -> 2
            case 1:
                result = inputNumber;
                break;
            //convert from 2 -> 10
            case 2:
                result = convertToDecimal(inputNumber, 2);
                break;
            //convert from 2 -> 16 ( 2->10->16)    
            case 3:
                result = convertdecimalToOther(convertToDecimal(inputNumber, 2), 16);
                break;
        }
        return result;
    }

    /**
     * convert from decimal to other base
     *
     * @param inputNumber
     * @param outputBase
     * @return result when convert successfull
     */
    private static String convertFromDecimal(String inputNumber, int outputBase) {
        String result = "";
        switch (outputBase) {
            //convert from 10 -> 2
            case 1:
                result = convertdecimalToOther(inputNumber, 2);
                break;
            //convert from 10  -> 10  
            case 2:
                result = inputNumber;
                break;
            //convert from 10 -> 16    
            case 3:
                result = convertdecimalToOther(inputNumber, 16);
                break;
        }
        return result;
    }

    /**
     * convert from hexadecimal to other base
     *
     * @param inputNumber
     * @param outputBase
     * @return result when convert successfull
     */
    private static String convertFromHexadecimal(String inputNumber, int outputBase) {
        String result = "";
        switch (outputBase) {
            //convert from 16 -> 2 ( 16->10 -> 2)
            case 1:
                result = convertdecimalToOther(convertToDecimal(inputNumber, 16), 2);
                break;
            //convert from 16 -> 10   
            case 2:
                result = convertToDecimal(inputNumber, 16);
                break;
            //convert from 16 -> 16  
            case 3:
                result = inputNumber;
                break;
        }
        return result;
    }

    /**
     * convert from binary or hexadecimal to decimal
     *
     * @param inputNumber
     * @param baseFrom
     * @return
     */
    public static String convertToDecimal(String inputNumber, int baseFrom) {
        if (inputNumber.compareTo("0") == 0) {
            return "0";
        }
        
        BigInteger baseBigInteger = BigInteger.valueOf(baseFrom);
        baseBigInteger = baseBigInteger.divide(baseBigInteger);
        String HEX = "0123456789ABCDEF";
        BigInteger result = new BigInteger("0");
        //loop length of number times
        for (int i = inputNumber.length() - 1; i >= 0; i--) {
            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(inputNumber.charAt(i)));
            BigInteger number = valueIndex.multiply(baseBigInteger);
            result = result.add(number);
            baseBigInteger = baseBigInteger.multiply(BigInteger.valueOf(baseFrom));
        }
        String resultString = result.toString();
        return resultString;
    }
    // 11001 cs 2 => cs 10 => output = 1*2^0+1*2^1+1*2^2+1*2^3+1*2^4 = 25
//    i=4
//    value = 1
//    result = 1*1
//    baseBigInteger = 1*2 

    //    i=3
//    value = 0
//    result = 1*1+0*2
//    baseBigInteger = 2*2 
    //    i=2
//    value = 0
//    result = 1*1+0*2+0*4
//    baseBigInteger = 2*2*2 
    //    i=1
//    value = 1
//    result = 1*1+0*2+0*4+1*8
//    baseBigInteger = 2*2*2*2
    //    i=0
//    value = 1
//    result = 1*1+0*2+0*4+1*8+1*16
//    baseBigInteger = 2*2*2*2*2
// => result = 25 =1*2^0+1*2^1+1*2^2+1*2^3+1*2^4 = 25
    /**
     * convert from decimal to binary or hexadecimal
     *
     * @param decimalNumber
     * @param base
     * @return
     */
    private static String convertdecimalToOther(String decimalNumber, int base) {
        if (decimalNumber.compareTo("0") == 0) {
            return "0";
        }
        BigInteger decimalBigInteger = new BigInteger(decimalNumber);
        BigInteger baseBigInteger = BigInteger.valueOf(base);
        String HEX = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();
        // loop until decimal number equal 0
        while (decimalBigInteger.compareTo(new BigInteger("0")) > 0) {
            int remainder = decimalBigInteger.mod(baseBigInteger).intValue();
            //resultString = HEX.charAt(remainder) + resultString + "";
            result.append(HEX.charAt(remainder));
            decimalBigInteger = decimalBigInteger.divide(baseBigInteger);
        }
        return result.reverse().toString();
    }

//    6996 base 10 -> base 16 
//    6996%16= 4
//    remainder = 4 
//     decimalBigInteger/16 = 6992       
//    
//             6992%16=0
//     remainder =0 
//             6992/16 = 437
//     
//     437%16=5 
//     remainder =5 
//           437/16 = 27
//     
//     27%16=11
//     remainder = 11
//             27/16=1
//     
//     1%16=1
//        remainder = 1
//                1/16 = 0
//    => result = 1 B 5 4
}
