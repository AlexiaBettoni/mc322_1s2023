package src;

import java.util.ArrayList;

public class Seguradora {
    private final String cnpj;
    private String nome, telefone, endereço, email;
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    //Constructor
    public Seguradora(String nome, String telefone, String email, String endereço, String cnpj){
        this.cnpj = cnpj;
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
        if ( listaClientes.contains(cliente)==false){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public void listarClientes(){
        System.out.println("\n");
        for ( Cliente cliente:listaClientes){
            System.out.printf(cliente.getNome()+", ");
        }
    }
    
    public static Cliente findByName(ArrayList<Cliente> listaClientes, String nome) {
        return listaClientes.stream().filter(cliente -> nome.equals(cliente.getNome())).findFirst().orElse(null);
    }
    
    public boolean removerCliente(String nome){
        Cliente cliente = findByName(listaClientes, nome);
        return listaClientes.remove(cliente);
    }
    
    public Cliente[] listarClientes(String tipoCliente){
        Cliente[] cpflist = new Cliente[10];
        Cliente[] cnpjlist = new Cliente[10];
        int totalcpf = 0;
        int totalcnpj = 0;

        for (int i=0; i<listaClientes.size(); i++){
            System.out.println(listaClientes.get(i));
            if (listaClientes.get(i) instanceof Cliente_pf){
                cpflist[totalcpf] = listaClientes.get(i);
                totalcpf++;
            } else {
                cnpjlist[totalcnpj] = listaClientes.get(i);
                totalcnpj++;
            }
        }
        if(tipoCliente == "ClientePJ"){
            if (cnpjlist[0] == null){
                cnpjlist = null;
            }
            return cnpjlist;
        }
        if(tipoCliente == "ClientePF"){
            if (cpflist[0] == null){
                cpflist = null;
            }
            return cpflist;
        }
        return null;
    }
    
    //Gerar e visualizar sinistros
    public void listarSinistros(){
        for (Sinistro sus:listaSinistros){
            System.out.printf(sus.toString());
        }
    }
    
    public boolean vizualizarSinistro(String cliente){
        for (Cliente nome:listaClientes){
            if (nome.getNome()==cliente){
                nome.toString();
                return true;
            }
        }
        return false;
    }
    
    
    public boolean addSinistro(Sinistro sin ){
        listaSinistros.add(sin);
        return true;
    }

    //Calcular o preço cliente
    public double calcularPrecoSeguroCliente(Cliente cliente){
        double valor = cliente.calculaScore();
        cliente.setvalorSeguro(valor);
        return valor;
    }

    public double receitaTotal(){
        int tam = listaClientes.size();
        double soma = 0;
        for( int i = 0; i < tam; i++){
            soma += calcularPrecoSeguroCliente(listaClientes.get(i));
        }
        return soma;
    }

    //Transferir veiculos de cliente para cliente
    public void Transferir(String cpfor, String cpfdis){
        Cliente origem = findByName(listaClientes, cpfor);
        Cliente distino = findByName(listaClientes, cpfdis);
        distino.setlistaVeiculos(origem.getlistaVeiculos());
    }
    
}
