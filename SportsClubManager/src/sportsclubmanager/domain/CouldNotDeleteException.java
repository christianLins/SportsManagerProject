package sportsclubmanager.domain;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class CouldNotDeleteException extends Exception 
{
    public CouldNotDeleteException(Exception ex)
    {
        super(ex.getMessage());
    }
    
    public CouldNotDeleteException(String message)
    {
        super(message);
    }
}
