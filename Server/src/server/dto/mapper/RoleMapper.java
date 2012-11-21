/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.NotFoundException;
import contract.dto.IRole;
import contract.dto.ITrainer;
import contract.dto.IPlayer;
import contract.dto.IDepartmentHead;
import java.util.*;

/**

 @author Thomas
 */
public class RoleMapper
        implements IMapper<IRole>
{
    private static RoleMapper controller;

    RoleMapper()
    {
    }

    public static IMapper<IRole> getInstance()
    {
        if (controller == null)
        {
            controller = new RoleMapper();
        }

        return controller;
    }

    @Override
    public IRole getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            IRole r = PlayerMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        try
        {
            IRole r = TrainerMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        try
        {
            IRole r = DepartmentHeadMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IRole> getAll()
            throws NotFoundException
    {
        try
        {
            List<IRole> roles = new LinkedList<>();

            roles.addAll(TrainerMapper.getInstance().getAll());
            roles.addAll(PlayerMapper.getInstance().getAll());
            roles.addAll(DepartmentHeadMapper.getInstance().getAll());

            return roles;
        }
        catch (NotFoundException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IRole value)
    {
        if (value instanceof ITrainer)
        {
            return TrainerMapper.getInstance().set((ITrainer) value);
        }
        else if (value instanceof IPlayer)
        {
            return PlayerMapper.getInstance().set((IPlayer) value);
        }
        else if (value instanceof IDepartmentHead)
        {
            return DepartmentHeadMapper.getInstance().set((IDepartmentHead) value);
        }

        return 0;
    }

    @Override
    public void delete(IRole value)
    {
        if (value instanceof ITrainer)
        {
            TrainerMapper.getInstance().delete((ITrainer) value);
        }
        else if (value instanceof IPlayer)
        {
            PlayerMapper.getInstance().delete((IPlayer) value);
        }
        else if (value instanceof IDepartmentHead)
        {
            DepartmentHeadMapper.getInstance().delete((IDepartmentHead) value);
        }
    }

    @Override
    public IRole getNew()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
