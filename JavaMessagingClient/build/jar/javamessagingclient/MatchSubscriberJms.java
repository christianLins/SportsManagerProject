/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import javamessagingclient.stubs.IMemberDto;
import java.util.logging.*;
import javax.jms.*;
import javax.naming.*;

/**
 @author Thomas
 */
public class MatchSubscriberJms
{
    IMemberDto member;

    public MatchSubscriberJms(IMemberDto member)
    {
        this.member = member;
    }

    public IMemberDto getMember()
    {
        return member;
    }

    public void setMember(IMemberDto member)
    {
        this.member = member;
    }

    public void read(MessageListener messageListener, ExceptionListener exceptionListener)
    {
        try
        {
            // get the initial context
            InitialContext ctx = new InitialContext();

            // lookup the topic object
            Topic topic = (Topic) ctx.lookup("topic/memberAddedToClubTeamTopic");

            // lookup the topic connection factory
            TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("topic/memberAddedToClubTeamFactory");

            // create a topic connection
            TopicConnection topicConn = connFactory.createTopicConnection();
            topicConn.setClientID(member.getUsername());
            // create a topic session
            TopicSession topicSession = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // create a topic subscriber
            TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(topic, member.getUsername());

            // set an asynchronous message listener
            topicSubscriber.setMessageListener(messageListener);

            // set an asynchronous exception listener on the connection
            topicConn.setExceptionListener(exceptionListener);

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
        catch (InterruptedException ex)
        {
            Logger.getLogger(MatchSubscriberJms.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (JMSException ex)
        {
            Logger.getLogger(MatchSubscriberJms.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NamingException ex)
        {
            Logger.getLogger(MatchSubscriberJms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
