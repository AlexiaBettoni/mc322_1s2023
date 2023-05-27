package src;
import java.sql.Date;
import java.util.ArrayList;

public class Cliente_pf extends Cliente{
    private final String cpf;
    private String genero, educacao;
    private Date dataNasc;
    private ArrayList<Veiculo> listaVeiculos;

    //Constructor
    public Cliente_pf ( String nome, String endereço, String telefone, String email, String cpf, String genero, String educacao, Date dataNasc, ArrayList<Veiculo> listaVeiculos ) {
        // chama o construtor da superclasse
        super ( nome, endereço, telefone, email );
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.educacao = educacao;
        this.genero = genero;
        this.listaVeiculos = listaVeiculos;
    }

    //getters e setters
    public String getCpf() {
        return cpf;
    }
    public Date getDataNasc() {
        return dataNasc;
    }
    public String getEducacao() {
        return educacao;
    }
    public String getGenero() {
        return genero;
    }
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    //To String
    @Override
    public String toString() {
        String texto = "\nCliente: "+super.getNome() +", cpf: "+cpf+ ", telefone: "+ super.getTelefone();
        return texto;
    }

    //Alteração da Frota
    public boolean cadastrarVeiculo(Veiculo veiculo){
        if (listaVeiculos.contains(veiculo)==false){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }
    public boolean removeVeiculo(Veiculo veiculo){
        if (listaVeiculos.contains(veiculo)==true){
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }
}
