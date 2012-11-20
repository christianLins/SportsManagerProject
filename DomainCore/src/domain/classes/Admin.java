package domain.classes;

import domain.contract.IAdmin;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Administrator")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class Admin extends Role implements IAdmin, Serializable {
    private static final long serialVersionUID = 1L;

    public Admin()
    {
    }

    public Admin(Integer id)
    {
        super(id);
    }
}
