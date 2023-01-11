
package Projeto;


public class Produto {
    
    private String nomeProd;
    private int quantidadeProd;
    private float precoProd;
    private int tamanhoProd;
    private char tipoProd;
    private String dataCadastro;

    public Produto(String nomeProd, int quantidadeProd, float precoProd, int tamanhoProd, char tipoProd, String dataCadastro) {
        this.nomeProd = nomeProd;
        this.quantidadeProd = quantidadeProd;
        this.precoProd = precoProd;
        this.tamanhoProd = tamanhoProd;
        this.tipoProd = tipoProd;
        this.dataCadastro=dataCadastro;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getQuantidadeProd() {
        return quantidadeProd;
    }

    public void setQuantidadeProd(int quantidadeProd) {
        this.quantidadeProd = quantidadeProd;
    }

    public float getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(float precoProd) {
        this.precoProd = precoProd;
    }

    public int getTamanhoProd() {
        return tamanhoProd;
    }

    public void setTamanhoProd(int tamanhoProd) {
        this.tamanhoProd = tamanhoProd;
    }

    public char getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(char tipoProd) {
        this.tipoProd = tipoProd;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    

    @Override
    public String toString() {
        return "Produto{" + "nomeProd=" + nomeProd + ", quantidadeProd=" + quantidadeProd + ", precoProd=" + precoProd + ", tamanhoProd=" + tamanhoProd + ", tipoProd=" + tipoProd + '}';
    }
    
    

}
