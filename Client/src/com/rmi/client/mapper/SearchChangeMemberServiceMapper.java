/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.mapper;

import contract.rmi.services.ISearchChangeMemberRmiService;
import contract.useCaseController.ISearchChangeMember;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class SearchChangeMemberServiceMapper implements RmiServiceToServiceMapper<ISearchChangeMemberRmiService, ISearchChangeMember>
{

    @Override
    public ISearchChangeMember getService(ISearchChangeMemberRmiService rmiService)
    {
        SearchChangeMember n = new SearchChangeMember();
        n.setService(rmiService);
        return n;  
    }
    
}
