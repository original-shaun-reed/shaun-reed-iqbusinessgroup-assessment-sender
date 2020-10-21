package shaun.reed.iqbusiness.assessment.main;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

  private final static String QUEUE_NAME = "sreed-iq-queue";

  public Connection connection(ConnectionFactory connectionFactory)  throws Exception {
    return connectionFactory.newConnection();
  }

  public Channel createChannel(Connection connection)  throws Exception {
    return connection.createChannel();
  }

  public void checkIfAppShouldExit(String name, Connection connection) throws Exception {
    if (!name.isEmpty()) {
      if("q".equalsIgnoreCase(name) || "'q'".equalsIgnoreCase(name) || name.contains("q")) {
        connection.close();

        System.out.println("Exiting application . . .");
        System.exit(0);
      }
    }
  }

  public void onInit() throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = connection(factory);
    Channel channel = createChannel(connection);
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);

    System.out.println("-> Ready to send messages");
    System.out.println("-> To exit this application press enter 'q' then press the [ENTER] key on your keyboard");
    System.out.println("---------------------------------------------------------------------------------------");

    Scanner inputScanner = new Scanner(System.in);

    System.out.println("Enter your name: ");
    String name = inputScanner.nextLine();

    while(true) {
      checkIfAppShouldExit(name, connection);

      if (!name.isEmpty()) {
        String message = "Hello my name is, " + name;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("-> Sent message: '" + message + "' to the receiver.");


        System.out.println("Enter your name: ");
        name = inputScanner.nextLine();
      } else {
        System.out.println("Invalid input given. Input given is empty");
        System.exit(0);
      }
    }
  }

  public static void main(String[] argv) throws Exception  {
    Client client = new Client();
    client.onInit();
  }
}
