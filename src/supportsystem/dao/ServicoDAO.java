/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportsystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import supportsystem.database.DataBase;
import supportsystem.logging.LogController;
import supportsystem.models.Produto;
import supportsystem.models.Servico;

public class ServicoDAO {

    public ArrayList<ServicoDTO> listarServicos() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ServicoDTO> servicos = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM servico");

            while (rs.next()) {
                ServicoDTO servico = new ServicoDTO();

                servico.setId_servico(rs.getInt("id_servico"));
                servico.setDescricao_servico(rs.getString("descricao_servico"));
                servico.setPreco_servico(rs.getInt("preco_servico"));
                servicos.add(servico);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return servicos;

    }

    public void inserirServico(Servico servico) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("INSERT INTO servico (descricao_servico, preco_servico) VALUES (?, ?)");
            pstmt.setString(1, servico.getDescricao_servico());
            pstmt.setFloat(2, servico.getPreco_servico());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
    }
    
    public List<Servico> listarServicoVenda() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        List<Servico> servicos = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM servico");

            while (rs.next()) {
                Servico servico = new Servico();

                servico.setId_servico(rs.getInt("id_servico"));
                servico.setDescricao_servico(rs.getString("descricao_servico"));
                servico.setPreco_servico(rs.getFloat("preco_servico"));
                servicos.add(servico);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela SERVICO do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
        return servicos;

    }
}
