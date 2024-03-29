/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.competition;

import com.ServiceClient;
import com.ServiceNotAvailableException;
import contract.dto.*;
import contract.dto.classes.AddressDto;
import contract.dto.classes.CompetitionDto;
import contract.dto.classes.CountryDto;
import contract.dto.classes.MatchDto;
import contract.useCaseController.INewCompetition;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presentation.basics.AbstractForm;
import presentation.basics.AbstractMainForm;

/**
 * @author Lucia
 */
public class CreateCompetitionForm
        extends AbstractMainForm {

    ServiceClient client;
    INewCompetition controller;
    ICompetitionDto competition;
    List<IMatchDto> match;
    IMemberDto user;
    List<String> aTeam;
    List<String> bTeam;
    boolean confirmed = false;
    boolean lastWasA = false;
    Object tmpTeam = null;

    /**
     * Creates new form NewMatch
     */
    public CreateCompetitionForm(AbstractForm parent, ServiceClient client, IMemberDto user)
            throws ServiceNotAvailableException {
        super(parent);
        this.client = client;
        this.user = user;
        controller = this.client.getNewCompetitionService();
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

        panel = new javax.swing.JPanel();
        paneData = new javax.swing.JPanel();
        lblTeams = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSelectTeams = new javax.swing.JList();
        lblMatchNr = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        lblName = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblPostCode = new javax.swing.JLabel();
        txtfieldLocation = new javax.swing.JTextField();
        txtfieldName = new javax.swing.JTextField();
        dateDateFrom = new com.toedter.calendar.JDateChooser();
        txtfieldplz = new javax.swing.JTextField();
        txtfieldcity = new javax.swing.JTextField();
        txtfieldCountry = new javax.swing.JTextField();
        lblFee = new javax.swing.JLabel();
        txtfieldFee = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        dateDateTo = new com.toedter.calendar.JDateChooser();
        paneSetMatches = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSelectMatch = new javax.swing.JList();
        txtfieldTeamA = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        txtfieldTeamB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTeamA = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        listTeamB = new javax.swing.JList();
        lbl2 = new javax.swing.JLabel();
        btnAddMatch = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(845, 549));

        paneData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Set Competition Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        paneData.setMinimumSize(new java.awt.Dimension(794, 279));

        lblTeams.setText("Select Teams");

        listSelectTeams.setModel(new javax.swing.AbstractListModel() {
            String[] teams = getTeamsList();
            public int getSize() { return teams.length; }
            public Object getElementAt(int i) { return teams[i]; }
        });
        listSelectTeams.setMaximumSize(new java.awt.Dimension(40, 80));
        listSelectTeams.setMinimumSize(new java.awt.Dimension(40, 80));
        listSelectTeams.setPreferredSize(new java.awt.Dimension(40, 80));
        listSelectTeams.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSelectTeamsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listSelectTeams);

        lblMatchNr.setText("Matches");

        lblName.setText("Title");

        lblDate.setText("From");

        lblTime.setText("To");

        lblLocation.setText("Location");

        lblCity.setText("City");

        lblCountry.setText("Country");

        lblPostCode.setText("Post Code");

        txtfieldLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldLocationActionPerformed(evt);
            }
        });

        txtfieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldNameActionPerformed(evt);
            }
        });

        lblFee.setText("Fee");

        txtfieldFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldFeeActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm Data");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneDataLayout = new javax.swing.GroupLayout(paneData);
        paneData.setLayout(paneDataLayout);
        paneDataLayout.setHorizontalGroup(
            paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTeams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblMatchNr))
                        .addGap(27, 27, 27)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(165, 165, 165))
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLocation)
                            .addComponent(lblDate)
                            .addComponent(lblPostCode)
                            .addComponent(lblCountry)
                            .addComponent(lblFee))
                        .addGap(18, 18, 18)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addComponent(txtfieldplz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfieldcity))
                            .addComponent(txtfieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addComponent(dateDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(lblTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtfieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm)
                        .addContainerGap())))
        );
        paneDataLayout.setVerticalGroup(
            paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(paneDataLayout.createSequentialGroup()
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMatchNr)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTeams))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfieldName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneDataLayout.createSequentialGroup()
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(paneDataLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblDate))
                                    .addComponent(lblTime)
                                    .addComponent(dateDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLocation)
                                    .addComponent(txtfieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCity)
                                    .addComponent(txtfieldcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPostCode)
                                    .addComponent(txtfieldplz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCountry)
                                    .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConfirm))
                                .addGap(1, 1, 1))
                            .addComponent(lblFee))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        paneSetMatches.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Set Matches", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        listSelectMatch.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listSelectMatch.setEnabled(false);
        listSelectMatch.setMaximumSize(new java.awt.Dimension(40, 80));
        listSelectMatch.setMinimumSize(new java.awt.Dimension(40, 80));
        listSelectMatch.setPreferredSize(new java.awt.Dimension(40, 80));
        listSelectMatch.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSelectMatchValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listSelectMatch);

        txtfieldTeamA.setEnabled(false);
        txtfieldTeamA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldTeamAActionPerformed(evt);
            }
        });

        lbl1.setText("vs.");

        txtfieldTeamB.setEnabled(false);
        txtfieldTeamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldTeamBActionPerformed(evt);
            }
        });

        listTeamA.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        setListTeamAModel();
        listTeamA.setEnabled(false);
        jScrollPane2.setViewportView(listTeamA);

        listTeamB.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        setListTeamBModel();
        listTeamB.setEnabled(false);
        jScrollPane4.setViewportView(listTeamB);

        lbl2.setText("vs.");

        btnAddMatch.setText("Add Match");
        btnAddMatch.setEnabled(false);
        btnAddMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneSetMatchesLayout = new javax.swing.GroupLayout(paneSetMatches);
        paneSetMatches.setLayout(paneSetMatchesLayout);
        paneSetMatchesLayout.setHorizontalGroup(
            paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldTeamB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneSetMatchesLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lbl1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneSetMatchesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddMatch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl2)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneSetMatchesLayout.setVerticalGroup(
            paneSetMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addComponent(txtfieldTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldTeamB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddMatch)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
            .addGroup(paneSetMatchesLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(lbl2)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );

        btnCreate.setText("Create Competition");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paneData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addContainerGap(700, Short.MAX_VALUE)
                        .addComponent(btnCreate))
                    .addComponent(paneSetMatches, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(paneData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(paneSetMatches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPanel() {
        return panel;
    }
    private void txtfieldLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldLocationActionPerformed

    private void txtfieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldNameActionPerformed

    private void txtfieldFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldFeeActionPerformed

    private void txtfieldTeamAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldTeamAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldTeamAActionPerformed

    private void txtfieldTeamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldTeamBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldTeamBActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        if (confirmed) {
            List<Integer> matchInt = new LinkedList<>();
            for (IMatchDto m : match) {
                matchInt.add(m.getId());
            }
            competition.setMatchList(matchInt);

            controller.setCompetition(competition, user);
        } else {
            JOptionPane.showMessageDialog(null, "Please confirm the competition details first!");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void listSelectTeamsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSelectTeamsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listSelectTeamsValueChanged

    private void listSelectMatchValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSelectMatchValueChanged
        tmpTeam = listSelectMatch.getSelectedValue();
        
        if (lastWasA == false && txtfieldTeamA.getText().isEmpty()) {
            String teamA = listSelectMatch.getSelectedValue().toString();
            txtfieldTeamA.setText(teamA);
            lastWasA = true;
        } 
        else if (!tmpTeam.equals(txtfieldTeamA.getText()) || !txtfieldTeamB.getText().isEmpty()) {
            String teamB = listSelectMatch.getSelectedValue().toString();
            txtfieldTeamB.setText(teamB);
            lastWasA = false;

        }
    }//GEN-LAST:event_listSelectMatchValueChanged

    private void btnAddMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMatchActionPerformed
        addToATeams(txtfieldTeamA.getText());
        addToBTeams(txtfieldTeamB.getText());
        updateMatchTables();
        txtfieldTeamA.setText("");
        txtfieldTeamB.setText("");
    }//GEN-LAST:event_btnAddMatchActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        setMatchTeamList();
        confirmed = true;
        btnAddMatch.setEnabled(true);
        listSelectMatch.setEnabled(true);
        match = new LinkedList<>();

        competition = new CompetitionDto();
        competition.setName(txtfieldName.getText());
        competition.setDescription(txtfieldLocation.getText());
        competition.setDateFrom(dateDateFrom.getDate());
        competition.setDateTo(dateDateTo.getDate());
        competition.setPayment(Double.parseDouble(txtfieldFee.getText()));
        competition.setTeamList(getSelectedTeams(listSelectTeams));

        //Set Competitions address
        IAddressDto address = new AddressDto();
        address.setVillage(txtfieldcity.getText());
        address.setPostalCode(Integer.parseInt(txtfieldplz.getText()));
        ICountryDto country = new CountryDto();
        country.setName(txtfieldCountry.getText());
        address.setCountry(country.getId());

        competition.setAddress(address.getId());
    }//GEN-LAST:event_btnConfirmActionPerformed

    private String[] getTeamsList() {
        List<ITeamDto> teamList = controller.getTeams();
        String[] list = new String[teamList.size()];

        for (int i = 0; i < list.length; i++) {
            list[i] = teamList.get(i).getName();
        }
        return list;
    }

    private void setMatchTeamList() {
        Object[] selectedObj = listSelectTeams.getSelectedValues();
        final String[] selString = new String[selectedObj.length];
        for (int i = 0; i < selectedObj.length; i++) {
            selString[i] = selectedObj[i].toString();
        }

        listSelectMatch.setModel(new AbstractListModel() {
            String[] strings = selString;

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

    private List<Integer> getSelectedTeams(JList list) {
        Object[] selection = list.getSelectedValues();      //array with selected values
        List<String> teamSelection = new LinkedList<>();    //selected teams

        //add selected values to the selection teamlist
        for (int i = 0; i < selection.length; i++) {
            teamSelection.add(selection[i].toString());
        }

        List<ITeamDto> teamList = controller.getTeams();
        List<Integer> selTeam = new LinkedList<>();

        for (ITeamDto t : teamList) {
            for (int i = 0; i < teamSelection.size(); i++) {
                if (t.getName().equals(teamSelection.get(i))) {
                    selTeam.add(t.getId());
                }
            }
        }
        return selTeam;
    }

    private void updateMatchTables() {
        IMatchDto newMatch = new MatchDto();
        newMatch.setCompetition(competition.getId());
        newMatch.setHometeam(getTeamID(txtfieldTeamA.getText()));
        newMatch.setForeignteam(getTeamID(txtfieldTeamB.getText()));
        match.add(newMatch);

        setListTeamAModel();
        setListTeamBModel();
    }

    private Integer getTeamID(String name) {
        List<ITeamDto> teamList = controller.getTeams();
        Integer teamID = null;

        for (ITeamDto t : teamList) {
            if (t.getName().equals(name)) {
                teamID = t.getId();
            }
        }
        return teamID;
    }

    private void addToATeams(String name) {
        if (aTeam == null) {
            aTeam = new LinkedList<>();
        }
        aTeam.add(name);
    }

    private String[] getATeams() {
        if (aTeam == null) {
            aTeam = new LinkedList<>();
        }

        String[] aArray = new String[aTeam.size()];
        for (int i = 0; i < aTeam.size(); i++) {
            aArray[i] = aTeam.get(i);
        }
        return aArray;
    }

    private void addToBTeams(String name) {
        if (bTeam == null) {
            bTeam = new LinkedList<>();
        }
        bTeam.add(name);
    }

    private String[] getBTeams() {
        if (bTeam == null) {
            bTeam = new LinkedList<>();
        }

        String[] bArray = new String[bTeam.size()];
        for (int i = 0; i < bTeam.size(); i++) {
            bArray[i] = bTeam.get(i);
        }
        return bArray;
    }

    private void setListTeamAModel() {
        listTeamA.setModel(new AbstractListModel() {
            String[] strings = getATeams();

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

    private void setListTeamBModel() {
        listTeamB.setModel(new AbstractListModel() {
            String[] strings = getBTeams();

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMatch;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnCreate;
    private com.toedter.calendar.JDateChooser dateDateFrom;
    private com.toedter.calendar.JDateChooser dateDateTo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFee;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMatchNr;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JLabel lblTeams;
    private javax.swing.JLabel lblTime;
    private javax.swing.JList listSelectMatch;
    private javax.swing.JList listSelectTeams;
    private javax.swing.JList listTeamA;
    private javax.swing.JList listTeamB;
    private javax.swing.JPanel paneData;
    private javax.swing.JPanel paneSetMatches;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtfieldCountry;
    private javax.swing.JTextField txtfieldFee;
    private javax.swing.JTextField txtfieldLocation;
    private javax.swing.JTextField txtfieldName;
    private javax.swing.JTextField txtfieldTeamA;
    private javax.swing.JTextField txtfieldTeamB;
    private javax.swing.JTextField txtfieldcity;
    private javax.swing.JTextField txtfieldplz;
    // End of variables declaration//GEN-END:variables
}
