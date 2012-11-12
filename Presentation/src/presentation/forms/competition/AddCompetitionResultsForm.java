package presentation.forms.competition;

import contract.IAddMatchResults;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IMatchresult;
import dto.contract.IMember;
import dto.contract.ITeam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;
import services.ServiceClient;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lucia
 */
public class AddCompetitionResultsForm extends AbstractMainForm {

    // Variables declaration - do not modify
    private JButton btnAddResult;
    private JComboBox comboCompetition;
    private JLabel lblMatch;
    private JLabel lblSelectCompetition;
    private JLabel lblTeam;
    private JLabel lblVS;
    private JList listMatches;
    private JList listTeams;
    public JPanel paneMatchResults;
    private JScrollPane scrollMatch;
    private JScrollPane scrollTeam;
    private JSpinner spinTeamA;
    private JSpinner spinTeamB;
    private JTextField textfieldTeamB;
    private JTextField txtfieldTeamA;
    ServiceClient client;
    IAddMatchResults controller;
    ICompetition competition;
    List<ITeam> teamList;
    List<IMatch> matchList;
    IMatch match;
    IMember user;
    // End of variables declaration

    /**
     * Creates new form AddMatchResultsForm
     */
    public AddCompetitionResultsForm(AbstractForm form, ServiceClient client, IMember user) throws ServiceNotAvailableException {
        super(form);
        this.client = client;
        this.user = user;
        controller = this.client.getAddMatchResultsService();
        initComponents();
    }

    private void initComponents() {

        paneMatchResults = new JPanel();
        comboCompetition = new JComboBox();
        lblSelectCompetition = new JLabel();
        scrollMatch = new JScrollPane();
        listMatches = new JList();
        lblMatch = new JLabel();
        spinTeamA = new JSpinner();
        spinTeamB = new JSpinner();
        txtfieldTeamA = new JTextField();
        lblVS = new JLabel();
        textfieldTeamB = new JTextField();
        btnAddResult = new JButton();
        scrollTeam = new JScrollPane();
        listTeams = new JList();
        lblTeam = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Match Results");
        setMinimumSize(new java.awt.Dimension(848, 549));
        setPreferredSize(new java.awt.Dimension(848, 549));

        paneMatchResults.setMinimumSize(new java.awt.Dimension(848, 549));
        paneMatchResults.setPreferredSize(new java.awt.Dimension(848, 549));

        comboCompetition.setModel(new DefaultComboBoxModel(getAllCompetitions() /*new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}*/));
        comboCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboCompetitionActionPerformed(e);
            }
        });

        lblSelectCompetition.setText("Select Competition");
        listMatches.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                listMatchesValueChanged(e);
            }
        });
        scrollMatch.setViewportView(listMatches);

        lblMatch.setText("Match");
        txtfieldTeamA.setEditable(false);
        lblVS.setText(":");
        textfieldTeamB.setEditable(false);

        btnAddResult.setText("Add Result");
        btnAddResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addResultActionPerformed(e);
            }
        });

        listTeams.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                listTeamsValueChanged(e);
            }
        });
        scrollTeam.setViewportView(listTeams);

        lblTeam.setText("Team");

        GroupLayout paneMatchResultsLayout = new GroupLayout(paneMatchResults);
        paneMatchResults.setLayout(paneMatchResultsLayout);
        paneMatchResultsLayout.setHorizontalGroup(
                paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMatchResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMatchResultsLayout.createSequentialGroup()
                .addComponent(lblSelectCompetition)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCompetition, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addGroup(paneMatchResultsLayout.createSequentialGroup()
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addGroup(paneMatchResultsLayout.createSequentialGroup()
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblTeam)
                .addComponent(scrollTeam, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblMatch)
                .addComponent(scrollMatch, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                .addGroup(GroupLayout.Alignment.LEADING, paneMatchResultsLayout.createSequentialGroup()
                .addComponent(txtfieldTeamA, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinTeamA, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVS)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinTeamB, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfieldTeamB, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddResult)))
                .addContainerGap(243, Short.MAX_VALUE)));
        paneMatchResultsLayout.setVerticalGroup(
                paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, paneMatchResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblSelectCompetition)
                .addComponent(comboCompetition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(paneMatchResultsLayout.createSequentialGroup()
                .addComponent(lblTeam)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTeam, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                .addGroup(paneMatchResultsLayout.createSequentialGroup()
                .addComponent(lblMatch)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMatch, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(paneMatchResultsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(txtfieldTeamA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(spinTeamA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblVS)
                .addComponent(spinTeamB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(textfieldTeamB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddResult))
                .addContainerGap(199, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(paneMatchResults, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(paneMatchResults, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE)));

        pack();
    }

    private void comboCompetitionActionPerformed(ActionEvent e) {
        competition = (ICompetition) comboCompetition.getSelectedItem();    //search competition
        matchList = controller.getMatchList(competition.getMatchList());
        teamList = controller.getTeamList(competition.getTeamList());

        setListMatches();
        setListTeams();

    }

    private void addResultActionPerformed(ActionEvent e) {
        IMatchresult result = null;
        result.setPointsHometeam((double)spinTeamA.getValue());
        result.setPointsForeignteam((double)spinTeamB.getValue());        
        controller.setMatchResult(match, result);
    }

    private void listMatchesValueChanged(ListSelectionEvent e) {
        String selMatch = (String) listMatches.getSelectedValue();
                
        String[] array = selMatch.split(" ");
        String home = array[0];
        String foreign = array[2];
        
        for(IMatch m : matchList){
            if(m.getHometeam().getName().equals(home)){
                if(m.getForeignteam().getName().equals(foreign)){
                    match = m;
                }
            }                              
        }
        txtfieldTeamA.setText(home);
        textfieldTeamB.setText(foreign);
    }

    private void listTeamsValueChanged(ListSelectionEvent e) {
        String name = (String) listTeams.getSelectedValue();
        ITeam team = null;
        
        for(ITeam t : teamList){
            if(t.getName().equals(name)){
                team = t;
            }
        }
        List<IMatch> matches = controller.getMatchList(team.getMatchList());
        setListMatches(matches);
        
    }

    private String[] getAllCompetitions() {
        List<ICompetition> compList = controller.getCompetitionList();
        String[] compArray = new String[compList.size()];

        for (int i = 0; i < compArray.length; i++) {
            compArray[i] = compList.get(i)/*.getName()*/.toString();
        }
        return compArray;
    }

    private void setListMatches() {
        final String[] array = new String[matchList.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = matchList.get(i).getHometeam().getName() + " : " + matchList.get(i).getForeignteam().getName();
        }


        listMatches.setModel(new AbstractListModel() {
            String[] strings = array;

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
    
    private void setListMatches(List<IMatch> matches){
        final String[] array = new String[matches.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = matches.get(i).getHometeam().getName() + " : " + matches.get(i).getForeignteam().getName();
        }


        listMatches.setModel(new AbstractListModel() {
            String[] strings = array;
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

    private void setListTeams() {
        final String[] array = new String[teamList.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = teamList.get(i).getName();
        }


        listTeams.setModel(new AbstractListModel() {
            String[] strings = array;

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
}
