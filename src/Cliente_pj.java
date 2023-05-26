package src;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente_pj extends Cliente{
    private final String cnpj;
    private Date dataFundacao;
    ArrayList<Frota> listaFrota;
    Scanner scan = new Scanner(System.in);

    //Constructor
    public Cliente_pj(String nome, String endereço, String telefone, String email, Date dataFundacao, String cnpj, ArrayList<Frota> listaFrota){
        super ( nome , endereço, email, telefone);
        this.listaFrota = listaFrota;
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
    }

    //getters e setters
    public String getcnpj(){
        return cnpj;
    }
    public Date getdataFundacao(){
        return dataFundacao;
    }
    public void setdataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
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
