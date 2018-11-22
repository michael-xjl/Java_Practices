
package gof.creational.stepBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EMailTest
{

  private EMail eMailUnderTest;

  @Before
  public void setUp()
  {
    eMailUnderTest = null /* TODO: construct the instance */;
  }

  @Test
  public void testToString()
  {
    // Setup
    final String expectedResult = "result";

    // Run the test
    final String result = eMailUnderTest.toString();

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  public void testBuilder()
  {
    // Setup
    final EMail.IFrom expectedResult = null;

    // Run the test
    final EMail.IFrom result = EMail.builder();

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
