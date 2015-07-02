package ventanas;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import controlador.Sistema;
import persistencia.CargaVendedorView;
import sun.awt.SunHints.Value;
import modelo.Colocacion;
import modelo.ReporteColocacionView;

public class DevolucionTableModel extends AbstractTableModel {

	private Vector<CargaVendedorView> cargas;
	
	@Override
	public int getColumnCount() {

		return 3;
	}
	
	public DevolucionTableModel(Vector<CargaVendedorView> cargas) {
		super();
		this.cargas = cargas;
	}

	@Override
	public int getRowCount() {
		return this.cargas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		Object value = null;
		
		switch (columnIndex) {
	         case 0:
	             value = this.cargas.elementAt(rowIndex).getCodigoVendedor();
	             break;
	         case 1:
	        	 value = this.cargas.elementAt(rowIndex).getDireccionVendedor();
	             break;
	         case 2:
	        	 value = this.cargas.elementAt(rowIndex).getDevolucion();
	             break;
		 }
		 return value;
	}

	@Override
	public String getColumnName(int columnIndex) {
	    
		String name = "";
		
		switch(columnIndex) {
		
			case 0: 
				name = "Vendedor";
				break;
			case 1: 
				name = "Direccion";
				break;
			case 2: 
				name = "Cantidad devolucion";
				break;				
		}
		
		return name;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return columnIndex == 2;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		this.cargas.elementAt(rowIndex).setDevolucion(Integer.parseInt(aValue.toString()));
	}

	public Vector<CargaVendedorView> getCargas() {
		return cargas;
	}

	public void setCargas(Vector<CargaVendedorView> cargas) {
		this.cargas = cargas;
	}
}
