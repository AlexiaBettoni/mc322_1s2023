package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente_pj extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;
    ArrayList<Frota> listaFrota;
    Scanner scan = new Scanner(System.in);

    //Constructor
    public Cliente_pj(String nome, String endereço, String telefone, String email, LocalDate dataFundacao, String cnpj, ArrayList<Frota> listaFrota){
        super ( nome , endereço, email, telefone);
        this.listaFrota = listaFrota;
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
    }

    //getters e setters
    public String getcnpj(){
        return cnpj;
    }
    public LocalDate getdataFundacao(){
        return dataFundacao;
    }
    public void setdataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }

    //To String
    @Override
    public String toString() {
        String texto = "\nCliente: "+super.getNome() +", cnpj: "+ cnpj + ", telefone: "+ super.getTelefone();
        return texto;
    }

    //Frota
    public boolean atualizarFrota(){
        System.out.println("Digite a sua escolha entre as opções: 1-Excluir frota, 2-Apagar frota inteira");
        int valor = scan.nextInt();
        scan.nextLine();
        if (valor==2){
            listaFrota = null;
            return true;
        }
        return false;
    }
    
    public boolean cadastrarFrota(Frota frota){
        if (listaFrota.contains(frota)==false){
            listaFrota.add(frota);
            return true;
        }
        return false;
    }

    public boolean getVeiculosPorFrota(Frota frota){
        if (listaFrota.contains(frota)==true){
            frota.getveiculos();
            return true;
        }
        return false;
    }
}
