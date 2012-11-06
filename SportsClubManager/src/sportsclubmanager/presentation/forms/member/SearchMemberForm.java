package sportsclubmanager.presentation.forms.member;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;
import sportsclubmanager.controller.MemberController;
import sportsclubmanager.controller.MemberService;
import sportsclubmanager.dto.classes.Member;
import sportsclubmanager.presentation.basics.AbstractForm;
import sportsclubmanager.presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class SearchMemberForm extends AbstractMainForm {

    // Variables declaration - do not modify
    private JButton btnApplyChange;
    private JButton btnSearch;
    private JComboBox comboDepartment;
    private JComboBox comboTeam;
    private com.toedter.calendar.JDateChooser dateBirthday;
    private com.toedter.calendar.JDateChooser dateEntry;
    private JScrollPane jScrollPane1;
    private JLabel lblAddress;
    private JLabel lblBirthDate;
    private JLabel lblCity;
    private JLabel lblCountry;
    private JLabel lblDepartment;
    private JLabel lblEntryDate;
    private JLabel lblFName;
    private JLabel lblGender;
    private JLabel lblLName;
    private JLabel lblMail;
    private JLabel lblMemberNr;
    private JLabel lblPhone;
    private JLabel lblPostCode;
    private JLabel lblRole;
    private JLabel lblSport;
    private JLabel lblTeam;
    private JPanel paneMemberData;
    public JPanel paneSearch;
    private JRadioButton radioAdmin;
    private JRadioButton radioFemale;
    private JRadioButton radioFootball;
    private JRadioButton radioHandball;
    private JRadioButton radioIceHockey;
    private JRadioButton radioMale;
    private JRadioButton radioPlayer;
    private JRadioButton radioTrainer;
    private JRadioButton radioVolleyball;
    private JTable tabMember;
    private JTextField txtfieldAddress;
    private JTextField txtfieldCity;
    private JTextField txtfieldCountry;
    private JTextField txtfieldFName;
    private JTextField txtfieldLName;
    private JTextField txtfieldMail;
    private JTextField txtfieldMemberNr;
    private JTextField txtfieldPhone;
    private JTextField txtfieldPostCode;
    private JTextField txtfieldSearchMemb;
    
    private boolean dataExists;
    MemberController mController;
    Member member;
    // End of variables declaration    

    public SearchMemberForm(AbstractForm form) {
        super(form);
        initComponents();


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        dataExists = false;
        mController = new MemberController(); 
        member = new Member();
        
        paneSearch = new JPanel();
        txtfieldSearchMemb = new JTextField();
        btnSearch = new JButton();
        jScrollPane1 = new JScrollPane();
        tabMember = new JTable();
        paneMemberData = new JPanel();
        lblFName = new JLabel();
        lblAddress = new JLabel();
        lblCity = new JLabel();
        lblPhone = new JLabel();
        lblBirthDate = new JLabel();
        lblGender = new JLabel();
        radioFemale = new JRadioButton();
        radioMale = new JRadioButton();
        lblEntryDate = new JLabel();
        lblDepartment = new JLabel();
        lblSport = new JLabel();
        lblTeam = new JLabel();
        lblRole = new JLabel();
        radioAdmin = new JRadioButton();
        radioTrainer = new JRadioButton();
        radioPlayer = new JRadioButton();
        comboTeam = new JComboBox();
        radioFootball = new JRadioButton();
        radioVolleyball = new JRadioButton();
        radioHandball = new JRadioButton();
        radioIceHockey = new JRadioButton();
        lblLName = new JLabel();
        lblPostCode = new JLabel();
        lblCountry = new JLabel();
        lblMail = new JLabel();
        txtfieldLName = new JTextField();
        txtfieldPostCode = new JTextField();
        txtfieldCountry = new JTextField();
        txtfieldMail = new JTextField();
        txtfieldFName = new JTextField();
        txtfieldAddress = new JTextField();
        txtfieldCity = new JTextField();
        txtfieldPhone = new JTextField();
        dateBirthday = new com.toedter.calendar.JDateChooser();
        dateEntry = new com.toedter.calendar.JDateChooser();
        comboDepartment = new JComboBox();
        lblMemberNr = new JLabel();
        txtfieldMemberNr = new JTextField();
        btnApplyChange = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(848, 549));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mController = null;
                // m = m.getMember(txtfieldSearchMemb.getText());

                if (mController == null) {
                    JOptionPane.showMessageDialog(parent, "Your entry ' " + txtfieldSearchMemb.getText() + "' could not be found!");
                }

                //TODO: fill up table
            }
        });

        tabMember.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "Membership Nr.", "First Name", "Last Name", "Sport", "Birth Date", "Gender"
                }));


        tabMember.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                final int row = tabMember.getSelectedRow();
                mController = null;
                Integer id = (Integer) tabMember.getModel().getValueAt(row, 1);
                
                if (id != null) {
                    member = mController.getMember(id);
                    updateDetailPane();
                }
            }
        });

        jScrollPane1.setViewportView(tabMember);

        paneMemberData.setBorder(BorderFactory.createTitledBorder("Details"));

        lblFName.setText("First Name");

        lblAddress.setText("Address");

        lblCity.setText("City");

        lblPhone.setText("Phone");

        lblBirthDate.setText("Birth Date");

        lblGender.setText("Gender");

        radioFemale.setText("female");
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // radioFemaleActionPerformed(evt);
            }
        });

        radioMale.setText("male");
        lblEntryDate.setText("Entry Date");
        lblDepartment.setText("Department");
        lblSport.setText("Sport/s");
        lblTeam.setText("Team");
        lblRole.setText("Role");

        radioAdmin.setText("Administrator");
        radioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // radioAdminActionPerformed(evt);
            }
        });

        radioTrainer.setText("Trainer");

        radioPlayer.setText("Player");

        comboTeam.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        comboTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTeamActionPerformed(evt);
            }
        });

        radioFootball.setText("Football");

        radioVolleyball.setText("Volleyball");
        radioVolleyball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  radioVolleyballActionPerformed(evt);
            }
        });

        radioHandball.setText("Handball");

        radioIceHockey.setText("IceHockey");
        radioIceHockey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  radioIceHockeyActionPerformed(evt);
            }
        });

        lblLName.setText("Last Name");

        lblPostCode.setText("Post Code");

        lblCountry.setText("Country");

        lblMail.setText("Mail");

//        txtfieldPostCode.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtfieldPostCodeActionPerformed(evt);
//            }
//        });

        comboDepartment.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        lblMemberNr.setText("Membership Nr.");
        btnApplyChange.setText("Apply Changes");
        btnApplyChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success; 
                if (dataExists != false) {
                    updateMemberData();
                    mController = null;
                    success = mController.changeMember(); 
                    
                    if(success == true){
                        JOptionPane.showMessageDialog(parent, "Data sucessfully changed!");
                    }
                    else{
                        JOptionPane.showMessageDialog(parent, "Changes could not be applied!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(parent, "There is no data to change!");
                }              
            }
        });

        GroupLayout paneMemberDataLayout = new GroupLayout(paneMemberData);
        paneMemberData.setLayout(paneMemberDataLayout);
        paneMemberDataLayout.setHorizontalGroup(
                paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblFName)
                .addComponent(lblAddress)
                .addComponent(lblCity)
                .addComponent(lblPhone)
                .addComponent(lblBirthDate)
                .addComponent(lblEntryDate)
                .addComponent(lblSport)
                .addComponent(lblTeam)
                .addComponent(lblRole))
                .addGap(26, 26, 26)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(radioFootball)
                .addGap(10, 10, 10)
                .addComponent(radioVolleyball)
                .addGap(18, 18, 18)
                .addComponent(radioHandball)
                .addGap(18, 18, 18)
                .addComponent(radioIceHockey))
                .addComponent(comboTeam, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addGroup(GroupLayout.Alignment.LEADING, paneMemberDataLayout.createSequentialGroup()
                .addComponent(radioAdmin)
                .addGap(18, 18, 18)
                .addComponent(radioTrainer)
                .addGap(18, 18, 18)
                .addComponent(radioPlayer)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApplyChange))
                .addGroup(GroupLayout.Alignment.LEADING, paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(comboDepartment, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtfieldCity, GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldFName, GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldAddress, GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldPhone, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addComponent(dateBirthday, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                .addComponent(dateEntry, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(lblGender)
                .addComponent(lblMail)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(lblLName)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfieldLName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.TRAILING, paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(lblPostCode)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, paneMemberDataLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCountry)
                .addGap(21, 21, 21)))
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(txtfieldCountry, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(txtfieldPostCode)
                .addComponent(txtfieldMail)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(radioFemale)
                .addGap(10, 10, 10)
                .addComponent(radioMale))))
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(lblMemberNr)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfieldMemberNr)))))))
                .addComponent(lblDepartment))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        paneMemberDataLayout.setVerticalGroup(
                paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(txtfieldFName)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblFName)
                .addComponent(lblLName)
                .addComponent(txtfieldLName)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblAddress)
                .addComponent(lblPostCode)
                .addComponent(txtfieldPostCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCity)
                .addComponent(lblCountry)
                .addComponent(txtfieldCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblPhone)
                .addComponent(lblMail)
                .addComponent(txtfieldMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(lblBirthDate)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblGender)
                .addComponent(radioFemale)
                .addComponent(radioMale))))
                .addGroup(GroupLayout.Alignment.TRAILING, paneMemberDataLayout.createSequentialGroup()
                .addComponent(txtfieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateBirthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblEntryDate, GroupLayout.Alignment.TRAILING)
                .addComponent(dateEntry, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblMemberNr)
                .addComponent(txtfieldMemberNr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblDepartment)
                .addComponent(comboDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(radioFootball)
                .addComponent(radioVolleyball)
                .addComponent(radioHandball)
                .addComponent(radioIceHockey)
                .addComponent(lblSport))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(comboTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTeam))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(radioAdmin)
                .addComponent(radioTrainer)
                .addComponent(radioPlayer)
                .addComponent(lblRole)
                .addComponent(btnApplyChange))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        GroupLayout paneSearchLayout = new GroupLayout(paneSearch);
        paneSearch.setLayout(paneSearchLayout);
        paneSearchLayout.setHorizontalGroup(
                paneSearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addGroup(paneSearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addComponent(txtfieldSearchMemb, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch))
                .addComponent(paneMemberData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        paneSearchLayout.setVerticalGroup(
                paneSearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSearchLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(txtfieldSearchMemb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneMemberData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(paneSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(paneSearch, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void updateDetailPane() {
        dataExists = true;
        txtfieldFName.setText(member.getPrename());
        txtfieldLName.setText(member.getLastname());
        txtfieldAddress.setText(member.getAddress().toString());
//        txtfieldPostCode.setText(member.getPostCode);
//        txtfieldCity.setText(member.getCity());
        txtfieldCountry.setText(member.getNationality().toString());
        txtfieldMail.setText(member.getEmailAddress());
        txtfieldPhone.setText(member.getTelephonenumber());
        txtfieldMemberNr.setText(member.getId().toString());

        if (member.getGender() == true) {
            radioFemale.setSelected(true);
        } else {
            radioMale.setSelected(true);
        }

        dateEntry.setDate(member.getMemberFrom());
        dateBirthday.setDate(member.getDateOfBirth());

        List<Integer> roles = member.getRoleList();
        if (roles.contains(1)) {
            radioAdmin.setSelected(true);
        }
        if (roles.contains(2)) {
            radioTrainer.setSelected(true);
        }
        if (roles.contains(3)) {
            radioPlayer.setSelected(true);
        }

        //TODO set SPORTS        

    }

    private void updateMemberData() {
        member.setPrename(txtfieldFName.getText());
        member.setLastname(txtfieldLName.getText());
        member.setAddress(Integer.parseInt(txtfieldAddress.getText()));
        member.setEmailAddress(txtfieldMail.getText());
        member.setNationality(1);
        member.setTelephonenumber(txtfieldPhone.getText());
      
        //TODO change role list
        
    }

   
    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

   
}
