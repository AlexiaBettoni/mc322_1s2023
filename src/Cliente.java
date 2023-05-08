package src;

import java.util.Arrays;

public class Cliente {
    private String nome;
    private String endereço;
    private static Veiculo[] listaVeiculos;
    double valorSeguro;

    //Constructor
    public Cliente(String nome, String endereço, Veiculo[] listaVeiculos){
        this.nome = nome;
        this.endereço = endereço;
        Cliente.listaVeiculos = listaVeiculos;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getendereço(){
        return endereço;
    }
    public void setendereço(String endereço){
        this.endereço = endereço;
    } 
    public static Veiculo[] getlistaVeiculos(){
        return listaVeiculos;
    }
    public void setlistaVeiculos(Veiculo[] listaVeiculos){
        Cliente.listaVeiculos = listaVeiculos;
    }
    public void setvalorSeguro(double valor ){
        this.valorSeguro = valor;
    }
    
    //to string
    public String toString(){
        String dados;
        dados ="Nome: "+nome+"\nEndereço: "+endereço+"\nLista dos veículos: "+Arrays.toString(listaVeiculos)+"\n\n";
        return dados;
    }

    //Calcula score geral
    public double calculaScore(){
        double base = CalcSeguro.VALOR_BASE.getfator();
        int tam = Cliente.getlistaVeiculos().length;
        double valor = base * tam;
        return valor;
    }
}
