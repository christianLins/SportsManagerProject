package presentation;

import contract.ILogin;
import contract.MemberNotFoundException;
import dto.contract.IMember;
import dto.contract.IUserData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import ldap.contract.IAuthenticator;
import ldap.presentation.LoginFrame;
import ldap.presentation.core.DialogResult;
import ldap.presentation.core.IDialogListener;
import presentation.basics.AbstractForm;
import presentation.forms.competition.AddCompetitionResultsForm;
import presentation.forms.competition.ChangeCompetitionTeam;
import presentation.forms.competition.CreateCompetitionForm;
import presentation.forms.competition.ShowCompetitionForm;
import presentation.forms.member.NewMemberForm;
import presentation.forms.member.SearchMemberForm;
import services.CommunicationProblemException;
import services.ServiceClient;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lucia
 */
public class SCM_Overview extends AbstractForm {
    
    private ServiceClient rmiClient;
    private static IMember user;

    /**
     * Creates new form SCM_Overview
     */
    public SCM_Overview(AbstractForm form, ServiceClient rmiClient, IMember user) {
        super(form);
        this.rmiClient = rmiClient;
        this.user = user;
        this.setTitle("SportsClubManager");
        this.setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        tabPane = new javax.swing.JTabbedPane();
        tabMember = new javax.swing.JSplitPane();
        paneMemberNavi = new javax.swing.JPanel();
        btnMember = new javax.swing.JButton();
        btnNewMember = new javax.swing.JButton();
        paneMemberMain = new javax.swing.JPanel();
        tabMatch = new javax.swing.JSplitPane();
        paneCompNavi = new javax.swing.JPanel();
        btnShowCompetition = new javax.swing.JButton();
        btnAddResult = new javax.swing.JButton();
        btnCreateCompetition = new javax.swing.JButton();
        btnChangeTeam = new javax.swing.JButton();
        paneCompMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sports Club Manager");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);

        paneMemberNavi.setMinimumSize(new java.awt.Dimension(140, 549));
        paneMemberNavi.setPreferredSize(new java.awt.Dimension(140, 549));
        paneMemberNavi.setRequestFocusEnabled(false);

        btnMember.setText("Search Member");
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });

        btnNewMember.setText("Add New Member");
        btnNewMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneMemberNaviLayout = new javax.swing.GroupLayout(paneMemberNavi);
        paneMemberNavi.setLayout(paneMemberNaviLayout);
        paneMemberNaviLayout.setHorizontalGroup(
            paneMemberNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMemberNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMemberNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewMember, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btnMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneMemberNaviLayout.setVerticalGroup(
            paneMemberNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMemberNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewMember)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        tabMember.setLeftComponent(paneMemberNavi);

        javax.swing.GroupLayout paneMemberMainLayout = new javax.swing.GroupLayout(paneMemberMain);
        paneMemberMain.setLayout(paneMemberMainLayout);
        paneMemberMainLayout.setHorizontalGroup(
            paneMemberMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        paneMemberMainLayout.setVerticalGroup(
            paneMemberMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        tabMember.setRightComponent(paneMemberMain);

        tabPane.addTab("Member", tabMember);

        paneCompNavi.setMinimumSize(new java.awt.Dimension(140, 549));
        paneCompNavi.setPreferredSize(new java.awt.Dimension(140, 549));

        btnShowCompetition.setText("Show Result");
        btnShowCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowCompetitionActionPerformed(evt);
            }
        });

        btnAddResult.setText("Add Result");
        btnAddResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddResultActionPerformed(evt);
            }
        });

        btnCreateCompetition.setText("Create Competition");
        btnCreateCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCompetitionActionPerformed(evt);
            }
        });

        btnChangeTeam.setText("Change Team");
        btnChangeTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeTeamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneCompNaviLayout = new javax.swing.GroupLayout(paneCompNavi);
        paneCompNavi.setLayout(paneCompNaviLayout);
        paneCompNaviLayout.setHorizontalGroup(
            paneCompNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCompNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCompNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateCompetition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowCompetition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangeTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneCompNaviLayout.setVerticalGroup(
            paneCompNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCompNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowCompetition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddResult)
                .addGap(18, 18, 18)
                .addComponent(btnCreateCompetition)
                .addGap(18, 18, 18)
                .addComponent(btnChangeTeam)
                .addContainerGap(404, Short.MAX_VALUE))
        );

        tabMatch.setLeftComponent(paneCompNavi);

        javax.swing.GroupLayout paneCompMainLayout = new javax.swing.GroupLayout(paneCompMain);
        paneCompMain.setLayout(paneCompMainLayout);
        paneCompMainLayout.setHorizontalGroup(
            paneCompMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        paneCompMainLayout.setVerticalGroup(
            paneCompMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        tabMatch.setRightComponent(paneCompMain);

        tabPane.addTab("Competition", tabMatch);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
        try {
            paneMemberMain.removeAll();
            paneMemberMain = new SearchMemberForm(this, rmiClient, user).paneSearch;

            tabMember.setRightComponent(paneMemberMain);
            tabMember.validate();
            tabMember.repaint();
        } catch (ServiceNotAvailableException ex) {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMemberActionPerformed

    private void btnShowCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowCompetitionActionPerformed
        try {
            paneCompMain.removeAll();
            paneCompMain = new ShowCompetitionForm(null, rmiClient, user).paneShowInfo;

            tabMatch.setRightComponent(paneCompMain);
            tabMatch.validate();
            tabMatch.repaint();
        } catch (ServiceNotAvailableException ex) {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnShowCompetitionActionPerformed

    private void btnAddResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddResultActionPerformed
        try {
            paneCompMain.removeAll();
            paneCompMain = new AddCompetitionResultsForm(null, rmiClient, user).paneMatchResults;

            tabMatch.setRightComponent(paneCompMain);
            tabMatch.validate();
            tabMatch.repaint();
        } catch (ServiceNotAvailableException ex) {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddResultActionPerformed

    private void btnNewMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMemberActionPerformed
        try {
            paneMemberMain.removeAll();
            paneMemberMain = new NewMemberForm(this, rmiClient, user).panel;

            tabMember.setRightComponent(paneMemberMain);
            tabMember.validate();
            tabMember.repaint();
        } catch (ServiceNotAvailableException ex) {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewMemberActionPerformed

    private void btnCreateCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCompetitionActionPerformed
        try {
            paneCompMain.removeAll();
            paneCompMain = new CreateCompetitionForm(null, rmiClient, user).getPanel();

            tabMatch.setRightComponent(paneCompMain);
            tabMatch.validate();
            tabMatch.repaint();
        } catch (ServiceNotAvailableException ex) {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateCompetitionActionPerformed

    private void btnChangeTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeTeamActionPerformed
        try {
            paneCompMain.removeAll();
            paneCompMain = new ChangeCompetitionTeam(null, rmiClient, user).panelChangeTeam;

            tabMatch.setRightComponent(paneCompMain);
            tabMatch.validate();
            tabMatch.repaint();
        } catch (ServiceNotAvailableException ex) {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChangeTeamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SCM_Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SCM_Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SCM_Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SCM_Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame frame = new LoginFrame();

                frame.addDialogListener(new IDialogListener() {
                    @Override
                    public void dialogClosed(DialogResult dialogResult, IUserData userData) {
                        if (dialogResult.equals(DialogResult.Ok)) {

                            IAuthenticator a = new ldap.Authenticator();

                            while (a.auth(userData)) {
                                try {
                                    JOptionPane.showMessageDialog(null, "Access granted!");

                                    ServiceClient client;
                                    try
                                    {
                                        client = serviceClientFactories.ServiceClientFactory.getRmiServiceClient("localhost", 1099);
                                        ILogin loginService = client.getLoginService();
                                        IMember user = loginService.getMemberByUserData(userData);
                                        SCM_Overview manager = new SCM_Overview(null, client, user);
                                        manager.setVisible(true);
                                    } catch (MemberNotFoundException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid user name");
                                        //Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    catch (CommunicationProblemException ex)
                                    {
                                        Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                   
                                } catch (ServiceNotAvailableException ex) {
                                    Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } 
                        }
                    }
                });
                frame.setVisible(true);
            }
        ;
    }

);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddResult;
    private javax.swing.JButton btnChangeTeam;
    private javax.swing.JButton btnCreateCompetition;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnNewMember;
    private javax.swing.JButton btnShowCompetition;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel paneCompMain;
    private javax.swing.JPanel paneCompNavi;
    private javax.swing.JPanel paneMemberMain;
    private javax.swing.JPanel paneMemberNavi;
    private javax.swing.JSplitPane tabMatch;
    private javax.swing.JSplitPane tabMember;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables

}
