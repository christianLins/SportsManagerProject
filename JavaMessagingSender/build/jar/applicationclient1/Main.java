/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import java.io.*;
import javax.jms.*;
import javax.naming.*;

/**

 @author Thomas
 */
public class Main
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
            throws Exception
    {
        // get the initial context
        InitialContext ctx = new InitialContext();

        // lookup the topic object
        Topic topic = (Topic) ctx.lookup("topic/topic0");

        // lookup the topic connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
                lookup("topic/connectionFactory");

        // create a topic connection
        TopicConnection topicConn = connFactory.createTopicConnection();

        // create a topic session
        TopicSession topicSession = topicConn.createTopicSession(false,
                                                                 Session.CLIENT_ACKNOWLEDGE);

        // create a topic publisher
        TopicPublisher topicPublisher = topicSession.createPublisher(topic);
        topicPublisher.setDeliveryMode(DeliveryMode.PERSISTENT);

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        System.out.println("Enter a new message to pubish");
        String command = reader.readLine();

        while (!command.equals("exit"))
        {
            // create the "Hello World" message
            TextMessage message = topicSession.createTextMessage();
            message.setText(command);

            // publish the messages
            topicPublisher.publish(message);

            // print what we did
            System.out.println("published: " + message.getText());

            System.out.println("Enter a new message to pubish");
            command = reader.readLine();
        }
        // close the topic connection
        topicConn.close();
    }
}
