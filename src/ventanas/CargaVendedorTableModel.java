/**
 * 
 */
package ventanas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import persistencia.CargaVendedorView;


/**
 * @author lfuschetto
 *
 */
@SuppressWarnings("unchecked")
public class CargaVendedorTableModel extends AbstractTableModel {
	
    private static final long serialVersionUID = -8731598853835933253L;
    
    private List<String> columns;
    private List<CargaVendedorView> rows;
    

    public CargaVendedorTableModel(List<String> columns, List<CargaVendedorView> rows) {
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


}
