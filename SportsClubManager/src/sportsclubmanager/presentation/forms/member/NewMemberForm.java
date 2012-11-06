package sportsclubmanager.presentation.forms.member;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import sportsclubmanager.controller.MemberService;
import sportsclubmanager.presentation.basics.AbstractMainForm;

/**
 *
 * @author Lucia
 */
public class NewMemberForm extends AbstractMainForm {
           
    // Variables declaration - do not modify
    private JButton btnSaveMember;
    private JComboBox comboDepartment;
    private JComboBox comboTeam;
    private com.toedter.calendar.JDateChooser dateChooserBirth;
    private com.toedter.calendar.JDateChooser dateChooserEntry;
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
    private JLabel lblPhone;
    private JLabel lblPostCode;
    private JLabel lblRole;
    private JLabel lblSport;
    private JLabel lblTeam;
    private JPanel paneMembershipData;
    public JPanel panel;
    private JPanel panePersonData;
    private JRadioButton radioAdmin;
    private JRadioButton radioFemale;
    private JRadioButton radioFootball;
    private JRadioButton radioHandball;
    private JRadioButton radioIceHockey;
    private JRadioButton radioMale;
    private JRadioButton radioPlayer;
    private JRadioButton radioTrainer;
    private JRadioButton radioVolleyball;
    private JTextField txtfieldAddress;
    private JTextField txtfieldCity;
    private JTextField txtfieldCountry;
    private JTextField txtfieldFName;
    private JTextField txtfieldLName;
    private JTextField txtfieldMail;
    private JTextField txtfieldPhone;
    private JTextField txtfieldPostCode;
    // End of variables declaration
    
    /**
     * Creates new form NewMemb
     */
    
    public NewMemberForm(AbstractMainForm form) {
        super(form);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panel = new JPanel();
        panePersonData = new JPanel();
        lblFName = new JLabel();
        txtfieldFName = new JTextField();
        lblLName = new JLabel();
        txtfieldLName = new JTextField();
        lblAddress = new JLabel();
        txtfieldAddress = new JTextField();
        txtfieldPostCode = new JTextField();
        lblPostCode = new JLabel();
        lblCity = new JLabel();
        txtfieldCity = new JTextField();
        txtfieldCountry = new JTextField();
        lblCountry = new JLabel();
        txtfieldMail = new JTextField();
        lblMail = new JLabel();
        lblBirthDate = new JLabel();
        dateChooserBirth = new com.toedter.calendar.JDateChooser();
        lblGender = new JLabel();
        txtfieldPhone = new JTextField();
        lblPhone = new JLabel();
        radioFemale = new JRadioButton();
        radioMale = new JRadioButton();
        paneMembershipData = new JPanel();
        lblEntryDate = new JLabel();
        dateChooserEntry = new com.toedter.calendar.JDateChooser();
        lblSport = new JLabel();
        radioFootball = new JRadioButton();
        radioVolleyball = new JRadioButton();
        radioHandball = new JRadioButton();
        radioIceHockey = new JRadioButton();
        lblDepartment = new JLabel();
        comboDepartment = new JComboBox();
        lblRole = new JLabel();
        radioAdmin = new JRadioButton();
        radioTrainer = new JRadioButton();
        radioPlayer = new JRadioButton();
        lblTeam = new JLabel();
        comboTeam = new JComboBox();
        btnSaveMember = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Member Data");
        setMinimumSize(new java.awt.Dimension(848, 549));
        setPreferredSize(new java.awt.Dimension(848, 549));

        panePersonData.setBorder(BorderFactory.createTitledBorder("Person Data"));

        lblFName.setText("First Name");

        txtfieldFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldFNameActionPerformed(evt);
            }
        });

        lblLName.setText("Last Name");
        lblAddress.setText("Address");

        txtfieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldAddressActionPerformed(evt);
            }
        });

        lblPostCode.setText("Post Code");

        lblCity.setText("City");

        txtfieldCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldCityActionPerformed(evt);
            }
        });

        lblCountry.setText("Country");
        lblMail.setText("Mail");
        lblBirthDate.setText("Birth Date");
        lblGender.setText("Gender");
        lblPhone.setText("Phone");

        radioFemale.setText("female");
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        radioMale.setText("male");

        GroupLayout panePersonDataLayout = new GroupLayout(panePersonData);
        panePersonData.setLayout(panePersonDataLayout);
        panePersonDataLayout.setHorizontalGroup(
            panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panePersonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblFName)
                    .addComponent(lblAddress)
                    .addComponent(lblCity)
                    .addComponent(lblBirthDate)
                    .addComponent(lblPhone))
                .addGap(18, 18, 18)
                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtfieldCity)
                        .addComponent(txtfieldFName)
                        .addComponent(txtfieldAddress, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtfieldPhone)
                        .addGroup(panePersonDataLayout.createSequentialGroup()
                            .addComponent(dateChooserBirth, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblMail)
                        .addGroup(panePersonDataLayout.createSequentialGroup()
                            .addComponent(lblCountry)
                            .addGap(10, 10, 10))
                        .addComponent(lblGender))
                    .addComponent(lblLName, GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPostCode, GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panePersonDataLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtfieldCountry)
                                .addGroup(panePersonDataLayout.createSequentialGroup()
                                    .addComponent(txtfieldLName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(txtfieldPostCode)))
                        .addGroup(panePersonDataLayout.createSequentialGroup()
                            .addComponent(radioFemale)
                            .addGap(18, 18, 18)
                            .addComponent(radioMale)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, panePersonDataLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtfieldMail, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                .addGap(199, 199, 199))
        );
        panePersonDataLayout.setVerticalGroup(
            panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panePersonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panePersonDataLayout.createSequentialGroup()
                        .addComponent(txtfieldFName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtfieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panePersonDataLayout.createSequentialGroup()
                        .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLName)
                            .addComponent(txtfieldLName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFName))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPostCode)
                            .addComponent(txtfieldPostCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfieldCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCountry)
                            .addComponent(lblCity))
                        .addGap(27, 27, 27)
                        .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panePersonDataLayout.createSequentialGroup()
                                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfieldMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMail))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioFemale)
                                    .addComponent(radioMale)
                                    .addComponent(lblGender)))
                            .addGroup(panePersonDataLayout.createSequentialGroup()
                                .addGroup(panePersonDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBirthDate)
                                    .addGroup(panePersonDataLayout.createSequentialGroup()
                                        .addComponent(lblPhone)
                                        .addGap(29, 29, 29)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 4, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        paneMembershipData.setBorder(BorderFactory.createTitledBorder("Membership Data"));

        lblEntryDate.setText("Entry Date");

        lblSport.setText("Sport/s");

        radioFootball.setText("Football");

        radioVolleyball.setText("Volleyball");
        radioVolleyball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioVolleyballActionPerformed(evt);
            }
        });

        radioHandball.setText("Handball");

        radioIceHockey.setText("IceHockey");
        radioIceHockey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIceHockeyActionPerformed(evt);
            }
        });

        lblDepartment.setText("Department");

        //TODO: add Departments
        comboDepartment.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblRole.setText("Role");

        radioAdmin.setText("Administrator");
        radioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdminActionPerformed(evt);
            }
        });

        radioTrainer.setText("Trainer");
        radioPlayer.setText("Player");
        
        lblTeam.setText("Team");

        //TODO: add teams to combobox
        comboTeam.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTeamActionPerformed(evt);
            }
        });

        GroupLayout paneMembershipDataLayout = new GroupLayout(paneMembershipData);
        paneMembershipData.setLayout(paneMembershipDataLayout);
        paneMembershipDataLayout.setHorizontalGroup(
            paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneMembershipDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblDepartment)
                    .addComponent(lblEntryDate)
                    .addComponent(lblTeam)
                    .addComponent(lblRole)
                    .addComponent(lblSport))
                .addGap(18, 18, 18)
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(paneMembershipDataLayout.createSequentialGroup()
                        .addComponent(radioFootball)
                        .addGap(18, 18, 18)
                        .addComponent(radioVolleyball)
                        .addGap(18, 18, 18)
                        .addComponent(radioHandball)
                        .addGap(18, 18, 18)
                        .addComponent(radioIceHockey))
                    .addGroup(paneMembershipDataLayout.createSequentialGroup()
                        .addComponent(radioAdmin)
                        .addGap(18, 18, 18)
                        .addComponent(radioTrainer)
                        .addGap(18, 18, 18)
                        .addComponent(radioPlayer))
                    .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateChooserEntry, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboDepartment, 0, 200, Short.MAX_VALUE))
                    .addComponent(comboTeam, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneMembershipDataLayout.setVerticalGroup(
            paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneMembershipDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEntryDate)
                    .addComponent(dateChooserEntry, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartment)
                    .addComponent(comboDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radioFootball)
                    .addComponent(radioVolleyball)
                    .addComponent(radioHandball)
                    .addComponent(radioIceHockey)
                    .addComponent(lblSport))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeam))
                .addGap(6, 6, 6)
                .addGroup(paneMembershipDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(radioAdmin)
                    .addComponent(radioTrainer)
                    .addComponent(radioPlayer))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnSaveMember.setText("Save Member");

        GroupLayout paneNewMemberLayout = new GroupLayout(panel);
        panel.setLayout(paneNewMemberLayout);
        paneNewMemberLayout.setHorizontalGroup(
            paneNewMemberLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneNewMemberLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panePersonData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneMembershipData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneNewMemberLayout.createSequentialGroup()
                        .addComponent(btnSaveMember)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneNewMemberLayout.setVerticalGroup(
            paneNewMemberLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panePersonData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneMembershipData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveMember)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void txtfieldFNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtfieldAddressActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtfieldCityActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioVolleyballActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioIceHockeyActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioAdminActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void setMemberData(MemberService member){
//        txtfieldFName.setText(member.getFirstName());
//        txtfieldLName.setText(member.getLastName());  
//        txtfieldAddress.setText(member.getAddress());
//        txtfieldPostCode.setText(member.getPLZ());
//        txtfieldCity.setText(member.getCity());
//        txtfieldCountry.setText(member.getCountry());
//        txtfieldPhone.setText(member.getPhone());
//        txtfieldMail.setText(member.getMail);
        
        //set comboDepartment focus
//        dateChooserBirth.setDate(member.getBirthday());
//        dateChooserEntry.setDate(member.getEntryDate());
        
//        if(member.getGender() == male){
//            radioMale.setSelected(true);
//        }
//        else{
//            radioFemale.setSelected(true);
//        }
        
//        if(member.getRole() == "admin"){
//            radioAdmin.setSelected(true);
//        }
//        else if(member.getRole() == "Trainer"){
//            radioTrainer.setSelected(true);
//        }
//        else{
//            radioPlayer.setSelected(true);
//        }
        
        //TODO: set member sport
                
          
    }

    
}
