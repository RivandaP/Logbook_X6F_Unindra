package logbook.swing.table;

import db.db;
import logbook.form.Form_Approval;
import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;


public class btnReject extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 1L;
        private java.sql.Connection conn = new db().connect();

	JButton button;

	public btnReject() {
		super();
                
                
		button = new javax.swing.JButton();
                button.setSize(78, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                            int input = JOptionPane.showConfirmDialog(null, "Tolak Akses ?","", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            // 0=yes, 1=no, 2=cancel
                            if ( input == 0) {
                                
                                String id = button.getText().replaceAll("Reject - ID - ", "");
                                String updatedata = "UPDATE visitor_log SET status='reject' WHERE id_visitor="+id+"";
                                String updatedata2 = "UPDATE barang_log SET status='reject' where id_visitor="+id+"";

                                try {
                                    PreparedStatement update = conn.prepareStatement(updatedata);
                                    PreparedStatement update2 = conn.prepareStatement(updatedata2);
                                    update.execute();
                                    update2.execute();
                                    JOptionPane.showMessageDialog(null,"Akses Ditolak !");
                                    Form_Approval refresh = new Form_Approval();
                                    refresh.dataWaiting();
                                    refresh.dataApprove();
                                    
                                }
                                catch (SQLException ex) {
                                       Logger.getLogger(Form_Approval.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            else {
                                System.out.println("kosong");
                            }
				
                                
			}
		});
	}
        
        

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		button.setText(value.toString());
		return button;
	}

	public boolean stopCellEditing() {
		return super.stopCellEditing();
	}

	public Object getCellEditorValue() {
		return null;
	}

	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}

	public boolean shouldSelectCell(EventObject anEvent) {
		return false;
	}

	public void cancelCellEditing() {
	}

	public void addCellEditorListener(CellEditorListener l) {
	}

	public void removeCellEditorListener(CellEditorListener l) {
	}

}
