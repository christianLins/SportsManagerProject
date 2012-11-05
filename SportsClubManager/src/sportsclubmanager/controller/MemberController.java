/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import sportsclubmanager.dto.classes.*;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class MemberController implements MemberService
{
    
    public static MemberController getInstance() {
        // implement as singleton
        return null;
    }

    @Override
    public Member getMember()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean createNewMember()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean changeMember()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
