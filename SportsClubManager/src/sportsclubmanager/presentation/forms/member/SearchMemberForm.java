package sportsclubmanager.presentation.forms.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import sportsclubmanager.presentation.basics.AbstractForm;
import sportsclubmanager.presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class SearchMemberForm extends AbstractForm {

    // Variables declaration - do not modify
    public JPanel panel;
    private JScrollPane jScrollPane1;
    private JTextField txtfieldSearchMemb;
    private JButton btnSearch;
    private JTable tabMember;

    // End of variables declaration
    public SearchMemberForm(AbstractMainForm form) {
        super(form);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panel = new javax.swing.JPanel();
        txtfieldSearchMemb = new JTextField();
        btnSearch = new JButton("Search");
        jScrollPane1 = new JScrollPane();

        tabMember = new JTable();
        tabMember.setAutoCreateRowSorter(true);
        tabMember.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "MembershipNr", "First Name", "Last Name", "Sport", "Birth Date", "Gender"
                }));
        tabMember.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent evt) {
                if (evt.isMetaDown()) {
                    int row = tabMember.getSelectedRow();
                    
                    JPopupMenu pop = new JPopupMenu();
                    JMenuItem edit = new JMenuItem("Edit member Data");
                    edit.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            NewMemberForm changeMember = new NewMemberForm(null);
                             //MemberID id = tabMember.getModel().getValueAt(row, 1);
                            //Member member = getMember(id);
                            //changeMember.setMemberData(Member member);
                            //form.displayAddMember(member);
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    });
                    
                    pop.add(edit);
                    pop.show(evt.getComponent(), evt.getX(), evt.getY());                   
                   
                }
            }
            
        });

        jScrollPane1.setViewportView(tabMember);

        javax.swing.GroupLayout paneSearchLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(paneSearchLayout);
        paneSearchLayout.setHorizontalGroup(
                paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addComponent(txtfieldSearchMemb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        paneSearchLayout.setVerticalGroup(
                paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtfieldSearchMemb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearch))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>
}
