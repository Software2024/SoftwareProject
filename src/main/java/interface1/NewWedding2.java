package interface1;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import softwareproject.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class NewWedding2 extends javax.swing.JFrame {
	transient Event event1 = Event.getInstance();
	private DefaultTableModel model1;
	private int capacity;
	private String theme;
	private DefaultTableModel model2;
	private DefaultTableModel model3;
	private DefaultTableModel model4;
	private transient User currentUser;
    private int ssn;
    private  int serial;
    final String Error ="Error";
   	final String massage ="Invalid input. Please enter a valid integer value.";
    final String UNBOOK ="UNBOOK";
	final String FONT_NAME = "Leelawadee";
	final String PriceLimit="TELL US YOUR PRICE LIMIT\n";
	final String Show="SHOW ALL";
	final String Number="NUMBER";
	final String Price="PRICE";
	final String Booked="BOOKED";
	final String Filter="FILTERED TO YOUR SELECTION ";
    public NewWedding2() {
    	setMinimumSize(new Dimension(860, 680));
        initComponents();
           setLocationRelativeTo(null);
           serial = event1.getSerial();
           currentUser =User.getInstance();
           ssn = currentUser.getSSN();
           theme=event1.getTheme();
      	 ven = new Venue();
      	 std = new Studio();
      	 dj = new Dj();
      	 dec = new Decoration();
      	 cater = new Cater();
          city = event1.getCity();
          date =  event1.getDate();
          capacity = event1.getGuest();
          price = 0;
  }

                      
    @SuppressWarnings("deprecation")
	private void initComponents() {
    	

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(e -> {
            model1 = (DefaultTableModel) jTable1.getModel();
            ven.refreshVenue(model1, city, date, price, capacity, serial);
        });

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(e -> {
            int selectedRowIndex = jTable1.getSelectedRow();
            actionPerformedAdd(selectedRowIndex, "venue");
        });

        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton5.addActionListener(e -> {
            model2 = (DefaultTableModel) jTable2.getModel();
            dec.refreshDec(model2, city, date, price, theme, serial);
        });

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton6.addActionListener(this::jButton6ActionPerformed);

        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton8.addActionListener(e -> {
            int selectedRowIndex = jTable2.getSelectedRow();
            actionPerformedAdd(selectedRowIndex, "decoration");
        });

        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton9.addActionListener(e -> {
            model3 = (DefaultTableModel) jTable3.getModel();
            dj.refreshDj(model3, city, date, price, serial);
        });

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton10.addActionListener(this::jButton10ActionPerformed);
        	
      
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton12.addActionListener(e -> {
            int selectedRowIndex = jTable3.getSelectedRow();
            actionPerformedAdd(selectedRowIndex, "dj");
        });

        	
    
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton13.addActionListener(e -> {
            model4 = (DefaultTableModel) jTable4.getModel();
            std.refreshStudio(model4, city, date, price, serial);
        });

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        	jButton14.addActionListener((e) -> {
        	    actionPerformed14();
        	});
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton16.addActionListener((ActionEvent e) -> {
            int selectedRowIndex = jTable4.getSelectedRow();
            actionPerformedAdd(selectedRowIndex, "studio");
        });

        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton17.addActionListener((ActionEvent e) -> {
            model5 = (DefaultTableModel) jTable5.getModel();
            cater.refreshCater(model5, city, date, price, serial);
        });

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton18.addActionListener((ActionEvent e) -> {
            model5 = (DefaultTableModel) jTable5.getModel();
            handleActionPerformed(model5);
        });

        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
    
        jButton20.addActionListener((ActionEvent e) -> {
            int selectedRowIndex = jTable5.getSelectedRow();
            actionPerformedAdd(selectedRowIndex, "cater");
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 243, 252));

        jTabbedPane1.setBackground(new java.awt.Color(238, 243, 252));
        jTabbedPane1.setForeground(new java.awt.Color(31, 89, 130));
        jTabbedPane1.setFont(new java.awt.Font(FONT_NAME, 3, 36)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        jPanel2.setBackground(new java.awt.Color(238, 243, 252));

        jLabel1.setFont(new java.awt.Font(FONT_NAME, 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 89, 130));
        jLabel1.setText(PriceLimit);

        jButton1.setBackground(new java.awt.Color(31, 89, 130));
        jButton1.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText(Show);

        jTable1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        			Number, "NAME",Price, "CAPACITY", "DESCRIPTION", "LOCATION", Booked
        	}
        ) {
        	@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
        	};
        	@Override
        	@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false, false
        	};
        	@Override
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        jLabel2.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(31, 89, 130));
        jLabel2.setText(Filter);

        jButton2.setBackground(new java.awt.Color(31, 89, 130));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setLabel("GO!");

        jButton3.setBackground(new java.awt.Color(31, 89, 130));
        jButton3.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("NEXT");
        jButton3.addActionListener(evt -> jButton3ActionPerformed());


        jButton4.setBackground(new java.awt.Color(31, 89, 130));
        jButton4.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("BOOK");
        
        JButton btnUnbook = new JButton();
        btnUnbook.addActionListener(e -> {
            int selectedRowIndex = jTable1.getSelectedRow();
            actionPerformedDelete(selectedRowIndex, "venue");
        });

        btnUnbook.setText(UNBOOK);
        btnUnbook.setForeground(Color.WHITE);
        btnUnbook.setFont(new Font(FONT_NAME, Font.BOLD, 14));
        btnUnbook.setBackground(new Color(31, 89, 130));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(142)
        			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(85)
        			.addComponent(btnUnbook, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(153))
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
        						.addGap(27)
        						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(52)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jLabel2)
        			.addGap(2)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addGap(49)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnUnbook, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addGap(17))
        );
        jPanel2.setLayout(jPanel2Layout);

        jTabbedPane1.addTab("VENUE", jPanel2);

        jPanel7.setBackground(new java.awt.Color(238, 243, 252));

        jLabel3.setFont(new java.awt.Font(FONT_NAME, 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 89, 130));
        jLabel3.setText(PriceLimit);

        jButton5.setBackground(new java.awt.Color(31, 89, 130));
        jButton5.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText(Show);

        jTable2.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        			Number, "NAME", "THEME", Price, "CITY",Booked
        	}
        ) {
        	@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
        	};
        	@SuppressWarnings({ "rawtypes", "unchecked" })
        	@Override
			public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false
        	};
        	@Override
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setHeaderValue("THEME");
        }

        jLabel4.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(31, 89, 130));
        jLabel4.setText(Filter);

        jButton6.setBackground(new java.awt.Color(31, 89, 130));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setLabel("GO!");

        jButton7.setBackground(new java.awt.Color(31, 89, 130));
        jButton7.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("NEXT");
        jButton7.addActionListener(evt -> jButton7ActionPerformed());


        jButton8.setBackground(new java.awt.Color(31, 89, 130));
        jButton8.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("BOOK");
        
        btnUnbook4 = new JButton();
        btnUnbook4.addActionListener(e -> {
            int selectedRowIndex = jTable2.getSelectedRow();
            actionPerformedDelete(selectedRowIndex, "decoration");
        });

        btnUnbook4.setText(UNBOOK);
        btnUnbook4.setForeground(Color.WHITE);
        btnUnbook4.setFont(new Font(FONT_NAME, Font.BOLD, 14));
        btnUnbook4.setBackground(new Color(31, 89, 130));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7Layout.setHorizontalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addGap(143)
        			.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(84)
        			.addComponent(btnUnbook4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
        			.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(154))
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)
        					.addGroup(jPanel7Layout.createSequentialGroup()
        						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
        						.addGap(27)
        						.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addGap(52)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jLabel4)
        			.addGap(2)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addGap(49)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnUnbook4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        			.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addGap(17))
        );
        jPanel7.setLayout(jPanel7Layout);

        jTabbedPane1.addTab("DECORATIONS", jPanel7);

        jPanel8.setBackground(new java.awt.Color(238, 243, 252));

        jLabel5.setFont(new java.awt.Font(FONT_NAME, 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(31, 89, 130));
        jLabel5.setText(PriceLimit);

        jButton9.setBackground(new java.awt.Color(31, 89, 130));
        jButton9.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText(Show);

        jTable3.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        			Number, "NAME", Price, "CITY",Booked
        	}
        ) {
        	@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Object.class, Object.class, Boolean.class
        	};
        	@SuppressWarnings({ "rawtypes", "unchecked" })
        	@Override
			public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false
        	};
        	@Override
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel6.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(31, 89, 130));
        jLabel6.setText(Filter);

        jButton10.setBackground(new java.awt.Color(31, 89, 130));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setLabel("GO!");

        jButton11.setBackground(new java.awt.Color(31, 89, 130));
        jButton11.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("NEXT");
        jButton11.addActionListener(evt -> jButton11ActionPerformed());


        jButton12.setBackground(new java.awt.Color(31, 89, 130));
        jButton12.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("BOOK");
        
        btnUnbook3 = new JButton();
        btnUnbook3.addActionListener(e -> {
            int selectedRowIndex = jTable3.getSelectedRow();
            actionPerformedDelete(selectedRowIndex, "dj");
        });

        btnUnbook3.setText(UNBOOK);
        btnUnbook3.setForeground(Color.WHITE);
        btnUnbook3.setFont(new Font(FONT_NAME, Font.BOLD, 14));
        btnUnbook3.setBackground(new Color(31, 89, 130));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8Layout.setHorizontalGroup(
        	jPanel8Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel8Layout.createSequentialGroup()
        			.addGap(126)
        			.addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(95)
        			.addComponent(btnUnbook3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
        			.addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(152))
        		.addGroup(jPanel8Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel8Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel8Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)
        					.addGroup(jPanel8Layout.createSequentialGroup()
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
        						.addGap(27)
        						.addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
        	jPanel8Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel8Layout.createSequentialGroup()
        			.addGap(52)
        			.addGroup(jPanel8Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jLabel6)
        			.addGap(2)
        			.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addGroup(jPanel8Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel8Layout.createSequentialGroup()
        					.addGap(49)
        					.addGroup(jPanel8Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        					.addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        					.addGap(17))
        				.addGroup(jPanel8Layout.createSequentialGroup()
        					.addGap(48)
        					.addComponent(btnUnbook3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel8.setLayout(jPanel8Layout);

        jTabbedPane1.addTab("DJ", jPanel8);

        jPanel9.setBackground(new java.awt.Color(238, 243, 252));

        jLabel7.setFont(new java.awt.Font(FONT_NAME, 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(31, 89, 130));
        jLabel7.setText(PriceLimit);

        jButton13.setBackground(new java.awt.Color(31, 89, 130));
        jButton13.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText(Show);

        jTable4.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, "", "", null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        			Number, "NAME",Price, "PACKAGE", "CITY",Booked
        	}
        ) {
        	@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
        		Integer.class, String.class, Integer.class, String.class, String.class, Boolean.class
        	};
        	@SuppressWarnings({ "rawtypes", "unchecked" })
        	@Override
			public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false
        	};
        	@Override
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel8.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(31, 89, 130));
        jLabel8.setText(Filter);

        jButton14.setBackground(new java.awt.Color(31, 89, 130));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setLabel("GO!");

        jButton15.setBackground(new java.awt.Color(31, 89, 130));
        jButton15.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("NEXT");
        jButton15.addActionListener(evt -> jButton15ActionPerformed());


        jButton16.setBackground(new java.awt.Color(31, 89, 130));
        jButton16.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("BOOK");
        
        btnUnbook2 = new JButton();
        btnUnbook2.addActionListener(e -> {
            int selectedRowIndex = jTable4.getSelectedRow();
            actionPerformedDelete(selectedRowIndex, "studio");
        });

        btnUnbook2.setText(UNBOOK);
        btnUnbook2.setForeground(Color.WHITE);
        btnUnbook2.setFont(new Font(FONT_NAME, Font.BOLD, 14));
        btnUnbook2.setBackground(new Color(31, 89, 130));
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9Layout.setHorizontalGroup(
        	jPanel9Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addGap(125)
        			.addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
        			.addComponent(btnUnbook2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(84)
        			.addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(167))
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel9Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel9Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)
        					.addGroup(jPanel9Layout.createSequentialGroup()
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
        						.addGap(27)
        						.addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        					.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
        	jPanel9Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addGap(52)
        			.addGroup(jPanel9Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jLabel8)
        			.addGap(2)
        			.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addGap(49)
        			.addGroup(jPanel9Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel9Layout.createSequentialGroup()
        					.addGroup(jPanel9Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        					.addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        					.addGap(17))
        				.addGroup(jPanel9Layout.createSequentialGroup()
        					.addComponent(btnUnbook2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel9.setLayout(jPanel9Layout);

        jTabbedPane1.addTab("STUDIO", jPanel9);

        jPanel10.setBackground(new java.awt.Color(238, 243, 252));

        jLabel9.setFont(new java.awt.Font(FONT_NAME, 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(31, 89, 130));
        jLabel9.setText(PriceLimit);

        jButton17.setBackground(new java.awt.Color(31, 89, 130));
        jButton17.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText(Show);

        jTable5.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        			Number, "NAME",Price, "PACKAGE", Booked
        	}
        ) {
        	@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Object.class, Object.class, Boolean.class
        	};
        	@SuppressWarnings({ "rawtypes", "unchecked" })
        	@Override
			public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false
        	};
        	@Override
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel10.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(31, 89, 130));
        jLabel10.setText(Filter);

        jButton18.setBackground(new java.awt.Color(31, 89, 130));
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setLabel("GO!");

        jButton19.setBackground(new java.awt.Color(31, 89, 130));
        jButton19.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("DONE");
        jButton19.addActionListener(evt -> jButton19ActionPerformed());


        jButton20.setBackground(new java.awt.Color(31, 89, 130));
        jButton20.setFont(new java.awt.Font(FONT_NAME, 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("BOOK");
        
        btnUnbook1 = new JButton();
        btnUnbook1.addActionListener(e -> {
            int selectedRowIndex = jTable5.getSelectedRow();
            actionPerformedDelete(selectedRowIndex, "cater");
        });

        btnUnbook1.setText(UNBOOK);
        btnUnbook1.setForeground(Color.WHITE);
        btnUnbook1.setFont(new Font(FONT_NAME, Font.BOLD, 14));
        btnUnbook1.setBackground(new Color(31, 89, 130));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10Layout.setHorizontalGroup(
        	jPanel10Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel10Layout.createSequentialGroup()
        			.addGap(112)
        			.addComponent(jButton20, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(88)
        			.addComponent(btnUnbook1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
        			.addComponent(jButton17, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addGap(168))
        		.addGroup(jPanel10Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel10Layout.createSequentialGroup()
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
        					.addGap(27)
        					.addComponent(jButton18, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(jButton19, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
        	jPanel10Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel10Layout.createSequentialGroup()
        			.addGap(52)
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton18, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jLabel10)
        			.addGap(2)
        			.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addGap(49)
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel10Layout.createSequentialGroup()
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton20, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton17, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        					.addGap(26)
        					.addComponent(jButton19, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnUnbook1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        			.addGap(51))
        );
        jPanel10.setLayout(jPanel10Layout);

        jTabbedPane1.addTab("CATERER", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("VENUE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jTabbedPane1.addChangeListener(evt -> jTabbedPane1StateChanged());

    }
  
    private void jTabbedPane1StateChanged() {                                           
     
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        displayInfo(selectedIndex);
    }     
    void displayInfo(int selectedIndex) {
     
        switch(selectedIndex) {
            case 0:
                model1 = (DefaultTableModel) jTable1.getModel();
                 ven.refreshVenue(model1,city,date,price,capacity,serial);    
                break;
            case 1:
            	 model2 = (DefaultTableModel) jTable2.getModel();
                 dec.refreshDec(model2,city,date,price,theme,serial);    
                break;
            case 2:
            	 model3 = (DefaultTableModel) jTable3.getModel();
            	 dj.refreshDj(model3,city,date,price,serial);   
                break;
            case 3:
            	 model4 = (DefaultTableModel) jTable4.getModel();
                 std.refreshStudio(model4,city,date,price,serial);  
                break;
            case 4:
           	 model5 = (DefaultTableModel) jTable5.getModel();
                 cater.refreshCater(model5,city,date,price,serial);   
            default:
              
                System.out.println("Invalid selectedIndex");
                break;
            
        }

        pack();
    }        
  
private int skip (JTabbedPane tabbedPane){
       int currentIndex = tabbedPane.getSelectedIndex();
                int nextIndex = (currentIndex + 1) % tabbedPane.getTabCount(); 
                tabbedPane.setSelectedIndex(nextIndex);
                return nextIndex;
            }

    private void jButton3ActionPerformed() {                                         
       skip (jTabbedPane1);
    }                                        

    private void jButton7ActionPerformed() {                                         
          skip (jTabbedPane1);
    }                                        

    private void jButton11ActionPerformed() {                                          
       skip (jTabbedPane1);
    }                                         

    private void jButton15ActionPerformed() {                                          
          skip (jTabbedPane1);
          
    }                                         
    
    private void jButton19ActionPerformed() {       
    	
        dispose();
        if (currentUser.isAdmin(ssn)) {
        	 new AdminMenu().setVisible(true);
        	 
        }else {
        	 new MenuUser().setVisible(true);
        }
       
    }        
    public void actionPerformedAdd(int selectedRowIndex, String serviceType) {
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(null,"Please select a row", Error, JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = null;
        model= getModel( serviceType);
        if (model == null) {
            return;
        }
        int serviceNumber = (int) model.getValueAt(selectedRowIndex,0);
        int price1 = (int) model.getValueAt(selectedRowIndex, serviceType.equals("decoration") ? 3 : 2);

        boolean x = event1.editEvent(serial, serviceNumber, serviceType, price1);
        refreshTables(x,model,serviceType);
    }
    public void refreshTables(boolean x, DefaultTableModel model, String serviceType) {
        if (!x) {
            return;
        }

        switch (serviceType) {
            case "venue":
                ven.refreshVenue(model, city, date, price, capacity, serial);
                break;
            case "decoration":
                dec.refreshDec(model, city, date, price, theme, serial);
                break;
            case "dj":
                dj.refreshDj(model, city, date, price, serial);
                break;
            case "studio":
                std.refreshStudio(model, city, date, price, serial);
                break;
            case "cater":
                cater.refreshCater(model, city, date, price, serial);
                break;
            default:
                break;
        }
    }

   public DefaultTableModel getModel( String serviceType) {
	   DefaultTableModel model = null;
       switch(serviceType) {
           case "venue":
               model = (DefaultTableModel) jTable1.getModel();
               break;
           case "decoration":
               model = (DefaultTableModel) jTable2.getModel();
               break;
           case "dj":
           	model=(DefaultTableModel) jTable3.getModel();
           	break;
           case "studio":
        	   model = (DefaultTableModel) jTable4.getModel();
        	   break;
           case "cater":
           	 model = (DefaultTableModel) jTable5.getModel();
           	 break;
           default:
               break;
       }
           return model;
   }
   public void actionPerformedDelete(int selectedRowIndex, String serviceType) {
       if (selectedRowIndex == -1) {
           JOptionPane.showMessageDialog(null,"Please select a row",Error, JOptionPane.ERROR_MESSAGE);
           return;
       }
       DefaultTableModel model = null;
       model= getModel( serviceType);
       if (model == null) {
           return;
       }
       int serviceNumber = (int) model.getValueAt(selectedRowIndex,0);
       int price1 = (int) model.getValueAt(selectedRowIndex, serviceType.equals("decoration") ? 3 : 2);

       boolean x = event1.deleteFromEvent(serial, serviceNumber, serviceType, price1);
       refreshTables(x,model,serviceType);
   }
   private void jButton2ActionPerformed(ActionEvent e) {
	   try {
           model1 = (DefaultTableModel) jTable1.getModel();
           int price11 = Integer.parseInt(jTextField1.getText());
           ven.refreshVenue(model1, city, date, price11, capacity, serial);
       } catch (NumberFormatException ex) {
          // ex.printStackTrace(); 
           JOptionPane.showMessageDialog(null,massage, Error, JOptionPane.ERROR_MESSAGE);
       }
   }
   private void jButton6ActionPerformed(ActionEvent e) {
	    try {
	        model2 = (DefaultTableModel) jTable2.getModel();
	        int price12 = Integer.parseInt(jTextField2.getText());
	        dec.refreshDec(model2, city, date, price12, theme, serial);
	    } catch (NumberFormatException ex) {
	      //  ex.printStackTrace(); 
	        JOptionPane.showMessageDialog(null, massage, Error, JOptionPane.ERROR_MESSAGE);
	    }
	}
   private void jButton10ActionPerformed(ActionEvent e) {
	    try {
	        model3 = (DefaultTableModel) jTable3.getModel();
	        int price13 = Integer.parseInt(jTextField3.getText());
	        dj.refreshDj(model3, city, date, price13, serial);
	    } catch (NumberFormatException ex) {
	      //  ex.printStackTrace(); 
	        JOptionPane.showMessageDialog(null, massage, Error, JOptionPane.ERROR_MESSAGE);
	    }
	}
   private void actionPerformed14() {
	    try {
	        int price14 = Integer.parseInt(jTextField4.getText());
	        model4 = (DefaultTableModel) jTable4.getModel();
	        std.refreshStudio(model4, city, date, price14, serial);
	    } catch (NumberFormatException ex) {
	      //  ex.printStackTrace(); 
	        JOptionPane.showMessageDialog(null, massage, Error, JOptionPane.ERROR_MESSAGE);
	    }
	}
   private void handleActionPerformed(DefaultTableModel model5) {
	    try {
	        int price15 = Integer.parseInt(jTextField5.getText());
	        cater.refreshCater(model5, city, date,price15, serial);
	    } catch (NumberFormatException ex) {
	      //  ex.printStackTrace(); 
	        JOptionPane.showMessageDialog(null, massage, "Error", JOptionPane.ERROR_MESSAGE);
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
		        java.util.logging.Logger.getLogger(NewWedding2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		    }
   
       
		    java.awt.EventQueue.invokeLater(() -> {
		        new NewWedding2().setVisible(true);
		    });

    }

                
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
	private String city;
	private Date date;
	private int price;
	private transient Cater cater;
	private transient Decoration dec;
	private transient Dj dj;
	private transient Venue ven;
	private transient Studio std;
	private DefaultTableModel model5;
	private JButton btnUnbook1;
	private JButton btnUnbook2;
	private JButton btnUnbook3;
	private JButton btnUnbook4;
	
}
