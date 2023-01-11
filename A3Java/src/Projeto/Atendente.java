
package Projeto;
import java.sql.ResultSet;

public class Atendente {
    private String nomeFunc;
    private int idadeFunc;
    private double salarioFunc;
    private String cargoFunc;
    private String usuario;
    private int senha;


    
    public Atendente(String nomeFunc, int idadeFunc, double salarioFunc, String cargoFunc, String usuario, int senha) {
        this.nomeFunc = nomeFunc;
        this.idadeFunc = idadeFunc;
        this.salarioFunc = salarioFunc;
        this.cargoFunc = cargoFunc;
        this.usuario = usuario;
        this.senha = senha;
    }
    public Atendente(){
        
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public int getIdadeFunc() {
        return idadeFunc;
    }

    public void setIdadeFunc(int idadeFunc) {
        this.idadeFunc = idadeFunc;
    }

    public double getSalarioFunc() {
        return salarioFunc;
    }

    public void setSalarioFunc(double salarioFunc) {
        this.salarioFunc = salarioFunc;
    }

    public String getCargoFunc() {
        return cargoFunc;
    }

    public void setCargoFunc(String cargoFunc) {
        this.cargoFunc = cargoFunc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Atendente{" + "nomeFunc=" + nomeFunc + ", idadeFunc=" + idadeFunc + ", salarioFunc=" + salarioFunc + ", cargoFunc=" + cargoFunc + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    
    public void realizarVenda(int id, int quantidade, String data,int idFuncionario){
        Banco banco = new Banco();
        banco.iniciarConexao();
        banco.venda(id, quantidade, data,idFuncionario);
        banco.fecharConexao();
        
    }

    public void consultarClientes(){
        
    }
    
    public void consultarProdutos(){
        
    }
    
    public void login(String usuario, int senha){
        Main m = new Main();
        Banco banco = new Banco();
        banco.iniciarConexao();
        banco.consultaUsuarioESenha(usuario, senha);
        banco.fecharConexao();
    }
    
    
    public void imprimirFuncionarios() {
        Banco banco = new Banco();
        banco.iniciarConexao();
        String query = "select * from sneakerstore.funcionario";
        banco.select(query);
        banco.fecharConexao();
	}    
    
    public void imprimirProdutos() {
        Banco banco = new Banco();
        banco.iniciarConexao();
        String query = "select * from sneakerstore.produto";
        banco.select(query);
        banco.fecharConexao();
    }
    
    public void imprimirVendas() {
        Banco banco = new Banco();
        banco.iniciarConexao();
        String query = "select * from sneakerstore.venda";
        banco.select(query);
        banco.fecharConexao();
    }
    
    public ResultSet getProdutos(String query){
        Banco banco = new Banco();
        banco.iniciarConexao();
        ResultSet resultSet;
        resultSet = banco.retornaConsulta(query);
        
       return resultSet;
    }

    
}
