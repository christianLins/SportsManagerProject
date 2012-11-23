/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.jms.MessageListener;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface ClientCompetitionMessageListener extends MessageListener
{
    String getClientID();
    
    
}
