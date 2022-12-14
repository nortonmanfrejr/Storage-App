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
public class EquipamentoFromAnotherObjects implements ObjectInterface{

    private String patrimonio;
    private String servicetag;
    private String marca;
    private String modelo;
    private String observacao;
    private String tipoEquipamento;
    private String status;

    private String disponivelEmprestimo;
    private String emprestado;

    private Ambiente ambiente;


    public EquipamentoFromAnotherObjects(String... params){
        this.setDisponivelEmprestimo(params[0]);
        this.setTipoEquipamento(params[1]);
        this.setPatrimonio(params[2]);
        this.setServicetag(params[3]);
        this.setModelo(params[4]);
        this.setMarca(params[5]);
        this.ambiente = new Ambiente(
                params[6],
                params[7],
                params[8]
        );
        this.setObservacao(params[9]);
        this.setStatus(params[10]);
    }


    ConnectorInterface connectorInterface;
    public List<Object> list;

    @Override
    public List<Object> listForSQL(PreparedStatement pstm) {
        try {
            connectorInterface = new Connector();

            list = new ArrayList<>();
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) list.add(new EquipamentoFromAnotherObjects(
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
                    resultSet.getString("status")));

            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectorInterface.closeConnection();
        }
        return list;
    }
}