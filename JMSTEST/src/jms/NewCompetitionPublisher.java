/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import contract.dto.ICompetition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * jms topic publixher
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionPublisher implements Runnable
{
    private String connFactory = "jms/CompetitionsConnFactory";
    private TopicSession session;
    private String topicName = "jms/Competitions";
    private TopicPublisher topicPublisher;
    
    public NewCompetitionPublisher() {        
    }
    
    public NewCompetitionPublisher(String connFactory, String topic) {
        this.connFactory = connFactory;
        this.topicName = topic;
    }

    @Override
    public void run()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void init() {
            try
        {
            // Get the JNDI Initial Context to do JNDI lookups
             InitialContext ctx = new InitialContext();
             // Get the ConnectionFactory by JNDI name
             TopicConnectionFactory cf = (TopicConnectionFactory)ctx.lookup(connFactory);
             // get the Destination used to send the message by JNDI name
             Topic topic = (Topic)ctx.lookup(topicName);
             // Create a connection
             TopicConnection con = cf.createTopicConnection();
             // create a JMS session
             session = con.createTopicSession(false, Session.CLIENT_ACKNOWLEDGE);
             // Create a MessageProducer and some Message with the session
            
             // create a topic publisher
             topicPublisher = session.createPublisher(topic);
             topicPublisher.setDeliveryMode(DeliveryMode.PERSISTENT);

            
             System.out.println("jms connection intialized");
        }
        catch (NamingException ex)
        {
            Logger.getLogger(NewCompetitionPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (JMSException ex)
        {
            Logger.getLogger(NewCompetitionPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean publishCompetition(ICompetition competition)
    {
        if (competition == null) return false;
        try
        {
            System.out.println("Enter a new Message:");

            // set message
            TextMessage message = session.createTextMessage();
            message.setText(competition.getId().toString());

            // publish the messages
            topicPublisher.publish(message);

            // print what we did
            System.out.println("published new competition with id " + message.getText());
            return true;
        }
        catch (JMSException ex)
        {
            Logger.getLogger(NewCompetitionPublisher.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
}
