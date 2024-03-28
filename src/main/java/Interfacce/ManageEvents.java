package Interfacce;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import softwareProject1.Event;
import softwareProject1.User;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageEvents extends javax.swing.JFrame {

   
    public ManageEvents() {
    	 
        initComponents();
        setLocationRelativeTo(null);
    }

                        
    private void initComponents() {
    	
	        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Event event =  Event.getInstance();
        		
            	 int selectedRowIndex = jTable1.getSelectedRow();
        		    if (selectedRowIndex == -1) {
        		    	 JOptionPane.showMessageDialog(null, "please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        		     
        		    }else {
        		    	DefaultTableModel  model1=(DefaultTableModel) jTable1.getModel();

           		    	int serial=(int) model1.getValueAt(selectedRowIndex, 0);
           		 	String city= (String) model1.getValueAt(selectedRowIndex, 7); 
           			String theme= (String) model1.getValueAt(selectedRowIndex, 6);
           			int guests=(int) model1.getValueAt(selectedRowIndex, 8);
           			Date date= (Date) model1.getValueAt(selectedRowIndex, 3);
            	 event.setSerial(serial);
            	 event.setCity(city);
            	 event.setTheme(theme);
            	 event.setGuest(guests);
            	 event.setDate(date);
        		   dispose();
   	            new_wedding2 instance = new new_wedding2();
   	            instance.setVisible(true);
   	            instance.displayInfo(0);
        		 
        	}
        	}
        });
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Event event =  Event.getInstance();
         		
            	 int selectedRowIndex = jTable1.getSelectedRow();
        		    if (selectedRowIndex == -1) {
        		    	 JOptionPane.showMessageDialog(null, "please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        		     
        		    }else {
        		    	DefaultTableModel  model1=(DefaultTableModel) jTable1.getModel();
        		    	int serial=(int) model1.getValueAt(selectedRowIndex, 0);
        		    	event.deleteEvent(serial);
        		    	showTable();
        		    }
        	}
        });
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Budget budget =new Budget();
        		 Event event =  Event.getInstance();
          		
            	 int selectedRowIndex = jTable1.getSelectedRow();
        		    if (selectedRowIndex == -1) {
        		    	 JOptionPane.showMessageDialog(null, "please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        		     
        		    }else {
        		    	DefaultTableModel  model1=(DefaultTableModel) jTable1.getModel();
        		    	int serial=(int) model1.getValueAt(selectedRowIndex, 0);
        		    	DefaultTableModel  model2=(DefaultTableModel) budget.jTable1.getModel();
        		    	String x=event.retrieveEventData(model2, serial);
        		    	budget.textArea1.setText(x);
        		    	dispose();
        		    	budget.setVisible(true);
        		    }
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 243, 252));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 89, 130));
        jLabel1.setText("YOUR EVENTS");

        jTable1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"NUMBER", "BRIDE", "GROOM", "DATE", "TOTAL COST", "BUDGET", "THEME", "CITY", "GUESTS"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, true, true, true, true, true, true, true, true
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(31, 89, 130));
        jButton1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EDIT SREVICES");

        jButton2.setBackground(new java.awt.Color(31, 89, 130));
        jButton2.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("MENU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(31, 89, 130));
        jButton3.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");

        jButton4.setBackground(new java.awt.Color(31, 89, 130));
        jButton4.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("BUDGET");
        
        JButton btnSaveEdit = new JButton();
        btnSaveEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  Event event = Event.getInstance();
        		    int selectedRowIndex = jTable1.getSelectedRow();
        		    if (selectedRowIndex == -1) {
        		        JOptionPane.showMessageDialog(null, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        		    } else {
        		        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        		        int serial = (int) model1.getValueAt(selectedRowIndex, 0);
        		        String brideName = (String) model1.getValueAt(selectedRowIndex, 1);
        		        String groomName = (String) model1.getValueAt(selectedRowIndex, 2);
        		        String StringDate=(String) model1.getValueAt(selectedRowIndex, 3); 
        		        Date date = Date.valueOf(StringDate);
        		        int budget = (int) model1.getValueAt(selectedRowIndex, 5);
        		        String theme = (String) model1.getValueAt(selectedRowIndex, 6);
        		        String city = (String) model1.getValueAt(selectedRowIndex, 7);
        		        int guests = (int) model1.getValueAt(selectedRowIndex, 8);

        		        boolean x = event.editEventInfo(serial, brideName, groomName, budget, date, guests, theme, city);
        		        if (x) {
        		            JOptionPane.showMessageDialog(null, "Event details edited. Please go to edit services to book services again since your previous selection was deleted.");
        		            showTable();
        		        }
        		    }
        	}
        });
        btnSaveEdit.setText("SAVE DETAILS");
        btnSaveEdit.setForeground(Color.WHITE);
        btnSaveEdit.setFont(new Font("Leelawadee", Font.PLAIN, 14));
        btnSaveEdit.setBackground(new Color(31, 89, 130));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        					.addGap(165)
        					.addComponent(jLabel1))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(64)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(36)
        							.addComponent(btnSaveEdit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        							.addGap(68)
        							.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        							.addGap(57)
        							.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        							.addGap(16)))))
        			.addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(23)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
        			.addGap(41)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnSaveEdit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

      
        pack();
    }                    

    void showTable() {
    	 User currentUser = User.getInstance();
	        int ssn = currentUser.getSSN();
	     	DefaultTableModel  model1=(DefaultTableModel) jTable1.getModel();
	     	 List<Object[]> eventData= currentUser.retrieveEvents(ssn, false);
			 currentUser.populateTableModel( model1,eventData);
		
	}


	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	dispose();
       new menu_user().setVisible(true);
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
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageEvents().setVisible(true);
            }
        });
    }

                 
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}

