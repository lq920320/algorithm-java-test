package conversions;

import org.junit.Assert;
import org.junit.Test;

public class AnyBaseToDecimal {

  @Test
  public void anyBaseToDecimalTest() {
    Assert.assertEquals("Invalid Number", convertToDecimal("3", 2));
    Assert.assertEquals("3", convertToDecimal("11", 2));
    Assert.assertEquals("4", convertToDecimal("100", 2));
    Assert.assertEquals("5", convertToDecimal("101", 2));
    Assert.assertEquals("10", convertToDecimal("1010", 2));
    Assert.assertEquals("1024", convertToDecimal("10000000000", 2));

    Assert.assertEquals("Invalid Number", convertToDecimal("8", 8));
    Assert.assertEquals("Invalid Number", convertToDecimal("9", 8));
    Assert.assertEquals("7", convertToDecimal("7", 8));
    Assert.assertEquals("8", convertToDecimal("10", 8));
    Assert.assertEquals("9", convertToDecimal("11", 8));
    Assert.assertEquals("10", convertToDecimal("12", 8));
    Assert.assertEquals("1024", convertToDecimal("2000", 8));

    Assert.assertEquals("Invalid Number", convertToDecimal("A", 10));
    Assert.assertEquals("10", convertToDecimal("10", 10));
    Assert.assertEquals("1024", convertToDecimal("1024", 10));

    Assert.assertEquals("Invalid Number", convertToDecimal("G", 16));
    Assert.assertEquals("16", convertToDecimal("10", 16));
    Assert.assertEquals("17", convertToDecimal("11", 16));
    Assert.assertEquals("100", convertToDecimal("64", 16));
    Assert.assertEquals("225", convertToDecimal("E1", 16));
    Assert.assertEquals("1024", convertToDecimal("400", 16));
  }

  /**
   * This method produces a decimal value of any given input number of any base
   *
   * @param inpNum String of which we need the decimal value and base in integer format
   * @return string format of the decimal value
   */

  public String convertToDecimal(String inpNum, int base) {
    int len = inpNum.length();
    int num = 0;
    int pow = 1;

    for (int i = len - 1; i >= 0; i--) {
      if (valOfChar(inpNum.charAt(i)) >= base) {
        return "Invalid Number";
      }
      num += valOfChar(inpNum.charAt(i)) * pow;
      pow *= base;
    }
    return String.valueOf(num);
  }

  /**
   * This method produces integer value of the input character and returns it
   *
   * @param c Char of which we need the integer value of
   * @return integer value of input char
   */

  private static int valOfChar(char c) {
    if (c >= '0' && c <= '9') {
      return (int) c - '0';
    } else {
      return (int) c - 'A' + 10;
    }
  }
}