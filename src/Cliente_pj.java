package src;

import java.time.LocalDate;
import java.util.Arrays;

public class Cliente_pj extends Cliente{
    private String cnpj;
    private LocalDate dataFundacao;

    //Constructor
    public Cliente_pj(String nome , String endereco ,  Veiculo[] listaVeiculos , String cnpj, LocalDate dataFundacao){
        super ( nome , endereco , listaVeiculos );
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    //getters e setters
    public String getcnpj(){
        return cnpj;
    }
    public void setcnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public LocalDate getdataFundacao(){
        return dataFundacao;
    }
    public void setdataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    //to string
    public String toString(){
        String dados;
        dados ="\n------Dados Cliente PJ-----\nData de Fundação: "+dataFundacao+"\nCNPJ: "+cnpj+"\nNome: "+getNome()+"\nEndereço: "+getendereço()+"\nLista dos veículos: "+Arrays.toString(getlistaVeiculos())+"\n";
        return dados;
    }
    
    //calculdador de digitos verificadores
    protected boolean calculadordv(String cnpj){
        int d1 = 0, d2 = 0, soma1=0, soma2=0;
        boolean valido = false;

        //Calculo do primeiro digito
        for(int i=0; i<4; i++){
            int num = 6+i;
            int digito = (int)(cnpj.charAt(i) - 48);
            soma1+= digito*num;;
        }
        for(int i=4; i<12; i++){
            int num = i-2;
            int digito = (int)(cnpj.charAt(i) - 48);
            soma1+= digito*num;;
        }
        d1=soma1%11;
        if (d1==11 || d1==10){
            d1=0;
        }
        
        //calculo do segundo digito
        for(int i=0; i<5; i++){
            int num = 5+i;
            int digito = (int)(cnpj.charAt(i) - 48);
            soma2+= digito*num;;
        }
        for(int i=5; i<12; i++){
            int num = i-3;
            int digito = (int)(cnpj.charAt(i) - 48);
            soma2+= digito*num;;
        }
        soma2+= d1*9;
        d2=soma2%11;
        if (d2==10 || d2==11){
            d2=0;
        }
        //verificando se é valido ou não
        if ((int)(cnpj.charAt(12) - 48)==d1 && (int)(cnpj.charAt(13) - 48)==d2){
            valido = true;
        } 

        return valido;
    }

    //validar cnpj
    public boolean validarcnpj(String cnpj){
        boolean veredito = true;
        boolean igual = true;

        cnpj = cnpj.replaceAll("[^0-9]","");
        int len = cnpj.length();

        if (len!=14){
            return false;
        }

        for( int i=1; i< 14; i++)
            if (cnpj.charAt(i) != cnpj.charAt(0))
                igual = false;
        if (igual == true){
            return false;
        }

        if(calculadordv(cnpj) == false){
            return false;
        }
        return veredito;
    }
}
