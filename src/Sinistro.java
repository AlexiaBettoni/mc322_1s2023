package src;

import java.time.LocalDate;

public class Sinistro {
    public static int casos = 1;
    private int id;
    private LocalDate data;
    private String endereço;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //Constructor
    public Sinistro(LocalDate data, String endereço, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.id = casos;
        casos+=1;
        this.data = data;
        this.endereço = endereço;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Setters e Getters
    public LocalDate getdata(){
        return data;
    }
    public void setdata(LocalDate data){
        this.data = data;
    }
    public String getendereço(){
        return endereço;
    }
    public void setenderço(String endereço){
        this.endereço = endereço;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public Seguradora getseguradora(){
        return seguradora;
    }
    public void setid(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public Veiculo getveiculo(){
        return veiculo;
    }
    public void setveiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public Cliente getcliente(){
        return cliente;
    }
    public void setcliente(Cliente cliente){
        this.cliente = cliente;
    }

    //to String
    public String toString() {
        String texto = "\nSinistro id: "+ id+", data: "+data+ ", seguradora: "+ seguradora+ ", nome do cliente: "+ cliente.getNome()+ ", placa do veículo: "+ veiculo.getplaca();
        return texto;
    }
    
}

