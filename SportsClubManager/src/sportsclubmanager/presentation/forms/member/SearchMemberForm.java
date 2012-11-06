package sportsclubmanager.presentation.forms.member;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JTextField txtfielsSearchMemb;
    // End of variables declaration    

    public SearchMemberForm(AbstractForm form) {
        super(form);
        initComponents();


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        paneSearch = new javax.swing.JPanel();
        txtfielsSearchMemb = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMember = new javax.swing.JTable();
        paneMemberData = new javax.swing.JPanel();
        lblFName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        radioFemale = new javax.swing.JRadioButton();
        radioMale = new javax.swing.JRadioButton();
        lblEntryDate = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblSport = new javax.swing.JLabel();
        lblTeam = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioTrainer = new javax.swing.JRadioButton();
        radioPlayer = new javax.swing.JRadioButton();
        comboTeam = new javax.swing.JComboBox();
        radioFootball = new javax.swing.JRadioButton();
        radioVolleyball = new javax.swing.JRadioButton();
        radioHandball = new javax.swing.JRadioButton();
        radioIceHockey = new javax.swing.JRadioButton();
        lblLName = new javax.swing.JLabel();
        lblPostCode = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        txtfieldLName = new javax.swing.JTextField();
        txtfieldPostCode = new javax.swing.JTextField();
        txtfieldCountry = new javax.swing.JTextField();
        txtfieldMail = new javax.swing.JTextField();
        txtfieldFName = new javax.swing.JTextField();
        txtfieldAddress = new javax.swing.JTextField();
        txtfieldCity = new javax.swing.JTextField();
        txtfieldPhone = new javax.swing.JTextField();
        dateBirthday = new com.toedter.calendar.JDateChooser();
        dateEntry = new com.toedter.calendar.JDateChooser();
        comboDepartment = new javax.swing.JComboBox();
        lblMemberNr = new javax.swing.JLabel();
        txtfieldMemberNr = new javax.swing.JTextField();
        btnApplyChange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(848, 549));

        btnSearch.setText("Search");

        tabMember.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "Membership Nr.", "First Name", "Last Name", "Sport", "Birth Date", "Gender"
                }));

//             NewMemberForm changeMember = new NewMemberForm(null);
//                    MemberService member = null;
//                    Integer id = (Integer) tabMember.getModel().getValueAt(row, 1);
//                    member.getMember(id);
//                    changeMember.setMemberData(member);

        tabMember.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                final int row = tabMember.getSelectedRow();
                MemberService member = null;
                Integer id = (Integer) tabMember.getModel().getValueAt(row, 1);
                if(id != null){
                    updateDetailPane(member.getMember(id));
                }
            }
        });

        jScrollPane1.setViewportView(tabMember);

        paneMemberData.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        lblFName.setText("First Name");

        lblAddress.setText("Address");

        lblCity.setText("City");

        lblPhone.setText("Phone");

        lblBirthDate.setText("Birth Date");

        lblGender.setText("Gender");

        radioFemale.setText("female");
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
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
                radioAdminActionPerformed(evt);
            }
        });

        radioTrainer.setText("Trainer");

        radioPlayer.setText("Player");

        comboTeam.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        comboTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTeamActionPerformed(evt);
            }
        });

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

        lblLName.setText("Last Name");

        lblPostCode.setText("Post Code");

        lblCountry.setText("Country");

        lblMail.setText("Mail");

        txtfieldPostCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldPostCodeActionPerformed(evt);
            }
        });

        comboDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        lblMemberNr.setText("Membership Nr.");

        btnApplyChange.setText("Apply Changes");

        javax.swing.GroupLayout paneMemberDataLayout = new javax.swing.GroupLayout(paneMemberData);
        paneMemberData.setLayout(paneMemberDataLayout);
        paneMemberDataLayout.setHorizontalGroup(
                paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(radioFootball)
                .addGap(10, 10, 10)
                .addComponent(radioVolleyball)
                .addGap(18, 18, 18)
                .addComponent(radioHandball)
                .addGap(18, 18, 18)
                .addComponent(radioIceHockey))
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneMemberDataLayout.createSequentialGroup()
                .addComponent(radioAdmin)
                .addGap(18, 18, 18)
                .addComponent(radioTrainer)
                .addGap(18, 18, 18)
                .addComponent(radioPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApplyChange))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(comboDepartment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtfieldCity, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldFName, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldAddress, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dateBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(dateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(lblGender)
                .addComponent(lblMail)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(lblLName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(lblPostCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMemberDataLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCountry)
                .addGap(21, 21, 21)))
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtfieldCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(txtfieldPostCode)
                .addComponent(txtfieldMail)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(radioFemale)
                .addGap(10, 10, 10)
                .addComponent(radioMale))))
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addComponent(lblMemberNr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfieldMemberNr)))))))
                .addComponent(lblDepartment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        paneMemberDataLayout.setVerticalGroup(
                paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtfieldFName)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblFName)
                .addComponent(lblLName)
                .addComponent(txtfieldLName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMemberDataLayout.createSequentialGroup()
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAddress)
                .addComponent(lblPostCode)
                .addComponent(txtfieldPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblCity)
                .addComponent(lblCountry)
                .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblPhone)
                .addComponent(lblMail)
                .addComponent(txtfieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblBirthDate)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblGender)
                .addComponent(radioFemale)
                .addComponent(radioMale))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMemberDataLayout.createSequentialGroup()
                .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblEntryDate, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(dateEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMemberNr)
                .addComponent(txtfieldMemberNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblDepartment)
                .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioFootball)
                .addComponent(radioVolleyball)
                .addComponent(radioHandball)
                .addComponent(radioIceHockey)
                .addComponent(lblSport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTeam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMemberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioAdmin)
                .addComponent(radioTrainer)
                .addComponent(radioPlayer)
                .addComponent(lblRole)
                .addComponent(btnApplyChange))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout paneSearchLayout = new javax.swing.GroupLayout(paneSearch);
        paneSearch.setLayout(paneSearchLayout);
        paneSearchLayout.setHorizontalGroup(
                paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addGroup(paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addComponent(txtfielsSearchMemb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch))
                .addComponent(paneMemberData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        paneSearchLayout.setVerticalGroup(
                paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtfielsSearchMemb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneMemberData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void updateDetailPane(Member member){
        
        txtfieldFName.setText(member.getPrename());
        txtfieldLName.setText(member.getLastname());
        txtfieldAddress.setText(member.getAddress().toString());
//        txtfieldPostCode.setText(member.getPostCode);
//        txtfieldCity.setText(member.getCity());
        txtfieldCountry.setText(member.getNationality().toString());
        txtfieldMail.setText(member.getEmailAddress());
        txtfieldPhone.setText(member.getTelephonenumber());
        txtfieldMemberNr.setText(member.getId().toString());
        
        if(member.getGender() == true){
            radioFemale.setSelected(true);
        }
        else{
            radioMale.setSelected(true);
        }
        
        dateEntry.setDate(member.getMemberFrom());
        dateBirthday.setDate(member.getDateOfBirth());
        
        List<Integer> roles = member.getRoleList();
        if(roles.contains(1)){
            radioAdmin.setSelected(true);
        }
        if(roles.contains(2)){
            radioTrainer.setSelected(true);
        }
        if(roles.contains(3)){
            radioPlayer.setSelected(true);
        }
        
        //TODO set SPORTS        
        
    }

    private void txtfieldPostCodeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioIceHockeyActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioVolleyballActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioAdminActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
