/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.presentation.forms.competition;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import sportsclubmanager.presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class ChangeCompetitionTeam extends AbstractMainForm{
    
    // Variables declaration - do not modify
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnSave;
    private JComboBox comboCompetition;
    private JComboBox comboTeam;
    private JLabel jLabel1;
    private JLabel lblCompetitionSel;
    private JLabel lblMembers;
    private JLabel lblSelTeam;
    private JList listCompTeam;
    private JList listTeam;
    public JPanel panelChangeTeam;
    private JScrollPane scrollCompTeam;
    private JScrollPane scrollTeam;
    // End of variables declaration
    
    public ChangeCompetitionTeam(AbstractMainForm form){
        super(form);
        initComponents();
    }
    
    private void initComponents() {

        panelChangeTeam = new JPanel();
        lblCompetitionSel = new JLabel();
        comboCompetition = new JComboBox();
        lblSelTeam = new JLabel();
        comboTeam = new JComboBox();
        scrollTeam = new JScrollPane();
        listTeam = new JList();
        lblMembers = new JLabel();
        btnAdd = new JButton();
        scrollCompTeam = new JScrollPane();
        listCompTeam = new JList();
        jLabel1 = new JLabel();
        btnRemove = new JButton();
        btnSave = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(845, 549));
        setPreferredSize(new java.awt.Dimension(845, 549));

        lblCompetitionSel.setText("Competition");

        comboCompetition.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSelTeam.setText("Team");

        comboTeam.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listTeam.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollTeam.setViewportView(listTeam);

        lblMembers.setText("Team Members");

        btnAdd.setText("Add >");

        listCompTeam.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollCompTeam.setViewportView(listCompTeam);

        jLabel1.setText("Current Competition Team");

        btnRemove.setText("< Remove");

        btnSave.setText("Save Team");

        GroupLayout panelAddToTeamLayout = new GroupLayout(panelChangeTeam);
        panelChangeTeam.setLayout(panelAddToTeamLayout);
        panelAddToTeamLayout.setHorizontalGroup(
            panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAddToTeamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddToTeamLayout.createSequentialGroup()
                        .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompetitionSel)
                            .addComponent(lblSelTeam))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCompetition, 0, 200, Short.MAX_VALUE)
                            .addComponent(comboTeam, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave)
                        .addGroup(panelAddToTeamLayout.createSequentialGroup()
                            .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblMembers)
                                .addGroup(panelAddToTeamLayout.createSequentialGroup()
                                    .addComponent(scrollTeam, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(scrollCompTeam, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(362, Short.MAX_VALUE))
        );
        panelAddToTeamLayout.setVerticalGroup(
            panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAddToTeamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompetitionSel)
                    .addComponent(comboCompetition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelTeam))
                .addGap(27, 27, 27)
                .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelAddToTeamLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollCompTeam))
                    .addGroup(panelAddToTeamLayout.createSequentialGroup()
                        .addComponent(lblMembers)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddToTeamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddToTeamLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btnAdd)
                                .addGap(27, 27, 27)
                                .addComponent(btnRemove))
                            .addComponent(scrollTeam, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelChangeTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelChangeTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
