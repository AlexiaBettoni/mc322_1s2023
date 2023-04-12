package src;

import java.util.Arrays;

public class Cliente {
    private String nome;
    private String endereço;
    private Veiculo[] listaVeiculos;

    //Constructor
    public Cliente(String nome, String endereço, Veiculo[] listaVeiculos){
        this.nome = nome;
        this.endereço = endereço;
        this.listaVeiculos = listaVeiculos;
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
    
    public Veiculo[] getlistaVeiculos(){
        return listaVeiculos;
    }
    public void setlistaVeiculos(Veiculo[] listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }
    

    //to string
    public String toString(){
        String dados;
        dados ="Nome: "+nome+"\nEndereço: "+endereço+"\nLista dos veículos: "+Arrays.toString(listaVeiculos)+"\n\n";
        return dados;
    }
}
