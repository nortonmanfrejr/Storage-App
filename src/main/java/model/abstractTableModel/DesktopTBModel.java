package model.abstractTableModel;

import model.objectModel.Maquina;
import view.requierements.StaticFieldRequierementsVar;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DesktopTBModel extends AbstractTableModel {


    private String[] cols = {
            "Patrimonio",
            "Service Tag",
            "Marca",
            "Modelo",
            "Armazenamento",
            "RAM",
            "GPU",
            "Sistema Operacional",
            "Andar",
            "Departamento",
            "Setor",
            "Observação",
            "Status"
    };
    private List<Maquina> data;
    private Maquina x;


    public DesktopTBModel(List<Maquina> data) {
        this.data = data;
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

        Maquina x = data.get(rowIndex);

        switch (columnIndex) {
            case 0: return x.getEquipamento().getPatrimonio();
            case 1: return x.getEquipamento().getServicetag();
            case 2: return x.getEquipamento().getMarca();
            case 3: return x.getEquipamento().getModelo();
            case 4: return x.getArmazenamento();
            case 5: return x.getMemoriaRAM();
            case 6: return x.getGPU();
            case 7: return x.getSistemaOperacional();
            case 8: return x.getEquipamento().getAmbiente().getAndar();
            case 9: return x.getEquipamento().getAmbiente().getDepartamento();
            case 10: return x.getEquipamento().getAmbiente().getSetor();
            case 11: return x.getEquipamento().getObservacao();
            case 12: return x.getEquipamento().getStatus();

            default: throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    public void reloadTable(List<Maquina> data) {
        this.data = data;
        this.fireTableDataChanged();
    }

    public void reloadTableWithSetValues(List<Maquina> data) {
        this.data = data;
        this.fireTableDataChanged();
    }


}
