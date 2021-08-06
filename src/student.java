
import static java.lang.Class.forName;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

public class student extends javax.swing.JFrame {
   
    public student() {
        initComponents();
        connection();
        list();
        info();
    }
    
    Connection sqlConn;
    PreparedStatement pst;
    ResultSet rs ;
    DefaultTableModel tm;
   
    public void connection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void list()
    {
        int e;
        jbtncombo.removeAllItems();
        try {
            pst =sqlConn.prepareStatement("select * from stulis");
            rs=pst.executeQuery(); 
            
             ResultSetMetaData rsd =rs.getMetaData();
             e =rsd.getColumnCount();
            
            tm=( DefaultTableModel)jTable1. getModel();
            tm.setRowCount(0);
            while (rs.next())
            {
                Vector v =new Vector();
                for(int i=1;i<=e;i++);
                {
                    v.add(rs.getString("list_sr"));
                    v.add(rs.getString("list_id"));
                    v.add(rs.getString("list_name"));
                    v.add(rs.getString("list_ph"));
                    v.add(rs.getString("list_dep"));
                    
                }
                jbtncombo.addItem(rs.getString("list_id"));
                tm.addRow(v);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void info()
    {
        int e;
        try {
            pst =sqlConn.prepareStatement("select * from stuinfo");
            rs=pst.executeQuery(); 
            
             ResultSetMetaData rsd =rs.getMetaData();
             e =rsd.getColumnCount();
            
            tm=( DefaultTableModel)jTable2. getModel();
            tm.setRowCount(0);
            while (rs.next())
            {
                Vector v1 =new Vector();
                for(int i=1;i<=e;i++);
                {
                    v1.add(rs.getString("info_sr"));
                    v1.add(rs.getString("info_id"));
                    v1.add(rs.getString("info_tri"));
                    v1.add(rs.getString("info_cgpa"));
                    
                }
                tm.addRow(v1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lid = new javax.swing.JTextField();
        lna = new javax.swing.JTextField();
        lph = new javax.swing.JTextField();
        lde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtnexit = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbtnupdate = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jbtnseana = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbtnadd2 = new javax.swing.JButton();
        jbtndel2 = new javax.swing.JButton();
        jbtnexit2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        intri = new javax.swing.JTextField();
        incgpa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jbtnupdate2 = new javax.swing.JButton();
        jbtnseid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbtncombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane3.setBackground(new java.awt.Color(0, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Student Id", "Name", "Phone no", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Student Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Phone no");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Department");

        jbtnexit.setBackground(new java.awt.Color(204, 0, 153));
        jbtnexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnexit.setForeground(new java.awt.Color(255, 255, 255));
        jbtnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cross-icon.png"))); // NOI18N
        jbtnexit.setText("EXIT");
        jbtnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnexitMouseClicked(evt);
            }
        });
        jbtnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnexitActionPerformed(evt);
            }
        });

        btndel.setBackground(new java.awt.Color(204, 0, 153));
        btndel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndel.setForeground(new java.awt.Color(255, 255, 255));
        btndel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/page-text-delete-icon.png"))); // NOI18N
        btndel.setText("DELETE");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Arrow-Right-icon.png"))); // NOI18N
        jButton4.setText("NEXT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jbtnupdate.setBackground(new java.awt.Color(255, 0, 153));
        jbtnupdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnupdate.setForeground(new java.awt.Color(255, 255, 255));
        jbtnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil-add-icon.png"))); // NOI18N
        jbtnupdate.setText("UPDATE");
        jbtnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnupdateActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(204, 0, 102));
        btnadd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Female-user-add-icon.png"))); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jbtnseana.setBackground(new java.awt.Color(255, 51, 102));
        jbtnseana.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jbtnseana.setText("    SEARCH NAME....");
        jbtnseana.setBorder(new javax.swing.border.MatteBorder(null));
        jbtnseana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnseanaMouseClicked(evt);
            }
        });
        jbtnseana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbtnseanaKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Groups-Rescuers-Light-icon.png"))); // NOI18N
        jLabel9.setText("STUDENT LIST");

        jButton1.setBackground(new java.awt.Color(204, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Very-Basic-Full-Trash-icon.png"))); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lna, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lph, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lde, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbtnseana))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnupdate)
                .addGap(18, 18, 18)
                .addComponent(jbtnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jbtnseana, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lna, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lph, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lde, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jTabbedPane3.addTab("Student List", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        jbtnadd2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnadd2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnadd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Female-user-add-icon.png"))); // NOI18N
        jbtnadd2.setText("ADD");
        jbtnadd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnadd2ActionPerformed(evt);
            }
        });

        jbtndel2.setBackground(new java.awt.Color(255, 255, 255));
        jbtndel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtndel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/page-text-delete-icon.png"))); // NOI18N
        jbtndel2.setText("DELETE");
        jbtndel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtndel2ActionPerformed(evt);
            }
        });

        jbtnexit2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnexit2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnexit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cross-icon.png"))); // NOI18N
        jbtnexit2.setText("EXIT");
        jbtnexit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnexit2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back-icon.png"))); // NOI18N
        jButton8.setText("BACK");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Id");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Trimester");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CGPA");

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Student Id", "Trimester", "CGPA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jbtnupdate2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnupdate2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnupdate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil-add-icon.png"))); // NOI18N
        jbtnupdate2.setText("UPDATE");
        jbtnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnupdate2ActionPerformed(evt);
            }
        });

        jbtnseid.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jbtnseid.setText("   SEARCH ID.....");
        jbtnseid.setBorder(new javax.swing.border.MatteBorder(null));
        jbtnseid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnseidMouseClicked(evt);
            }
        });
        jbtnseid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbtnseidKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Female-user-info-icon.png"))); // NOI18N
        jLabel10.setText("    Student Information");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Very-Basic-Full-Trash-icon.png"))); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnseid)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jbtnadd2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jbtnupdate2)
                                .addGap(27, 27, 27)
                                .addComponent(jbtnexit2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jbtndel2)
                                .addGap(88, 88, 88))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbtncombo, 0, 148, Short.MAX_VALUE)
                                    .addComponent(intri)
                                    .addComponent(incgpa))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jbtnseid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtncombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(intri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(incgpa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnexit2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnadd2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtndel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnupdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        jTabbedPane3.addTab("Student Info", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel6.setText("TASPIYA ALAM");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel11.setText("Chayan deb nath");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel12.setText("Shahidullah kaiser ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel13.setText("PORT CITY INTERNATIONAL UNIVERSITY");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel14.setText("Department Of Computer Science & engineering");

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel15.setText("CSE 20th Batch");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("About", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private JFrame frame;
    private void jbtnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnexitActionPerformed
        frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"confirm if you want to exit","student management system",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
        System.exit(0);
    }
    }//GEN-LAST:event_jbtnexitActionPerformed

    private void jbtnexit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnexit2ActionPerformed
        frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"confirm if you want to exit","student management system",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
        System.exit(0);
    }
    }//GEN-LAST:event_jbtnexit2ActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        try  {
            tm =(DefaultTableModel)jTable1.getModel();
        int index= jTable1.getSelectedRow();
        
        String se=tm.getValueAt(index, 0).toString();
         pst = sqlConn.prepareStatement("delete from stulis where list_sr=?");
         pst.setString(1,se);
         pst.executeUpdate();
         JOptionPane.showMessageDialog(this,"Student Record Deleted");
         btnadd.setEnabled(true);
             
             lid.setText("");
             lna.setText("");
             lph.setText("");
             lde.setText("");
             list();
             
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndelActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            String id = lid.getText();
            String name = lna.getText();
            String phone = lph.getText();
            String department = lde.getText();
             pst = sqlConn.prepareStatement("insert into stulis(list_id,list_name,list_ph,list_dep) values(?,?,?,?)");
             pst.setString(1, id);
             pst.setString(2, name);
             pst.setString(3, phone);
             pst.setString(4, department);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"student record added");
             
             lid.setText("");
             lna.setText("");
             lph.setText("");
             lde.setText("");
             list();

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_btnaddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tm =(DefaultTableModel)jTable1.getModel();
        int index= jTable1.getSelectedRow();
        
        
        String se=tm.getValueAt(index, 0).toString();
        lid.setText(tm.getValueAt(index, 1).toString());
        lna.setText(tm.getValueAt(index, 2).toString());
        lph.setText(tm.getValueAt(index, 3).toString());
        lde.setText(tm.getValueAt(index, 4).toString());
        
        btnadd.setEnabled(false);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtnadd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnadd2ActionPerformed
        try {
            String id = (String) jbtncombo.getSelectedItem();
            String trimester = intri.getText();
            String cgpa = incgpa.getText();
             pst = sqlConn.prepareStatement("insert into stuinfo(info_id,info_tri,info_cgpa) values(?,?,?)");
             pst.setString(1, id);
             pst.setString(2, trimester);
             pst.setString(3, cgpa);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"student record added");
             
            jbtncombo.setSelectedIndex(-1);
             intri.setText("");
             incgpa.setText("");
             info();

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jbtnadd2ActionPerformed

    private void jbtnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnexitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnexitMouseClicked

    private void jbtnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnupdateActionPerformed
    try {
            tm =(DefaultTableModel)jTable1.getModel();
            int index= jTable1.getSelectedRow();
        
            String se=tm.getValueAt(index, 0).toString();
            
            String id = lid.getText();
            String name = lna.getText();
            String phone = lph.getText();
            String department = lde.getText();
            pst = sqlConn.prepareStatement("update stulis set list_id=?,list_name=?,list_ph=?,list_dep=? where list_sr=?");
             
             pst.setString(1, id);
             pst.setString(2, name);
             pst.setString(3, phone);
             pst.setString(4, department);
             pst.setString(5, se);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"student record edited");
             
             lid.setText("");
             lna.setText("");
             lph.setText("");
             lde.setText("");
             list();

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtnupdateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            
        jTabbedPane3.setSelectedIndex(1);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        jTabbedPane3.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jbtndel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtndel2ActionPerformed
        try  {
            tm =(DefaultTableModel)jTable2.getModel();
        int index= jTable2.getSelectedRow();
        
        String se=tm.getValueAt(index, 0).toString();
         pst = sqlConn.prepareStatement("delete from stuinfo where info_sr=?");
         pst.setString(1,se);
         pst.executeUpdate();
         JOptionPane.showMessageDialog(this,"Student Record Deleted");
         btnadd.setEnabled(true);
             
            jbtncombo.setSelectedIndex(-1);
             intri.setText("");
             incgpa.setText("");
             info();
             
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtndel2ActionPerformed

    private void jbtnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnupdate2ActionPerformed
      try {
            tm =(DefaultTableModel)jTable2.getModel();
            int index= jTable2.getSelectedRow();
        
            String se=tm.getValueAt(index, 0).toString();
            
            String id = (String) jbtncombo.getSelectedItem();
             String trimester = intri.getText();
            String cgpa = incgpa.getText();
            pst = sqlConn.prepareStatement("update stuinfo set info_id=?,info_tri=?,info_cgpa=? where info_sr=?");
             
             pst.setString(1, id);
             pst.setString(2, trimester);
             pst.setString(3, cgpa);
             pst.setString(4, se);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"student record edited");
             
             jbtncombo.setSelectedIndex(-1);
             intri.setText("");
             incgpa.setText("");
             info();

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnupdate2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        tm =(DefaultTableModel)jTable2.getModel();
        int index= jTable2.getSelectedRow();
        
        
        String se=tm.getValueAt(index, 0).toString();
       jbtncombo.setSelectedItem(tm.getValueAt(index, 1).toString());
        intri.setText(tm.getValueAt(index, 2).toString());
        incgpa.setText(tm.getValueAt(index, 3).toString());
        
        jbtnadd2.setEnabled(false);  
    }//GEN-LAST:event_jTable2MouseClicked

    private void jbtnseanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnseanaMouseClicked
       jbtnseana.setText("");
    }//GEN-LAST:event_jbtnseanaMouseClicked

    private void jbtnseanaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnseanaKeyReleased
         String sn =jbtnseana.getText();
       
        try {
            String qu = "Select * from stulis where list_name LIKE'%"+sn+"%'";
            pst=sqlConn.prepareStatement(qu);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       } catch (Exception e) {
           
           JOptionPane.showMessageDialog(null, e);
        }
        finally{
             try{
                 if(pst!=null){
                     rs.close();
                     pst.close();
                 }
             }
             catch(Exception e){
             }
        }
    }//GEN-LAST:event_jbtnseanaKeyReleased

    private void jbtnseidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnseidKeyReleased
         String sn =jbtnseid.getText();
       
        try {
            String qu = "Select * from stuinfo where info_id LIKE '%"+sn+"%'";
            pst=sqlConn.prepareStatement(qu);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
       } catch (Exception e) {
           
           JOptionPane.showMessageDialog(null, e);
        }
        finally{
             try{
                 if(pst!=null){
                     rs.close();
                     pst.close();
                 }
             }
             catch(Exception e){
             }
        }
    }//GEN-LAST:event_jbtnseidKeyReleased

    private void jbtnseidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnseidMouseClicked
        jbtnseid.setText("");
    }//GEN-LAST:event_jbtnseidMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnadd.setEnabled(true);
             lid.setText("");
             lna.setText("");
             lph.setText("");
             lde.setText("");
             list();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           jbtnadd2.setEnabled(true);
           jbtncombo.setSelectedIndex(-1);
             intri.setText("");
             incgpa.setText("");
             info(); 
             
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndel;
    private javax.swing.JTextField incgpa;
    private javax.swing.JTextField intri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtnadd2;
    private javax.swing.JComboBox<String> jbtncombo;
    private javax.swing.JButton jbtndel2;
    private javax.swing.JButton jbtnexit;
    private javax.swing.JButton jbtnexit2;
    private javax.swing.JTextField jbtnseana;
    private javax.swing.JTextField jbtnseid;
    private javax.swing.JButton jbtnupdate;
    private javax.swing.JButton jbtnupdate2;
    private javax.swing.JTextField lde;
    private javax.swing.JTextField lid;
    private javax.swing.JTextField lna;
    private javax.swing.JTextField lph;
    // End of variables declaration//GEN-END:variables
}
