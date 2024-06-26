package interfacce;
import java.sql.Date;
import java.sql.Time;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import softwareproject.Event;
import softwareproject.User;

@SuppressWarnings("serial")
public class NewWedding1 extends javax.swing.JFrame {
	private transient User currentUser;
    private int ssn;
    int result;
    public NewWedding1() {
        initComponents();
         setLocationRelativeTo(null);
         currentUser =User.getInstance();
         ssn = currentUser.getSSN();
    }
               
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
    	 javax.swing.JButton jButton1;
    	 javax.swing.JLabel jLabel1;
    	 javax.swing.JLabel jLabel10;
    	 javax.swing.JLabel jLabel2;
    	 javax.swing.JLabel jLabel3;
    	 javax.swing.JLabel jLabel5;
    	 javax.swing.JLabel jLabel6;
    	 javax.swing.JLabel jLabel7;
    	 javax.swing.JLabel jLabel8;
    	 javax.swing.JLabel jLabel9;
    	 javax.swing.JPanel jPanel1;
    	 JButton btnMenu;
    	final String FONT_NAME = "Leelawadee";
    	 final String ERROR_TITLE = "Error";
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
      final JDateChooser dateChooser = new JDateChooser();
      jButton1.addActionListener(e -> {
    	    String brideName = jTextField1.getText();
    	    String groomName = jTextField2.getText();
    	    String budgetText = jTextField3.getText();
    	    java.util.Date date1 = dateChooser.getDate();
    	    String timeText = txtHoursminutes.getText();
    	    String durationText = jTextField6.getText();
    	    String guestsText = jTextField7.getText();
    	    String theme = (String) comboBox.getSelectedItem();
    	    String city = (String) comboBox1.getSelectedItem();

    	    if (brideName.isEmpty() || groomName.isEmpty() || budgetText.isEmpty() || date1 == null || timeText.isEmpty() || durationText.isEmpty() || guestsText.isEmpty()) {
    	        JOptionPane.showMessageDialog(null, "Please fill all the fields.", ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
    	        return;
    	    }

    	    try {
    	        int budget = Integer.parseInt(budgetText);
    	        Date date = new Date(date1.getTime());
    	        String[] timeParts = timeText.split(":");
    	        int hours = Integer.parseInt(timeParts[0]);
    	        int minutes = Integer.parseInt(timeParts[1]);
    	        LocalTime localTime = LocalTime.of(hours, minutes);
    	        Time startingTime = Time.valueOf(localTime);
    	        int duration = Integer.parseInt(durationText);
    	        int guests = Integer.parseInt(guestsText);

    	        Event event1 = Event.getInstance();
    	        int result1 = event1.createEvent(ssn, brideName, groomName, budget, date, startingTime, duration, guests, theme, city);

    	        if (result1 != -1) {
    	            dispose();
    	            NewWedding2 instance = new NewWedding2();
    	            instance.setVisible(true);
    	            instance.displayInfo(0);
    	        }
    	    } catch (NumberFormatException ex) {
    	        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.", ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
    	    } catch (IllegalArgumentException ex) {
    	        JOptionPane.showMessageDialog(null, "Invalid date or time format.", ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
    	    }
    	});

        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(880, 650));

        jPanel1.setBackground(new java.awt.Color(238, 243, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 650));

        jLabel1.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel1.setText("bride's full name");

        jLabel2.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel2.setText("theme");

        jLabel3.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel3.setText("starting time");

        jButton1.setBackground(new java.awt.Color(31, 89, 130));
        jButton1.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NEXT");

        jLabel6.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel6.setText("groom's full name");

        jLabel7.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel7.setText("budget");

        jLabel9.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel9.setText("date");

        jLabel8.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel8.setText("duration");

        jLabel10.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel10.setText("guest count");

        jLabel5.setFont(new java.awt.Font(FONT_NAME, 0, 16)); // NOI18N
        jLabel5.setText("city");
        
        txtHoursminutes = new JTextField();
        txtHoursminutes.setText("hh:mm");
        
        btnMenu = new JButton();
        btnMenu.addActionListener(e -> {
            dispose();
            if (currentUser.isAdmin(ssn)) {
                new AdminMenu().setVisible(true);
            } else {
                new MenuUser().setVisible(true);
            }
        });

        btnMenu.setText("MENU");
        btnMenu.setForeground(Color.WHITE);
        btnMenu.setFont(new Font(FONT_NAME, Font.PLAIN, 16));
        btnMenu.setBackground(new Color(31, 89, 130));
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vintage", "Princess ", "Hollywood", "Garden Floral", "Cultural Ethnic"}));
        
       comboBox1 = new JComboBox();
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {"nablus", "ramallah", "tulkarm", "jerusalem", "jenin"}));
        
      

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
        							.addGap(23)
        							.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        							.addGap(3))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel2)
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel7)
        								.addComponent(jLabel6))
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel3)
        								.addComponent(jLabel8))
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel10)
        							.addPreferredGap(ComponentPlacement.RELATED))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(258)
        					.addComponent(jLabel9)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(txtHoursminutes, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(276, Short.MAX_VALUE))
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        						.addComponent(comboBox1, Alignment.LEADING, 0, 290, Short.MAX_VALUE)
        						.addComponent(comboBox, Alignment.LEADING, 0, 290, Short.MAX_VALUE)
        						.addGroup(Alignment.LEADING, jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(jTextField6, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        							.addComponent(jTextField3)
        							.addComponent(jTextField1)
        							.addComponent(jTextField2)
        							.addComponent(jTextField7, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
        					.addGap(84)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
        					.addGap(47))))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addGap(38)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addGap(38)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel7))
        			.addGap(28)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        			.addGap(33)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(txtHoursminutes, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(34)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8))
        			.addGap(38)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel10))
        			.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel2)
        				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addGap(18))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(28)
        			.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(632, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
    }     

   
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewWedding1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> 
            new NewWedding1().setVisible(true));
    }


    

	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox comboBox ;
   
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox comboBox1 ;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private JTextField txtHoursminutes;

}
