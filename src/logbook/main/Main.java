package logbook.main;

import java.awt.Component;
import logbook.form.Form_Dashboard;
import logbook.form.Form_Approval;
import logbook.form.Form_DataKaryawan;
import logbook.form.Form_DataVisitor;
import logbook.form.Form_Empty;
import logbook.menu.EventMenuSelected;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import java.sql.*;
import db.db;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import logbook.form.Form_DataMitra;
import logbook.form.Form_Laporan;
import logbook.form.Form_ListMitra;
import logbook.swing.ComboItem;



public class Main extends javax.swing.JFrame {
    
    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean  signIn;
    private String filename;
    
    private Connection conn = new db().connect();
     
    private static Main main;
    
    public Main() throws SQLException {
            
        initComponents();
        init();
        
         TimingTarget targetLogin = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    bgAnimation.setAnimate(fraction);
                } else {
                    bgAnimation.setAnimate(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn) {
                    panelAdmin.setVisible(false);
                    bgAnimation.setShowPaint(true);
                    panelBody.setAlpha(0);
                    panelBody.setVisible(true);
                    animatorBody.start();
                } else {
                    enableLogin(true);
                    admUsername.grabFocus();
                }
            }
        };
         
          TimingTarget targetBody = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    panelBody.setAlpha(fraction);
                } else {
                    panelBody.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn == false) {
                    panelBody.setVisible(false);
                    bgAnimation.setShowPaint(false);
                    bgAnimation.setAnimate(1);
                    main.setVisible(true);
                    animatorLogin.start();
                }
            }
        };
        
        animatorLogin = new Animator(2500, targetLogin);
        animatorBody = new Animator(500, targetBody);
        animatorLogin.setResolution(0);
        animatorBody.setResolution(0);
        
        hide();
        
        namavisitor();
        namainstansi();
        
 
 
   
        
        
    }
    
    private void init() {
        main = this;
        titleBar.initJFram(this);
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                // Dashboard 
                if (index == 0 && indexSubMenu == 0) {
                    showForm(new Form_Dashboard());
                } 
                
                // Approval Form
                else if (index == 1 && indexSubMenu == 0) {
                    showForm(new Form_Approval());
                }
                
                 else if (index == 2 && indexSubMenu == 0) {
                    showForm(new Form_DataVisitor());
                }
                 
                  else if (index == 3 && indexSubMenu == 0) {
                    showForm(new Form_DataKaryawan());
                }
                  
                  else if (index == 4 && indexSubMenu ==0 ) {
                    try {
                        showForm(new Form_DataMitra());
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  }
                  
                else if (index == 5 && indexSubMenu == 0) {
                    showForm(new Form_ListMitra());
                } 
                  
                else if (index == 6 && indexSubMenu == 0) {
                    showForm(new Form_Laporan());
                } 
                  
                  
                 
                   else if (index == 7 && indexSubMenu == 0) {
                    showForm(new Form_DataKaryawan());
                }
                  
                else {
                    showForm(new Form_Empty(index + " " + indexSubMenu));
                }
            }
        });
        menu.setSelectedIndex(0, 0);
        
       
    }
    
    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }
    
    public void signout(){
        
        animatorBody.start();
    }
    
    public static Main getMain() {
        return main;
    }
    
    public void hide(){
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitorBarang.setVisible(false);
        panelVisitor.setVisible(false);
        
        KeperluanLain.setVisible(false);
    }
    
    private void clear(){
           panelVisitorRegist.setVisible(false);
           panelUtama.setVisible(true);
           visitorNama.setText("");
           visitorEmail.setText("");
           visitorTelp.setText("");
           visitorAlamat.setText("");
           visitorInstansi.setSelectedItem(0);
           visitorKeperluan.setSelectedItem(0);
           
          
           visitorBarangSN.setText("");
           visitorJenisBarang.setSelectedItem(0);
    }
    
    public void logout(){
        signIn = false;
        animatorBody.start();
         String updatedata = "UPDATE admin SET status='loggout' WHERE username="+admUsername.getText()+"";

         try {
              PreparedStatement update = conn.prepareStatement(updatedata);
              update.execute();
                                
                                  
         }
         catch (SQLException ex) {
            Logger.getLogger(Form_Approval.class.getName()).log(Level.SEVERE, null, ex);
         }
        //main.setVisible(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgUtama = new javax.swing.JLabel();
        panelUtama = new javax.swing.JPanel();
        titleBar2 = new logbook.swing.titlebar.TitleBar();
        visitor = new javax.swing.JButton();
        admin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bgUtama2 = new javax.swing.JLabel();
        panelVisitor = new javax.swing.JPanel();
        titleBar5 = new logbook.swing.titlebar.TitleBar();
        RegistVisitor = new javax.swing.JButton();
        RegistBarang = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnBack = new logbook.swing.button();
        bgUtama5 = new javax.swing.JLabel();
        panelVisitorBarang = new javax.swing.JPanel();
        titleBar3 = new logbook.swing.titlebar.TitleBar();
        jLabel7 = new javax.swing.JLabel();
        visitorJenisBarang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbVisitor = new javax.swing.JComboBox<>();
        visitorBarangSN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        visitorSimpanBarang = new javax.swing.JButton();
        visitorKembali = new javax.swing.JButton();
        btnFoto = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        FotoBarang = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        bgUtama3 = new javax.swing.JLabel();
        panelVisitorRegist = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        visitorNama = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        visitorTelp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        visitorKeperluan = new javax.swing.JComboBox<>();
        KeperluanLain = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        visitorAlamat = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        visitorEmail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        visitorRegist = new javax.swing.JButton();
        visitorKembali1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        titleBar4 = new logbook.swing.titlebar.TitleBar();
        visitorInstansi = new javax.swing.JComboBox<>();
        bgUtama4 = new javax.swing.JLabel();
        bgAnimation = new logbook.swing.bgAnimation();
        panelAdmin = new javax.swing.JPanel();
        titleBar1 = new logbook.swing.titlebar.TitleBar();
        btnLoginAdm = new logbook.swing.button();
        btnKembaliAdm = new logbook.swing.button();
        admUsername = new javax.swing.JTextField();
        admPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bgUtama1 = new javax.swing.JLabel();
        panelBody = new logbook.swing.PanelTransparent();
        panelMenu = new javax.swing.JPanel();
        menu = new logbook.menu.Menu();
        titleBar = new logbook.swing.titlebar.TitleBar();
        body = new javax.swing.JPanel();

        bgUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelUtama.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelUtama.add(titleBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        visitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/visitors.png"))); // NOI18N
        visitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorActionPerformed(evt);
            }
        });
        panelUtama.add(visitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 210, -1));

        admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system-administrator.png"))); // NOI18N
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        panelUtama.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 200, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("LogBook Application");
        panelUtama.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 260, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/telkom.png"))); // NOI18N
        panelUtama.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 110, 110));

        bgUtama2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg.png"))); // NOI18N
        panelUtama.add(bgUtama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RegistVisitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/regist_visitor.png"))); // NOI18N
        RegistVisitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistVisitorActionPerformed(evt);
            }
        });

        RegistBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barang.png"))); // NOI18N
        RegistBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistBarangActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel10.setText("LogBook Application");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/telkom.png"))); // NOI18N

        btnBack.setBackground(new java.awt.Color(153, 153, 153));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        bgUtama5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg.png"))); // NOI18N

        javax.swing.GroupLayout panelVisitorLayout = new javax.swing.GroupLayout(panelVisitor);
        panelVisitor.setLayout(panelVisitorLayout);
        panelVisitorLayout.setHorizontalGroup(
            panelVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(RegistVisitor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(650, 650, 650)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(670, 670, 670)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(740, 740, 740)
                .addComponent(RegistBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(bgUtama5)
        );
        panelVisitorLayout.setVerticalGroup(
            panelVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addComponent(titleBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307)
                .addComponent(RegistVisitor)
                .addGap(10, 10, 10)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(RegistBarang))
            .addGroup(panelVisitorLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel10))
            .addComponent(bgUtama5)
        );

        panelVisitorBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelVisitorBarang.add(titleBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/telkom.png"))); // NOI18N
        panelVisitorBarang.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 110, 110));

        visitorJenisBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Silahkan Pilih ---", "Digital Data Shredder", "SSD SAN Storage", "KVM Console Server", "Virtual Tape Libraries", "Blade Server", "Baremetal Server", "Firewall", "NAS", "Router", "Switch", "Lainnya" }));
        panelVisitorBarang.add(visitorJenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 240, -1));

        jLabel9.setText("Jenis Barang");
        panelVisitorBarang.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 80, -1));

        jLabel11.setText("Nama Visitor");
        panelVisitorBarang.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 110, -1));

        cbVisitor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelVisitorBarang.add(cbVisitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 240, -1));
        panelVisitorBarang.add(visitorBarangSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 240, -1));

        jLabel12.setText("Serial Number");
        panelVisitorBarang.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 90, -1));

        visitorSimpanBarang.setBackground(new java.awt.Color(102, 102, 255));
        visitorSimpanBarang.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        visitorSimpanBarang.setForeground(new java.awt.Color(255, 255, 255));
        visitorSimpanBarang.setText("Simpan");
        visitorSimpanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorSimpanBarangActionPerformed(evt);
            }
        });
        panelVisitorBarang.add(visitorSimpanBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 230, 30));

        visitorKembali.setBackground(new java.awt.Color(153, 153, 153));
        visitorKembali.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        visitorKembali.setForeground(new java.awt.Color(255, 255, 255));
        visitorKembali.setText("Kembali");
        visitorKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorKembaliActionPerformed(evt);
            }
        });
        panelVisitorBarang.add(visitorKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 230, 30));

        btnFoto.setText("Pilih Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        panelVisitorBarang.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 90, -1));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel22.setText("Registrasi Barang");
        panelVisitorBarang.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 230, -1));

        FotoBarang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Foto Barang");

        javax.swing.GroupLayout FotoBarangLayout = new javax.swing.GroupLayout(FotoBarang);
        FotoBarang.setLayout(FotoBarangLayout);
        FotoBarangLayout.setHorizontalGroup(
            FotoBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FotoBarangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FotoBarangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(153, 153, 153))
        );
        FotoBarangLayout.setVerticalGroup(
            FotoBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FotoBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelVisitorBarang.add(FotoBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        bgUtama3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg_visitor.png"))); // NOI18N
        panelVisitorBarang.add(bgUtama3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelVisitorRegist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/telkom.png"))); // NOI18N
        panelVisitorRegist.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 110, 110));
        panelVisitorRegist.add(visitorNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 240, -1));

        jLabel14.setText("Nama");
        panelVisitorRegist.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));
        panelVisitorRegist.add(visitorTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 240, -1));

        jLabel15.setText("No Telp");
        panelVisitorRegist.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 80, -1));

        visitorKeperluan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Silahkan Pilih ---", "Maintenance", "Instalasi", "Troubleshoot", "Change Request", "Monitoring", "Lainnya" }));
        visitorKeperluan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorKeperluanActionPerformed(evt);
            }
        });
        panelVisitorRegist.add(visitorKeperluan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 240, -1));
        panelVisitorRegist.add(KeperluanLain, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 240, -1));

        jLabel16.setText("Keperluan");
        panelVisitorRegist.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 80, -1));

        visitorAlamat.setColumns(20);
        visitorAlamat.setRows(5);
        jScrollPane2.setViewportView(visitorAlamat);

        panelVisitorRegist.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 240, 110));

        jLabel17.setText("Alamat");
        panelVisitorRegist.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 49, -1));

        jLabel18.setText("Instansi / Mitra");
        panelVisitorRegist.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 110, -1));
        panelVisitorRegist.add(visitorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 240, -1));

        jLabel19.setText("Email");
        panelVisitorRegist.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 49, -1));

        visitorRegist.setBackground(new java.awt.Color(102, 102, 255));
        visitorRegist.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        visitorRegist.setForeground(new java.awt.Color(255, 255, 255));
        visitorRegist.setText("Register");
        visitorRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorRegistActionPerformed(evt);
            }
        });
        panelVisitorRegist.add(visitorRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 230, 30));

        visitorKembali1.setBackground(new java.awt.Color(153, 153, 153));
        visitorKembali1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        visitorKembali1.setForeground(new java.awt.Color(255, 255, 255));
        visitorKembali1.setText("Kembali");
        visitorKembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorKembali1ActionPerformed(evt);
            }
        });
        panelVisitorRegist.add(visitorKembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, 230, 30));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel21.setText("Registrasi Visitor");
        panelVisitorRegist.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 117, 250, -1));
        panelVisitorRegist.add(titleBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        panelVisitorRegist.add(visitorInstansi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 240, -1));

        bgUtama4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg_visitor.png"))); // NOI18N
        panelVisitorRegist.add(bgUtama4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 8, -1, 700));

        panelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelAdmin.add(titleBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnLoginAdm.setBackground(new java.awt.Color(102, 102, 255));
        btnLoginAdm.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginAdm.setText("Login");
        btnLoginAdm.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLoginAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAdmActionPerformed(evt);
            }
        });
        panelAdmin.add(btnLoginAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 180, 37));

        btnKembaliAdm.setBackground(new java.awt.Color(153, 153, 153));
        btnKembaliAdm.setForeground(new java.awt.Color(255, 255, 255));
        btnKembaliAdm.setText("Kembali");
        btnKembaliAdm.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnKembaliAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliAdmActionPerformed(evt);
            }
        });
        panelAdmin.add(btnKembaliAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 180, 37));
        panelAdmin.add(admUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 320, -1));
        panelAdmin.add(admPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 320, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Username");
        panelAdmin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 120, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        panelAdmin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 140, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/telkom.png"))); // NOI18N
        panelAdmin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, 100));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel23.setText("Administrator Login");
        panelAdmin.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 270, -1));

        bgUtama1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg.png"))); // NOI18N
        panelAdmin.add(bgUtama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelBody.setMaximumSize(new java.awt.Dimension(1330, 710));
        panelBody.setPreferredSize(new java.awt.Dimension(1330, 710));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                .addGap(0, 230, Short.MAX_VALUE)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBodyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(903, Short.MAX_VALUE)))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBodyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout bgAnimationLayout = new javax.swing.GroupLayout(bgAnimation);
        bgAnimation.setLayout(bgAnimationLayout);
        bgAnimationLayout.setHorizontalGroup(
            bgAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        bgAnimationLayout.setVerticalGroup(
            bgAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelVisitorRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelVisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelVisitorBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(bgAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelVisitorRegist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(panelVisitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(panelVisitorBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAdmActionPerformed
       
        if (!animatorLogin.isRunning()) {
            signIn = true;
            String user = admUsername.getText().trim();
            String pass = String.valueOf(admPass.getPassword());
            boolean action = true;
            
            try {
                 ResultSet check = conn.createStatement().executeQuery("select * from admin where username='"+admUsername.getText()+"' and password='"+String.valueOf(admPass.getText())+"'");
                 if (check.next()){
                     String updatedata = "UPDATE admin SET status='loggedin' WHERE  username='"+user+"' ";
                     PreparedStatement update = conn.prepareStatement(updatedata);
                     update.execute();
                     
                     animatorLogin.start();          
                 }
                 else {
                      JOptionPane.showMessageDialog(rootPane,"Username atau Password salah !!");
                 }
            }
            catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
            signout();
        }
        
    }//GEN-LAST:event_btnLoginAdmActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        panelUtama.setVisible(false);
        panelAdmin.setVisible(true);
        
    }//GEN-LAST:event_adminActionPerformed

    private void btnKembaliAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliAdmActionPerformed
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitorBarang.setVisible(false);
        panelVisitor.setVisible(false);
        panelUtama.setVisible(true);
       
        
        clear();
    }//GEN-LAST:event_btnKembaliAdmActionPerformed

    private void visitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorActionPerformed
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitorBarang.setVisible(false);
        panelVisitor.setVisible(true);
        panelUtama.setVisible(false);
    }//GEN-LAST:event_visitorActionPerformed

    private void visitorKembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorKembali1ActionPerformed
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitorBarang.setVisible(false);
        panelVisitor.setVisible(true);
        panelUtama.setVisible(false);
        
        clear();
    }//GEN-LAST:event_visitorKembali1ActionPerformed

    private void visitorKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorKembaliActionPerformed
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitorBarang.setVisible(false);
        panelVisitor.setVisible(false);
        panelUtama.setVisible(true);
        
        clear();
    }//GEN-LAST:event_visitorKembaliActionPerformed

    private void RegistVisitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistVisitorActionPerformed
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(true);
        panelVisitorBarang.setVisible(false);
        panelVisitor.setVisible(false);
        panelUtama.setVisible(false);
    }//GEN-LAST:event_RegistVisitorActionPerformed

    /// REGIST BARANG ///
    private void RegistBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistBarangActionPerformed
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitorBarang.setVisible(true);
        panelVisitor.setVisible(false);
        panelUtama.setVisible(false);
    }//GEN-LAST:event_RegistBarangActionPerformed

    private void visitorSimpanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorSimpanBarangActionPerformed

       String jenis = visitorJenisBarang.getSelectedItem().toString();
       String sn = visitorBarangSN.getText();
       String namavisitor = cbVisitor.getSelectedItem().toString();
       String id_visitor = null;
        try {
            Statement show=conn.createStatement();
            
            ResultSet idvisitor = show.executeQuery("Select id_visitor from visitor_log where nama ='"+namavisitor+"' and tanggal like CONCAT(CURRENT_DATE(),'%')  " );  
            while(idvisitor.next()){
                
                  id_visitor = idvisitor.getString("id_visitor");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       String tambahbarang = "INSERT INTO barang_log(nama_visitor,jenis,sn,foto,id_visitor,tanggal)"+ "VALUES (?,?,?,?,?,now())";
       
       try {
           
           String newpath = "src/logbook/images";
           File directory = new File(newpath);
           if (!directory.exists()){
               directory.mkdirs();
           }
           File fileawal = null;
           File fileakhir = null;
           String ext = this.filename.substring(filename.lastIndexOf('.')+1);
           fileawal = new File(filename);
           fileakhir = new File(newpath+"/"+namavisitor+"_"+id_visitor+"."+ext);
           
           PreparedStatement add = conn.prepareStatement(tambahbarang);
           add.setString(1, namavisitor);
           add.setString(2, jenis);
           add.setString(3, sn);
           add.setString(4, namavisitor+"_"+id_visitor+"."+ext);
           add.setString(5, id_visitor);
           
           
           if (namavisitor.isEmpty() || jenis.isEmpty() || sn.isEmpty() ) {
               JOptionPane.showMessageDialog(null,"Form harus diisi semua, Tidak boleh kosong !!");
           }
           else {
               add.execute();
                JOptionPane.showMessageDialog(null,"Data Tersimpan !");
                Files.copy(fileawal.toPath(), fileakhir.toPath());
                panelVisitorBarang.setVisible(false);
                panelUtama.setVisible(true);
           }
           
       } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_visitorSimpanBarangActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
          JFileChooser chooser = new JFileChooser();
           chooser.showOpenDialog(null);
           File f = chooser.getSelectedFile();
           ImageIcon icon = new ImageIcon(f.toString());
           Image img = icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
           ImageIcon ic = new ImageIcon(img);
           foto.setIcon(ic);
           this.filename = f.getAbsolutePath();
    }//GEN-LAST:event_btnFotoActionPerformed

    
    private void namainstansi() throws SQLException {
         try 
        {
            String query = "select nama_instansi from mitra";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            visitorInstansi.removeAllItems();
            
            while(rs.next()){
                visitorInstansi.addItem(rs.getString("nama_instansi"));
                
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
         
   
            
    }
    
    
   
     
    
    
    private void visitorRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorRegistActionPerformed
       
       
       
       String name_visitor = visitorNama.getText();
       String email_visitor = visitorEmail.getText();
       String no_telp = visitorTelp.getText();
       String instansi_visitor = visitorInstansi.getSelectedItem().toString();
       String alamat_visitor = visitorAlamat.getText();
       String id_mitra = null;
        try {
            Statement show=conn.createStatement();
            
            ResultSet idmitra = show.executeQuery("Select id_mitra from mitra where nama_instansi ='"+instansi_visitor+"' " );  
            while(idmitra.next()){
                
                  id_mitra = idmitra.getString("id_mitra");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       if ( KeperluanLain.getText().equals("")) {

           String keperluan_visitor = visitorKeperluan.getSelectedItem().toString();
           
           String addVisitor = "INSERT INTO visitor_log(nama,email,telp,instansi,keperluan,alamat,id_mitra,tanggal)"+ "VALUES (?,?,?,?,?,?,?,now())";

     
           try {
           PreparedStatement add = conn.prepareStatement(addVisitor);
           add.setString(1, name_visitor);
           add.setString(2, email_visitor);
           add.setString(3, no_telp);
           add.setString(4, instansi_visitor);
           add.setString(5, keperluan_visitor);
           add.setString(6, alamat_visitor);
           add.setString(7,id_mitra);
           
           
           
                if (name_visitor.isEmpty() || email_visitor.isEmpty() || no_telp.isEmpty() || instansi_visitor.isEmpty() || keperluan_visitor.isEmpty() || alamat_visitor.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Form harus diisi semua, Tidak boleh kosong !!");
                }
                else {
                    add.execute();
                     JOptionPane.showMessageDialog(null,"Data Tersimpan");

                     panelVisitorRegist.setVisible(false);
                     panelUtama.setVisible(true);
                     
                     clear();
                     namavisitor();

                }
           
            } catch (SQLException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
       else { 
           
           String keperluan_visitor = KeperluanLain.getText();
           String addVisitor = "INSERT INTO visitor_log(nama,email,telp,instansi,keperluan,alamat,id_mitra,tanggal)"+ "VALUES (?,?,?,?,?,?,?,now())";

     
           try {
           PreparedStatement add = conn.prepareStatement(addVisitor);
           add.setString(1, name_visitor);
           add.setString(2, email_visitor);
           add.setString(3, no_telp);
           add.setString(4, instansi_visitor);
           add.setString(5, keperluan_visitor);
           add.setString(6, alamat_visitor);
           add.setString(7,id_mitra);
           
           
           
                if (name_visitor.isEmpty() || email_visitor.isEmpty() || no_telp.isEmpty() || instansi_visitor.isEmpty() || keperluan_visitor.isEmpty() || alamat_visitor.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Form harus diisi semua, Tidak boleh kosong !!");
                }
                else {
                    add.execute();
                     JOptionPane.showMessageDialog(null,"Data Tersimpan");

                     panelVisitorRegist.setVisible(false);
                     panelUtama.setVisible(true);
                     
                     clear();
                     namavisitor();

                }
           
            } catch (SQLException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
       }
       
       
    }//GEN-LAST:event_visitorRegistActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        panelUtama.setVisible(true);
        panelBody.setVisible(false);
        panelAdmin.setVisible(false);
        panelVisitorBarang.setVisible(false);
        panelVisitorRegist.setVisible(false);
        panelVisitor.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void visitorKeperluanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorKeperluanActionPerformed
       //Kondisi Enable Box Ketika pilih dropdown lainnya
       
       if ( visitorKeperluan.getSelectedItem() == "Lainnya") {
           KeperluanLain.setVisible(true);
       }
       else { KeperluanLain.setVisible(false);}
    }//GEN-LAST:event_visitorKeperluanActionPerformed

    private void namavisitor() throws SQLException {
        try 
        {
      
            String query = "select nama from visitor_log where status='waiting'";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            cbVisitor.removeAllItems();
            
            while(rs.next()){
                cbVisitor.addItem(rs.getString("nama"));
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    ///////// END OF REGIST BARANG //////////////
    
    
    
     private void enableLogin(boolean action) {
        admUsername.setEditable(action);
        admPass.setEditable(action);
        btnLoginAdm.setEnabled(action);
    }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FotoBarang;
    private javax.swing.JTextField KeperluanLain;
    private javax.swing.JButton RegistBarang;
    private javax.swing.JButton RegistVisitor;
    private javax.swing.JPasswordField admPass;
    private javax.swing.JTextField admUsername;
    private javax.swing.JButton admin;
    private logbook.swing.bgAnimation bgAnimation;
    private javax.swing.JLabel bgUtama;
    private javax.swing.JLabel bgUtama1;
    private javax.swing.JLabel bgUtama2;
    private javax.swing.JLabel bgUtama3;
    private javax.swing.JLabel bgUtama4;
    private javax.swing.JLabel bgUtama5;
    private javax.swing.JPanel body;
    private logbook.swing.button btnBack;
    private javax.swing.JButton btnFoto;
    private logbook.swing.button btnKembaliAdm;
    private logbook.swing.button btnLoginAdm;
    private javax.swing.JComboBox<String> cbVisitor;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private logbook.menu.Menu menu;
    private javax.swing.JPanel panelAdmin;
    private logbook.swing.PanelTransparent panelBody;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JPanel panelVisitor;
    private javax.swing.JPanel panelVisitorBarang;
    private javax.swing.JPanel panelVisitorRegist;
    private logbook.swing.titlebar.TitleBar titleBar;
    private logbook.swing.titlebar.TitleBar titleBar1;
    private logbook.swing.titlebar.TitleBar titleBar2;
    private logbook.swing.titlebar.TitleBar titleBar3;
    private logbook.swing.titlebar.TitleBar titleBar4;
    private logbook.swing.titlebar.TitleBar titleBar5;
    private javax.swing.JButton visitor;
    private javax.swing.JTextArea visitorAlamat;
    private javax.swing.JTextField visitorBarangSN;
    private javax.swing.JTextField visitorEmail;
    private javax.swing.JComboBox<String> visitorInstansi;
    private javax.swing.JComboBox<String> visitorJenisBarang;
    private javax.swing.JButton visitorKembali;
    private javax.swing.JButton visitorKembali1;
    private javax.swing.JComboBox<String> visitorKeperluan;
    private javax.swing.JTextField visitorNama;
    private javax.swing.JButton visitorRegist;
    private javax.swing.JButton visitorSimpanBarang;
    private javax.swing.JTextField visitorTelp;
    // End of variables declaration//GEN-END:variables

    
}
