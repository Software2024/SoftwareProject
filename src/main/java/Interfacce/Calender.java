package Interfacce;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;


import softwareProject1.User;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Calender extends javax.swing.JFrame {

	private User currentUser;
	private Map<Date, String> eventsMap;
	private int ssn;
	JCalendar calendar = new JCalendar();
    public Calender() {
        initComponents();
         setLocationRelativeTo(null);
         currentUser = User.getInstance();
       ssn= currentUser.getSSN();
       eventsMap = new HashMap<>();
       
       List<Object[]> eventData = currentUser.retrieveEvents(ssn,currentUser.isAdmin(ssn));
       for (Object[] row : eventData) {
           Date eventDate = (Date) row[3]; 
           String eventInfo = "Event Number: " + row[0] + "\n" +
                              "Bride: " + row[1] + "\n" +
                              "Groom: " + row[2] + "\n" +
                              "Date: " + row[3] + "\n" +
                              "Total Cost: " + row[4] + "\n" +
                              "Budget: " + row[5] + "\n" +
                              "Theme: " + row[6] + "\n" +
                              "Location: " + row[7] + "\n" +
                              "Guest Count: " + row[8];
           eventsMap.put(eventDate, eventInfo);
       }
       updateCalendarEvents();
       
   }
    
   
                           
    private void initComponents() {
    	 
         
    	        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(860, 680));

        jPanel1.setBackground(new java.awt.Color(238, 243, 252));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 89, 130));
        jLabel1.setText("UPCOMING EVENTS");
        
        
        calendar.getDayChooser().setSundayForeground(new Color(0, 255, 255));
        calendar.getDayChooser().setDecorationBackgroundColor(SystemColor.activeCaption);
        calendar.getDayChooser().setBackground(Color.BLUE);
        
        JButton btnMenu = new JButton();
        btnMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		if (currentUser.isAdmin(ssn)) {
        			new admin_menu().setVisible(true);
        		}else {
        		new menu_user().setVisible(true);
        		}
        	}
        });
        btnMenu.setText("MENU");
        btnMenu.setForeground(Color.WHITE);
        btnMenu.setFont(new Font("Leelawadee", Font.PLAIN, 16));
        btnMenu.setBackground(new Color(31, 89, 130));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(btnMenu)
        					.addGap(158)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(81)
        					.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    void updateCalendarEvents() {
    	
        for (Date eventDate : eventsMap.keySet()) {
            calendar.getDayChooser().addDateEvaluator(new IDateEvaluator() {
                @Override
                public boolean isSpecial(Date date) {
                    Calendar cal1 = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();
                    cal1.setTime(eventDate);
                    cal2.setTime(date);
                    return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                           cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                           cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
                }

                @Override
                public Color getSpecialForegroundColor() {
                    return Color.RED; 
                }

                @Override
                public Color getSpecialBackroundColor() {
                    return null; // You can set background color if needed
                }

				@Override
				public Color getInvalidBackroundColor() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Color getInvalidForegroundColor() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getInvalidTooltip() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getSpecialTooltip() {
					
					return eventsMap.get(eventDate);
				}

				@Override
				public boolean isInvalid(Date arg0) {
					// TODO Auto-generated method stub
					return false;
				}
            });
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
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calender().setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}