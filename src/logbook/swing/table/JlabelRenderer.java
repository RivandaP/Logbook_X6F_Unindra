/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package logbook.swing.table;

import java.awt.Component;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author keratampan
 */
public class JlabelRenderer {

    JLabel lbl = new JLabel();

    public JlabelRenderer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * @param args the command line arguments
     */
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
      lbl.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icon/approve.png"))));
      //lbl.setIcon(icon);
      return lbl;
}
    
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
