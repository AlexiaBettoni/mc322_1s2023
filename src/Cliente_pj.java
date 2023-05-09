package src;

import java.time.LocalDate;
import java.util.Arrays;

public class Cliente_pj extends Cliente{
    private String cnpj;
    private LocalDate dataFundacao;
    private int quantidadeFuncionarios;

    //Constructor
    public Cliente_pj(String nome , String endereco ,  Veiculo[] listaVeiculos , String cnpj, LocalDate dataFundacao, int quantidadeFuncionarios){
        super ( nome , endereco , listaVeiculos );
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    //getters e setters
    public String getcnpj(){
        return cnpj;
    }
    public void setcnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public LocalDate getdataFundacao(){
        return dataFundacao;
    }
    public void setdataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    //to string
    public String toString(){
        String dados;
        dados ="\n------Dados Cliente PJ-----\nData de Fundação: "+dataFundacao+"\nCNPJ: "+cnpj+"\nNome: "+getNome()+"\nEndereço: "+getendereço()+"\nLista dos veículos: "+Arrays.toString(getlistaVeiculos())+"\n";
        return dados;
    }

    //Calcula o score do cliente
    public double calculaScore(){
        double base = CalcSeguro.VALOR_BASE.getfator();
        int tam = Cliente.getlistaVeiculos().length;
        double valor = base * (1 + quantidadeFuncionarios/100) * tam;
        return valor;
    }

}
