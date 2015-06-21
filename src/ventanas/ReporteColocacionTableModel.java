package ventanas;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import modelo.Colocacion;
import modelo.ReporteColocacionView;

public class ReporteColocacionTableModel extends AbstractTableModel {

	private Vector<ReporteColocacionView> reportesColocacion;
	
	@Override
	public int getColumnCount() {

		return 4;
	}
	
	public ReporteColocacionTableModel(Vector<ReporteColocacionView> reportesColocacion) {
		super();
		this.reportesColocacion = reportesColocacion;
	}

	@Override
	public int getRowCount() {
		return reportesColocacion.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		Object value = null;
		
		switch (columnIndex) {
	         case 0:
	             value = this.reportesColocacion.elementAt(rowIndex).getEdicion();
	             break;
	         case 1:
	        	 value = this.reportesColocacion.elementAt(rowIndex).getVendedor();
	             break;
	         case 2:
	        	 value = this.reportesColocacion.elementAt(rowIndex).getCantEntregada();
	             break;
	         case 3:
	        	 value = this.reportesColocacion.elementAt(rowIndex).getCantDevuelta();
	             break;
		 }
		 return value;
	}

	@Override
	public String getColumnName(int columnIndex) {
	    
		String name = "";
		
		switch(columnIndex) {
		
			case 0: 
				name = "Edicion";
				break;
			case 1: 
				name = "Vendedor";
				break;
			case 2: 
				name = "Cantidad entrega";
				break;				
			case 3: 
				name = "Cantidad devolucion";
				break;				
		}
		
		return name;
	}
}
