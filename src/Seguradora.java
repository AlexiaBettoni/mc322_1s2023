package src;

import java.util.ArrayList;
import java.util.Collection;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereço;
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    //Constructor
    public Seguradora(String nome, String telefone, String email, String endereço){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereço = endereço;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String gettelefone(){
        return telefone;
    }
    public void settelefone(String telefone){
        this.telefone = telefone;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email = email;
    }
    public String getendereço(){
        return endereço;
    }
    public void setendereço(String endereço){
        this.endereço = endereço;
    }

    //Cadastro e remoção clientes
    public boolean cadastrarCliente(Cliente cliente){
        boolean teste;
        teste = listaClientes.add(cliente);
        return teste;
    }
    public static Cliente findByCpf(ArrayList<Cliente> listaClientes, String cpf) {
        return listaClientes.stream().filter(cliente -> cpf.equals(cliente.getNome())).findFirst().orElse(null);
    }
    public boolean removerCliente(String nome){
        Cliente cliente = findByCpf(listaClientes, nome);
        return listaClientes.remove(cliente);
        
    }
}
