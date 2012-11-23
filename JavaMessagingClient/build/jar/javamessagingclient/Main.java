/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 @author Thomas
 */
public class Main
        implements MessageListener, ExceptionListener
{
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
        topicConn.setClientID("name");
        // create a topic session
        TopicSession topicSession = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        // create a topic subscriber
        TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(topic, "name");

        // set an asynchronous message listener
        Main asyncSubscriber = new Main();
        topicSubscriber.setMessageListener(asyncSubscriber);

        // set an asynchronous exception listener on the connection
        topicConn.setExceptionListener(asyncSubscriber);

        // start the connection
        topicConn.start();

        // wait for messages
        System.out.println("waiting for messages");
        for (int i = 0; i < 10; i++)
        {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println();

        // close the topic connection
        topicConn.close();
    }

    /**
     This method is called asynchronously by JMS when a message arrives
     at the topic. Client applications must not throw any exceptions in
     the onMessage method.

     @param message A JMS message.
     */
    @Override
    public void onMessage(Message message)
    {
        TextMessage msg = (TextMessage) message;
        try
        {
            System.out.println("received: " + msg.getText());
        }
        catch (JMSException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     This method is called asynchronously by JMS when some error occurs.
     When using an asynchronous message listener it is recommended to use
     an exception listener also since JMS have no way to report errors
     otherwise.

     @param exception A JMS exception.
     */
    @Override
    public void onException(JMSException exception)
    {
        System.err.println("something bad happended: " + exception);
    }
}
