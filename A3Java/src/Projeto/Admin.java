package Projeto;

import java.sql.ResultSet;

public class Admin extends Atendente {

    public Admin(String nomeFunc, int idadeFunc, double salarioFunc, String cargoFunc, String usuario, int senha) {
        super(nomeFunc, idadeFunc, salarioFunc, cargoFunc, usuario, senha);
    }

    public void cadastrarAdmin(String nome, int idade, double salario, String cargo, String usuario, int senha) {
        Admin adm = new Admin(nome, idade, salario, cargo, usuario, senha);
        Banco banco = new Banco();
        banco.iniciarConexao();
        banco.insertAdmin(adm);
        banco.fecharConexao();

    }

    public void cadastrarAtendente(String nome, int idade, double salario, String cargo, String usuario, int senha) {
        Atendente at = new Atendente(nome, idade, salario, cargo, usuario, senha);
        Banco banco = new Banco();
        banco.iniciarConexao();
        banco.insertFuncionario(at);
        banco.fecharConexao();
    }

    public void cadastrarProduto(String nome, int quantidade, float preco, int tamanho, char tipo, String dataCadastro) {
        Produto prod = new Produto(nome, quantidade, preco, tamanho, tipo, dataCadastro);
        Banco banco = new Banco();
        banco.iniciarConexao();
        banco.insertProduto(prod);
        banco.fecharConexao();
    }

    public void removerFuncionario(String nome, String username) {
        Banco banco = new Banco();
        banco.iniciarConexao();
        banco.excluirFuncionario(nome, username);
        banco.fecharConexao();
    }

    public ResultSet gerarRelatorio(int month) {
        Banco conn = new Banco();

        conn.iniciarConexao();
        ResultSet resultSet;
        resultSet = conn.trazerRelatorio(month);
        return resultSet;

    }

    public String getLucro() {
        Banco banco = new Banco();
        banco.iniciarConexao();
        String result = banco.trazerLucro();
        
        return result;
        
    }

}
