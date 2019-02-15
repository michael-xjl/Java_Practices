package gc.memoryleak;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author Michael Liu
 */
public class UnclosedStreams
{
  @Test(expected = OutOfMemoryError.class)
  public void givenURL_whenUnclosedStream_thenOutOfMemory()
      throws IOException, URISyntaxException
  {
    String str = "";
    URLConnection conn
        = new URL("http://norvig.com/big.txt").openConnection();
    BufferedReader br = new BufferedReader(
        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

    while (br.readLine() != null) {
      str += br.readLine();
    }

    //
  }
}
