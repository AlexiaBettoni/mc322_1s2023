package src;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    public static int casos = 1;
    final private int id;
    int VALOR_BASE = 10;
    LocalDate dataInicio, dataFim;
    Cliente cliente;
    Seguradora seguradora;
    ArrayList<Sinistro> listaSinistros;
    ArrayList<Condutor> condutores;
    int valorMensal;

    public Seguro(LocalDate datainicio, LocalDate datafim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, Cliente cliente){
        this.id = casos;
        casos+=1;
        this.dataFim = datafim;
        this.dataInicio = datainicio;
        this.seguradora =  seguradora;
        this.listaSinistros = listaSinistros;
        this.cliente = cliente;
    }

    //getters e setters
    //não tem setter do ID pois ele é final
    public LocalDate getDataFim() {
        return dataFim;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public int getValorMensal() {
        return valorMensal;
    }
    public ArrayList<Condutor> getCondutores() {
        return condutores;
    }
    
    //To String
    public String toString() {
        String texto = "\nSeguro id: "+id +", Seguradora: "+seguradora;
        return texto;
    }

    //Autorização do condutor
    public boolean autorizarCondutor(Condutor condutor){
        condutores.add(condutor);
        return true;
    }
    public boolean desautorizarCondutor(Condutor condutor){
        if (condutores.contains(condutor)==true){
            condutores.remove(condutor);
            return true;
        }
        return false;
    }

    //Gerar Sinistro
    public boolean gerarSinistro(LocalDate data,String endereço, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        Sinistro sinistro = new Sinistro(data, endereço, seguradora, veiculo, cliente);
        listaSinistros.add(sinistro);
        return true;
    }
    public boolean excluirSinistro(Sinistro sin){
        if (listaSinistros.contains(sin)==true){
            listaSinistros.remove(sin);
            return true;
        }
        return false;
    }

    //Calcula valor
    public void calcularValor(){
        this.valorMensal = VALOR_BASE;
    }
      
}
