package ventanas;

import javax.swing.table.DefaultTableModel;

public class TablaVendedoresModel {

    private DefaultTableModel model;

    private String[] columns = {"Vendedor", "C1", "D1", "C2", "D2", "C3", "D3", "Salida"};

    private String[][] rows = {
    		{"Rivadavia 3044", "5", "4", "4", "4", "5", "4", "5"},
    		{"Corrientes 1500", "10", "6", "8", "4", "6", "6", "6"},
    		{"Rivadavia 12750", "5", "5", "6", "6", "7", "5", "7"}};

    public TablaVendedoresModel() {
        this.model = new DefaultTableModel();
        this.model.setColumnIdentifiers(columns);
        setModelRows();
    }

    private void setModelRows() {
        String prevGroup = "";
        for (String[] row : rows) {
            if (row[0].equals(prevGroup)) {
                row[0] = " ";
            } else {
                prevGroup = row[0];
            }
            this.model.addRow(row);
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }

}