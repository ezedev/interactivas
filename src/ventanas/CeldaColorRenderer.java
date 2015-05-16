package ventanas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class CeldaColorRenderer extends DefaultTableCellRenderer {

	private Color color;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		
		//Cells are by default rendered as a JLabel.
	    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

	    //Get the status for the current row.
	    TableModel tableModel = (TableModel) table.getModel();
	    l.setBackground(this.color);
	    
	    

	  //Return the JLabel which renders the cell.
	  return l;
	  
	}
	
	public CeldaColorRenderer(Color color) {
		this.color = color;
		
	}

}
