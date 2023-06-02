package src;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SeguroPJ extends Seguro{
    Cliente_pj cliente;
    Frota frota;
    boolean autoriza = true;
    int VALOR_BASE = 10;
    int qtdFuncionarios;

    public SeguroPJ(Frota frota, Cliente_pj cliente, LocalDate dataini, LocalDate datafim, Seguradora seguradora,  ArrayList<Sinistro> listaSinistros, int funcionarios, ArrayList<Condutor> condutors){
        super(dataini, datafim, seguradora, listaSinistros, cliente);
        this.cliente = cliente;
        this.frota = frota;
        this.qtdFuncionarios = funcionarios;
        this.condutores = condutors;
    }

    //getters e setters
    @Override
    public Cliente getCliente() {
        return cliente;
    }
    public Frota getFrota() {
        return frota;
    }
    public void setCliente(Cliente_pj cliente) {
        this.cliente = cliente;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }
    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    //to String
    @Override
    public String toString() {
        String texto = "\nSeguro id: "+super.getId() +", Seguradora: "+super.getSeguradora()+", Dados do cliente: "+cliente.toString();
        return texto;
    }

    //Autorização do condutor 
    @Override
    public boolean autorizarCondutor(Condutor condutor){
        if (condutores.contains(condutor)==false){
            condutores.add(condutor);
            return true;
        }
        return false; 
    }
    @Override
    public boolean desautorizarCondutor(Condutor condutor){
        if (condutores.contains(condutor)==true){
            condutores.remove(condutor);
            return true;
        }
        return false;
    }
    

    //Calcula valor
    public int calculaValor(){
        int valor;

        //saber a idade em anos
        Period intervalo = Period.between(cliente.getdataFundacao(), LocalDate.now());
        int idade = intervalo.getYears();

        valor = VALOR_BASE * (10 + qtdFuncionarios /10) * (1 + 1/( frota.getListaVeiculos().size()+2) ) * (1 + 1/(idade + 2) ) * (2 + listaSinistros.size() /10) * (5 + condutores.size() /10);
        return valor;
    }

    //Gerar Sinistro
    public boolean gerarSinistro(LocalDate data,String endereço, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        Sinistro sinistro;
        sinistro = new Sinistro(data, endereço, seguradora, veiculo, cliente);
        listaSinistros.add(sinistro);
        return true;
    }
}
