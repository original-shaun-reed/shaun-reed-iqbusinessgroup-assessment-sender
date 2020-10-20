package iqbusiness.test;

import shaun.reed.iqbusiness.assessment.main.Client;
import org.junit.Ignore;
import org.junit.Test;


@Ignore
public class  ClientTest {

  @Test
  public void testConnectionOnClose() throws Exception {
    Client client = new Client();
    client.onInit();
  }
}
