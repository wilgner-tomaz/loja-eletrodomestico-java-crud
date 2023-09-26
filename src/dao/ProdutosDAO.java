
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logico.LogicoProd;
import conexao.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ProdutosDAO {
    
    Connection Conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LogicoProd> lista = new ArrayList<>();
    
    public void cadastrarProd(LogicoProd lp) throws SQLException{
        String sql = "insert into tbProdutos(nome_prod,qtde_prod,preco_prod,tipo_prod,marca_prod)values(?,?,?,?,?)";      
        Conn = Conexao.getconexao();
        
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setString(1, lp.getNomeProd());
            pstm.setString(2, lp.getQtdeProd());
            pstm.setString(3, lp.getPrecoProd());
            pstm.setString(4, lp.getTipoProd());
            pstm.setString(5, lp.getMarcaProd());
            //executando o codigo sql
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
        }
    }
    
    public void editarProd(LogicoProd lp) throws SQLException{
        String sql = "UPDATE tbProdutos SET nome_prod=?,"+
            "qtde_prod=?, preco_prod=?, tipo_prod=?, marca_prod=? WHERE id_prod=?";
        Conn = Conexao.getconexao();
        
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setString(1, lp.getNomeProd());
            pstm.setString(2, lp.getQtdeProd());
            pstm.setString(3, lp.getPrecoProd());
            pstm.setString(4, lp.getTipoProd());
            pstm.setString(5, lp.getMarcaProd());
            pstm.setInt(6, lp.getIdProd());
            //executa o codigo sql
            pstm.executeUpdate();
            //encerrar codigo sql
            pstm.close();
        } catch (Exception e) {
        }
    }
    public ArrayList<LogicoProd> pesquisarProdutos() {
        String sql = "select * from tbProdutos";
        Conn = Conexao.getconexao();
        
        try {
            pstm = Conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                LogicoProd lp = new LogicoProd();
                lp.setIdProd(rs.getInt("id_prod"));
                lp.setNomeProd(rs.getString("nome_prod"));
                lp.setQtdeProd(rs.getString("qtde_prod"));
                lp.setPrecoProd(rs.getString("preco_prod"));
                lp.setTipoProd(rs.getString("tipo_prod"));
                lp.setMarcaProd(rs.getString("marca_prod"));
                
                lista.add(lp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Funcao Pesquisar DAO" +e);
            }
        return lista;
    }
    public void remover(LogicoProd lp) throws SQLException{
        String sql = "delete from tbProdutos where id_prod = ?";
        Conn = Conexao.getconexao();
        
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setInt(1, lp.getIdProd());
            //executa o codigo sql
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
        }
    }
}
