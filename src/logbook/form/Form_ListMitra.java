package logbook.form;

import com.mysql.jdbc.Connection;
import db.db;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import logbook.report.HelperMain;
import logbook.swing.ComboItem;


public class Form_ListMitra extends javax.swing.JPanel {

    private Connection conn = (Connection) new db().connect();
    private String appRootPath;
    private String appAssetPath;
    private String appReportsPath;
    private String appImagesPath;
    
    public Form_ListMitra()  {
      
        initComponents();
        
        try {
            initOptions();
        } catch (SQLException ex) {
            Logger.getLogger(Form_ListMitra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         initDirectory();
         
         ((JLabel)cb_perusahaan.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
         
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new logbook.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_perusahaan = new javax.swing.JComboBox<>();
        Jscroll = new javax.swing.JScrollPane();
        table = new logbook.swing.table.Table();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(125, 125, 125));
        jLabel1.setText("List Device Mitra");

        cb_perusahaan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_perusahaanItemStateChanged(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama Perusahaan", "Nama Visitor", "Tanggal", "Keperluan", "SN", "Foto Barang", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jscroll.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(Jscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(cb_perusahaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(166, 166, 166))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(cb_perusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(Jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_perusahaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_perusahaanItemStateChanged
       Object selected = cb_perusahaan.getSelectedItem();
        
        String id = ((ComboItem) selected).getValue();
        String nama = ((ComboItem) selected).getKey();
        
        try {
            load_table_daily_activity(id);
            System.out.println("Menampilkan Data Perusahaan"+nama);
            
        } catch (SQLException ex) {
            Logger.getLogger(Form_ListMitra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
    }//GEN-LAST:event_cb_perusahaanItemStateChanged

    private void initOptions() throws SQLException {
          try {
            cb_perusahaan.addItem(new ComboItem("-- Pilih Nama Perusahaan --", null));

            String sql = "select "
                    + "id_mitra, "
                    + "nama_instansi "
                    + "from mitra";
            //java.sql.Connection conn = (Connection) ConfigConnection.mysql();
            Connection conn = (Connection) new db().connect();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                cb_perusahaan.addItem(new ComboItem(
                        res.getString("nama_instansi"),
                        res.getString("id_mitra")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void initDirectory() {
        String appRootName = "//Logbook_Telkom";
        File directory = HelperMain.makeDirectory(appRootName + "//src//logbook//images");
        this.appImagesPath = directory.getAbsolutePath() + "//";

    }
    
    private void load_table_daily_activity(String id) throws SQLException {
        
        table.RemoveElement();
        
        java.sql.Connection conn = new db().connect();
        Statement show=conn.createStatement();
            
         ResultSet query = show.executeQuery("select m.nama_instansi, vl.nama, vl.tanggal, vl.keperluan, bl.sn, bl.foto, vl.status from barang_log bl inner join visitor_log vl on bl.id_visitor = vl.id_visitor inner join mitra m on m.id_mitra = vl.id_mitra where m.id_mitra = '"+id+"' ORDER BY vl.tanggal DESC");  
            while(query.next()){
                Object[] data={
                    query.getString("nama_instansi"),
                    query.getString("nama"),
                    query.getString("tanggal"),
                    query.getString("keperluan"),
                    query.getString("sn"),
                    this.appImagesPath + query.getString("foto"),
                    query.getString("status")
                };
   
        table.addRow(data);
        table.fixTable(Jscroll);
        table.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
            }
    }
    

    private class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String photoName = value.toString();
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon(photoName)
                            .getImage()
                            .getScaledInstance(-1, 60, Image.SCALE_SMOOTH)
            );
            return new JLabel(imageIcon);
        }

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Jscroll;
    private javax.swing.JComboBox<ComboItem> cb_perusahaan;
    private javax.swing.JLabel jLabel1;
    private logbook.swing.RoundPanel roundPanel1;
    private logbook.swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}
