package src;

import java.sql.Date;
import java.util.ArrayList;

public class SeguroPJ extends Seguro{
    Cliente_pj cliente;
    Frota frota;
    boolean autoriza = true;
    int VALOR_BASE = 10;

    public SeguroPJ(Frota frota, Cliente_pj cliente, Date dataini, Date datafim, Seguradora seguradora,  ArrayList<Sinistro> listaSinistros){
        super(dataini, datafim, seguradora, listaSinistros);
        this.cliente = cliente;
        this.frota = frota;
    }

    //getters e setters
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

    //to String
    public String toString() {
        String dados;
        dados ="\n------Dados Seguro PJ-----\nCliente: "+cliente.getNome()+"\nCNPJ: "+cliente.getcnpj()+"\nFrota de veículos: "+frota+"\nAutorização do condutor: "+autoriza+"\n";
        return dados;
    }

    //Autorização do condutor 
    @Override
    public boolean autorizarCondutor(Condutor condutor){
        condutores.add(condutor);
        return true;
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
    public int calculaValor(int funcionarios, int veiculos, int anos, int sinCli, int sinCond){
        int valor;
        valor = VALOR_BASE * (10 + funcionarios /10) * (1 + 1/( veiculos +2) ) * (1 + 1/( anos + 2) ) * (2 + sinCli /10) * (5 + sinCond /10);
        return valor;
    }

}
