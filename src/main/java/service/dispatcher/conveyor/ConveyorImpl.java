package service.dispatcher.conveyor;

import model.jComboBoxModel.CBoxModel;
import model.jComboBoxModel.ComboBoxModelInterface;
import service.dispatcher.DispatcherEquipamento;
import service.dispatcher.DispatcherInterface;
import view.DisplayImpl;
import view.requierements.FieldAssistant;
import view.requierements.StaticFieldRequierementsVar;

import java.util.List;

public class ConveyorImpl implements ConveyorInterface{

    private final DisplayImpl display = new DisplayImpl();
    private final DispatcherInterface dispatcherEquipamento = new DispatcherEquipamento();
    private final DispatcherInterface dispatcherInterface;
    private ComboBoxModelInterface dataList = new CBoxModel();



    public ConveyorImpl(DispatcherInterface dispatcherInterface) {
        this.dispatcherInterface = dispatcherInterface;
    }

    private String valueOfPatrimonio(){
        return StaticFieldRequierementsVar.
                txfPatrimonio.
                getText();
    }

    private String valueOfServiceTag(){
        return StaticFieldRequierementsVar.
                txfServiceTag.
                getText();
    }

    private String valueOfTxfBuscar() {
        return StaticFieldRequierementsVar.txf_campoDeBusca.getText();
    }


    private List<String> listOfValues(String col){
        return dataList.dataListForJCBModel(
                "SELECT * FROM tbequipamento WHERE patrimonio = ? OR servicetag = ?",
                col,

                valueOfPatrimonio(),
                valueOfServiceTag()
        );
    }

    private List<String> listOfValues2(String col){
        return dataList.dataListForJCBModel(
                "SELECT * FROM tbequipamento WHERE patrimonio = ? OR servicetag = ?",
                col,

                valueOfTxfBuscar(),
                valueOfTxfBuscar()
        );
    }

    @Override
    public void insert() {
        if (!listOfValues("patrimonio").contains(valueOfPatrimonio()) &&
                !listOfValues("servicetag").contains(valueOfServiceTag())
        ) {

            dispatcherEquipamento.valueForInsert();
            dispatcherInterface.valueForInsert();
        } else
            display.displayWithOk("O equipamento ja existe em nossos registros.");
    }

    private final String notExists = "Equipamento não listado.";

    @Override
    public void update() {
        if (!listOfValues2("patrimonio").contains(valueOfTxfBuscar()) &&
                !listOfValues2("servicetag").contains(valueOfTxfBuscar()))

            display.displayWithOk(notExists);
        else {
            dispatcherEquipamento.valueForUpdate();
            dispatcherInterface.valueForUpdate();
            StaticFieldRequierementsVar.txf_campoDeBusca.setText("Campo de Busca...");
            display.displayWithOk("Alterado com sucesso.");
        }
    }

    @Override
    public void delete() {
        if (!listOfValues2("patrimonio").contains(valueOfTxfBuscar()) &&
                !listOfValues2("servicetag").contains(valueOfTxfBuscar()))

            display.displayWithOk(notExists);
        else {
            dispatcherInterface.valueForDelete();
            dispatcherEquipamento.valueForDelete();
            StaticFieldRequierementsVar.txf_campoDeBusca.setText("Campo de Busca...");
            display.displayWithOk("Excluido com sucesso!");

        }
    }

    @Override
    public List read() {
        return dispatcherInterface.valueForRead();
    }

    @Override
    public List search() {
        return dispatcherInterface.valueForSearch(
                StaticFieldRequierementsVar.txf_campoDeBusca.getText(),
                StaticFieldRequierementsVar.txf_campoDeBusca.getText()
        );
    }
}
