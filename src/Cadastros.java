package src;
import java.sql.Date;
import java.util.Scanner;
import java.util.ArrayList;


//Classe criada para ter métodos de cadastro através do teclado
public class Cadastros {
    static Scanner input = new Scanner(System.in);
    //Método para cadastrar a classe veículo pelo teclado
    public static Veiculo inVeiculo(){
        System.out.println("\nPara cadastrar o seu veículo digite a Placa, a marca, o modelo e o ano de fabricação do carro:");

        // input
        String placa = input.nextLine();
        String marca = input.nextLine();
        String modelo = input.nextLine();
        int ano = input.nextInt();
        input.close();

        Veiculo carro = new Veiculo(placa, marca, modelo, ano);
        return carro;
    }

    //Método para cadastrar a classe Frota
    public static Frota inFrota(){
        System.out.println("\nQuantos veículos estarão cadastrados nessa Frota?");
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        int total = input.nextInt();
        input.close();
        for (int i=0; i<total;i++){
            Veiculo carro = inVeiculo();
            veiculos.add(carro);
        }

        Frota frota = new Frota(veiculos);
        return frota;
    }

    //Método para cadastro de Cliente pf  pelo teclado
    public static Cliente_pf inClientePf(){
        // Cadastro das imformações básicas do seguro
        System.out.println("\nPara cadastrar o Cliente digite o nome, telefone, endeço e email:");
        String nome = input.nextLine();
        String telefone = input.nextLine();
        String enderço = input.nextLine();
        String email = input.nextLine();
        input.close();

        //Informações referentes ao cliente pf
        System.out.println("\nDigite o cpf, genero, eduação:");
        String cpf = input.nextLine();
        if (Validacao.validarCPF(cpf)== false){
            System.out.println("\nDigite um cpf válido:");
            cpf = input.nextLine();
        }
        String genero = input.nextLine();
        String educacao = input.nextLine();
        input.close();

        System.out.println("\nPara cadastrar a data de nascimento digite o dia, o mes e o ano, com números e sem espaço ou pontuação:");
        int num = input.nextInt();
        Date data = new Date(num);
        input.close();

        System.out.println("\nQuantos veículos estarão cadastrados nesse cliente?");
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        int total = input.nextInt();
        input.close();
        for (int i=0; i<total;i++){
            Veiculo carro = inVeiculo();
            veiculos.add(carro);
        }

        Cliente_pf novoPF = new Cliente_pf(nome, enderço, telefone, email, cpf, genero, educacao, data, veiculos); 
        return novoPF;
    }

    //Método para cadastro de Cliente pj pelo teclado
    public static Cliente_pj inClientePJ(){
        // Cadastro das imformações básicas do seguro
        System.out.println("\nPara cadastrar o Cliente digite o nome, telefone, endeço e email:");
        String nome = input.nextLine();
        String telefone = input.nextLine();
        String enderço = input.nextLine();
        String email = input.nextLine();
        input.close();

        //Informações referentes ao cliente pj
        System.out.println("\nDigite o cnpj:");
        String cnpj = input.nextLine();
        if (Validacao.validarcnpj(cnpj)== false){
            System.out.println("\nDigite um cnpj válido:");
            cnpj = input.nextLine();
        }

        System.out.println("\nPara cadastrar a data de fundação digite o dia, o mes e o ano, com números e sem espaço ou pontuação:");
        int num = input.nextInt();
        Date data = new Date(num);
        input.close();

        System.out.println("\nQuantas frotas estarão cadastradas nesse cliente?");
        ArrayList<Frota> frotas = new ArrayList<Frota>();
        int total = input.nextInt();
        input.close();
        for (int i=0; i<total;i++){
            Frota frota = inFrota();
            frotas.add(frota);
        }
        Cliente_pj novoPJ = new Cliente_pj(nome, enderço, telefone, email, data, cnpj, frotas); 
        return novoPJ;
    }

}
