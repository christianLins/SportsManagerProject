package contract.domain;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class CouldNotFetchException extends Exception
{

    public CouldNotFetchException()
    {
        super();
    }

    public CouldNotFetchException(String message)
    {
        super(message);
    }
    
}
