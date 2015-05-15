package modelo;

import javax.swing.table.DefaultTableModel;

public class TablaVendedoresModel {

    private DefaultTableModel model;

    private String[] columns = {"Vendedor", "Fecha 1", "Fecha 2", "Fecha 3", "Salida"};

    private String[][] rows = {{"Group A", "all", "box", "game"},
            {"Group A", "apple", "band", "going"},
            {"Group B", "alabaster", "banquet", "ghost"},
            {"Group B", "alone", "boy", "ghoulish"}};

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