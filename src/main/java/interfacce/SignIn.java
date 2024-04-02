package interfacce;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import softwareproject.User;


public class SignIn extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 static final String FONTNAME = "Leelawadee";
    public SignIn() {
        initComponents();
        setLocationRelativeTo(null);
       
    }

    private void initComponents() {
    	
        javax.swing.JButton jButton1;
        javax.swing.JButton jButton2;
       javax.swing.JLabel jLabel1;
       javax.swing.JLabel jLabel2;
       javax.swing.JLabel jLabel3;
       javax.swing.JLabel jLabel4;
       javax.swing.JLabel jLabel5;
       javax.swing.JPanel jPanel1;
    



        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(880, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(860, 660));

        jPanel1.setBackground(new java.awt.Color(238, 243, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 650));

        jLabel1.setFont(new java.awt.Font(FONTNAME, 0, 16)); // NOI18N
        jLabel1.setText("email ");

        jLabel2.setFont(new java.awt.Font(FONTNAME, 0, 16)); // NOI18N
        jLabel2.setText("password");

        jLabel3.setFont(new java.awt.Font(FONTNAME, 0, 16)); // NOI18N
        jLabel3.setText("choose your role");

        jButton1.setBackground(new java.awt.Color(31, 89, 130));
        jButton1.setFont(new java.awt.Font(FONTNAME, 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SIGN IN");
        jButton1.addActionListener(evt -> jButton1ActionPerformed());


        jComboBox1.setBackground(new java.awt.Color(253, 252, 252));
        jComboBox1.setFont(new java.awt.Font(FONTNAME, 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin ", "user" }));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Green_White_Minimalist_Aesthetic_Plant_and_Flower_Shop_Logo-removebg-preview.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font(FONTNAME, 0, 16)); // NOI18N
        jLabel5.setText("no account?no problem! sign up now->");

        jButton2.setBackground(new java.awt.Color(238, 243, 252));
        jButton2.setText("SIGN UP");
        jButton2.addActionListener(evt -> jButton2ActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, 290, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed() {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new SignUp().setVisible(true); 
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed() {
        User signin = new User();
        String ad;
        String e = jTextField1.getText();
        @SuppressWarnings("deprecation")
		String pass = jPasswordField1.getText();
        String ad1 = (String) jComboBox1.getSelectedItem();

        if ("user".equals(ad1)) {
            ad = "dream.user";
        } else  {
        	ad1="admin";
            ad = "dream.admin";
        }

        try {
            boolean x = signin.logIn(e, pass, ad);

            if (x && "user".equals(ad1)) {
                dispose();
                new MenuUser().setVisible(true);
            } else if (x && "admin".equals(ad1)) {
                dispose();
                new AdminMenu().setVisible(true);
            }
        } catch (Exception ex) {
        	 JOptionPane.showMessageDialog(null, "An SQL exception occurred: " + ex.getMessage(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
            
        }
    }

  
  
    public static void main(String[] args) {
   
    	 try {
    	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    	            if ("Nimbus".equals(info.getName())) {
    	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
    	                break;
    	            }
    	        }
    	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
    	        java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	    }
    
    	 java.awt.EventQueue.invokeLater(() -> 
    		    new SignIn().setVisible(true));
    		

    }
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JComboBox<String> jComboBox1;

}
