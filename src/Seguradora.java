package src;

import java.util.ArrayList;

public class Seguradora {
    private final String cnpj;
    private String nome, telefone, endereço, email;
    private ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    //Constructor
    public Seguradora(String nome, String telefone, String email, String endereço, String cnpj,ArrayList<Seguro> listaSeguros,ArrayList<Cliente> listaClientes){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereço = endereço;
        this.listaClientes =listaClientes;
        this.listaSeguros = listaSeguros;
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
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    //To String
    public String toString() {
        String texto = "\nSeguradora: "+nome +", cnpj: "+cnpj+ ", telefone: "+ telefone;
        return texto;
    }

    //Cadastro e remoção clientes
    public boolean cadastrarCliente(Cliente cliente){
        if ( listaClientes.contains(cliente)==false){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }
    public boolean removerCliente(Cliente cliente){
        if ( listaClientes.contains(cliente)==true){
            listaClientes.remove(cliente);
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
    
    //Métodos do seguro
    public boolean gerarSeguro(Seguro seg){
        if ( listaSeguros.contains(seg)==false){
            listaSeguros.add(seg);
            return true;
        }
        return false;
    }
    public boolean cancelarSeguro(Seguro seg){
        if ( listaSeguros.contains(seg)==true){
            listaSeguros.remove(seg);
            return true;
        }
        return false;
    }

    //Métodos de busca de sinistros e seguros por clientes
    public ArrayList<Seguro> getSegurosPorCliente(String cliente){
        ArrayList<Seguro> seguros = new ArrayList<Seguro>();
        for (Seguro seg : listaSeguros){
            if (seg.getCliente().getNome()==cliente){
                seguros.add(seg);
            }
        }
        return seguros;
    }

    public ArrayList<Sinistro> getSinistroPorCliente(String cliente){
        ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();
        for (Seguro seg : listaSeguros){
            for (Sinistro sin: seg.getListaSinistros()){
                if (sin.getcliente().getNome() == cliente){
                    sinistros.add(sin);
                }
            } 
        }
        return sinistros;
    }

    //Método de cálculo da recita total da seguradora
    public int calculaReceita(){
        int receita = 0;
        for (Seguro seg : listaSeguros){
            receita += seg.valorMensal;
        }
        return receita;
    }
    
}
