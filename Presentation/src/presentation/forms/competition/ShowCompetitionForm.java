/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.competition;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;



/**
 *
 * @author Lucia
 */
public class ShowCompetitionForm extends AbstractMainForm{
    
        // Variables declaration - do not modify
    private JComboBox comboCompetition;
    private JLabel lblCompetition;
    private JLabel lblYourMembers;
    public JPanel paneShowInfo;
    private JScrollPane scrollCompetition;
    private JScrollPane scrollMembers;
    private JTable tableCompetition;
    private JTable tableOurMembers;
    // End of variables declaration
    
    
     /**
     * Creates new form ShowCompetitionForm
     */    
    public ShowCompetitionForm(AbstractForm form) {
        super(form);
        initComponents();
    }
    
    private void initComponents() {

        paneShowInfo = new JPanel();
        comboCompetition = new JComboBox();
        lblCompetition = new JLabel();
        scrollCompetition = new JScrollPane();
        tableCompetition = new JTable();
        lblYourMembers = new JLabel();
        scrollMembers = new JScrollPane();
        tableOurMembers = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(848, 549));
        setPreferredSize(new java.awt.Dimension(848, 549));

        comboCompetition.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCompetition.setText("Competition");

        tableCompetition.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Team", "Match", "Result"
            }
        ));
        scrollCompetition.setViewportView(tableCompetition);

        lblYourMembers.setText("Announced members from your department");

        tableOurMembers.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "First Name", "Last Name"
            }
        ));
        scrollMembers.setViewportView(tableOurMembers);

        GroupLayout paneShowInfoLayout = new GroupLayout(paneShowInfo);
        paneShowInfo.setLayout(paneShowInfoLayout);
        paneShowInfoLayout.setHorizontalGroup(
            paneShowInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneShowInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneShowInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCompetition, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(paneShowInfoLayout.createSequentialGroup()
                        .addGroup(paneShowInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(scrollMembers, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneShowInfoLayout.createSequentialGroup()
                                .addComponent(lblCompetition)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCompetition, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblYourMembers))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneShowInfoLayout.setVerticalGroup(
            paneShowInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneShowInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneShowInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCompetition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompetition))
                .addGap(18, 18, 18)
                .addComponent(scrollCompetition, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblYourMembers)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMembers, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(paneShowInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(paneShowInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>
    
}
