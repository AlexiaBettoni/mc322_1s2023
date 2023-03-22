package src;
public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereço;

    //Constructor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereço){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereço = endereço;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getdataNascimento(){
        return dataNascimento;
    }
    public void setdataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public String getcpf(){
        return cpf;
    }
    public void setcpf(String cpf){
        this.cpf = cpf;
    }
    public String getendereço(){
        return endereço;
    }
    public void setendereço(String endereço){
        this.endereço = endereço;
    }
    public int getidade(){
        return idade;
    }
    public void setidade(int idade){
        this.idade = idade;
    }

    //to string
    public String tostring(){
        String dados;
        dados ="Nome: "+nome+"\nIdade: "+idade+".\nData de Nascimento: "+dataNascimento+".\nCPF: "+cpf+".\nEndereço: "+endereço+".";
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
