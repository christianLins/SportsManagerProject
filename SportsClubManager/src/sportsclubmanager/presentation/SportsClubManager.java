package sportsclubmanager.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import sportsclubmanager.communication.rmi.client.CommunicationProblemException;
import sportsclubmanager.communication.rmi.client.RmiServiceClient;
import sportsclubmanager.communication.rmi.contract.*;
import sportsclubmanager.presentation.basics.AbstractForm;
import sportsclubmanager.presentation.forms.competition.AddCompetitionResultsForm;
import sportsclubmanager.presentation.forms.competition.ChangeCompetitionTeam;
import sportsclubmanager.presentation.forms.competition.CreateCompetitionForm;
import sportsclubmanager.presentation.forms.competition.ShowCompetitionForm;
import sportsclubmanager.presentation.forms.member.NewMemberForm;
import sportsclubmanager.presentation.forms.member.SearchMemberForm;

/**

 @author Lucia
 */
public class SportsClubManager
        extends AbstractForm
{
    private JButton btnChangeTeam;
    private JButton btnAddResult;
    private JButton btnCreateCompet;
    private JButton btnMember;
    private JButton btnNewMember;
    private JButton btnShowCompetition;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JPanel paneMatchMain;
    private JPanel paneMatchNavi;
    private JPanel paneMemberMain;
    private JPanel paneMemberNavi;
    private JSplitPane tabMatch;
    private JSplitPane tabMember;
    private JTabbedPane tabPane;
    private RmiServiceClient rmiClient;

    public SportsClubManager(AbstractForm form, RmiServiceClient rmiClient)
    {
        super(form);
        this.rmiClient = rmiClient;
        this.setTitle("SportsClubManager");
        this.setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sports Club Manager");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        tabPane = new JTabbedPane();
        tabMember = new JSplitPane();
        paneMemberNavi = new JPanel();
        paneMemberMain = new JPanel();
        tabMatch = new JSplitPane();
        paneMatchNavi = new JPanel();
        btnShowCompetition = new JButton();
        btnAddResult = new JButton();
        btnCreateCompet = new JButton();
        btnChangeTeam = new JButton();
        paneMatchMain = new JPanel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        btnNewMember = new JButton("Add New Member");
        btnMember = new JButton("Member");

        paneMemberMain = new JPanel();

        paneMemberNavi.setMinimumSize(new java.awt.Dimension(140, 549));
        paneMemberNavi.setPreferredSize(new java.awt.Dimension(140, 549));
        paneMemberNavi.setRequestFocusEnabled(false);

        GroupLayout paneMemberNaviLayout = new GroupLayout(paneMemberNavi);
        paneMemberNavi.setLayout(paneMemberNaviLayout);
        paneMemberNaviLayout.setHorizontalGroup(
                paneMemberNaviLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMemberNaviLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(btnNewMember, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addComponent(btnMember, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
        paneMemberNaviLayout.setVerticalGroup(
                paneMemberNaviLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMember)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewMember)
                .addContainerGap(486, Short.MAX_VALUE)));

        tabMember.setLeftComponent(paneMemberNavi);

        //buttons Member
        btnMember.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                displaySearchMain();
            }
        });

        btnNewMember.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                displayAddMember();
            }
        });


        GroupLayout paneMemberMainLayout = new GroupLayout(paneMemberMain);
        paneMemberMain.setLayout(paneMemberMainLayout);
        paneMemberMainLayout.setHorizontalGroup(
                paneMemberMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 848, Short.MAX_VALUE));
        paneMemberMainLayout.setVerticalGroup(
                paneMemberMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 549, Short.MAX_VALUE));
        tabMember.setRightComponent(paneMemberMain);

        tabPane.addTab("Member", tabMember);

        paneMatchNavi.setMinimumSize(new java.awt.Dimension(140, 549));
        paneMatchNavi.setPreferredSize(new java.awt.Dimension(140, 549));

        //show match results
        btnShowCompetition.setText("Show Competition");
        btnShowCompetition.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnShowResultActionPerformed(evt);
            }
        });

        //add match results
        btnAddResult.setText("Add Result");
        btnAddResult.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddResultActionPerformed(evt);
            }
        });

        btnCreateCompet.setText("Create Competition");
        btnCreateCompet.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCreateCompetActionPerformed(evt);
            }
        });


        btnChangeTeam.setText("Change Team");
        btnChangeTeam.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChangeTeamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneMatchNaviLayout = new javax.swing.GroupLayout(paneMatchNavi);
        paneMatchNavi.setLayout(paneMatchNaviLayout);
        paneMatchNaviLayout.setHorizontalGroup(
                paneMatchNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMatchNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMatchNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnCreateCompet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShowCompetition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChangeTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap()));
        paneMatchNaviLayout.setVerticalGroup(
                paneMatchNaviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMatchNaviLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowCompetition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddResult)
                .addGap(18, 18, 18)
                .addComponent(btnCreateCompet)
                .addGap(18, 18, 18)
                .addComponent(btnChangeTeam)
                .addContainerGap(404, Short.MAX_VALUE)));

        tabMatch.setLeftComponent(paneMatchNavi);

        GroupLayout paneMatchMainLayout = new GroupLayout(paneMatchMain);
        paneMatchMain.setLayout(paneMatchMainLayout);
        paneMatchMainLayout.setHorizontalGroup(
                paneMatchMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 848, Short.MAX_VALUE));
        paneMatchMainLayout.setVerticalGroup(
                paneMatchMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 549, Short.MAX_VALUE));

        tabMatch.setRightComponent(paneMatchMain);

        tabPane.addTab("Competition", tabMatch);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tabPane));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tabPane));

        pack();
    }// </editor-fold>

    //set SearchMember as Main
    private void displaySearchMain()
    {
        paneMemberMain.removeAll();
        paneMemberMain = new SearchMemberForm(this, rmiClient).paneSearch;

        tabMember.setRightComponent(paneMemberMain);
        tabMember.validate();
        tabMember.repaint();
    }

    public void displayAddMember()
    {
        paneMemberMain.removeAll();
        paneMemberMain = new NewMemberForm(this, rmiClient).panel;

        tabMember.setRightComponent(paneMemberMain);
        tabMember.validate();
        tabMember.repaint();
    }

    private void btnShowResultActionPerformed(java.awt.event.ActionEvent evt)
    {
        paneMatchMain.removeAll();
        paneMatchMain = new ShowCompetitionForm(null).paneShowInfo;

        tabMatch.setRightComponent(paneMatchMain);
        tabMatch.validate();
        tabMatch.repaint();
    }

    private void btnAddResultActionPerformed(java.awt.event.ActionEvent evt)
    {
        paneMatchMain.removeAll();
        paneMatchMain = new AddCompetitionResultsForm(null).paneMatchResults;

        tabMatch.setRightComponent(paneMatchMain);
        tabMatch.validate();
        tabMatch.repaint();
    }

    private void btnCreateCompetActionPerformed(ActionEvent evt)
    {
        paneMatchMain.removeAll();
        paneMatchMain = new CreateCompetitionForm(null, rmiClient).panel;

        tabMatch.setRightComponent(paneMatchMain);
        tabMatch.validate();
        tabMatch.repaint();
    }

    private void btnChangeTeamActionPerformed(ActionEvent evt)
    {
        paneMatchMain.removeAll();
        paneMatchMain = new ChangeCompetitionTeam(null).panelChangeTeam;

        tabMatch.setRightComponent(paneMatchMain);
        tabMatch.validate();
        tabMatch.repaint();
    }

    /**
     @param args the command line arguments
     */
    public static void main(String args[])
    {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SportsClubManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SportsClubManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SportsClubManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SportsClubManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Registry r = LocateRegistry.getRegistry("localhost", 1099);
                    IRmiServiceFactory client = (IRmiServiceFactory) r.lookup("CommunicationFactory");
                    SportsClubManager manager = new SportsClubManager(null, new RmiServiceClient(client));
                    manager.setVisible(true);
                }
                catch (CommunicationProblemException | NotBoundException ex)
                {
                    Logger.getLogger(SportsClubManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (AccessException ex)
                {
                    Logger.getLogger(SportsClubManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (RemoteException ex)
                {
                    Logger.getLogger(SportsClubManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
