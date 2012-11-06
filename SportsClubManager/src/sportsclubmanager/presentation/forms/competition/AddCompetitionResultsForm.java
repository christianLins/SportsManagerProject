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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import sportsclubmanager.presentation.basics.AbstractForm;
import sportsclubmanager.presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class AddCompetitionResultsForm extends AbstractMainForm{
    
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
    // End of variables declaration
    
      /**
     * Creates new form AddMatchResultsForm
     */    
    public AddCompetitionResultsForm(AbstractForm form) {
        super(form);
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

        comboCompetition.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSelectCompetition.setText("Select Competition");

        listMatches.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollMatch.setViewportView(listMatches);

        lblMatch.setText("Match");

        txtfieldTeamA.setEditable(false);

        lblVS.setText(":");

        textfieldTeamB.setEditable(false);

        btnAddResult.setText("Add Result");

        listTeams.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
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
                                .addComponent(spinTeamA, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVS)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinTeamB, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textfieldTeamB, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddResult)))
                .addContainerGap(243, Short.MAX_VALUE))
        );
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
                .addContainerGap(199, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(paneMatchResults, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneMatchResults, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }
    
}
