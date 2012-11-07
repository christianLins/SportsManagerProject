/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.ClubTeam;
import dto.contract.IClubTeam;
import dto.mapper.contract.*;

/**

 @author Thomas
 */
public class ClubTeamMapper
        implements IMapper<IClubTeam>
{
    private static ClubTeamMapper controller;

    ClubTeamMapper()
    {
    }

    public static IMapper<IClubTeam> getInstance()
    {
        if (controller == null)
        {
            controller = new ClubTeamMapper();
        }

        return controller;
    }

    public domain.contract.IClubTeam getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IClubTeam a : DomainFacade.getAll(domain.contract.IClubTeam.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IClubTeam getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IClubTeam a : DomainFacade.getAll(domain.contract.IClubTeam.class))
        {
            if (a.getId() == id)
            {
                return ClubTeam.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IClubTeam> getAll()
    {
        List<IClubTeam> result = new LinkedList<>();

        for (domain.contract.IClubTeam a : DomainFacade.getAll(domain.contract.IClubTeam.class))
        {
            result.add(ClubTeam.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IClubTeam value)
    {
        try
        {
            domain.classes.ClubTeam clubTeam = createDomain(value);

            return DomainFacade.set(clubTeam);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(ClubTeamMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IClubTeam value)
    {
        try
        {
            domain.classes.ClubTeam clubTeam = createDomain(value);

            DomainFacade.delete(clubTeam);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(ClubTeamMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.ClubTeam createDomain(IClubTeam value)
            throws IdNotFoundException
    {
        domain.classes.ClubTeam clubTeam = new domain.classes.ClubTeam(value.getId());
        List<domain.contract.IDepartment> departmentList = new LinkedList<>();
        List<domain.contract.IPlayer> teamhasPlayerList = new LinkedList<>();
        List<domain.contract.ITrainer> trainerList = new LinkedList<>();

        for (int d : value.getDepartmentList())
        {
            departmentList.add(new DepartmentMapper().getDomainById(d));
        }

        for (int d : value.getPlayerList())
        {
            teamhasPlayerList.add(new PlayerMapper().getDomainById(d));
        }

        for (int d : value.getTrainerList())
        {
            trainerList.add(new TrainerMapper().getDomainById(d));
        }

        clubTeam.setDepartmentList(departmentList);
        clubTeam.setPlayerList(teamhasPlayerList);
        clubTeam.setTrainerList(trainerList);

        return clubTeam;
    }
}
