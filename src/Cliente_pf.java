package src;

import java.time.LocalDate;
import java.util.Arrays;

public class Cliente_pf extends Cliente{
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    //Constructor
    public Cliente_pf ( String nome , String endereco , LocalDate dataLicenca , String educacao , String genero , String classeEconomica , Veiculo[] listaVeiculos , String cpf , LocalDate dataNascimento ) {
        // chama o construtor da superclasse
        super ( nome , endereco , listaVeiculos );
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this . cpf = cpf ;
        this . dataNascimento = dataNascimento ;
    }

    //getters e setters
    public String getcpf(){
        return cpf;
    }
    public void setcpf(String cpf){
        this.cpf = cpf;
    }
    public LocalDate getdataNascimento(){
        return dataNascimento;
    }
    public void setdataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public LocalDate getdataLicenca(){
        return dataLicenca;
    }
    public void setdataLicenca(LocalDate dataLicenca){
        this.dataLicenca = dataLicenca;
    }
    public String geteducacao(){
        return educacao;
    }
    public void seteducacao(String educacao){
        this.educacao = educacao;
    }
    public String getgenero(){
        return genero;
    }
    public void setgenero(String genero){
        this.genero = genero;
    }
    public String getclasseEconomica(){
        return classeEconomica;
    }
    public void setclasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }

    //to string
    public String toString(){
        String dados;
        dados ="\n-----Dados Cliente PF-----\nData de Nascimento: "+dataNascimento+"\nCPF: "+cpf+"\nNome: "+getNome()+"\nEndereço: "+getendereço()+"\nData da Licença: "+getdataLicenca()+"\nNível de educação: "+geteducacao()+"\nGenero: "+getgenero()+"\nClasse Economica: "+getclasseEconomica()+"\nLista dos veículos: "+Arrays.toString(getlistaVeiculos())+"\n";
        return dados;
    }
    
    //calculdador de digitos verificadores
    protected boolean calculadordv(String cpf){
        int d1 = 0, d2 = 0, soma1=0, soma2=0;
        boolean valido = false;

        //Calculo do primeiro digito
        for(int i=0; i<9; i++){
            int num = 10-i;
            int digito = (int)(cpf.charAt(i) - 48);
            soma1+= digito*num;;
        }
        d1=11-soma1%11;
        if (d1==11 || d1==10){
            d1=0;
        }
        
        //calculo do segundo digito
        for(int i=0; i<9; i++){
            int num = 11-i;
            int digito = (int)(cpf.charAt(i) - 48);
            soma2+= digito*num;;
        }
        soma2+= d1*2;
        d2=11-soma2%11;
        if (d2==10 || d2==11){
            d2=0;
        }

        //verificando se é valido ou não
        if ((int)(cpf.charAt(9) - 48)==d1 && (int)(cpf.charAt(10) - 48)==d2){
            valido = true;
        } 

        return valido;
    }

    //validar cpf
    public boolean validarCPF(String cpf){
        boolean veredito = true;
        boolean igual = true;

        cpf = cpf.replaceAll("[^0-9]","");
        int len = cpf.length();

        if (len!=11){
            return false;
        }

        for( int i=1; i< 11; i++)
            if (cpf.charAt(i) != cpf.charAt(0))
                igual = false;
        if (igual == true){
            return false;
        }

        if(calculadordv(cpf) == false){
            return false;
        }
        return veredito;
    }
}
