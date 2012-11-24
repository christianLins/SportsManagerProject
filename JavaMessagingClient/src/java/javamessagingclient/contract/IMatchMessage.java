/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import javamessagingclient.stubs.IClubTeamDto;
import javamessagingclient.stubs.ICompetitionDto;
import java.util.Date;
import javamessagingclient.stubs.*;

/**

 @author Thomas
 */
public interface IMatchMessage
{
    IMemberDto getMember();
    
     IClubTeamDto getClubTeam();

     ICompetitionDto getCompetition();
}
