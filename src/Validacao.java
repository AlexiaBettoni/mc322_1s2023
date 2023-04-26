package src;

public class Validacao {
    //calculdador de digitos verificadores do CPF
    protected static boolean calculadordvCPF(String cpf){
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
    public static boolean validarCPF(String cpf){
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

        if(calculadordvCPF(cpf) == false){
            return false;
        }
        return veredito;
    }

    //calculdador de digitos verificadores
    protected static boolean calculadordvCNPJ(String cnpj){
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
    public static boolean validarcnpj(String cnpj){
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

        if(calculadordvCNPJ(cnpj) == false){
            return false;
        }
        return veredito;
    }

    //Validar nome, ele verifica se tem só letras no nome
    public static boolean validaNome(String nome){
        boolean result = nome.matches("[a-zA-Z]+");
        return result;
    }
}
