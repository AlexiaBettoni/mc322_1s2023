package src;

public class SeguroPJ {
    Cliente_pj cliente;
    Frota frota;
    boolean autoriza = true;
    int VALOR_BASE = 10;

    public SeguroPJ(Frota frota, Cliente_pj cliente){
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
    public boolean autorizarCondutor(){
        autoriza = true;
        return true;
    }
    public boolean desautorizarCondutor(){
        autoriza = false;
        return false;
    }

    //Calcula valor
    public int calculaValor(int funcionarios, int veiculos, int anos, int sinCli, int sinCond){
        int valor;
        valor = VALOR_BASE * (10 + funcionarios /10) * (1 + 1/( veiculos +2) ) * (1 + 1/( anos + 2) ) * (2 + sinCli /10) * (5 + sinCond /10);
        return valor;
    }

}
