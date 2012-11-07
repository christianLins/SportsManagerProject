package domain;

/**
 @author Markus Mohanty <markus.mo at gmx.net>
 */
public class CouldNotSaveException
        extends Exception
{
    public CouldNotSaveException(Exception ex)
    {
        super(ex.getMessage());
    }

    public CouldNotSaveException(String message)
    {
        super(message);
    }
}
