/**
 * 
 */
package ventanas;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import persistencia.CargaVendedorView;


/**
 * @author lfuschetto
 *
 */
@SuppressWarnings("unchecked")
public class CargaVendedorTableModel extends AbstractTableModel implements TableModelListener {
	
    private static final long serialVersionUID = -8731598853835933253L;
    
    private List<String> columns;
    private Vector<CargaVendedorView> rows;
    

    public CargaVendedorTableModel(List<String> columns, Vector<CargaVendedorView> rows) {
    	super();
    	this.columns = columns;
    	this.rows = rows;
    }

	@Override
	public int getColumnCount() {
		return this.columns.size();
	}
	
	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Object value = "??";
		
        CargaVendedorView item = this.rows.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = item.getCodigoVendedor();
                break;
            case 1:
            	value = item.getDireccionVendedor();
                break;
            case 2:
            	value = item.getCarga1();
                break;
            case 3:
            	value = item.getDevolucion1();
                break;
            case 4:
            	value = item.getCarga2();
                break;
            case 5:
            	value = item.getDevolucion2();
                break;
            case 6:
            	value = item.getCarga3();
                break;
            case 7:
            	value = item.getDevolucion3();
                break;
            case 8:
            	value = item.getSalida();
                break;
        }

        return value;
        
	}
	
	@Override
	public String getColumnName(int columnIndex) {
	    return columns.get(columnIndex);
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
	     switch (col) {
	         case 8:
	             return true;
	         default:
	             return false;
	      }
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

    }
	
	/*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        if (true) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }
        
        
        System.out.println(value);
        
//        Integer.parseInt((String)value)
        rows.get(row).setSalida(Integer.parseInt((String)value));

//        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (true) {
            System.out.println("New value of data:");
//            printDebugData();
        }
    }

	public Vector<CargaVendedorView> getRows() {
		return rows;
	}
    
    



}
