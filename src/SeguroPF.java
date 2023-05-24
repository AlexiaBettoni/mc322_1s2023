package src;

import java.sql.Date;
import java.util.ArrayList;

public class SeguroPF extends Seguro{
    Cliente_pf cliente;
    Veiculo veiculo;
    boolean autoriza = true;
    int VALOR_BASE = 10;

    public SeguroPF(Veiculo veiculo, Cliente_pf cliente, Date dataini, Date datafim, Seguradora seguradora,  ArrayList<Sinistro> listaSinistros){
        super(dataini, datafim, seguradora, listaSinistros);
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    //getters e setters
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente_pf cliente) {
        this.cliente = cliente;
    }

    //to String
    public String toString() {
        String dados;
        dados ="\n------Dados Seguro PJ-----\nCliente: "+cliente.getNome()+"\nCPF: "+cliente.getcpf()+"\nVeiculo: "+veiculo+"\nAutorização do condutor: "+autoriza+"\n";
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
    public double calculaValor(int idade, int qtdvei, int anos, int sinCli, int sinCond){
        double FATOR_IDADE;
        double valor;

        if (idade<30){
            FATOR_IDADE = 1.25;
        } else if( idade < 60){
            FATOR_IDADE = 1;
        } else {
            FATOR_IDADE = 1.5;
        }

        valor = VALOR_BASE * FATOR_IDADE * (1 + 1/( qtdvei +2) ) * (2 + sinCli /10) * (5 + sinCond /10);
        return valor;
    }
}
