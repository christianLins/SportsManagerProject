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
import dto.contract.ITypeOfSport;
import dto.mapper.contract.*;

/**

 @author Thomas
 */
public class ClubTeamMapper
        implements IClubTeamMapper
{
    private static ClubTeamMapper controller;

    ClubTeamMapper()
    {
    }

    public static IClubTeamMapper getInstance()
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
        try
        {
            domain.contract.IClubTeam a = DomainFacade.getInstance().getByID(domain.contract.IClubTeam.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IClubTeam getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IClubTeam a = DomainFacade.getInstance().getByID(domain.contract.IClubTeam.class, id);
            return ClubTeam.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IClubTeam> getAll()
            throws NotFoundException
    {
        try
        {
            List<IClubTeam> result = new LinkedList<>();

            for (domain.contract.IClubTeam a : DomainFacade.getInstance().getAll(domain.contract.IClubTeam.class))
            {
                result.add(ClubTeam.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IClubTeam value)
    {
        try
        {
            domain.classes.ClubTeam clubTeam = createDomain(value);

            return DomainFacade.getInstance().set(clubTeam);
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

            DomainFacade.getInstance().delete(clubTeam);
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

    @Override
    public IClubTeam getNew()
    {
        return new ClubTeam();
    }
    
    public List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport) throws ClubTeamNotFoundException{
        try {
            List<IClubTeam> ret  = new LinkedList<>();
            List<domain.classes.ClubTeam> clubTeams = DomainFacade.getInstance().getClubTeamsByTypeOfSport(DomainFacade.getInstance().getByID(domain.contract.ITypeOfSport.class, sport.getId()));
            for(domain.classes.ClubTeam c : clubTeams){
                ret.add(ClubTeam.copy(c));
            }
            return ret;
            
        } catch (CouldNotFetchException e) {
            throw new ClubTeamNotFoundException(e.getMessage());
        }
        
    }
}
