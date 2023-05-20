/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logbook.form;

import java.sql.Connection;
import java.sql.Statement;
import db.db;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author keratampan
 */
public class Form_DataVisitor extends javax.swing.JPanel {

    private Connection conn = new db().connect();
    /**
     * Creates new form Form_DataVisitor
     */
    public Form_DataVisitor() {
        initComponents();
        datavisitor();
        dummydata();
    }
    
    
    private void datavisitor(){
        try{
          
            Connection conn = new db().connect();
            Statement show=conn.createStatement();
          
            listdata.RemoveElement();
            
            ResultSet list = show.executeQuery("SELECT * from visitor_log vl LEFT OUTER JOIN barang_log bl ON vl.id_visitor = bl.id_visitor order by vl.tanggal desc "); 
            while(list.next()){
                Object[] data={
                    list.getString("vl.nama"), //0
                    list.getString("vl.instansi"), //1
                    list.getString("vl.tanggal"), //2
                    list.getString("vl.status"), //3
                    list.getString("vl.email"), //4
                    list.getString("vl.telp"), //5
                    list.getString("vl.keperluan"), //6
                    list.getString("vl.alamat"),  //7
                    list.getString("vl.id_visitor") //8
                };
                
                listdata.fixTable(jScrollPane2);
                listdata.addRow(data);
               
                listdata.getColumnModel().getColumn(4).setWidth(0);
                listdata.getColumnModel().getColumn(4).setMinWidth(0);
                listdata.getColumnModel().getColumn(4).setMaxWidth(0); 
                
                listdata.getColumnModel().getColumn(5).setWidth(0);
                listdata.getColumnModel().getColumn(5).setMinWidth(0);
                listdata.getColumnModel().getColumn(5).setMaxWidth(0); 
                
                listdata.getColumnModel().getColumn(6).setWidth(0);
                listdata.getColumnModel().getColumn(6).setMinWidth(0);
                listdata.getColumnModel().getColumn(6).setMaxWidth(0); 
                
                listdata.getColumnModel().getColumn(7).setWidth(0);
                listdata.getColumnModel().getColumn(7).setMinWidth(0);
                listdata.getColumnModel().getColumn(7).setMaxWidth(0); 
                
                listdata.getColumnModel().getColumn(8).setWidth(0);
                listdata.getColumnModel().getColumn(8).setMinWidth(0);
                listdata.getColumnModel().getColumn(8).setMaxWidth(0); 
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }

    private void cariData(String key_name){
        try{
          
            Connection conn = new db().connect();
            Statement show=conn.createStatement();
            
            listdata.RemoveElement();
            
            ResultSet list=show.executeQuery("SELECT * from visitor_log WHERE nama LIKE '%"+key_name+"%' OR instansi LIKE '%"+key_name+"%' OR keperluan LIKE '%"+key_name+"%' ORDER BY tanggal DESC " );  
            while(list.next()){
                 Object[] data={
                    list.getString("nama"), //0
                    list.getString("instansi"), //1
                    list.getString("tanggal"), //2
                    list.getString("status"), //3
                    list.getString("email"), //4
                    list.getString("telp"), //5
                    list.getString("keperluan"), //6
                    list.getString("alamat"),  //7
                    list.getString("id_visitor") //8
                };
                  
               listdata.fixTable(jScrollPane2);
               
               listdata.addRow(data);
               
               listdata.getColumnModel().getColumn(4).setWidth(0);
               listdata.getColumnModel().getColumn(4).setMinWidth(0);
               listdata.getColumnModel().getColumn(4).setMaxWidth(0); 
               
               listdata.getColumnModel().getColumn(5).setWidth(0);
               listdata.getColumnModel().getColumn(5).setMinWidth(0);
               listdata.getColumnModel().getColumn(5).setMaxWidth(0); 
               
               listdata.getColumnModel().getColumn(6).setWidth(0);
               listdata.getColumnModel().getColumn(6).setMinWidth(0);
               listdata.getColumnModel().getColumn(6).setMaxWidth(0); 
               
               listdata.getColumnModel().getColumn(7).setWidth(0);
               listdata.getColumnModel().getColumn(7).setMinWidth(0);
               listdata.getColumnModel().getColumn(7).setMaxWidth(0);
               
               listdata.getColumnModel().getColumn(8).setWidth(0);
               listdata.getColumnModel().getColumn(8).setMinWidth(0);
               listdata.getColumnModel().getColumn(8).setMaxWidth(0); 
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    private void dummydata(){
         try{
             
            Connection conn = new db().connect();
            Statement show=conn.createStatement();
           
            listbarang.RemoveElement();
 
                  ResultSet barang = show.executeQuery("SELECT * from barang_log order by tanggal desc ");
                    while(barang.next()){
                        Object[] data={
                            "","","","",""
                         };
                        
                        listbarang.fixTable(Jscroll);
                        listbarang.addRow(data);
                    }
            
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
         
    }
    
    private void databarang(String idvisitor) throws SQLException{
        
        Connection conn = new db().connect();
        Statement show=conn.createStatement();
        listbarang.RemoveElement();
 
                  ResultSet barang = show.executeQuery("SELECT * from barang_log where id_visitor ='"+idvisitor+"' order by tanggal desc ");
                    while(barang.next()){
                        Object[] data={
                            barang.getString("jenis"),
                            barang.getString("sn"),
                            barang.getString("tanggal")
                         };
                        
                        listbarang.fixTable(Jscroll);
                        listbarang.addRow(data);
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

        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new logbook.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listdata = new logbook.swing.table.Table();
        roundPanel2 = new logbook.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        namavisitor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        instansivisitor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailvisitor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telpvisitor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatvisitor = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        keperluanvisitor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        statusvisitor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        roundPanel3 = new logbook.swing.RoundPanel();
        Jscroll = new javax.swing.JScrollPane();
        listbarang = new logbook.swing.table.Table();

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        listdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Instansi", "Tanggal", "Status", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listdataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listdata);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel2.setRound(10);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(125, 125, 125));
        jLabel2.setText("Nama");

        namavisitor.setEditable(false);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(125, 125, 125));
        jLabel3.setText("Instansi");

        instansivisitor.setEditable(false);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(125, 125, 125));
        jLabel4.setText("Email");

        emailvisitor.setEditable(false);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(125, 125, 125));
        jLabel5.setText("No Telepon");

        telpvisitor.setEditable(false);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(125, 125, 125));
        jLabel6.setText("Alamat");

        alamatvisitor.setEditable(false);
        alamatvisitor.setColumns(20);
        alamatvisitor.setRows(5);
        jScrollPane1.setViewportView(alamatvisitor);

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(125, 125, 125));
        jLabel7.setText("Keperluan");

        keperluanvisitor.setEditable(false);

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(125, 125, 125));
        jLabel8.setText("Status");

        statusvisitor.setEditable(false);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(emailvisitor, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(namavisitor)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instansivisitor)
                    .addComponent(telpvisitor)
                    .addComponent(keperluanvisitor)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(statusvisitor))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namavisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instansivisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailvisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telpvisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(keperluanvisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusvisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("Pencarian  :");

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel3.setRound(10);

        listbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jenis", "S/N", "Tanggal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jscroll.setViewportView(listbarang);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(572, 572, 572)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
         String key_name = search.getText();
        System.out.println(key_name);
        if ( key_name != "" ) {
            cariData(key_name);
        }else{
            datavisitor();
        }
    }//GEN-LAST:event_searchKeyReleased

    private void listdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listdataMouseClicked
       
        int baris = listdata.rowAtPoint(evt.getPoint());

        String nama =  listdata.getValueAt(baris,0).toString();
        String instansi = listdata.getValueAt(baris,1).toString();
        String tanggal = listdata.getValueAt(baris, 2).toString();
        String status = listdata.getValueAt(baris,3).toString();
        String email = listdata.getValueAt(baris, 4).toString();
        String telp = listdata.getValueAt(baris, 5).toString();
        String keperluan = listdata.getValueAt(baris, 6).toString();
        String alamat = listdata.getValueAt(baris, 7).toString();
        String idvisitor = listdata.getValueAt(baris, 8).toString();

        namavisitor.setText(nama);
        instansivisitor.setText(instansi);
        emailvisitor.setText(email);
        telpvisitor.setText(telp);
        keperluanvisitor.setText(keperluan);
        alamatvisitor.setText(alamat);
        statusvisitor.setText(status);
        
        try{
            
            Statement show=conn.createStatement();
                
                ResultSet rs = show.executeQuery("SELECT count(*) as r from barang_log where id_visitor ='"+idvisitor+"' order by tanggal desc");
                rs.next();
                String rowCount = rs.getString("r");
                
                if ( rowCount.equals("0")) {
                    dummydata();
                    System.out.println("kosong");
                } else {
                   databarang(idvisitor);
                }
 
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        
        System.out.println("Menampilkan data visitor "+nama);                                 
        
    }//GEN-LAST:event_listdataMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Jscroll;
    private javax.swing.JTextArea alamatvisitor;
    private javax.swing.JTextField emailvisitor;
    private javax.swing.JTextField instansivisitor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keperluanvisitor;
    private logbook.swing.table.Table listbarang;
    private logbook.swing.table.Table listdata;
    private javax.swing.JTextField namavisitor;
    private logbook.swing.RoundPanel roundPanel1;
    private logbook.swing.RoundPanel roundPanel2;
    private logbook.swing.RoundPanel roundPanel3;
    private javax.swing.JTextField search;
    private javax.swing.JTextField statusvisitor;
    private javax.swing.JTextField telpvisitor;
    // End of variables declaration//GEN-END:variables
}
