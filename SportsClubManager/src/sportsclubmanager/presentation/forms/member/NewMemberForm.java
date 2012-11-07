package sportsclubmanager.presentation.forms.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sportsclubmanager.communication.rmi.client.CommunicationProblemException;
import sportsclubmanager.communication.rmi.client.RmiServiceClient;
import sportsclubmanager.dto.controller.contract.IController;
import sportsclubmanager.dto.classes.Address;
import sportsclubmanager.dto.classes.Player;
import sportsclubmanager.dto.contract.IRole;
import sportsclubmanager.dto.contract.IAddress;
import sportsclubmanager.dto.contract.IClubTeam;
import sportsclubmanager.dto.contract.ICountry;
import sportsclubmanager.dto.contract.IDepartment;
import sportsclubmanager.dto.contract.IDepartmentHead;
import sportsclubmanager.dto.contract.IMember;
import sportsclubmanager.dto.contract.IPlayer;
import sportsclubmanager.dto.contract.ITeam;
import sportsclubmanager.presentation.basics.AbstractForm;
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
    //Controler and contract
    IController<IMember> memberCtrl;
    IController<IAddress> addressCtrl;
    IController<ICountry> countryCtrl;
    IController<IPlayer> playerCtrl;
    IController<IDepartmentHead> depHeadCtrl;
    IController<IDepartment> depCtrl;
    IController<IClubTeam> clubTeamCtrl;
    IMember m;
    IAddress address;
    ICountry country;
    IDepartmentHead depHead;
    IDepartment department;
    ITeam team;

    RmiServiceClient rmiClient;
    // End of variables declaration
    /**
     * Creates new form NewMemb
     */
    public NewMemberForm(AbstractForm form, RmiServiceClient rmiClient) {
        super(form);
        this.rmiClient = rmiClient;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        try {
            memberCtrl = rmiClient.getMemberManager();
        
        addressCtrl = rmiClient.getAddressManager();
        countryCtrl = rmiClient.getCountryManager();
        playerCtrl = rmiClient.getPlayerManager();
        depHeadCtrl = rmiClient.getDepartmentHeadManager();
        depCtrl = rmiClient.getDepartmentManager();
        clubTeamCtrl = rmiClient.getClubTeamManager();
        team = null;
        m = null;
        address = null;
        country = null;
        depHead = null;
        department = null;
        } catch (CommunicationProblemException ex) {
            Logger.getLogger(NewMemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }

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


        panePersonData.setBorder(javax.swing.BorderFactory.createTitledBorder("Person Data"));

        lblFName.setText("First Name");
        lblLName.setText("Last Name");
        lblAddress.setText("Address");
        lblPostCode.setText("Post Code");
        lblCity.setText("City");
        lblCountry.setText("Country");
        lblMail.setText("Mail");
        lblBirthDate.setText("Birth Date");
        lblGender.setText("Gender");
        lblPhone.setText("Phone");

        radioFemale.setText("female");
        radioMale.setText("male");

        javax.swing.GroupLayout panePersonDataLayout = new javax.swing.GroupLayout(panePersonData);
        panePersonData.setLayout(panePersonDataLayout);
        panePersonDataLayout.setHorizontalGroup(
                panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblFName)
                .addComponent(lblAddress)
                .addComponent(lblCity)
                .addComponent(lblBirthDate)
                .addComponent(lblPhone))
                .addGap(26, 26, 26)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtfieldCity)
                .addComponent(txtfieldFName)
                .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldPhone)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addComponent(dateChooserBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panePersonDataLayout.createSequentialGroup()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblMail)
                .addComponent(lblCountry)
                .addComponent(lblGender))
                .addGap(10, 10, 10))
                .addComponent(lblLName, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblPostCode, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addComponent(radioFemale)
                .addGap(18, 18, 18)
                .addComponent(radioMale)
                .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtfieldCountry)
                .addComponent(txtfieldPostCode)
                .addComponent(txtfieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtfieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(191, 191, 191)));
        panePersonDataLayout.setVerticalGroup(
                panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addComponent(txtfieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtfieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblLName)
                .addComponent(txtfieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblFName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblPostCode)
                .addComponent(txtfieldPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCountry)
                .addComponent(lblCity))
                .addGap(30, 30, 30)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMail)
                .addComponent(txtfieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioFemale)
                .addComponent(radioMale)
                .addComponent(lblGender)))
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addGroup(panePersonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblBirthDate)
                .addGroup(panePersonDataLayout.createSequentialGroup()
                .addComponent(lblPhone)
                .addGap(29, 29, 29))
                .addComponent(dateChooserBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE)));

        paneMembershipData.setBorder(javax.swing.BorderFactory.createTitledBorder("Membership Data"));

        lblEntryDate.setText("Entry Date");
        lblSport.setText("Sport/s");

        radioFootball.setText("Football");
        radioVolleyball.setText("Volleyball");
        radioHandball.setText("Handball");
        radioIceHockey.setText("IceHockey");

        lblDepartment.setText("Department");
        String[] comboDeps = getDepartments();
        comboDepartment.setModel(new DefaultComboBoxModel(comboDeps));
        comboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //get teams from department and set selectable teams for combobox 
                comboTeam.setModel(new DefaultComboBoxModel(getTeams(comboDepartment.getSelectedItem().toString())));
            }
        });

//        String [] comboTeams = getTeams();
//        comboTeam.setModel(new DefaultComboBoxModel(comboTeams/*new String[] { "Item 1", "Item 2" }*/));
        lblRole.setText("Role");

        radioAdmin.setText("Administrator");
        radioTrainer.setText("Trainer");
        radioPlayer.setText("Player");

        lblTeam.setText("Team");


        javax.swing.GroupLayout paneMembershipDataLayout = new javax.swing.GroupLayout(paneMembershipData);
        paneMembershipData.setLayout(paneMembershipDataLayout);
        paneMembershipDataLayout.setHorizontalGroup(
                paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMembershipDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblDepartment)
                .addComponent(lblEntryDate)
                .addComponent(lblTeam)
                .addComponent(lblRole)
                .addComponent(lblSport))
                .addGap(18, 18, 18)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(dateChooserEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(comboDepartment, 0, 200, Short.MAX_VALUE))
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE)));
        paneMembershipDataLayout.setVerticalGroup(
                paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneMembershipDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblEntryDate)
                .addComponent(dateChooserEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblDepartment)
                .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioFootball)
                .addComponent(radioVolleyball)
                .addComponent(radioHandball)
                .addComponent(radioIceHockey)
                .addComponent(lblSport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTeam))
                .addGap(6, 6, 6)
                .addGroup(paneMembershipDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblRole)
                .addComponent(radioAdmin)
                .addComponent(radioTrainer)
                .addComponent(radioPlayer))
                .addContainerGap(26, Short.MAX_VALUE)));

        btnSaveMember.setText("Save Member");
        btnSaveMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validInput()) {
                    try {
                        setMemberData();
                        //TODO add some success message
                    } catch (CommunicationProblemException ex) {
                        Logger.getLogger(NewMemberForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(parent, "Please fill in all text fields!");
                }
            }
        });

        javax.swing.GroupLayout paneNewMemberLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(paneNewMemberLayout);
        paneNewMemberLayout.setHorizontalGroup(
                paneNewMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneNewMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panePersonData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneMembershipData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addComponent(btnSaveMember)
                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        paneNewMemberLayout.setVerticalGroup(
                paneNewMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneNewMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panePersonData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneMembershipData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveMember)
                .addContainerGap(63, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void setMemberData() throws CommunicationProblemException {
        m.setPrename(txtfieldFName.getText());
        m.setLastname(txtfieldLName.getText());
        m.setDateOfBirth(dateChooserBirth.getDate());
        m.setMemberFrom(dateChooserEntry.getDate());
        m.setTelephonenumber(txtfieldPhone.getText());
        m.setEmailAddress(txtfieldMail.getText());
        
        address.setStreet(txtfieldAddress.getText());
        address.setPostalCode(Integer.parseInt(txtfieldPostCode.getText()));
        address.setVillage(txtfieldCity.getText());
        m.setAddress(address.getId());
        
        country.setName(txtfieldCountry.getText());
        m.setNationality(country.getId());
        
        boolean gender = false;
        if (radioFemale.isSelected()) {
            gender = true;
        }
        m.setGender(gender);

        IController<IPlayer> player = rmiClient.getPlayerManager();
        List<IPlayer> playList = player.getAll();
                
                
                
                
        
        List<IRole> roleList = new LinkedList<>();
        List<Integer> roles = new LinkedList<Integer>();
        if (radioAdmin.isSelected()) {
            roles.add(1);
        }
        if (radioTrainer.isSelected()) {
            roles.add(2);
        }
        if (radioPlayer.isSelected()) {
            roles.add(3);
        }
        m.setRoleList(roles);

        department = getSelectedDepartment(comboDepartment.getSelectedItem().toString());
        team = getSelectedTeam(comboTeam.getSelectedItem().toString());

        List<String> types = getSportTypes();
        
        
        //TODO add department, type of sports, team
    }

    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private String[] getDepartments() {
        List<IDepartment> depList = depCtrl.getAll();
        String [] list = new String[depList.size()];

        for(int i = 0; i < list.length; i++){
            list[i] = depList.get(i).getName();
        }       
        return list;
    }

    private String[] getTeams() {
        List<IClubTeam> teamList = clubTeamCtrl.getAll();
        String[] list = new String[teamList.size()];

        for(int i = 0; i < list.length; i++){
            list[i] = teamList.get(i).getName();
        }       
        return list;
    }

    private String[] getTeams(String name) {
        List<IDepartment> deplist = depCtrl.getAll();
        List<Integer> clubteams = null;   
        
        
        for(int i = 0; i < deplist.size(); i ++){
            if(deplist.get(i).getName().equals(name)){
                IDepartment dep = deplist.get(i);
                clubteams = dep.getClubTeamList();                
            }
        }
        String [] teams = new String[clubteams.size()];
        
        for(int x = 0; x < clubteams.size(); x++){
            
        }
//        Team depHead = new Team();
//        Object[] list = depHead.getDepartmentList().toArray();            
       

//        for(int i = 0; i < list.length; i++){
//            deps[i] = list[i].toString();
//        }       
        return teams;
    }

    private ITeam getSelectedTeam(String name) {
        List<IClubTeam> teamList = clubTeamCtrl.getAll();
        IClubTeam selTeam = null;

        for (IClubTeam t : teamList) {
            if (t.getName().equals(name)) {
                selTeam = t;
            }
        }
        return selTeam;
    }

    private IDepartment getSelectedDepartment(String name) {
        List<IDepartment> depList = depCtrl.getAll();
        IDepartment selDepartment = null;

        for (IDepartment d : depList) {
            if (d.getName().equals(name)) {
                selDepartment = d;
            }
        }
        return selDepartment;
    }
    
    private boolean validInput(){
        boolean success = true;
        
        if (txtfieldFName.getText().isEmpty()) {
            success = false;            
        }
        else if(txtfieldLName.getText().isEmpty()){
            success = false;
        }
        else if(txtfieldCity.getText().isEmpty()){
            success = false;
        }
        else if(dateChooserBirth.getDate() == null){
            success = false;
        }
        else if(comboTeam.getSelectedItem() == null){
            success = false;
        }        
        
        return success;
    }

    private List<String> getSportTypes() {
        List<String> types = new LinkedList<>();
        
        if(radioFootball.isSelected()){
            types.add("Football");
        }
        if(radioHandball.isSelected()){
            types.add("Handball");
        }
        if(radioVolleyball.isSelected()){
            types.add("Volleyball");
        }
        if(radioIceHockey.isSelected()){
            types.add("IceHockey");
        }
        
        return types;
   
    }
}
