package guru.springframework.gof;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * a = 0011 1100
 *
 * b = 0000 1101
 *
 * -----------------
 *
 * a&b = 0000 1100
 *
 * a|b = 0011 1101
 *
 * a^b = 0011 0001
 *
 * ~a  = 1100 0011
 *
 *
 * Operator	Description	Example
 * & (bitwise and)	Binary AND Operator copies a bit to the result if it exists in both operands.	(A & B) will give 12 which is 0000 1100
 * | (bitwise or)	Binary OR Operator copies a bit if it exists in either operand.	(A | B) will give 61 which is 0011 1101
 * ^ (bitwise XOR)	Binary XOR Operator copies the bit if it is set in one operand but not both.	(A ^ B) will give 49 which is 0011 0001
 * ~ (bitwise compliment)	Binary Ones Complement Operator is unary and has the effect of 'flipping' bits.	(~A ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.
 * << (left shiftRight)	Binary Left Shift Operator. The left operands value is moved left by the number of bits specified by the right operand.	A << 2 will give 240 which is 1111 0000
 * >> (right shiftRight)	Binary Right Shift Operator. The left operands value is moved right by the number of bits specified by the right operand.	A >> 2 will give 15 which is 1111
 * >>> (zero fill right shiftRight)	Shift right zero fill operator. The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.	A >>>2 will give 15 which is 0000 1111
 *
 *
 * @author Michael Liu
 */
public class BitsOperatorsTest
{
  public static void main(String[] args)
  {

  }

  @Test
  public void testByte2Binary()
  {
    byte b1 = (byte)2;
    String s1 = String.format("%8s", Integer.toBinaryString(b1)).replace(' ', '0');
    assertEquals("00000010", s1);

    byte b2 = (byte)129; //aka -127
    System.out.println(b2); //-127
    System.out.println((int)b2); //-127
    String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
    assertEquals("10000001", s2);

    int i1 = -127;
    System.out.println(Integer.toBinaryString(i1));
    System.out.println(Integer.toBinaryString(127));
    System.out.println(Integer.toBinaryString(-1));
    System.out.println(Integer.toBinaryString(0));
    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

    // Byte -1:
    //1111_1111
    //byte -127
    //1000_0001
    // Byte.Min -128
    //1000_0000

    //byte 1
    // 0000_0001
    //byte.Max 127
    // 0111_1111

    // int -1
    //1111_1111_1111_1111_1111_1111_1111_1111
    // int -127
    //1111_1111_1111_1111_1111_1111_1000_0001
    //int Integer.MIN_VaLUe
    //10000000000000000000000000000000

  }

  @Test
  public void testBitWise1()
  {
    // X >> 1 = X/2;
    assertEquals(4 , 8 >> 1);
    assertEquals(3 , 6 >> 1);
    assertEquals(9 , 18 >> 1);

    // X << 1 = 2X
    assertEquals(4 , 2 << 1);
    assertEquals(6 , 3 << 1);

  }



  @Test
  public void testXOR()
  {
    //if perform XOR twice, will result some value
    byte toBeEncrypted = 0b0010_0110;
    byte salt = 0b0100_1011;

    byte encryptedVal = (byte)(toBeEncrypted ^ salt );


    //swap value without temp
    int a = 1; //aka 0000 0001
    int b = 5; //aka 0000 0101

    a = a ^ b; // a = salt c
    System.out.println("salt : : = " + a);
    b = a ^ b;
    a = a ^ b;
    assertEquals(5, a);
    assertEquals(1, b);

    //2.swap values
    a = a + b; //6
    b = a - b; //1
    a = a - b; //5
    assertEquals(1, a);
    assertEquals(5, b);

  }
  @Test
  public void testBitWise3()
  {
    byte aByte = 0b101; //aka 5
    byte bByte = 0b110; //aka 6

    assertEquals(1, aByte >> 2);
    assertEquals(0, aByte >> 3);
    assertEquals(0, aByte >> 4);

    assertEquals(10 ,  aByte << 1);
    assertEquals(2 ,  (aByte >>> 1));

    //XOR
    assertEquals(3, aByte ^ bByte); //0b011


    System.out.println(0b11111101);
    System.out.println(0b0011);

    //16 + 15*15(150+75),,,/,
    int i = 0xFF;
    System.out.println(i);


    Byte b = (byte)-129;
    System.out.println(b); //value = 207
  }


  @Test
  public void testOverflow()
  {
    byte aByte = (byte)128;
    assertEquals(-128, aByte);
    byte bByte = (byte)-130;
    assertEquals(126, bByte);
  }


  @Test
  public void testTwoComplement()
  {

    //complement operator
    //    assertEquals(-3 ,  ~ aByte); //0b1111 010 -> //0b011
    assertEquals(-3, ~ 3 + 1);


    //    0   0   0   0   0   0   0   0 | 8 bit long
    //    128 64  32  16  8   4   2   1 | Value Represented
    //    0   0   0   1   0   1   0   0 | Number chosen is 20

    byte aByte = 0b10100; //aka 20

    System.out.println(Integer.toBinaryString(-20 & 0xFF)); //byte 11101100
    System.out.println(Integer.toBinaryString(20 & 0xFF));  //byte 00010100

    // compliment + 1 = negative val
    System.out.println(Integer.toBinaryString(~20 & 0xFF + 1));  //byte 00010100
    assertEquals(-20, ~20 + 1);

    assertEquals(-20, 0b11111111111111111111111111101100 );

  }

  @Test
  public void binaryToByteTest()
  {
    String s = "11111111";
    int val = Integer.parseInt(s, 2);
    System.out.println(val);

    System.out.println(Integer.parseInt("-11111111",2));

    byte aByte = (byte)val;
    System.out.println(aByte);

    System.out.println(Byte.MAX_VALUE);
    System.out.println(Byte.MIN_VALUE);

    System.out.println(Integer.toBinaryString(Byte.MIN_VALUE));
  }
}
