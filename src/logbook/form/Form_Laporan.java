/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logbook.form;

import com.mysql.jdbc.Connection;
import db.db;
import java.awt.HeadlessException;
import java.io.File;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import logbook.report.HelperMain;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import logbook.swing.ComboItem;

/**
 *
 * @author keratampan
 */
public class Form_Laporan extends javax.swing.JPanel {
  

   private String appImagesPath;
   private String appReportPath;
   private String nama_admin;
   
    public Form_Laporan() {
        
        initComponents();
        initOptions();
        namaVisitor();
        initDirectory();
        namaAdmin();
        
    }

    
    private void initDirectory() {
        
        
        String appRootName = "//Logbook_Telkom";
        File directory = HelperMain.makeDirectory(appRootName + "//src//logbook//images");
        File directory1 = HelperMain.makeDirectory(appRootName + "//src//logbook//report");
        this.appImagesPath = directory.getAbsolutePath() + "//";
        this.appReportPath = directory1.getAbsolutePath() + "//";

    }
    
    
    private void initOptions() {
        
        try {
            cb_perusahaan1.addItem(new ComboItem("-- Pilih Nama Perusahaan --", null));

            String sql = "select "
                    + "id_mitra, "
                    + "nama_instansi "
                    + "from mitra";
            
            Connection conn = (Connection) new db().connect();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                cb_perusahaan1.addItem(new ComboItem(
                        res.getString("nama_instansi"),
                        res.getString("id_mitra")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void namaVisitor() {
        
        try {
            cb_namaVisitor.addItem(new ComboItem("-- Pilih Nama Visitor --", null));

            String sql = "select distinct nama, id_visitor from visitor_log";
            
            Connection conn = (Connection) new db().connect();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                cb_namaVisitor.addItem(new ComboItem(
                        res.getString("nama"),
                        res.getString("id_visitor")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void namaAdmin() {
        

        try {

            String sql = "select nama from admin where status = 'loggedin' ";
            
            Connection conn = (Connection) new db().connect();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {               
                         nama_admin = res.getString("nama");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new logbook.swing.RoundPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Lap_Perusahaan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cb_perusahaan1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        text_tanggal_akhir_perusahaan = new com.toedter.calendar.JDateChooser();
        text_tanggal_awal_perusahaan = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btn_export_to_excel_perusahaan = new javax.swing.JButton();
        Lap_Periode = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        text_tanggal_akhir_periode = new com.toedter.calendar.JDateChooser();
        text_tanggal_awal_periode = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        btn_export_to_excel_periode = new javax.swing.JButton();
        Lap_DataVisitor = new javax.swing.JPanel();
        btn_export_datavisitor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cb_namaVisitor = new javax.swing.JComboBox<>();
        Lap_DataBarang = new javax.swing.JPanel();
        btn_export_dataBarang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cb_status = new javax.swing.JComboBox<>();
        Lap_DataKaryawan = new javax.swing.JPanel();
        btn_export_Karyawan = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setMaximumSize(new java.awt.Dimension(925, 670));
        setPreferredSize(new java.awt.Dimension(925, 670));

        jTabbedPane2.setBackground(new java.awt.Color(245, 245, 245));

        Lap_Perusahaan.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setText("Nama Perusahaan");

        cb_perusahaan1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cb_perusahaan1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_perusahaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal Periode");

        text_tanggal_akhir_perusahaan.setBackground(new java.awt.Color(255, 255, 255));

        text_tanggal_awal_perusahaan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(text_tanggal_awal_perusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_tanggal_akhir_perusahaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tanggal_akhir_perusahaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_tanggal_awal_perusahaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_export_to_excel_perusahaan.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_export_to_excel_perusahaan.setText("Cetak Data");
        btn_export_to_excel_perusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_to_excel_perusahaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lap_PerusahaanLayout = new javax.swing.GroupLayout(Lap_Perusahaan);
        Lap_Perusahaan.setLayout(Lap_PerusahaanLayout);
        Lap_PerusahaanLayout.setHorizontalGroup(
            Lap_PerusahaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lap_PerusahaanLayout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addGroup(Lap_PerusahaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_export_to_excel_perusahaan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(302, 302, 302))
        );
        Lap_PerusahaanLayout.setVerticalGroup(
            Lap_PerusahaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lap_PerusahaanLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_export_to_excel_perusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Laporan Perusahaan", Lap_Perusahaan);

        Lap_Periode.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal Periode");

        text_tanggal_akhir_periode.setBackground(new java.awt.Color(255, 255, 255));

        text_tanggal_awal_periode.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel6.setText("-");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(text_tanggal_awal_periode, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_tanggal_akhir_periode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tanggal_akhir_periode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_tanggal_awal_periode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_export_to_excel_periode.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_export_to_excel_periode.setText("Cetak Data");
        btn_export_to_excel_periode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_to_excel_periodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lap_PeriodeLayout = new javax.swing.GroupLayout(Lap_Periode);
        Lap_Periode.setLayout(Lap_PeriodeLayout);
        Lap_PeriodeLayout.setHorizontalGroup(
            Lap_PeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lap_PeriodeLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addGroup(Lap_PeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_export_to_excel_periode, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        Lap_PeriodeLayout.setVerticalGroup(
            Lap_PeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lap_PeriodeLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_export_to_excel_periode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Laporan Periode", Lap_Periode);

        Lap_DataVisitor.setBackground(new java.awt.Color(255, 255, 255));
        Lap_DataVisitor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_export_datavisitor.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_export_datavisitor.setText("Cetak Data");
        btn_export_datavisitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_datavisitorActionPerformed(evt);
            }
        });
        Lap_DataVisitor.add(btn_export_datavisitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 332, 30));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setText("Pilih Nama Visitor");
        Lap_DataVisitor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        cb_namaVisitor.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        Lap_DataVisitor.add(cb_namaVisitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 332, 30));

        jTabbedPane2.addTab("Laporan Data Visitor", Lap_DataVisitor);

        Lap_DataBarang.setBackground(new java.awt.Color(255, 255, 255));
        Lap_DataBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_export_dataBarang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_export_dataBarang.setText("Cetak Data");
        btn_export_dataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_dataBarangActionPerformed(evt);
            }
        });
        Lap_DataBarang.add(btn_export_dataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 284, 332, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setText("Pilih Status");

        cb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih Status ---", "Approve", "Waiting", "Reject" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(cb_status, 0, 330, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_status, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        Lap_DataBarang.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 200, 330, -1));

        jTabbedPane2.addTab("Laporan Data Barang", Lap_DataBarang);

        Lap_DataKaryawan.setBackground(new java.awt.Color(255, 255, 255));

        btn_export_Karyawan.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_export_Karyawan.setText("Cetak Data");
        btn_export_Karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_KaryawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lap_DataKaryawanLayout = new javax.swing.GroupLayout(Lap_DataKaryawan);
        Lap_DataKaryawan.setLayout(Lap_DataKaryawanLayout);
        Lap_DataKaryawanLayout.setHorizontalGroup(
            Lap_DataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lap_DataKaryawanLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(btn_export_Karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        Lap_DataKaryawanLayout.setVerticalGroup(
            Lap_DataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lap_DataKaryawanLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(btn_export_Karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Laporan Data Karyawan", Lap_DataKaryawan);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel1Layout.createSequentialGroup()
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_export_to_excel_perusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_to_excel_perusahaanActionPerformed
        try {
            Connection conn = (Connection) new db().connect();

            Object item = cb_perusahaan1.getSelectedItem();
           
  

            String nama_perusahaan_key = ((ComboItem) item).getKey();
            String nama_perusahaan_value = ((ComboItem) item).getValue();

            String tanggal_awal = HelperMain.formatTanggal(text_tanggal_awal_perusahaan.getDate());
            String tanggal_akhir = HelperMain.formatTanggal(text_tanggal_akhir_perusahaan.getDate());

            if (nama_perusahaan_value == null) {
                throw new Exception("Pilih Nama Perusahaan.");
            }

            if (tanggal_awal == null || tanggal_akhir == null) {
                throw new Exception("Tentukan Tanggal Periode.");
            }

            String fileName = "report_perMitra.jrxml";
            String tanggal_cetak = HelperMain.formatTanggalCetak(new Date());
            String appLogoName = "logo-telkom-indonesia.png";
            String nama_supervisor = nama_admin;

            HashMap parameters = new HashMap();
            parameters.put("APP_IMAGE_PATH", appImagesPath);
            parameters.put("APP_LOGO_NAME", appLogoName);
            parameters.put("TANGGAL_AWAL", tanggal_awal);
            parameters.put("TANGGAL_AKHIR", tanggal_akhir);
            parameters.put("TANGGAL_CETAK", tanggal_cetak);
            parameters.put("NAMA_SUPERVISOR", nama_supervisor);
            parameters.put("NAMA_PERUSAHAAN", nama_perusahaan_key);

            File file = new File(appReportPath + fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            JasperViewer.viewReport(print, false);
        } catch (HeadlessException | SQLException | JRException e) {
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_export_to_excel_perusahaanActionPerformed

    private void btn_export_to_excel_periodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_to_excel_periodeActionPerformed
        try {
            Connection conn = (Connection) new db().connect();

            String tanggal_awal = HelperMain.formatTanggal(text_tanggal_awal_periode.getDate());
            String tanggal_akhir = HelperMain.formatTanggal(text_tanggal_akhir_periode.getDate());

            if (tanggal_awal == null || tanggal_akhir == null) {
                throw new Exception("Tentukan Tanggal Periode.");
            }

           // String fileName = "report visitor periode.jrxml";
           String fileName = "report_periode.jrxml";
            String tanggal_cetak = HelperMain.formatTanggalCetak(new Date());
            String appLogoName = "logo-telkom-indonesia.png";
            String nama_supervisor = nama_admin;

            HashMap parameters = new HashMap();
            parameters.put("APP_IMAGE_PATH", appImagesPath);
            parameters.put("APP_LOGO_NAME", appLogoName);
            parameters.put("TANGGAL_AWAL", tanggal_awal);
            parameters.put("TANGGAL_AKHIR", tanggal_akhir);
            parameters.put("TANGGAL_CETAK", tanggal_cetak);
            parameters.put("NAMA_SUPERVISOR", nama_supervisor);

            File file = new File(appReportPath + fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            JasperViewer.viewReport(print, false);
        } catch (HeadlessException | SQLException | JRException e) {
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_export_to_excel_periodeActionPerformed

    private void btn_export_KaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_KaryawanActionPerformed
        try {
            Connection conn = (Connection) new db().connect();


       

            String fileName = "report_dataKaryawan.jrxml";
            String tanggal_cetak = HelperMain.formatTanggalCetak(new Date());
            String appLogoName = "logo-telkom-indonesia.png";
            String nama_supervisor = nama_admin;

            HashMap parameters = new HashMap();
            parameters.put("APP_IMAGE_PATH", appImagesPath);
            parameters.put("APP_LOGO_NAME", appLogoName);
            parameters.put("TANGGAL_CETAK", tanggal_cetak);
            parameters.put("NAMA_SUPERVISOR", nama_supervisor);

            File file = new File(appReportPath + fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            JasperViewer.viewReport(print, false);
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_export_KaryawanActionPerformed

    private void btn_export_dataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_dataBarangActionPerformed

        System.out.println(appReportPath+" and "+appImagesPath);
        
        
         try {
            Connection conn = (Connection) new db().connect();

            String fileName = "report_dataBarang.jrxml";
            String tanggal_cetak = HelperMain.formatTanggalCetak(new Date());
            String appLogoName = "logo-telkom-indonesia.png";
            String nama_supervisor = nama_admin;
            String status = cb_status.getSelectedItem().toString();

            HashMap parameters = new HashMap();
            parameters.put("APP_IMAGE_PATH", appImagesPath);
            parameters.put("APP_LOGO_NAME", appLogoName);
            parameters.put("TANGGAL_CETAK", tanggal_cetak);
            parameters.put("NAMA_SUPERVISOR", nama_supervisor);
            parameters.put("STATUS", status);

            File file = new File(appReportPath + fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            JasperViewer.viewReport(print, false);
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }//GEN-LAST:event_btn_export_dataBarangActionPerformed

    private void btn_export_datavisitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_datavisitorActionPerformed
       
         try {
            Connection conn = (Connection) new db().connect();

            String fileName = "report_dataVisitor.jrxml";
            String tanggal_cetak = HelperMain.formatTanggalCetak(new Date());
            String appLogoName = "logo-telkom-indonesia.png";
            String nama_supervisor = nama_admin;
            String nama = cb_namaVisitor.getSelectedItem().toString();

            HashMap parameters = new HashMap();
            parameters.put("APP_IMAGE_PATH", appImagesPath);
            parameters.put("APP_LOGO_NAME", appLogoName);
            parameters.put("TANGGAL_CETAK", tanggal_cetak);
            parameters.put("NAMA_SUPERVISOR", nama_supervisor);
            parameters.put("NAMA_VISITOR", nama);

            File file = new File(appReportPath + fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            JasperViewer.viewReport(print, false);
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        
    }//GEN-LAST:event_btn_export_datavisitorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Lap_DataBarang;
    private javax.swing.JPanel Lap_DataKaryawan;
    private javax.swing.JPanel Lap_DataVisitor;
    private javax.swing.JPanel Lap_Periode;
    private javax.swing.JPanel Lap_Perusahaan;
    private javax.swing.JButton btn_export_Karyawan;
    private javax.swing.JButton btn_export_dataBarang;
    private javax.swing.JButton btn_export_datavisitor;
    private javax.swing.JButton btn_export_to_excel_periode;
    private javax.swing.JButton btn_export_to_excel_perusahaan;
    private javax.swing.JComboBox<ComboItem> cb_namaVisitor;
    private javax.swing.JComboBox<ComboItem> cb_perusahaan1;
    private javax.swing.JComboBox<String> cb_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private logbook.swing.RoundPanel roundPanel1;
    private com.toedter.calendar.JDateChooser text_tanggal_akhir_periode;
    private com.toedter.calendar.JDateChooser text_tanggal_akhir_perusahaan;
    private com.toedter.calendar.JDateChooser text_tanggal_awal_periode;
    private com.toedter.calendar.JDateChooser text_tanggal_awal_perusahaan;
    // End of variables declaration//GEN-END:variables
}
