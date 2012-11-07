package sportsclubmanager.presentation.forms.member;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sportsclubmanager.communication.rmi.client.CommunicationProblemException;
import sportsclubmanager.communication.rmi.client.RmiServiceClient;
import sportsclubmanager.controller.AddressController;
import sportsclubmanager.controller.ClubTeamController;
import sportsclubmanager.controller.CountryController;
import sportsclubmanager.controller.DepartmentController;
import sportsclubmanager.controller.DepartmentHeadController;
import sportsclubmanager.controller.contract.IdNotFoundException;
import sportsclubmanager.controller.MemberController;
import sportsclubmanager.controller.PlayerController;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.dto.contract.IDepartment;
import sportsclubmanager.dto.contract.IDepartmentHead;
import sportsclubmanager.dto.contract.ICountry;
import sportsclubmanager.dto.contract.IAddress;
import sportsclubmanager.dto.contract.IClubTeam;
import sportsclubmanager.dto.contract.IMember;
import sportsclubmanager.dto.contract.IPlayer;
import sportsclubmanager.dto.contract.ITypeOfSport;
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
    
    //Controler and contract
    RmiServiceClient rmiClient;    
    IController<IMember> memberCtrl;
    IController<IAddress> addressCtrl;
    IController<ICountry> countryCtrl;
    IController<IPlayer> playerCtrl;
    IController<IDepartmentHead> depHeadCtrl;
    IController<IDepartment> depCtrl;
    IController<IClubTeam> clubCtrl;
    IController<ITypeOfSport> tosCtrl;
    IMember m;
    IAddress address;
    ICountry country;
    IDepartmentHead depHead;
    IDepartment department;
    IClubTeam club;
    // End of variables declaration    

    public SearchMemberForm(AbstractForm form, RmiServiceClient rmiClient) {
        super(form);
        this.rmiClient = rmiClient;
        initComponents();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        try {
            dataExists = false;

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

            memberCtrl = rmiClient.getMemberManager();
            addressCtrl = rmiClient.getAddressManager();
            countryCtrl = rmiClient.getCountryManager();
            playerCtrl = rmiClient.getPlayerManager();
            depHeadCtrl = rmiClient.getDepartmentHeadManager();
            depCtrl = rmiClient.getDepartmentManager();
            clubCtrl = rmiClient.getClubTeamManager();
            tosCtrl =  rmiClient.getTypeOfSportManager();
            club = null;
            m = null;
            address = null;
            country = null;
            depHead = null;
            department = null;

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setMinimumSize(new Dimension(848, 549));

            btnSearch.setText("Search");
            btnSearch.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (txtfieldSearchMemb.getText() == null) {
                        JOptionPane.showMessageDialog(parent, "Please enter a name!");
                    } else {
                        List<IMember> result = null /*findMember(txtfieldSearchMemb.getText())*/;

                        if (result == null || result.isEmpty()) {
                            JOptionPane.showMessageDialog(parent, "Your entry ' " + txtfieldSearchMemb.getText() + "' could not be found!");
                        } else {
                            TableModel tableModel = tabMember.getModel();

                            for (int row = 0; row < result.size(); row++) {
                                IMember tmpMember = result.remove(row);

                                tableModel.setValueAt(m.getId().toString(), row, 0);
                                tableModel.setValueAt(m.getPrename(), row, 1);
                                tableModel.setValueAt(m.getLastname(), row, 2);
                                tableModel.setValueAt(m.getDateOfBirth().toString(), row, 3);
                                if (m.getGender() == true) {
                                    tableModel.setValueAt("female", row, 4);
                                } else {
                                    tableModel.setValueAt("male", row, 4);
                                }
                            }
                            tabMember.setModel(tableModel);
                        }
                    }
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
                        "Membership Nr.", "First Name", "Last Name"/*, "Sport"*/, "Birth Date", "Gender"
                    }));

            //get member from selected table row
            tabMember.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {

                    final int row = tabMember.getSelectedRow();
                    Integer id = (Integer) tabMember.getModel().getValueAt(row, 1);

                    if (id != null) {
                        try {
                            m = memberCtrl.getById(id);
                            updateDetailPane();
                        } catch (IdNotFoundException ex) {
                            JOptionPane.showMessageDialog(parent, "ID '" + id + "' could not be found!");
                        }
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
                    if (radioFemale.isSelected()) {
                        radioMale.setEnabled(false);
                    } else {
                        radioMale.setEnabled(true);
                    }
                }
            });

            radioMale.setText("male");
            radioMale.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radioMale.isSelected()) {
                        radioFemale.setEnabled(false);
                    } else {
                        radioFemale.setEnabled(true);
                    }
                }
            });

            lblEntryDate.setText("Entry Date");
            lblDepartment.setText("Department");
            lblSport.setText("Sport/s");
            lblTeam.setText("Team");
            lblRole.setText("Role");

            radioAdmin.setText("Administrator");
            radioTrainer.setText("Trainer");
            radioPlayer.setText("Player");

            comboTeam.setModel(new DefaultComboBoxModel(new String[]{"Team"}));
            comboTeam.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboTeamActionPerformed(evt);
                }
            });

            radioFootball.setText("Football");
            radioVolleyball.setText("Volleyball");
            radioHandball.setText("Handball");
            radioIceHockey.setText("IceHockey");

            lblLName.setText("Last Name");
            lblPostCode.setText("Post Code");
            lblCountry.setText("Country");
            lblMail.setText("Mail");
            lblMemberNr.setText("Membership Nr.");

            
            comboDepartment.setModel(new DefaultComboBoxModel(getComboDepartment()));
            comboDepartment.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboDepartmentActionPerformed(evt);
                }
            });

            btnApplyChange.setText("Apply Changes");
            btnApplyChange.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (dataExists != false) {
                        updateMemberData();
                        memberCtrl.set(m);
                        //Throw exception in case of an error !!!!!

                    } else {
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
        } // </editor-fold>
        catch (CommunicationProblemException ex) {
            Logger.getLogger(SearchMemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// </editor-fold>

    private List<IMember> findMember(String name) {
        List<IMember> result = new LinkedList<>();
        List<IMember> memberList = memberCtrl.getAll();

        for (IMember m : memberList) {
            if (m.getPrename().equals(name) || m.getLastname().equals(name)) {
                result.add(m);
            }
        }
        return result;
    }
    
    private List<Integer> findSports(){
        List<ITypeOfSport> tosList = tosCtrl.getAll();
        List<Integer> sports = new LinkedList<>();
        List<Integer> roles = m.getRoleList();
        
        if (radioFootball.isSelected()) {
           // roles.
                    
        }
        if (radioHandball.isSelected()) {
        }
        if (radioIceHockey.isSelected()) {
        }
        if (radioVolleyball.isSelected()) {
        }
        
        return sports;
        
    }

    private void updateDetailPane() {
        try {
            dataExists = true;
            txtfieldFName.setText(m.getPrename());
            txtfieldLName.setText(m.getLastname());
            txtfieldMail.setText(m.getEmailAddress());
            txtfieldPhone.setText(m.getTelephonenumber());

            address = addressCtrl.getById(m.getAddress());
            txtfieldAddress.setText(address.getStreet());
            //TODO: ADD AN EXTRA STREET NR FIELD
            String postCode = Integer.toString(address.getPostalCode());
            txtfieldPostCode.setText(postCode);
            txtfieldCity.setText(address.getVillage());

            country = countryCtrl.getById(m.getNationality());
            txtfieldCountry.setText(country.getName());

            txtfieldMemberNr.setText(m.getId().toString());

            if (m.getGender()) {
                radioFemale.setSelected(true);
            } else {
                radioMale.setSelected(true);
            }

            dateEntry.setDate(m.getMemberFrom());
            dateBirthday.setDate(m.getDateOfBirth());

            List<Integer> roles = m.getRoleList();

            if (roles.contains(1)) {
                radioAdmin.setSelected(true);
            }
            if (roles.contains(2)) {
                radioTrainer.setSelected(true);
            }
            if (roles.contains(3)) {
                radioPlayer.setSelected(true);
                IPlayer player = playerCtrl.getById(3);

                List<Integer> sportsID = player.getTypeOfSportList();
                //TODO: add sports                
            }
            
            //TODO: set combobox focus on department of member
            comboDepartment.getModel().setSelectedItem(department.getName());
            

        } catch (IdNotFoundException ex) {
            Logger.getLogger(SearchMemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateMemberData() {
        m.setPrename(txtfieldFName.getText());
        m.setLastname(txtfieldLName.getText());
        m.setDateOfBirth(dateBirthday.getDate());
        m.setMemberFrom(dateEntry.getDate());
        m.setTelephonenumber(txtfieldPhone.getText());
        m.setEmailAddress(txtfieldMail.getText());
        m.setId(Integer.parseInt(txtfieldMemberNr.getText()));

        address.setStreet(txtfieldAddress.getText());
        address.setPostalCode(Integer.parseInt(txtfieldPostCode.getText()));
        address.setVillage(txtfieldCity.getText());
        country.setName(txtfieldCountry.getText());
        

        if (radioFemale.isSelected()) {
            m.setGender(true);
        } else {
            m.setGender(false);
        }

        //TODO: make this work
        List<Integer> role = new LinkedList<>();

        if (radioAdmin.isSelected()) {
        } else if (radioTrainer.isSelected()) {
        } else if (radioPlayer.isSelected()) {
        }
        m.setRoleList(role);

        List<Integer> sports = findSports();
        
        //add list with type of sports

        //TODO: add "club" to team
        //TODO: add "department" to departmetn
    }

    private void comboTeamActionPerformed(java.awt.event.ActionEvent evt) {
        String name = comboTeam.getSelectedItem().toString();
        List<IClubTeam> clublist = clubCtrl.getAll();

        for (IClubTeam c : clublist) {
            if (c.getName().equals(name)) {
                club = c;
            }
        }
    }

    private void comboDepartmentActionPerformed(ActionEvent evt) {
        String name = comboDepartment.getSelectedItem().toString();
        List<IDepartment> deplist = depCtrl.getAll();

        for (IDepartment d : deplist) {
            if (d.getName().equals(name)) {
                department = d;
            }
        }
    }

    //List<IDepartment>
    private List<String> getDepartments() {
        //List<IDepartment> depList = depCtrl.getAll();
        
        //only for testing:
        List<String> depList = new LinkedList<>();
        depList.add("dep 1");
        depList.add("dep2");

        return depList;
    }

    //private IDepartment[] getComboDepartment() {
    private String[] getComboDepartment() {
//        List<String> depList = getDepartments();
//        IDepartment[] depArray = new IDepartment[depList.size()];
        List<String> depList = getDepartments();
        String[] depArray = new String[depList.size()];
        
        for(int i = 0; i<depList.size(); i++){
            depArray[i] = depList.get(i);
        }
        return depArray;       
    }
}