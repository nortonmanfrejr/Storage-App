package model.abstractTableModel;

import model.objectModel.Maquina;
import model.objectModel.Monitor;
import view.requierements.StaticFieldRequierementsVar;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MonitorTBModel extends AbstractTableModel {

    private String[] cols = {
            "Patrimonio",
            "Service Tag",
            "Marca",
            "Modelo",
            "Ajustabilidade",
            "Andar",
            "Departamento",
            "Setor",
            "Observação",
            "Status"
    };
    private List<Monitor> data;

    public MonitorTBModel(List<Monitor> data) {
        this.data = data;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Monitor x = data.get(rowIndex);

        switch (columnIndex) {
            case 0: return x.getEquipamento().getPatrimonio();
            case 1: return x.getEquipamento().getServicetag();
            case 2: return x.getEquipamento().getMarca();
            case 3: return x.getEquipamento().getModelo();
            case 4: return x.getAjustabilidade();
            case 5: return x.getEquipamento().getAmbiente().getAndar();
            case 6: return x.getEquipamento().getAmbiente().getDepartamento();
            case 7: return x.getEquipamento().getAmbiente().getSetor();
            case 8: return x.getEquipamento().getObservacao();
            case 9: return x.getEquipamento().getStatus();

            default: throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }


    public void reloadTable(List<Monitor> data) {
        this.data = data;
        this.fireTableDataChanged();
    }
    public void reloadTableWithSetValues(List<Monitor> data) {
        this.data = data;
        this.fireTableDataChanged();
    }

}
