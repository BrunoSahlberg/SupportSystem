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
import supportsystem.models.Vendedor;

public class VendedorDAO {

    public List<Vendedor> listarVendedores() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM vendedor");

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();

                vendedor.setId_vendedor(rs.getInt("id_vendedor"));
                vendedor.setNome_vendedor(rs.getString("nome_vendedor"));
                vendedor.setPc_comissao(rs.getInt("pc_comissao"));
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela VENDEDOR do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
        return vendedores;

    }

    public boolean validaComissao(Vendedor vendedor) throws SQLException {
        if (vendedor.getPc_comissao() >= 60) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaVendedor(Vendedor vendedor) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        if (validaComissao(vendedor) == true) {
            try {
                pstmt = db.getConnection().prepareStatement("INSERT INTO vendedor (id_vendedor, nome_vendedor, pc_comissao) VALUES (?, ?, ?)");
                pstmt.setInt(1, vendedor.getId_vendedor());
                pstmt.setString(2, vendedor.getNome_vendedor());
                pstmt.setInt(3, vendedor.getPc_comissao());
                pstmt.execute();

                pstmt = db.getConnection().prepareStatement("delete from vendedor where id_vendedor = ?");
                pstmt.setInt(1, vendedor.getId_vendedor());
                pstmt.execute();

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                db.close();
            }
        }
        return true;
    }

    public void inserirVendedor(Vendedor vendedor) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("INSERT INTO vendedor (nome_vendedor, pc_comissao) VALUES (?, ?)");
            pstmt.setString(1, vendedor.getNome_vendedor());
            pstmt.setInt(2, vendedor.getPc_comissao());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
    }

    public ArrayList<VendedorDTO> deleteVendedor(VendedorDTO vendedordto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("delete from vendedor where id_vendedor = ?");
            pstmt.setInt(1, vendedordto.getId_vendedor());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }

    public void alterarVendedor(Vendedor vendedor) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("update vendedor set nome_vendedor = ?, pc_comissao= ? where id_vendedor = ?");
            pstmt.setString(1, vendedor.getNome_vendedor());
            pstmt.setInt(2, vendedor.getPc_comissao());
            pstmt.setInt(3, vendedor.getId_vendedor());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela VENDEDOR do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
    }

}
