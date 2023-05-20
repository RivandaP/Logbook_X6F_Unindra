package logbook.form;

import db.db;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logbook.card.ModelCard;
import logbook.chart.ModelChart;


public class Form_Dashboard extends javax.swing.JPanel {

    private Connection conn = new db().connect();
    
    public Form_Dashboard()  {
        initComponents();
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        chart();
        try {
            dataChart();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        chart.start();
        
        
    }

    private void init() throws SQLException {
        
        //  init card data
        Statement show=conn.createStatement();
        List<String> jumlah = new ArrayList<String>();
        
         ResultSet jmlApprove = show.executeQuery("SELECT COUNT(nama) as 'jumlah' from visitor_log where status ='approve' and tanggal between (NOW()- interval 6 day) and now(); " );  
            while(jmlApprove.next()){
                
                Object[] data={
                   jumlah.add(jmlApprove.getString("jumlah"))
                };
            } 
          
          ResultSet jmlWaiting = show.executeQuery("SELECT COUNT(nama) as 'jumlah' from visitor_log where status ='waiting' and tanggal between (NOW()- interval 6 day) and now(); " );  
            while(jmlWaiting.next()){
                
                Object[] data={
                   jumlah.add(jmlWaiting.getString("jumlah"))
                };
            }
            
          ResultSet jmlReject = show.executeQuery("SELECT COUNT(nama) as 'jumlah' from visitor_log where status ='reject' and tanggal between (NOW()- interval 6 day) and now(); " );  
            while(jmlReject.next()){
                
                Object[] data={
                   jumlah.add(jmlReject.getString("jumlah"))
                };
            } 
            
        card1.setData(new ModelCard(null, null, null, jumlah.get(0), "Approved"));
        card2.setData(new ModelCard(null, null, null, jumlah.get(1), "Waiting For Approval"));
        card3.setData(new ModelCard(null, null, null, jumlah.get(2), "Rejected"));
    }
    
    private void chart() {
        
        chart.addLegend("Approved", new Color(95, 243, 140));  
        chart.addLegend("Waiting", new Color(95, 211, 226)); 
        chart.addLegend("Rejected", new Color(255, 51, 51)); 
        
        
    }
    
    private void dataChart() throws SQLException {
        
        Integer approve_jml,approve_jml2,approve_jml3,approve_jml4,approve_jml5,approve_jml6,approve_jml7;
        Integer waiting_jml,waiting_jml2,waiting_jml3,waiting_jml4,waiting_jml5,waiting_jml6,waiting_jml7;
        Integer reject_jml,reject_jml2,reject_jml3,reject_jml4,reject_jml5,reject_jml6,reject_jml7;

        Statement show=conn.createStatement();
        List<String> approveLine = new ArrayList<String>();
            
            ResultSet approve_day = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW(), '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW(),'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day.next()){
                
                Object[] data={
                   approveLine.add(approve_day.getString("jumlah")),
                   approveLine.add(approve_day.getString("tgl"))
                    
                };
               
            }  
            
            ResultSet approve_day2 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 1 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 1 day,'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day2.next()){
                
                Object[] data={
                   approveLine.add(approve_day2.getString("jumlah")),
                   approveLine.add(approve_day2.getString("tgl"))
                    
                };
               
            }
            
            ResultSet approve_day3 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 2 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 2 day,'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day3.next()){
                
                Object[] data={
                   approveLine.add(approve_day3.getString("jumlah")),
                   approveLine.add(approve_day3.getString("tgl"))
                    
                };
               
            }
            
            ResultSet approve_day4 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 3 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 3 day,'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day4.next()){
                
                Object[] data={
                   approveLine.add(approve_day4.getString("jumlah")),
                   approveLine.add(approve_day4.getString("tgl"))
                    
                };
               
            }
            
            ResultSet approve_day5 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 4 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 4 day,'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day5.next()){
                
                Object[] data={
                   approveLine.add(approve_day5.getString("jumlah")),
                   approveLine.add(approve_day5.getString("tgl"))
                    
                };
               
            }
            
            ResultSet approve_day6 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 5 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 5 day,'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day6.next()){
                
                Object[] data={
                   approveLine.add(approve_day6.getString("jumlah")),
                   approveLine.add(approve_day6.getString("tgl"))
                    
                };
               
            } 
            
            ResultSet approve_day7 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 6 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 6 day,'%Y-%m-%d')), '%') and status ='approve'");  
            while(approve_day7.next()){
                
                Object[] data={
                   approveLine.add(approve_day7.getString("jumlah")),
                   approveLine.add(approve_day7.getString("tgl"))
                    
                };
               
            } 
            
            
            ////// UNTUK LINE CHART WAITING ///////
            List<String> waitingLine = new ArrayList<String>();
            
            ResultSet waiting_day = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW(), '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW(),'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day.getString("jumlah")),
                   waitingLine.add(waiting_day.getString("tgl"))
                    
                };
               
            }  
            
            ResultSet waiting_day2 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 1 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 1 day,'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day2.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day2.getString("jumlah")),
                   waitingLine.add(waiting_day2.getString("tgl"))
                    
                };
               
            }
            
            ResultSet waiting_day3 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 2 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 2 day,'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day3.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day3.getString("jumlah")),
                   waitingLine.add(waiting_day3.getString("tgl"))
                    
                };
               
            }
            
            ResultSet waiting_day4 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 3 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 3 day,'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day4.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day4.getString("jumlah")),
                   waitingLine.add(waiting_day4.getString("tgl"))
                    
                };
               
            }
            
            ResultSet waiting_day5 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 4 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 4 day,'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day5.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day5.getString("jumlah")),
                   waitingLine.add(waiting_day5.getString("tgl"))
                    
                };
               
            }
            
            ResultSet waiting_day6 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 5 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 5 day,'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day6.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day6.getString("jumlah")),
                   waitingLine.add(waiting_day6.getString("tgl"))
                    
                };
               
            } 
            
            ResultSet waiting_day7 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 6 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 6 day,'%Y-%m-%d')), '%') and status ='waiting'");  
            while(waiting_day7.next()){
                
                Object[] data={
                   waitingLine.add(waiting_day7.getString("jumlah")),
                   waitingLine.add(waiting_day7.getString("tgl"))
                    
                };
               
            } 
            
            ////// UNTUK LINE CHART reject ///////
            List<String> rejectLine = new ArrayList<String>();
            
            ResultSet reject_day = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW(), '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW(),'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day.next()){
                
                Object[] data={
                   rejectLine.add(reject_day.getString("jumlah")),
                   rejectLine.add(reject_day.getString("tgl"))
                    
                };
               
            }  
            
            ResultSet reject_day2 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 1 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 1 day,'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day2.next()){
                
                Object[] data={
                   rejectLine.add(reject_day2.getString("jumlah")),
                   rejectLine.add(reject_day2.getString("tgl"))
                    
                };
               
            }
            
            ResultSet reject_day3 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 2 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 2 day,'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day3.next()){
                
                Object[] data={
                   rejectLine.add(reject_day3.getString("jumlah")),
                   rejectLine.add(reject_day3.getString("tgl"))
                    
                };
               
            }
            
            ResultSet reject_day4 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 3 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 3 day,'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day4.next()){
                
                Object[] data={
                   rejectLine.add(reject_day4.getString("jumlah")),
                   rejectLine.add(reject_day4.getString("tgl"))
                    
                };
               
            }
            
            ResultSet reject_day5 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 4 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 4 day,'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day5.next()){
                
                Object[] data={
                   rejectLine.add(reject_day5.getString("jumlah")),
                   rejectLine.add(reject_day5.getString("tgl"))
                    
                };
               
            }
            
            ResultSet reject_day6 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 5 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 5 day,'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day6.next()){
                
                Object[] data={
                   rejectLine.add(reject_day6.getString("jumlah")),
                   rejectLine.add(reject_day6.getString("tgl"))
                    
                };
               
            } 
            
            ResultSet reject_day7 = show.executeQuery("SELECT COUNT(nama) as 'jumlah', DATE_FORMAT(NOW()- interval 6 day, '%Y-%m-%d') as 'tgl' from visitor_log where tanggal like CONCAT( (DATE_FORMAT(NOW()- interval 6 day,'%Y-%m-%d')), '%') and status ='reject'");  
            while(reject_day7.next()){
                
                Object[] data={
                   rejectLine.add(reject_day7.getString("jumlah")),
                   rejectLine.add(reject_day7.getString("tgl"))
                    
                };
               
            } 
            
            
            // force to integer
            approve_jml = Integer.parseInt(approveLine.get(0));
            approve_jml2 = Integer.parseInt(approveLine.get(2));
            approve_jml3 = Integer.parseInt(approveLine.get(4));
            approve_jml4 = Integer.parseInt(approveLine.get(6));
            approve_jml5 = Integer.parseInt(approveLine.get(8));
            approve_jml6 = Integer.parseInt(approveLine.get(10));
            approve_jml7 = Integer.parseInt(approveLine.get(12));
            
            waiting_jml = Integer.parseInt(waitingLine.get(0));
            waiting_jml2 = Integer.parseInt(waitingLine.get(2));
            waiting_jml3 = Integer.parseInt(waitingLine.get(4));
            waiting_jml4 = Integer.parseInt(waitingLine.get(6));
            waiting_jml5 = Integer.parseInt(waitingLine.get(8));
            waiting_jml6 = Integer.parseInt(waitingLine.get(10));
            waiting_jml7 = Integer.parseInt(waitingLine.get(12));
            
            reject_jml = Integer.parseInt(rejectLine.get(0));
            reject_jml2 = Integer.parseInt(rejectLine.get(2));
            reject_jml3 = Integer.parseInt(rejectLine.get(4));
            reject_jml4 = Integer.parseInt(rejectLine.get(6));
            reject_jml5 = Integer.parseInt(rejectLine.get(8));
            reject_jml6 = Integer.parseInt(rejectLine.get(10));
            reject_jml7 = Integer.parseInt(rejectLine.get(12));
            
            
            // tanggal, value approve, value waiting, value reject
            chart.addData(new ModelChart(approveLine.get(1), new double[]{approve_jml, waiting_jml, reject_jml}));
            chart.addData(new ModelChart(approveLine.get(3), new double[]{approve_jml2, waiting_jml2, reject_jml2}));
            chart.addData(new ModelChart(approveLine.get(5), new double[]{approve_jml3, waiting_jml3, reject_jml3}));
            chart.addData(new ModelChart(approveLine.get(7), new double[]{approve_jml4, waiting_jml4, reject_jml4}));
            chart.addData(new ModelChart(approveLine.get(9), new double[]{approve_jml5, waiting_jml5, reject_jml5}));
            chart.addData(new ModelChart(approveLine.get(11), new double[]{approve_jml6, waiting_jml6, reject_jml6}));
            chart.addData(new ModelChart(approveLine.get(13), new double[]{approve_jml7, waiting_jml7, reject_jml7}));
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new logbook.card.Card();
        card2 = new logbook.card.Card();
        card3 = new logbook.card.Card();
        roundPanel1 = new logbook.swing.RoundPanel();
        chart = new logbook.chart.Chart();

        setOpaque(false);

        card1.setColor1(new java.awt.Color(95, 243, 140));
        card1.setColor2(new java.awt.Color(3, 157, 27));

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));

        card3.setColor1(new java.awt.Color(255, 51, 51));
        card3.setColor2(new java.awt.Color(153, 0, 0));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private logbook.card.Card card1;
    private logbook.card.Card card2;
    private logbook.card.Card card3;
    private logbook.chart.Chart chart;
    private logbook.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
