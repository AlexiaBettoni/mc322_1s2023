package src;

public class SeguroPF{
    Cliente_pf cliente;
    Veiculo veiculo;
    boolean autoriza = true;
    int VALOR_BASE = 10;

    public SeguroPF(Veiculo veiculo, Cliente_pf cliente){
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
    public boolean autorizarCondutor(){
        autoriza = true;
        return true;
    }
    public boolean desautorizarCondutor(){
        autoriza = false;
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
