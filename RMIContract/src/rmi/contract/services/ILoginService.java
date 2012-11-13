/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import dto.contract.IMember;
import dto.contract.IUserData;
import java.rmi.Remote;

/**
 *
 * @author Lucia
 */
public interface ILoginService extends Remote {
    IMember  getMemberByUserData(IUserData userData);
}
