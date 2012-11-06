/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.io.Serializable;
import java.util.Date;
import sportsclubmanager.domain.contract.IMember;
import sportsclubmanager.dto.classes.Member;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface MemberService extends Serializable
{
    public IMember getMember(Integer id); // add paraemeters
    public boolean createNewMember(IMember member);
    public boolean changeMember(IMember changedMember);
    
    
}
