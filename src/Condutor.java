package src;

import java.sql.Date;
import java.util.ArrayList;

public class Condutor {
    String nome, telefone, endereco, email;
    final String cpf;
    Date dataNasc;
    ArrayList<Sinistro> listaSinistros;
    
    public Condutor(String nome, String telefone, String endereco, String email, String cpf, Date data, ArrayList<Sinistro> lista){
        this.cpf = cpf;
        this.dataNasc = data;
        this.telefone = telefone;
        this.email = email;
        this.listaSinistros = lista;
        this.nome = nome;
    }

    //getters e setters
    public String getCpf() {
        return cpf;
    }
    public Date getDataNasc() {
        return dataNasc;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //To String
    public String toString() {
        String texto = "\nCondutor: "+nome +", cpf: "+cpf+ ", telefone: "+ telefone;
        return texto;
    }

    //Add sinistro
    public void addSinistro(Sinistro sin){
        listaSinistros.add(sin);
    }
}
