package presentation.forms.competition;

import com.ServiceClient;
import com.ServiceNotAvailableException;
import contract.dto.*;
import contract.useCaseController.IShowCompetition;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import presentation.basics.*;

/**
 *
 * @author Lucia
 */
public class ShowCompetitionForm extends AbstractMainForm {

    ServiceClient client;
    IShowCompetition controller;
    ICompetitionDto competition;
    List<IClubTeamDto> clubTeams;
    List<IMatchDto> compMatches;
    IClubTeamDto cTeam;
    IMemberDto user;

    /**
     * Creates new form ShowMatchInfo
     */
    public ShowCompetitionForm(AbstractForm form, ServiceClient client, IMemberDto user) throws ServiceNotAvailableException {
        super(form);
        this.client = client;
        this.user = user;
        controller = this.client.getShowCompetitionService();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneShowCompetition = new javax.swing.JPanel();
        comboCompetition = new javax.swing.JComboBox();
        lblCompetition = new javax.swing.JLabel();
        scrollCompetition = new javax.swing.JScrollPane();
        tableCompetition = new javax.swing.JTable();
        lblYourMembers = new javax.swing.JLabel();
        scrollMembers = new javax.swing.JScrollPane();
        tableOurMembers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(848, 549));

        comboCompetition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCompetitionActionPerformed(evt);
            }
        });

        lblCompetition.setText("Competition");

        tableCompetition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Team A", "Team B", "Result"
            }
        ));
        tableCompetition.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                tableCompetitionValueChanged(e);
            }
        });
        scrollCompetition.setViewportView(tableCompetition);
        tableCompetition.getColumnModel().getColumn(0).setHeaderValue("Team A");
        tableCompetition.getColumnModel().getColumn(1).setHeaderValue("Team B");
        tableCompetition.getColumnModel().getColumn(2).setHeaderValue("Result");

        lblYourMembers.setText("Announced members from your department");

        tableOurMembers.setModel(new javax.swing.table.DefaultTableModel(
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

        javax.swing.GroupLayout paneShowCompetitionLayout = new javax.swing.GroupLayout(paneShowCompetition);
        paneShowCompetition.setLayout(paneShowCompetitionLayout);
        paneShowCompetitionLayout.setHorizontalGroup(
            paneShowCompetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneShowCompetitionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneShowCompetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCompetition, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(paneShowCompetitionLayout.createSequentialGroup()
                        .addGroup(paneShowCompetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneShowCompetitionLayout.createSequentialGroup()
                                .addComponent(lblCompetition)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCompetition, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblYourMembers))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneShowCompetitionLayout.setVerticalGroup(
            paneShowCompetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneShowCompetitionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneShowCompetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCompetition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompetition))
                .addGap(18, 18, 18)
                .addComponent(scrollCompetition, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblYourMembers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMembers, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneShowCompetition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneShowCompetition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCompetitionActionPerformed
        competition = (ICompetitionDto) comboCompetition.getSelectedItem();
        setNewCompTable();
    }//GEN-LAST:event_comboCompetitionActionPerformed

    private void setNewCompTable() {
        TableModel tableModel = tableCompetition.getModel();
        List<IMatchDto> matchList = controller.getMatchs(competition.getMatchList());

        for (int row = 0; row < matchList.size(); row++) {
            IMatchDto tmp = matchList.get(row);
            compMatches.add(tmp);

            tableModel.setValueAt(tmp.getHometeam().getName(), row, 0);
            tableModel.setValueAt(tmp.getForeignteam().getName(), row, 1);
            tableModel.setValueAt(tmp.getMatchresult().getPointsHometeam() + " : " + tmp.getMatchresult().getPointsForeignteam(), row, 2);
        }
        tableCompetition.setModel(tableModel);
    }
    
    private void tableCompetitionValueChanged(ListSelectionEvent e) {
        final int row = tableCompetition.getSelectedRow();
        IMatchDto match = compMatches.get(row);

        setNewMembersTable(match);
    }
    
    private void setNewMembersTable(IMatchDto match) {
        TableModel tableModel = tableOurMembers.getModel();
        findClubTeams();

        if (findClubTeam(match) == true) {
            List<IPlayerDto> tmpPlayer = controller.getPlayer(cTeam);
            int counter;

            for (int row = 0; row < tmpPlayer.size(); row++) {
                counter = 0; 
                
                String[] fullname = tmpPlayer.get(row).getName().split(" ");
                tableModel.setValueAt(fullname[counter], row, counter++);     // first name
                tableModel.setValueAt(fullname[counter], row, counter);     // last name
            }
        }
        tableOurMembers.setModel(tableModel);
    }
    
    private String[] getAllCompetitions() {
        List<ICompetitionDto> compList = controller.getCompetitions();
        String[] compArray = new String[compList.size()];

        for (int i = 0; i < compArray.length; i++) {
            compArray[i] = compList.get(i)/*.getName()*/.toString();
        }
        return compArray;
    }

    private void findClubTeams() {
        List<IMatchDto> matchList = controller.getMatchs(competition.getMatchList());
        clubTeams = null;

        for (IMatchDto m : matchList) {
            if (m.getForeignteam().getClass().isInstance(clubTeams)) {
                clubTeams.add((IClubTeamDto) m.getForeignteam());
            }
            if (m.getHometeam().getClass().isInstance(clubTeams)) {
                clubTeams.add((IClubTeamDto) m.getHometeam());
            }
        }
    }
    
    private boolean findClubTeam(IMatchDto match) {

        for (IClubTeamDto ct : clubTeams) {
            if (ct.equals(match.getHometeam())) {
                cTeam = ct;
                return true;
            }
            if (ct.equals(match.getForeignteam())) {
                cTeam = ct;
                return true;
            }
        }
        return false;
    }
    
    public JPanel getPanel(){
        return paneShowCompetition;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCompetition;
    private javax.swing.JLabel lblCompetition;
    private javax.swing.JLabel lblYourMembers;
    private javax.swing.JPanel paneShowCompetition;
    private javax.swing.JScrollPane scrollCompetition;
    private javax.swing.JScrollPane scrollMembers;
    private javax.swing.JTable tableCompetition;
    private javax.swing.JTable tableOurMembers;
    // End of variables declaration//GEN-END:variables
}
