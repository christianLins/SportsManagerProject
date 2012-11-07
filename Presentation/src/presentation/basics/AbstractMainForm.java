package presentation.basics;

/**
 *
 * @author Lucia
 */
public class AbstractMainForm extends AbstractForm {

    public AbstractMainForm() {
        this(null);
    }

    public AbstractMainForm(AbstractForm parent) {
        super(parent);
        //initControls(891, 612);
    }

    public AbstractMainForm(AbstractForm parent, int x, int y) {
        super(parent);
        //initControls(x, y);
    }

    private void initControls(int x, int y) {
       // setSize(x, y);
    }
}
