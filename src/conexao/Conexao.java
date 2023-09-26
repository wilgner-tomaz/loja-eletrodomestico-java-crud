
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {
     public static Connection getconexao() {
        
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3325/bdLojaEletrodomesticos?user=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }
        return conn;
    }
}
