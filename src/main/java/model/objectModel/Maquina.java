package model.objectModel;

import connector.Connector;
import connector.ConnectorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class

Maquina implements ObjectInterface {

    private String armazenamento;
    private String memoriaRAM;
    private String GPU;
    private String sistemaOperacional;
    private String macAddres;

    private EquipamentoFromAnotherObjects equipamento;

    public Maquina(String... params){
        this.setArmazenamento(params[0]);
        this.setMemoriaRAM(params[1]);
        this.setGPU(params[2]);
        this.setSistemaOperacional(params[3]);
        this.equipamento = new EquipamentoFromAnotherObjects(
                params[4],
                params[5],
                params[6],
                params[7],
                params[8],
                params[9],
                params[10],
                params[11],
                params[12],
                params[13],
                params[14]
        );
    }


    ConnectorInterface connectorInterface;
    public List<Object> list;

    @Override
    public List<Object> listForSQL(PreparedStatement pstm) {
        try {
            connectorInterface = new Connector();

            list = new ArrayList<>();
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) list.add(new Maquina(
                    resultSet.getString("armazenamento"),
                    resultSet.getString("memoriaRAM"),
                    resultSet.getString("gpu"),
                    resultSet.getString("sistemaOperacional"),
                    resultSet.getString("disponibilidadeEmprestimo"),
                    resultSet.getString("tipoEquipamento"),
                    resultSet.getString("patrimonio"),
                    resultSet.getString("servicetag"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getString("andar"),
                    resultSet.getString("departamento"),
                    resultSet.getString("setor"),
                    resultSet.getString("observacao"),
                    resultSet.getString("status")
            ));

            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectorInterface.closeConnection();
        }
        return list;
    }

}