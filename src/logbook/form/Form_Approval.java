/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package logbook.form;

import db.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import logbook.swing.ComboItem;
import logbook.swing.table.btnApprove;
import logbook.swing.table.btnReject;
import logbook.swing.table.JButtonRenderer;

/**
 *
 * @author keratampan
 */
public class Form_Approval extends javax.swing.JPanel {

      private Connection conn = new db().connect();
      
    /**
     * Creates new form Form_Approval
     */
    public Form_Approval() {
        initComponents();
        dataWaiting();
        dataApprove();
        
        
    }

    public void dataWaiting(){
        
        
        try{
            
            Connection conn = new db().connect();
            Statement show=conn.createStatement();
      
            dataWaiting.RemoveElement();
            
            ResultSet listData = show.executeQuery("SELECT * from visitor_log where status ='waiting' order by tanggal desc "); 
            while(listData.next()){
              
                Object[] data={
                 
                    listData.getString("nama"), 
                    listData.getString("instansi"), 
                    listData.getString("keperluan"), 
                    listData.getString("tanggal"),
                    listData.getString("status"), 
                    "Approve - ID - "+listData.getString("id_visitor"),
                    "Reject - ID - "+listData.getString("id_visitor")
                    
                    
                };
               dataWaiting.fixTable(Jscroll1);
               
               dataWaiting.addRow(data);
             
               
                dataWaiting.getColumn(dataWaiting.getColumnName(5)).setCellRenderer(new JButtonRenderer());
                dataWaiting.getColumn(dataWaiting.getColumnName (5)).setCellEditor(new btnApprove());
                
                dataWaiting.getColumn(dataWaiting.getColumnName(6)).setCellRenderer(new JButtonRenderer());
                dataWaiting.getColumn(dataWaiting.getColumnName (6)).setCellEditor(new btnReject());
                
                    
              
   
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    
    public void dataApprove(){
        try{
            Connection conn = new db().connect();
            Statement show=conn.createStatement();
         
          
            ResultSet listDataApprove = show.executeQuery("SELECT * from visitor_log where status='approve' or status='reject' order by tanggal desc "); 
            while(listDataApprove.next()){
                Object[] data={
                   
                    listDataApprove.getString("nama"), //1
                    listDataApprove.getString("email"), //2
                    listDataApprove.getString("telp"), //3
                    listDataApprove.getString("instansi"), //4
                    listDataApprove.getString("keperluan"), //5
                    listDataApprove.getString("tanggal"), //6
                    listDataApprove.getString("status")  //7
                    //listData.getString("vl.id_visitor") //8
                    
                    
                };
               dataApprove.fixTable(Jscroll2);
               dataApprove.addRow(data);
   
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
     private void cariData ( String key_name ){
        try{
            
     
           Connection conn = new db().connect();
           Statement show=conn.createStatement();
         
           
            dataWaiting.RemoveElement();
            
            if ( key_name == "" ) {
                ResultSet listData = show.executeQuery("SELECT * from visitor_log where status = 'waiting' order by tanggal desc ");  
                while(listData.next()){
                      Object[] data={

                        listData.getString("nama"), 
                        listData.getString("instansi"), 
                        listData.getString("keperluan"), 
                        listData.getString("tanggal"),
                        listData.getString("status"), 
                        "Approve - ID - "+listData.getString("id_visitor"),
                        "Reject - ID - "+listData.getString("id_visitor")


                    };
                   dataWaiting.fixTable(Jscroll1);
                   dataWaiting.addRow(data);
                   
                   dataWaiting.getColumn(dataWaiting.getColumnName(5)).setCellRenderer(new JButtonRenderer());
                   dataWaiting.getColumn(dataWaiting.getColumnName (5)).setCellEditor(new btnApprove());
                
                   dataWaiting.getColumn(dataWaiting.getColumnName(6)).setCellRenderer(new JButtonRenderer());
                   dataWaiting.getColumn(dataWaiting.getColumnName (6)).setCellEditor(new btnReject());
                }  
            }
            else {
                ResultSet listData = show.executeQuery("SELECT * from visitor_log where status = 'waiting' and nama LIKE '%"+key_name+"%' OR instansi like '%"+key_name+"%' order by tanggal desc ");  
                while(listData.next()){
                      Object[] data={

                        listData.getString("nama"), 
                        listData.getString("instansi"), 
                        listData.getString("keperluan"), 
                        listData.getString("tanggal"),
                        listData.getString("status"), 
                        "Approve - ID - "+listData.getString("id_visitor"),
                        "Reject - ID - "+listData.getString("id_visitor")

                    };
                   dataWaiting.fixTable(Jscroll1);
                   dataWaiting.addRow(data);
                   
                   dataWaiting.getColumn(dataWaiting.getColumnName(5)).setCellRenderer(new JButtonRenderer());
                   dataWaiting.getColumn(dataWaiting.getColumnName (5)).setCellEditor(new btnApprove());
                
                   dataWaiting.getColumn(dataWaiting.getColumnName(6)).setCellRenderer(new JButtonRenderer());
                   dataWaiting.getColumn(dataWaiting.getColumnName (6)).setCellEditor(new btnReject());
                }  
            }
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
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
        Jscroll1 = new javax.swing.JScrollPane();
        dataWaiting = new logbook.swing.table.Table();
        roundPanel2 = new logbook.swing.RoundPanel();
        Jscroll2 = new javax.swing.JScrollPane();
        dataApprove = new logbook.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        key = new javax.swing.JTextField();

        setBackground(new java.awt.Color(245, 245, 245));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        dataWaiting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Instansi", "Keperluan", "Tanggal", "Status", "Approve", "Reject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jscroll1.setViewportView(dataWaiting);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jscroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jscroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel2.setRound(10);

        dataApprove.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "No Telp", "Instansi", "Keperluan", "Tanggal", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jscroll2.setViewportView(dataApprove);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jscroll2)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jscroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(125, 125, 125));
        jLabel1.setText("List Data Approve/Reject");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(125, 125, 125));
        jLabel2.setText("List Data Waiting");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Cari Data    :");

        key.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void keyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyKeyReleased
        String key_name = key.getText();
        System.out.println(key_name);
        if ( key_name != "" ) {
            cariData(key_name);
        }else{
            dataWaiting();
        }
    }//GEN-LAST:event_keyKeyReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Jscroll1;
    private javax.swing.JScrollPane Jscroll2;
    private logbook.swing.table.Table dataApprove;
    private logbook.swing.table.Table dataWaiting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField key;
    private logbook.swing.RoundPanel roundPanel1;
    private logbook.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
