package model.abstractTableModel;

import model.objectModel.EquipamentoFromAnotherObjects;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EquipamentoTBModel extends AbstractTableModel {


    private String[] cols = {"Tipo","Patrimonio","Service Tag","Marca","Modelo","Andar","Departamento","Setor","Observação","Status"};
    private List<EquipamentoFromAnotherObjects> data;

    public EquipamentoTBModel(List<EquipamentoFromAnotherObjects> data) {
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

        EquipamentoFromAnotherObjects x = data.get(rowIndex);

        switch (columnIndex) {
            case 0: return x.getTipoEquipamento();
            case 1: return x.getPatrimonio();
            case 2: return x.getServicetag();
            case 3: return x.getMarca();
            case 4: return x.getModelo();
            case 5: return x.getAmbiente().getAndar();
            case 6: return x.getAmbiente().getDepartamento();
            case 7: return x.getAmbiente().getSetor();
            case 8: return x.getObservacao();
            case 9: return x.getStatus();

            default:
                throw new IndexOutOfBoundsException("Column or Table not found!!");
        }
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
}
