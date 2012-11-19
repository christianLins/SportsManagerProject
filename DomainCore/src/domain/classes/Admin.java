package domain.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Admin")
public class Admin extends Role
implements Serializable {
    private static final long serialVersionUID = 1L;

}
