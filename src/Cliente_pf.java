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
    
    //Calcula o score do cliente
    public double calculaScore(){
        double idade;
        double base = CalcSeguro.VALOR_BASE.getfator();
        if (2023-dataNascimento.getYear()>=30){
            idade = CalcSeguro.FATOR_18_30.getfator();
        } else if (2023-dataNascimento.getYear()>60){
            idade = CalcSeguro.FATOR_60_90.getfator();
        } else {
            idade = CalcSeguro.FATOR_30_60.getfator();
        }
        int tam = Cliente.getlistaVeiculos().length;
        double valor = base * idade * tam;
        return valor;
    }
}
