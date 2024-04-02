package interfacce;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
public class MenuUser extends javax.swing.JFrame {
	private static final String FONTL = "Leelawadee";

  
    public MenuUser() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

                          
    @SuppressWarnings("deprecation")
	private void initComponents() {
        
javax.swing.JButton jButton1;
javax.swing.JButton jButton5;
javax.swing.JButton jButton6;
javax.swing.JButton jButton7;
javax.swing.JLabel jLabel1;
javax.swing.JPanel jPanel1;

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 243, 252));

        jPanel1.setBackground(new java.awt.Color(31, 89, 130));
        jPanel1.setMinimumSize(new java.awt.Dimension(860, 660));

        jButton5.setBackground(new java.awt.Color(31, 89, 130));
        jButton5.setFont(new java.awt.Font(FONTL, 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("CREATE A NEW EVENT");
        jButton5.setActionCommand("");
        jButton5.addActionListener(evt -> jButton5ActionPerformed());


        jButton6.setBackground(new java.awt.Color(31, 89, 130));
        jButton6.setFont(new java.awt.Font(FONTL, 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton6.setLabel("MANAGE YOUR EVENTS");
        jButton6.addActionListener(evt -> jButton6ActionPerformed());


        jButton1.setBackground(new java.awt.Color(31, 89, 130));
        jButton1.setFont(new java.awt.Font(FONTL, 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("YOUR CALENDER");
        jButton1.addActionListener(evt -> jButton1ActionPerformed());


        jButton7.setBackground(new java.awt.Color(31, 89, 130));
        jButton7.setFont(new java.awt.Font(FONTL, 1, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("EXIT");
        jButton7.setActionCommand("");
        jButton7.addActionListener(evt -> jButton7ActionPerformed());


        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cover1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(33)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jButton6, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(47)
        			.addComponent(jLabel1)
        			.addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(82)
        			.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        			.addGap(73)
        			.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        			.addGap(76)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        			.addGap(83)
        			.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
        		.addComponent(jLabel1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void jButton5ActionPerformed() {                                         
        dispose();
        new NewWedding1().setVisible(true);
    }                                        

    private void jButton6ActionPerformed() {                                         
        dispose();
         ManageEvents manageEvents=new ManageEvents();
         manageEvents.showTable();
         manageEvents.setVisible(true);
    }                                        

    private void jButton7ActionPerformed() {                                         
       dispose();
       new WelcomePage().setVisible(true);
    }                                        

    private void jButton1ActionPerformed() {                                         
      dispose();
      
      new Calender().setVisible(true);
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
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(() -> 
            new MenuUser().setVisible(true));
    }
                 
}
