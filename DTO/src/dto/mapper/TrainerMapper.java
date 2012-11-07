/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Trainer;
import dto.contract.ITrainer;
import dto.mapper.contract.*;

/**

 @author Thomas
 */
 public class TrainerMapper
        implements IMapper<ITrainer>
{
    private static TrainerMapper controller;

     TrainerMapper()
    {
    }

    public static IMapper<ITrainer> getInstance()
    {
        if (controller == null)
        {
            controller = new TrainerMapper();
        }

        return controller;
    }

    public domain.contract.ITrainer getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.ITrainer a : DomainFacade.getAll(domain.contract.ITrainer.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public ITrainer getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.ITrainer a : DomainFacade.getAll(domain.contract.ITrainer.class))
        {
            if (a.getId() == id)
            {
                return Trainer.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ITrainer> getAll()
    {
        List<ITrainer> result = new LinkedList<>();

        for (domain.contract.ITrainer a : DomainFacade.getAll(domain.contract.ITrainer.class))
        {
            result.add(Trainer.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(ITrainer value)
    {
        Integer returnv = 0;
        try
        {
            domain.classes.Trainer trainer = new domain.classes.Trainer(value.getId());

            List<domain.contract.IClubTeam> clubTeamList = new LinkedList<>();
            for (int i : value.getClubTeamList())
            {
                clubTeamList.add(new ClubTeamMapper().getDomainById(i));
            }
            trainer.setClubTeamList(clubTeamList);

            returnv = DomainFacade.set(trainer);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return returnv;
        }
    }

    @Override
    public void delete(ITrainer value)
    {
        try
        {
            domain.classes.Trainer typeofsport = createDomain(value);

            DomainFacade.delete(typeofsport);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Trainer createDomain(ITrainer value)
            throws IdNotFoundException
    {
        domain.classes.Trainer trainer = new domain.classes.Trainer(value.getId());

        List<Integer> clubTeams = value.getClubTeamList();
        List<Integer> permisssions = value.getPermisssionList();

        LinkedList<domain.contract.IClubTeam> teams = new LinkedList<>();
        for (int id : clubTeams)
        {
            teams.add(new ClubTeamMapper().getDomainById(id));
        }
        trainer.setClubTeamList(teams);

        LinkedList<domain.contract.IPermission> p = new LinkedList<>();

        for (int id : permisssions)
        {
            p.add(new PermissionMapper().getDomainById(id));
        }
        trainer.setPermisssionList(p);

        return trainer;
    }
}