package presentation.forms.competition;

import contract.IChangeCompetitionTeam;
import dto.contract.IClubTeam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
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
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import dto.contract.ICompetition;
import dto.contract.IMember;
import dto.contract.IPlayer;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;
import services.ServiceClient;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lucia
 */
public class ChangeCompetitionTeam extends AbstractMainForm {

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
    IMember user;
    ServiceClient client;
    IChangeCompetitionTeam controller;
    ICompetition competition;
    List<IClubTeam> cTeams;
    IClubTeam team;
    List<IPlayer> teamMember;
    List<IPlayer> oldTeam;
    List<IPlayer> newTeam;

    // End of variables declaration
    public ChangeCompetitionTeam(AbstractForm form, ServiceClient client, IMember user) throws ServiceNotAvailableException {
        super(form);
        this.client = client;
        this.user = user;
        controller = this.client.getChangeCompetitionTeamService();
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
        comboCompetition.setModel(new DefaultComboBoxModel(getCompetitionList()));
        comboCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboCompetitionActionPerformed(e);
            }
        });

        lblSelTeam.setText("Team");

        comboTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboTeamActionPerformed(e);
            }
        });

        scrollTeam.setViewportView(listTeam);

        lblMembers.setText("Team Members");
        btnAdd.setText("Add >");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember();
            }
        });


        scrollCompTeam.setViewportView(listCompTeam);

        jLabel1.setText("Current Competition Team");

        btnRemove.setText("< Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeMember();
            }
        });

        btnSave.setText("Save Team");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveActionPerformed(e);
                //TODO: save competitionTeam; //list
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

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
                .addContainerGap(362, Short.MAX_VALUE)));
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
                .addContainerGap(186, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panelChangeTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panelChangeTeam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void comboCompetitionActionPerformed(ActionEvent e) {
        comboTeam.setModel(new DefaultComboBoxModel(getTeamList()));
    }

    private void comboTeamActionPerformed(ActionEvent e) {
        String teamName = comboTeam.getSelectedItem().toString();

        for (IClubTeam ct : cTeams) {
            if (ct.getName().equals(teamName)) {
                team = ct;
            }
        }
        setTeamMemberList();

        IClubTeam compTeam = controller.getCompetitionTeam(team);
        List<Integer> playerInt = compTeam.getPlayerList();
        oldTeam = controller.getPlayers(playerInt);
        newTeam = controller.getPlayers(playerInt);
        setCompTeamList();

    }

    private void saveActionPerformed(ActionEvent e) {
        IClubTeam oldCompTeam = controller.getCompetitionTeam(team);   
        IClubTeam newCompTeam = oldCompTeam;
        
        List<Integer> newPlayInt = new LinkedList<>();
        for(IPlayer player: newTeam){
            newPlayInt.add(player.getId());
        }                
        newCompTeam.setPlayerList(newPlayInt);        
        
        controller.setCompetitonTeam(competition, oldCompTeam, newCompTeam);
    }
    
    private void setTeamMemberList() {
        List<Integer> playerInt = team.getPlayerList();
        teamMember = controller.getPlayers(playerInt);
        final String[] players = new String[teamMember.size()];

        for (int i = 0; i < players.length; i++) {
            players[i] = teamMember.get(i).toString();
        }

        listTeam.setModel(new AbstractListModel() {
            String[] strings = players;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void setCompTeamList() {

        final String[] topTeam = new String[newTeam.size()];
        for (int i = 0; i < topTeam.length; i++) {
            topTeam[i] = newTeam.get(i).toString();
        }

        listCompTeam.setModel(new AbstractListModel() {
            String[] strings = topTeam;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void addMember() {
        //List Models
        ListModel cTeamModel = listCompTeam.getModel();
        ListModel origModel = listTeam.getModel();

        //arrays to store teams, list to save new state of origin
        Object[] origSel = listTeam.getSelectedValues();
        Object[] cTeam = new Object[cTeamModel.getSize() + origSel.length];
        List<Object> tmpOrig = new LinkedList<>();

        for (int i = 0; i < origModel.getSize(); i++) {
            tmpOrig.add(origModel.getElementAt(i));
        }
        for (int i = 0; i < cTeamModel.getSize(); i++) {
            cTeam[i] = cTeamModel.getElementAt(i);
        }
        for (int i = cTeamModel.getSize(); i < cTeam.length; i++) {
            cTeam[i] = origSel[i - cTeamModel.getSize()];
            newTeam.add((IPlayer) origSel[i - cTeamModel.getSize()]);
            teamMember.remove((IPlayer) origSel[i-cTeamModel.getSize()]);   //remove from available team member list
            
            tmpOrig.remove(origSel[i - cTeamModel.getSize()]);
        }
        Object[] newOrigSel = tmpOrig.toArray();

        listCompTeam.setListData(cTeam);
        listTeam.setListData(newOrigSel);
    }

    private void removeMember() {
        //List Models
        ListModel compTModel = listCompTeam.getModel();
        ListModel teamModel = listTeam.getModel();

        //arrays to store teams, list to save new state of competition team                            
        Object[] cTeamSel = listCompTeam.getSelectedValues();                  //competitionteam
        Object[] origTeam = new Object[teamModel.getSize() + cTeamSel.length];  //team general
        List<Object> tmpTeam = new LinkedList<>();

        //Competition Team before removing
        for (int i = 0; i < compTModel.getSize(); i++) {
            tmpTeam.add(compTModel.getElementAt(i));
        }
        //add team data to teamlist
        for (int i = 0; i < teamModel.getSize(); i++) {
            origTeam[i] = teamModel.getElementAt(i);
        }
        //add selected from compTeam to Team
        for (int i = teamModel.getSize(); i < origTeam.length; i++) {
            origTeam[i] = cTeamSel[i - teamModel.getSize()];
            tmpTeam.remove(cTeamSel[i - teamModel.getSize()]);
        }

        for (int i = 0; i < cTeamSel.length; i++) {
            teamMember.add((IPlayer) cTeamSel[i]);
            newTeam.remove((IPlayer) cTeamSel[i]);  //remove from new team list
        }

        Object[] nTeam = tmpTeam.toArray();

        listCompTeam.setListData(nTeam);
        listTeam.setListData(origTeam);
    }

    private String[] getCompetitionList() {
        List<ICompetition> compList = controller.getCompetition();
        String[] compArray = new String[compList.size()];

        for (int i = 0; i < compList.size(); i++) {
            //TODO: check how to name it
            compArray[i] = compList.get(i).toString();
        }
        return compArray;
    }

    private String[] getTeamList() {
        competition = (ICompetition) comboCompetition.getSelectedItem(); //TODO: get compname
        List<Integer> allTeams = competition.getTeamList();

        cTeams = controller.getClubTeams(allTeams);
        String[] cTeamArray = new String[cTeams.size()];

        for (int i = 0; i < cTeamArray.length; i++) {
            cTeamArray[i] = cTeams.get(i).getName();
        }
        return cTeamArray;
    }

    private String[] getAllTeamMembers() {
        String[] tMembers = null;

//        Object[] list = getTeamList().toArray();
//        
//        for(int i = 0; i < list.length; i++){
//            tMembers[i] = list[i].toString();            
//        }
        return tMembers;
    }

    private String[] getSelectedTeamMembers() {
        // String[] team = null;
//        Object[] list = getTopTeamList().toArray();
//        
//        for(int i = 0; i < list.length; i++){
//            team[i] = list[i].toString();            
//        }
        //return team;
        throw new UnsupportedOperationException("Not yet implemented");
    }

    
}
