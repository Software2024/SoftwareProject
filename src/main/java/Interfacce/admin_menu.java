package Interfacce;




import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import softwareProject1.*;

/**
 *
 * @author asus
 */
@SuppressWarnings("serial")
public class admin_menu extends javax.swing.JFrame {
    public admin_menu() {
        initComponents();
        setLocationRelativeTo(null);
         EVENTS.setVisible(false);
        USERS.setVisible(false);
        SERVICES.setVisible(false);
       CALENDER.setVisible(false);
    }

    private void initComponents() {

        panel1 = new java.awt.Panel();
        events = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        services = new javax.swing.JButton();
        calender = new javax.swing.JButton();
        users = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        USERS = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        button1 = new java.awt.Button();
        jLabel5 = new javax.swing.JLabel();
        EVENTS = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        SERVICES = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        HOME = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CALENDER = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 89, 130));
        setMinimumSize(new java.awt.Dimension(850, 680));
        setPreferredSize(new java.awt.Dimension(850, 680));
        setResizable(false);
        setSize(new java.awt.Dimension(850, 680));

        panel1.setBackground(new java.awt.Color(31, 89, 130));
        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel1.setMinimumSize(new java.awt.Dimension(850, 580));
        panel1.setPreferredSize(new java.awt.Dimension(850, 680));

        events.setBackground(new java.awt.Color(31, 89, 130));
        events.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        events.setForeground(new java.awt.Color(255, 255, 255));
        events.setText("EVENTS");
        events.setFocusable(false);
        events.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventsActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(31, 89, 130));
        exit.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("EXIT");
        exit.setFocusable(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        services.setBackground(new java.awt.Color(31, 89, 130));
        services.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        services.setForeground(new java.awt.Color(255, 255, 255));
        services.setText("SERVICES");
        services.setFocusable(false);
        services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesActionPerformed(evt);
            }
        });

        calender.setBackground(new java.awt.Color(31, 89, 130));
        calender.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        calender.setForeground(new java.awt.Color(255, 255, 255));
        calender.setText("CALENDER");
        calender.setFocusable(false);
        calender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calenderActionPerformed(evt);
            }
        });

        users.setBackground(new java.awt.Color(31, 89, 130));
        users.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        users.setForeground(new java.awt.Color(255, 255, 255));
        users.setText("USERS");
        users.setFocusable(false);
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });

        panel2.setBackground(new java.awt.Color(0, 51, 51));
        panel2.setPreferredSize(new java.awt.Dimension(660, 688));

        USERS.setBackground(new java.awt.Color(31, 89, 130));
        USERS.setPreferredSize(new java.awt.Dimension(660, 580));
        USERS.setRequestFocusEnabled(false);
        USERS.setVerifyInputWhenFocusTarget(false);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SSN", "First name", "Last name", "Email", "Phone number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        button1.setActionCommand("Remove user");
        button1.setBackground(new java.awt.Color(255, 255, 255));
        button1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        button1.setForeground(new java.awt.Color(204, 0, 0));
        button1.setLabel("Remove user");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Rockwell", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USERS");

        javax.swing.GroupLayout USERSLayout = new javax.swing.GroupLayout(USERS);
        USERS.setLayout(USERSLayout);
        USERSLayout.setHorizontalGroup(
            USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(USERSLayout.createSequentialGroup()
                .addGroup(USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(USERSLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(USERSLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        USERSLayout.setVerticalGroup(
            USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(USERSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button1.getAccessibleContext().setAccessibleName("jButton1");
        button1.getAccessibleContext().setAccessibleDescription("");

        EVENTS.setBackground(new java.awt.Color(31, 89, 130));
        EVENTS.setPreferredSize(new java.awt.Dimension(600, 580));

        jLabel1.setFont(new java.awt.Font("Rockwell", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EVENTS");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NUMBER", "BRIDE", "GROOM", "BUDGET", "DATE", "TIME", "DURATION", "GUESTS", "THEME", "CITY"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            @SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jButton2.setBackground(new java.awt.Color(31, 89, 130));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCEL");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(31, 89, 130));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-addition-20.png"))); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EVENTSLayout = new javax.swing.GroupLayout(EVENTS);
        EVENTS.setLayout(EVENTSLayout);
        EVENTSLayout.setHorizontalGroup(
            EVENTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EVENTSLayout.createSequentialGroup()
                .addGroup(EVENTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EVENTSLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24))
                    .addGroup(EVENTSLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EVENTSLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EVENTSLayout.setVerticalGroup(
            EVENTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EVENTSLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(EVENTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        SERVICES.setBackground(new java.awt.Color(31, 89, 130));
        SERVICES.setPreferredSize(new java.awt.Dimension(660, 580));

        jLabel4.setFont(new java.awt.Font("Rockwell", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SERVICES");

        jTabbedPane1.setBackground(new java.awt.Color(31, 89, 130));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(31, 89, 130));

        jTable3.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Number", "Name", "Price", "Capacity", "Location", "Description", "City"
        	}
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton4.setBackground(new java.awt.Color(31, 89, 130));
        jButton4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add");
        jButton4.setFocusPainted(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(31, 89, 130));
        jButton5.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Edit");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(31, 89, 130));
        jButton6.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Remove");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(31, 89, 130));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-addition-20.png"))); // NOI18N
        jButton20.setFocusPainted(false);
        jButton20.setFocusable(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("venue", jPanel1);

        jPanel2.setBackground(new java.awt.Color(31, 89, 130));

        jTable5.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Number", "Name", "Price", "City", "Package"
        	}
        ));
        jScrollPane5.setViewportView(jTable5);

        jButton7.setBackground(new java.awt.Color(31, 89, 130));
        jButton7.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(31, 89, 130));
        jButton8.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(31, 89, 130));
        jButton9.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Remove");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(31, 89, 130));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-addition-20.png"))); // NOI18N
        jButton19.setFocusPainted(false);
        jButton19.setFocusable(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton19)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("studio", jPanel2);

        jPanel3.setBackground(new java.awt.Color(31, 89, 130));

        jTable6.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"Number", "Name", "Price", "City"
        	}
        ));
        jScrollPane6.setViewportView(jTable6);

        jButton10.setBackground(new java.awt.Color(31, 89, 130));
        jButton10.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(31, 89, 130));
        jButton11.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Edit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(31, 89, 130));
        jButton12.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Remove");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(31, 89, 130));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-addition-20.png"))); // NOI18N
        jButton21.setFocusPainted(false);
        jButton21.setFocusable(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton21)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("dj", jPanel3);

        jPanel4.setBackground(new java.awt.Color(31, 89, 130));

        jTable7.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Number", "Name", "Theme", "Price", "City"
        	}
        ));
        jScrollPane7.setViewportView(jTable7);

        jButton13.setBackground(new java.awt.Color(31, 89, 130));
        jButton13.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Add");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(31, 89, 130));
        jButton14.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Edit");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(31, 89, 130));
        jButton15.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Remove");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(31, 89, 130));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-addition-20.png"))); // NOI18N
        jButton22.setFocusPainted(false);
        jButton22.setFocusable(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton22)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("decorations", jPanel4);

        jPanel5.setBackground(new java.awt.Color(31, 89, 130));

        jTable8.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Number", "Name", "Price", "Package", "City"
        	}
        ));
        jScrollPane8.setViewportView(jTable8);

        jButton16.setBackground(new java.awt.Color(31, 89, 130));
        jButton16.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Add");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(31, 89, 130));
        jButton17.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Edit");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(31, 89, 130));
        jButton18.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Remove");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(31, 89, 130));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-addition-20.png"))); // NOI18N
        jButton23.setFocusPainted(false);
        jButton23.setFocusable(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton23)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("cater", jPanel5);

        javax.swing.GroupLayout SERVICESLayout = new javax.swing.GroupLayout(SERVICES);
        SERVICES.setLayout(SERVICESLayout);
        SERVICESLayout.setHorizontalGroup(
            SERVICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SERVICESLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SERVICESLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        SERVICESLayout.setVerticalGroup(
            SERVICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SERVICESLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        HOME.setBackground(new java.awt.Color(31, 89, 130));
        HOME.setPreferredSize(new java.awt.Dimension(660, 588));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cover1.jpg"))); // NOI18N

        javax.swing.GroupLayout HOMELayout = new javax.swing.GroupLayout(HOME);
        HOME.setLayout(HOMELayout);
        HOMELayout.setHorizontalGroup(
            HOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HOMELayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(jLabel19)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        HOMELayout.setVerticalGroup(
            HOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CALENDER.setBackground(new java.awt.Color(31, 89, 130));
        CALENDER.setPreferredSize(new java.awt.Dimension(600, 580));

        jLabel9.setFont(new java.awt.Font("Rockwell", 3, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CALENDER");

        jCalendar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        javax.swing.GroupLayout CALENDERLayout = new javax.swing.GroupLayout(CALENDER);
        CALENDER.setLayout(CALENDERLayout);
        CALENDERLayout.setHorizontalGroup(
            CALENDERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CALENDERLayout.createSequentialGroup()
                .addGroup(CALENDERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CALENDERLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CALENDERLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        CALENDERLayout.setVerticalGroup(
            CALENDERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CALENDERLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(EVENTS, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SERVICES, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addComponent(USERS, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addComponent(HOME, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addComponent(CALENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(EVENTS, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addComponent(SERVICES, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addComponent(USERS, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addComponent(HOME, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CALENDER, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
        );

        CALENDER.getAccessibleContext().setAccessibleName("jPanel5");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(events, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(services, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(users, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(70, 70, 70)
                .addComponent(events, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(calender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(services, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("jf");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsActionPerformed
        EVENTS.setVisible(true);
        HOME.setVisible(false);
        USERS.setVisible(false);
       CALENDER.setVisible(false);
        SERVICES.setVisible(false);
    
     try {
         
    try (Connection conn = DataBasecon.getConnection(); 
         Statement stmt = conn.createStatement(); 
         ResultSet rsUser = stmt.executeQuery("SELECT * FROM dream.event")) {
   
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        while (rsUser.next()) {
            Object[] row = new Object[10];
            row[0] = rsUser.getInt("number");
            row[1] = rsUser.getString("bride full name");
            row[2] = rsUser.getString("groom full name");
            row[3] = rsUser.getInt("budget");
            row[4] = rsUser.getDate("date");
            row[5] = rsUser.getTime("starting time");
            row[6] = rsUser.getInt("duration");
            row[7] = rsUser.getInt("guest count");
            row[8] = rsUser.getString("theme");
            row[9] = rsUser.getString("city_location");
     
            model.addRow(row);
        }
    } 
} catch (SQLException ex) {
    ex.printStackTrace();
}
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
dispose();
new sign_in_frame().setVisible(true);
    }

    private void calenderActionPerformed(java.awt.event.ActionEvent evt) {
    dispose();
       new  Calender().setVisible(true);
       
    }

    private void servicesActionPerformed(java.awt.event.ActionEvent evt) {
    	    try (Connection conn = DataBasecon.getConnection()) {
    	        SERVICES.setVisible(true);
    	        HOME.setVisible(false);
    	        USERS.setVisible(false);
    	        EVENTS.setVisible(false);
    	        CALENDER.setVisible(false);

    	        // Clear existing rows from all tables
    	        ((DefaultTableModel) jTable3.getModel()).setRowCount(0);
    	        ((DefaultTableModel) jTable5.getModel()).setRowCount(0);
    	        ((DefaultTableModel) jTable6.getModel()).setRowCount(0);
    	        ((DefaultTableModel) jTable7.getModel()).setRowCount(0);
    	        ((DefaultTableModel) jTable8.getModel()).setRowCount(0);

    	        try (Statement stmt = conn.createStatement()) {
    	            ResultSet rs = stmt.executeQuery("SELECT * FROM dream.venue");
    	            populateTable(rs, jTable3, 7);

    	            rs = stmt.executeQuery("SELECT * FROM dream.studio");
    	            populateTable(rs, jTable5, 5);

    	            rs = stmt.executeQuery("SELECT * FROM dream.dj");
    	            populateTable(rs, jTable6, 4);

    	            rs = stmt.executeQuery("SELECT * FROM dream.decorations");
    	            populateTable(rs, jTable7, 5);

    	            rs = stmt.executeQuery("SELECT * FROM dream.cater");
    	            populateTable(rs, jTable8,5);
    	        }
    	    } catch (SQLException ex) {
    	        ex.printStackTrace();
    	    }
    	}

    	private void populateTable(ResultSet rs, JTable table, int columnCount) throws SQLException {
    	    DefaultTableModel model = (DefaultTableModel) table.getModel();
    	    while (rs.next()) {
    	        Object[] row = new Object[columnCount];
    	        for (int i = 0; i < columnCount; i++) {
    	            row[i] = rs.getString(i + 1); 
    	        }
    	        model.addRow(row);
    	    }
    	    rs.close();
    	}
    
    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
        USERS.setVisible(true);
        HOME.setVisible(false);
       EVENTS.setVisible(false);
       CALENDER.setVisible(false);
        SERVICES.setVisible(false);

       try {
            try (Connection conn = DataBasecon.getConnection(); 
                    Statement stmt = conn.createStatement(); ResultSet rsUser = stmt.executeQuery("SELECT * FROM dream.user")) {
                
                
    
                DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                model.setRowCount(0);
                
                
                while (rsUser.next()) {
                    Object[] row = new Object[5];
             row[0] = rsUser.getInt("ssn");
            row[1] = rsUser.getString("first name");
            row[2] = rsUser.getString("last name");
            row[3] = rsUser.getString("email");
             row[4] = rsUser.getInt("phone number");
                    model.addRow(row);
                }
            }
    } catch (SQLException ex) {
        ex.printStackTrace(); 
    }
    }//GEN-LAST:event_usersActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
       int selectedIndex = jTable4.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        int ssn = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        User user = new User();
        try {
			user.removeUser(selectedIndex, ssn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		model.removeRow(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     try {
    int index = jTable3.getSelectedRow();
    TableModel model = jTable3.getModel();
    int number = -1; 
    String name = "";
    int price = -1;
    int capacity = -1;
    String location = "";
    String description = "";
    String city="";
	if (index != -1) {
        number = Integer.parseInt(model.getValueAt(index, 0).toString());
        name = model.getValueAt(index, 1).toString();
        price = Integer.parseInt(model.getValueAt(index, 2).toString());
        capacity = Integer.parseInt(model.getValueAt(index, 3).toString());
        city = model.getValueAt(index, 4).toString();
        location = model.getValueAt(index, 5).toString();
        description = model.getValueAt(index, 6).toString();
    }
    
    venue myVenue = new venue();
    myVenue.addVenue(number, name, price, capacity,city, location, description);
} catch (SQLException ex) {
    ex.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}
    
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int selectedIndex = jTable3.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        String newName = model.getValueAt(selectedIndex, 1).toString();
        int newPrice = Integer.parseInt(model.getValueAt(selectedIndex, 2).toString());
        int newCapacity = Integer.parseInt(model.getValueAt(selectedIndex, 3).toString());
        String newLocation = model.getValueAt(selectedIndex, 5).toString();
        String newCity = model.getValueAt(selectedIndex, 4).toString();
        String newDescription = model.getValueAt(selectedIndex, 6).toString();
        int venueNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString()); 

        try {
            venue venue = new venue();
            venue.editVenue(newName, newPrice, newCapacity, newLocation,newCity, newDescription, venueNumber);
        } catch (SQLException ex) {
            Logger.getLogger(admin_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
          int selectedIndex = jTable3.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int venueNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        venue myVenue = new venue();
        try {
            myVenue.removeVenue(selectedIndex, venueNumber);
            model.removeRow(selectedIndex);
        } catch (SQLException ex) {
            Logger.getLogger(admin_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                 try {
    int index = jTable5.getSelectedRow();
    TableModel model = jTable5.getModel();
    
    int number = Integer.parseInt(model.getValueAt(index, 0).toString());
    String name = model.getValueAt(index, 1).toString();
    int price = Integer.parseInt(model.getValueAt(index, 2).toString());
    String city = model.getValueAt(index, 3).toString();
    String package1 = model.getValueAt(index, 4).toString();
     studio myStudio = new studio();
    myStudio.addStudio(number, name, price,city,package1);
} catch (SQLException ex) {
    ex.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}
    
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
    int selectedIndex = jTable5.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        String newName = model.getValueAt(selectedIndex, 1).toString();
        int newPrice = Integer.parseInt(model.getValueAt(selectedIndex, 2).toString());
        int studioNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString()); 
        String city = model.getValueAt(selectedIndex, 3).toString();
        String package1 = model.getValueAt(selectedIndex, 4).toString();
        studio studio = new studio();
        studio.editStudio(studioNumber, newName, newPrice,city,package1);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
                  int selectedIndex = jTable5.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        int studioNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        studio myStudio = new studio();
        myStudio.removeStudio(selectedIndex,studioNumber);
		model.removeRow(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                 try {
    int index = jTable6.getSelectedRow();
    TableModel model = jTable6.getModel();
    
    int number = Integer.parseInt(model.getValueAt(index, 0).toString());
    String name = model.getValueAt(index, 1).toString();
    int price = Integer.parseInt(model.getValueAt(index, 2).toString());
    String city= model.getValueAt(index, 3).toString();
     dj myDj = new dj();
    myDj.addDj(number, name, price,city);
} catch (SQLException ex) {
    ex.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}
    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int selectedIndex = jTable6.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        String newName = model.getValueAt(selectedIndex, 1).toString();
        int newPrice = Integer.parseInt(model.getValueAt(selectedIndex, 2).toString());
        int djNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString()); 
        String city = model.getValueAt(selectedIndex, 3).toString();
        dj dj = new dj();
        dj.editDj(djNumber, newName, newPrice,city);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
         int selectedIndex = jTable6.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        int djNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        dj myDj = new dj();
        myDj.removeDj(selectedIndex,djNumber);
        model.removeRow(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
         try {
    int index = jTable7.getSelectedRow();
    TableModel model = jTable7.getModel();
    
    int number = Integer.parseInt(model.getValueAt(index, 0).toString());
    String name = model.getValueAt(index, 1).toString();
    int price = Integer.parseInt(model.getValueAt(index, 3).toString());
    String theme = model.getValueAt(index, 2).toString();
    String city = model.getValueAt(index, 3).toString();
     decoration myDecor = new decoration();
    myDecor.addDecorations(number, name, price, theme,city);
} catch (SQLException ex) {
    ex.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
         int selectedIndex = jTable7.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        String newName = model.getValueAt(selectedIndex, 1).toString();
        int newPrice = Integer.parseInt(model.getValueAt(selectedIndex, 2).toString());
        String newTheme = model.getValueAt(selectedIndex, 3).toString();
        int decorNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString()); 
        String city = model.getValueAt(selectedIndex, 4).toString();
        decoration decoration = new decoration();
        decoration.editDecoration(decorNumber, newName, newPrice, newTheme,city);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
    }      
    }

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
                          int selectedIndex = jTable7.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        int decorationNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        decoration myDecoration = new decoration();
        myDecoration.removeDecoration(selectedIndex,decorationNumber);
        model.removeRow(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
                 try {
    int index = jTable8.getSelectedRow();
    TableModel model = jTable8.getModel();
    
    int number = Integer.parseInt(model.getValueAt(index, 0).toString());
    String name = model.getValueAt(index, 1).toString();
    int price = Integer.parseInt(model.getValueAt(index, 2).toString());
    String Package = model.getValueAt(index, 3).toString();
    String city = model.getValueAt(index,4).toString();
     cater myCater = new cater();
    myCater.addCater(number, name, price, Package,city);
} catch (SQLException ex) {
    ex.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}

    }

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {
            int selectedIndex = jTable8.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        String newName = model.getValueAt(selectedIndex, 1).toString();
        int newPrice = Integer.parseInt(model.getValueAt(selectedIndex, 2).toString());
        String newPackage = model.getValueAt(selectedIndex, 3).toString();
        int caterNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString()); 
        String city = model.getValueAt(selectedIndex, 4).toString();
        cater cater = new cater();
        cater.editCater(caterNumber, newName, newPrice, newPackage,city);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
    }      
    }

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
                          int selectedIndex = jTable8.getSelectedRow();
    if (selectedIndex != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        int caterNumber = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        cater myCater = new cater();
        myCater.removeCater(selectedIndex,caterNumber);
        model.removeRow(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.addRow(new Object[]{"", "", ""});
    
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
           DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.addRow(new Object[]{"", "", "", "", "", ""});
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
          DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.addRow(new Object[]{"", "", ""});
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.addRow(new Object[]{"", "", "", ""});
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        model.addRow(new Object[]{"", "", "", ""});
    }//GEN-LAST:event_jButton23ActionPerformed

  
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {
    	dispose();
     new new_wedding().setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedIndex = jTable2.getSelectedRow();
        if (selectedIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            int serial = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            Event event = new Event();
            event.deleteEvent(serial);
            model.removeRow(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_menu().setVisible(true);
            }
        });
    }

   
    private javax.swing.JPanel CALENDER;
    private javax.swing.JPanel EVENTS;
    private javax.swing.JPanel HOME;
    private javax.swing.JPanel SERVICES;
    private javax.swing.JPanel USERS;
    private java.awt.Button button1;
    private javax.swing.JButton calender;
    private javax.swing.JButton events;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton services;
    private javax.swing.JButton users;
  

}