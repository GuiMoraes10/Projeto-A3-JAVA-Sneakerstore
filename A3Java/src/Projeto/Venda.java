
package Projeto;


public class Venda {
    
    private String data;
    private String nomeProduto;
    private int quantidadeProduto;
    private double valorVenda;

    public Venda(String data, String nomeProduto, int quantidadeProduto, double valorVenda) {
        this.data = data;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorVenda = valorVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "data=" + data + ", nomeProduto=" + nomeProduto + ", quantidadeProduto=" + quantidadeProduto + ", valorVenda=" + valorVenda + '}';
    }
    
    
    
    
    
}
