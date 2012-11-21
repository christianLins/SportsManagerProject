package presentation.forms.helper;

import contract.dto.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class SelectTeamsHelper extends javax.swing.JFrame {
    private List<ITypeOfSport> allSports;
    private AbstractMainForm parent;
    private List<IClubTeam> selectedTeams;

    /**
     * Creates new form SelectSports
     */
    public SelectTeamsHelper(List<ITypeOfSport> allSports, AbstractMainForm parent) {
        this.allSports = allSports;
        this.parent = parent;
        selectedTeams = new LinkedList<>();
        initComponents();
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSetTeams = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTeams = new javax.swing.JList();
        btnSave = new javax.swing.JButton();
        comboSports = new javax.swing.JComboBox();
        btnFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change/Set Team(s)");

        panelSetTeams.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Set Teams", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        listTeams.setModel(new javax.swing.AbstractListModel() {
            Object[] strings = getTeamsArray();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listTeams.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listTeamsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listTeams);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        comboSports.setModel(new javax.swing.DefaultComboBoxModel(allSports.toArray()));
        comboSports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSportsActionPerformed(evt);
            }
        });

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSetTeamsLayout = new javax.swing.GroupLayout(panelSetTeams);
        panelSetTeams.setLayout(panelSetTeamsLayout);
        panelSetTeamsLayout.setHorizontalGroup(
            panelSetTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSetTeamsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSetTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(comboSports, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSetTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSetTeamsLayout.setVerticalGroup(
            panelSetTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSetTeamsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(panelSetTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSetTeamsLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinish)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSetTeams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSetTeams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        selectedTeams.add((IClubTeam)listTeams.getSelectedValue());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void listTeamsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listTeamsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listTeamsValueChanged

    private void comboSportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSportsActionPerformed
        updateListTeamsModel();

    }//GEN-LAST:event_comboSportsActionPerformed

    private void updateListTeamsModel() {
        listTeams.setModel(new AbstractListModel() {
            Object[] strings = getTeamsArray();

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
    
    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
       
        //parent.setTxtFieldTeams(selectedTeams);
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnFinishActionPerformed

    private Object[] getTeamsArray(){
        ITypeOfSport tos = (ITypeOfSport) comboSports.getSelectedItem();
        List<IClubTeam> clubTeamOfSport = parent.getClubTeams(tos);
        return clubTeamOfSport.toArray();
    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboSports;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listTeams;
    private javax.swing.JPanel panelSetTeams;
    // End of variables declaration//GEN-END:variables

}
