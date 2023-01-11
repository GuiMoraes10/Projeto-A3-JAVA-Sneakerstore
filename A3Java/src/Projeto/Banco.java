package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Banco {

    String DB_URL = "jdbc:mysql://localhost:3306/sneakerstore";
    String DB_USER = "root";
    String DB_PASSWORD = "123456";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    ResultSet rs = null;
    public ArrayList<Object> listVendas = new ArrayList<Object>();

    public void iniciarConexao() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
        } catch (Exception erro) {
            System.err.println("Problema com a conexao");
            erro.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            statement.close();
            connection.close();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    public void atualizar(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException erro) {
            System.out.println("erro ao executar Query");
            erro.printStackTrace();
        }
    }

    public void insertProduto(Produto produto) {
        String query = "INSERT INTO sneakerstore.produto (nome_produto, quantidade_produto, preco, tamanho, tipo, dt_cadastro)"
                + "VALUES ('" + produto.getNomeProd() + "', " + produto.getQuantidadeProd() + ", "
                + produto.getPrecoProd() + ", " + produto.getTamanhoProd() + ", '" + produto.getTipoProd() + "', '"+produto.getDataCadastro()+"')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException erro) {
            System.out.println("erro ao executar Query");
            erro.printStackTrace();
        }
    }

    public void insertAdmin(Admin adm) {
        String query = "INSERT INTO sneakerstore.funcionario (nome, idade, salario, cargo, user, senha)"
                + "VALUES ('" + adm.getNomeFunc() + "', " + adm.getIdadeFunc() + ", " + adm.getSalarioFunc() + ", '"
                + adm.getCargoFunc() + "', '" + adm.getUsuario() + "', '" + adm.getSenha() + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException erro) {
            System.out.println("erro ao executar Query");
            erro.printStackTrace();
        }
    }

    public void insertFuncionario(Atendente at) {
        String query = "INSERT INTO sneakerstore.funcionario (nome, idade, salario, cargo, user, senha)"
                + "VALUES ('" + at.getNomeFunc() + "', " + at.getIdadeFunc() + ", " + at.getSalarioFunc() + ", '"
                + at.getCargoFunc() + "', '" + at.getUsuario() + "', '" + at.getSenha() + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException erro) {
            System.out.println("erro ao executar Query");
            erro.printStackTrace();
        }
    }

    public void select(String query) {
        try {
            resultSet = statement.executeQuery(query);
            int nrColunas = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i < nrColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException erro) {
            System.out.println("Aconteceu algo de errado");
            erro.printStackTrace();
        }
    }

    public void consultaUsuarioESenha(String usuario, int senha) {
        String query = "Select cargo from sneakerstore.funcionario where user ='" + usuario + "' and senha = '" + senha
                + "'";
        try {
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String retorno = resultSet.getString(1);
                System.out.println(retorno);
                if (retorno.equals("Atendente")) {
                    Main m = new Main();
                    m.frameFuncionario.setVisible(true);
                } else {
                    Main m = new Main();
                    m.frameGerente.setVisible(true);
                }
            } else {
                Main m = new Main();
                m.setVisible(true);
            }

        } catch (SQLException erro) {
            System.out.println("erro ao executar Query");
            erro.printStackTrace();
        }
    }

    public ResultSet trazerRelatorio(int month) {

        String query = "select prd.nome_produto as Produto,vd.valorvenda as Valor, vd.quantidadeproduto as Quantidade,vd.valorvenda*vd.quantidadeproduto as ValorTotal, \n"
                + "vd.data as DataVenda, fc.nome as Vendedor from venda as vd inner join produto as prd on vd.idproduto = prd.idproduto \n"
                + "inner join funcionario as fc on fc.idfuncionario = vd.idfuncionario where vd.data >= DATE_SUB(curdate(), interval "+month+" MONTH ) order by vd.data desc";
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return resultSet = null;
        }
    }

    public void excluirFuncionario(String nome, String username) {
        String query = "DELETE FROM sneakerstore.funcionario WHERE nome ='" + nome + "' and user = '" + username + "'";

        try {
            boolean tr;
            tr = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir o usuário\n" + erro);
        }
    }

    public ResultSet retornaConsulta(String query) {
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir o usuário\n" + erro);
            return resultSet;
        }

    }

    public String trazerLucro() {
        String query = "SELECT SUM(valorVenda*quantidadeproduto) as Lucro from venda";

        try {
            resultSet = statement.executeQuery(query);
            resultSet.next();

            String result = resultSet.getString(1);

            return result;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return "" + erro;
        }
    }

    public void venda(int id, int quantidadeVenda, String data, int idFuncionario) {
        String query = "select quantidade_produto from sneakerstore.produto where idproduto = " + id + "";
        int quantidadeProduto;
        try {
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                quantidadeProduto = resultSet.getInt(1);
                int quantF = quantidadeProduto - quantidadeVenda;
                if (quantidadeVenda <= quantidadeProduto && quantF >= 0) {
                    Banco banco = new Banco();
                    String query2 = "update sneakerstore.produto set quantidade_produto = " + quantF + " where idproduto = " + id + "";
                    try {
                        statement.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Venda concluida");
                    } catch (SQLException erro) {
                        System.out.println("erro ao executar query3");
                        erro.printStackTrace();
                    }
                    String query3 = "select preco, nome_produto from sneakerstore.produto where idproduto = " + id + "";
                    double preco;
                    String nome;
                    try {
                        rs = statement.executeQuery(query3);
                        if (rs.next()) {
                            preco = rs.getDouble(1);
                            System.out.println(preco);
                            nome = rs.getString(2);
                            System.out.println(nome);
                            double valor = preco * quantidadeVenda;
                            Venda venda = new Venda(data, nome, quantidadeVenda, valor);
                            String query4 = "INSERT INTO sneakerstore.venda (data,quantidadeproduto,valorvenda,idproduto,idfuncionario)"
                                    + "VALUES ('" + venda.getData() + "', '" + venda.getQuantidadeProduto() + "', " + venda.getValorVenda() + ", "
                                    + id + "," + idFuncionario + " )";
                            try {
                                statement.executeUpdate(query4);
                            } catch (SQLException erro) {
                                System.out.println("erro ao executar Query(essa)");
                                erro.printStackTrace();
                            }
                        }
                    } catch (SQLException erro) {
                        System.out.println("erro ao executar query1");
                        erro.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Quantidade Indisponivel");
                }
            }
        } catch (SQLException erro) {
            System.out.println("erro ao executar query2");
            erro.printStackTrace();
        }
    }

}
