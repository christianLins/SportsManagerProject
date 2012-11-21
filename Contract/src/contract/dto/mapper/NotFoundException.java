package contract.dto.mapper;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class NotFoundException extends Exception {

    public NotFoundException()
    {
        super();
    }
    
    public NotFoundException(Exception ex){
        super(ex);
    }
    

}
