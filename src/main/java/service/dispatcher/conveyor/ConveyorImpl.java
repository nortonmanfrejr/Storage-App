package service.dispatcher.conveyor;

import model.jComboBoxModel.CBoxModel;
import model.jComboBoxModel.ComboBoxModelInterface;
import service.dispatcher.DispatcherEquipamento;
import service.dispatcher.DispatcherInterface;
import view.DisplayAnswer;
import view.requierements.StaticFieldRequierementsVar;

import java.util.ArrayList;
import java.util.List;

public class ConveyorImpl implements ConveyorInterface{

    private final DispatcherInterface dispatcherInterface;
    private final DispatcherInterface dispatcherEquipamento = new DispatcherEquipamento();

    DisplayAnswer displayAnswer;
    ComboBoxModelInterface dataList = new CBoxModel();

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


    private List<String> listOfValues(String col){
        return dataList.dataListForJCBModel(
                "SELECT * FROM tbequipamento WHERE patrimonio = ? OR servicetag = ?",
                col,

                valueOfPatrimonio(),
                valueOfServiceTag()
        );
    }

    private void displayOk(String message) {
        displayAnswer = new DisplayAnswer();
        displayAnswer.confirmDisplay(message);
    }

    @Override
    public void insert() {
        if (!listOfValues("patrimonio").contains(valueOfPatrimonio()) &&
                !listOfValues("servicetag").contains(valueOfServiceTag())
        ) {

            dispatcherEquipamento.valueForInsert();
            dispatcherInterface.valueForInsert();
        } else
            displayOk("O equipamento ja existe em nossos registros.");
    }

    private final String notExists = "Equipamento não listado.";

    @Override
    public void update() {
        if (!listOfValues("patrimonio").contains(valueOfPatrimonio()) &&
                !listOfValues("servicetag").contains(valueOfServiceTag()))

            displayOk(notExists);
        else {
            dispatcherEquipamento.valueForUpdate();
            dispatcherInterface.valueForUpdate();
            displayOk("Alterado com sucesso.");
        }
    }

    @Override
    public void delete() {
        if (!listOfValues("patrimonio").contains(valueOfPatrimonio()) ||
                !listOfValues("servicetag").contains(valueOfServiceTag()))
            displayOk(notExists);

        else {
                dispatcherInterface.valueForDelete();
                dispatcherEquipamento.valueForDelete();
                displayOk("Excluido com sucesso!");
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
