/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import contract.dto.IPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionSubscriberManager implements MessageListener
{
    
    /*TODO auf fat client portieren
     * kein manager
     * eventuell factory für topics
     * host angabe
     * db entry anpassen - use case ??? vorhanden, erstellen
     * 
     */
    
    private static NewCompetitionSubscriberManager INSTANCE;
    
    private Map<String,ClientCompetitionMessageListener> registeredPlayer = new HashMap<>();
    private Map<String,TopicConnection> connections = new HashMap<>();
    private String topicName;
    private String connFactory = "jms/CompetitionsConnFactory";
    private Topic topic;
    private TopicConnectionFactory factory;
    
    private NewCompetitionSubscriberManager() {
        init();
    }
    
    public static NewCompetitionSubscriberManager getInstance() {
        if(INSTANCE == null) INSTANCE = new NewCompetitionSubscriberManager();
        return INSTANCE;
    }
    
    public synchronized void subscribe(ClientCompetitionMessageListener listener) {
        try
        {
            doSubscribe(listener);
            registeredPlayer.put(listener.getClientID(), listener);
        }
        catch (JMSException ex)
        {
            Logger.getLogger(NewCompetitionSubscriberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void unsubscribe(ClientCompetitionMessageListener listener) {
        try
        {
            doUnsubscribe(listener);
            registeredPlayer.remove(listener.getClientID());
        }
        catch (JMSException ex)
        {
            Logger.getLogger(NewCompetitionSubscriberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void init() {
        try
        {
            InitialContext ctx = new InitialContext();
            
            topic = (Topic) ctx.lookup(topicName);
            
            factory = (TopicConnectionFactory) ctx.lookup(connFactory);
        }
        catch (NamingException ex)
        {
            Logger.getLogger(NewCompetitionSubscriberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doSubscribe(ClientCompetitionMessageListener subscriber) throws JMSException
    {
        String clientID = subscriber.getClientID();
        
        // init connection and set id of client for durable subsribe mode
        TopicConnection createTopicConnection = factory.createTopicConnection();
        connections.put(clientID,createTopicConnection);
        
        createTopicConnection.setClientID(clientID);
            
        TopicSession topicSession = createTopicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(topic, clientID);

        topicSubscriber.setMessageListener(subscriber);

        createTopicConnection.start();
    }

    private void doUnsubscribe(ClientCompetitionMessageListener listener) throws JMSException
    {
        TopicConnection conn = connections.get(listener.getClientID());
        conn.close();
    }

    @Override
    public void onMessage(Message message)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
    
}
