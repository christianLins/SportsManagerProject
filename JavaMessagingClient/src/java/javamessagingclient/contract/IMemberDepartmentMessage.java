/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient.contract;

import javamessagingclient.stubs.IDepartmentDto;
import javamessagingclient.stubs.IMemberDto;

/**

 @author Thomas
 */
public interface IMemberDepartmentMessage
{
    IMemberDto getMember();
    
    IDepartmentDto getDepartment();
}
