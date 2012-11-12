package presentation.forms.competition;

import contract.IShowCompetition;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.*;
import dto.contract.IPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;
import services.ServiceClient;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lucia
 */
public class ShowCompetitionForm extends AbstractMainForm {

    // Variables declaration - do not modify
    private JComboBox comboCompetition;
    private JLabel lblCompetition;
    private JLabel lblYourMembers;
    public JPanel paneShowInfo;
    private JScrollPane scrollCompetition;
    private JScrollPane scrollMembers;
    private JTable tableCompetition;
    private JTable tableOurMembers;
    ServiceClient client;
    IShowCompetition controller;
    ICompetition competition;
    List<IClubTeam> clubTeams;
    List<IMatch> compMatches;
    IClubTeam cTeam;
    IMember user; 
    // End of variables declaration

    /**
     * Creates new form ShowCompetitionForm
     */
    public ShowCompetitionForm(AbstractForm form, ServiceClient client, IMember user) throws ServiceNotAvailableException {
        super(form);
        this.client = client;
        this.user = user;
        controller = this.client.getShowCompetitionService();
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

        comboCompetition.setModel(new DefaultComboBoxModel(getAllCompetitions()));
        comboCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboCompetitionActionPerformed(e);
            }
        });

        lblCompetition.setText("Competition");

        tableCompetition.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Team A", "Team B", "Result"
                }));
        tableCompetition.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tableCompetitionValueChanged(e);
            }
        });
        scrollCompetition.setViewportView(tableCompetition);

        lblYourMembers.setText("Announced members from your department");

        tableOurMembers.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String[]{
                    "First Name", "Last Name"
                }));
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
                .addContainerGap()));
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
                .addContainerGap()));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(paneShowInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(paneShowInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>

    private void comboCompetitionActionPerformed(ActionEvent e) {
        competition = (ICompetition) comboCompetition.getSelectedItem();
        setNewCompTable();
    }

    private void tableCompetitionValueChanged(ListSelectionEvent e) {
        final int row = tableCompetition.getSelectedRow();
        IMatch match = compMatches.get(row);

        setNewMembersTable(match);
    }

    private void setNewCompTable() {
        TableModel tableModel = tableCompetition.getModel();
        List<IMatch> matchList = controller.getMatchs(competition.getMatchList());

        for (int row = 0; row < matchList.size(); row++) {
            IMatch tmp = matchList.get(row);
            compMatches.add(tmp);

            tableModel.setValueAt(tmp.getHometeam().getName(), row, 0);
            tableModel.setValueAt(tmp.getForeignteam().getName(), row, 1);
            tableModel.setValueAt(tmp.getMatchresult().getPointsHometeam() + " : " + tmp.getMatchresult().getPointsForeignteam(), row, 2);
        }
        tableCompetition.setModel(tableModel);
    }

    private void setNewMembersTable(IMatch match) {
        TableModel tableModel = tableOurMembers.getModel();
        findClubTeams();

        if (findClubTeam(match) == true) {
            List<IPlayer> tmpPlayer = controller.getPlayer(cTeam);

            for (int row = 0; row < tmpPlayer.size(); row++) {
                IPlayer tmp = tmpPlayer.get(row);

//                tableModel.setValueAt(tmp.getPrename(), row, 0);
//                tableModel.setValueAt(tmp.getLastname(), row, 1);
            }
        }
        tableOurMembers.setModel(tableModel);
    }

    private String[] getAllCompetitions() {
        List<ICompetition> compList = controller.getCompetitions();
        String[] compArray = new String[compList.size()];

        for (int i = 0; i < compArray.length; i++) {
            compArray[i] = compList.get(i)/*.getName()*/.toString();
        }
        return compArray;
    }

    private void findClubTeams() {
        List<IMatch> matchList = controller.getMatchs(competition.getMatchList());
        clubTeams = null;

        for (IMatch m : matchList) {
            if (m.getForeignteam().getClass().isInstance(clubTeams)) {
                clubTeams.add((IClubTeam) m.getForeignteam());
            }
            if (m.getHometeam().getClass().isInstance(clubTeams)) {
                clubTeams.add((IClubTeam) m.getHometeam());
            }
        }
    }

    private boolean findClubTeam(IMatch match) {

        for (IClubTeam ct : clubTeams) {
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
}
