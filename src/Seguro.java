package src;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Seguro {
    public static int casos = 1;
    final private int id;
    int VALOR_BASE = 10;
    Date dataInicio, dataFim;
    Seguradora seguradora;
    ArrayList<Sinistro> listaSinistros;
    ArrayList<Condutor> condutores;

    public Seguro(Date datainicio, Date datafim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros){
        this.id = casos;
        casos+=1;
        this.dataFim = datafim;
        this.dataInicio = datainicio;
        this.seguradora =  seguradora;
        this.listaSinistros = listaSinistros;
    }

    //getters e setters
    //não tem setter do ID pois ele é final
    public Date getDataFim() {
        return dataFim;
    }
    public Date getDataInicio() {
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
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
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
    public boolean gerarSinistro(String data,String endereço, Seguradora seguradora, Veiculo veiculo, Cliente cliente ){
        Sinistro sinistro;
        sinistro = new Sinistro("03/02/01", "Rua Walt Disney, 32", seguradora, veiculo, cliente);
        listaSinistros.add(sinistro);
        return true;
    }

    //Calcula valor
    public int calcularValor(){
        return VALOR_BASE;
    }
      
}