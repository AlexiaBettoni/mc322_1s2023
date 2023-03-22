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
    public String tostring(int idade){
        String idadestr = Integer.toString(idade);
        return idadestr;
    }
    //calculdador de digitos verificadores
    protected int calculadordv(String cpf){
        int d1 = 0, d2 = 0, soma1=0, soma2=0;
        for(int i=2; i<11; i++){
            int pos = 11-i-1;
            soma1+=cpf.charAt((pos))*i;
        }
        for(int i=2; i<11; i++){
            int pos = 11-i-2;
            soma1+=cpf.charAt((pos))*i;
        }
        d1=soma1%11;
        d1=soma2%11;
        if (d1==1 || d1==0 ){
            d1=0;
        } else {
            d1 = 11-d1;
        }
        if (d2==1 || d2==0 ){
            d2=0;
        } else {
            d2 = 11-d2;
        }
        return d1*10+d2;
    }

    //validar cpf
    public boolean validarCPF(String cpf){
        boolean veredito = true;
        boolean igual = true;
        String dv;

        cpf = cpf.replaceAll("[^0-9]","");
        int len = cpf.length();
        if (len!=11){
            veredito = false;
        }
        for( int i=1; i< len; i++)
            if (cpf.charAt(i) != cpf.charAt(0))
                igual = false;
        if (igual == true)
            veredito = false;
        dv = Integer.toString(calculadordv(cpf));
        if(cpf.substring(9, 10)!=dv){
            veredito = false;
        }
        return veredito;
    }
    
}
