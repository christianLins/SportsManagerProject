/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.io.Serializable;
import sportsclubmanager.dto.classes.Member;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface MemberService extends Serializable
{
    public Member getMember(); // add paraemeters
    public boolean createNewMember();
    public boolean changeMember();
    
    
}
