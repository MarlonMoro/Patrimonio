/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author gusta
 */
public class ColorirReais extends DefaultTableCellRenderer {

    /**
     * 
     */
    private static final long   serialVersionUID    = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color c = Color.GREEN;
        Object text = table.getValueAt(row, 3);
       
        if(isSelected)
            c = Color.LIGHT_GRAY;
        
        label.setBackground(c);
        return label;
    }
}