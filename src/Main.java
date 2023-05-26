package src;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    //Método para cadastrar a classe veículo pelo teclado
    

    public static Veiculo inVeiculo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Para cadastrar o seu veículo digite a Placa, a marca, o modelo e o ano de fabricação do carro:");

        // input
        String placa = input.nextLine();
        String marca = input.nextLine();
        String modelo = input.nextLine();
        int ano = input.nextInt();
        input.close();

        Veiculo carro = new Veiculo(placa, marca, modelo, ano);
        return carro;
    }
    public static void main(String args[]){
        Validacao val = new Validacao();
        LocalDate date = LocalDate.of(2020, 1, 8);
        LocalDate date2 = LocalDate.of(1982, 1, 8);
        MenuOperacoes menu = MenuOperacoes.VOLTAR;
        
        //Criação da seguradora e dos veículos
        Seguradora seguradora = new Seguradora("Nossa casa","33333-2222" , "nossacasa@gmail.com.br", "Rua 7 de Setembro, 007");
        Veiculo[] veiculos = new Veiculo[1];
        Veiculo veiculo = new Veiculo("POP 030", "Batmovel", "Batman", 2002);
        veiculos[0] = new Veiculo("POP 030", "Batmovel", "Batman", 2002);
        Veiculo[] veiculos2 = new Veiculo[1];
        veiculos2[0] = new Veiculo("POP 031", "Fusca", "WV", 2003);
        
        //Criação dos clientes e cadastro deles na seguradora
        Cliente clientePF = new Cliente_pf("Robin", "Batcaverna", date, "Médio completo", "Homem", "média", veiculos, "355.796.820-00", date2);
        Cliente clientePJ = new Cliente_pj("House construçoes", "Rua prego, 333", veiculos2, "18.781.203/0001-28", date, 10);
        seguradora.cadastrarCliente(clientePF);
        seguradora.cadastrarCliente(clientePJ);

        //Criação dos sinistros e cadastro deles na main
        Sinistro sin1 = new Sinistro("03/02/01", "Rua Walt Disney, 32", seguradora, veiculo, clientePF);
        Sinistro sin2 = new Sinistro("03/02/01", "Rua Walt Disney, 32", seguradora, veiculo, clientePF);
        seguradora.addSinistro(sin2);
        seguradora.addSinistro(sin1);
        seguradora.addSinistro(new Sinistro("03/02/01", "Rua Walt Disney, 32", seguradora, veiculo, clientePJ));

        //Teste da classe seguradora
        System.out.println("\n\n--------Teste da classe Seguradora-------\n\nPrimerio restaremos o Listar clientes, visualizar sinistro, listar sinistro e depois calculaar receita");
        System.out.printf("\n"+seguradora.listarClientes("ClientePJ")+"\n");
        System.out.printf("\n"+seguradora.listarClientes("ClientePF")+"\n");
        System.out.printf("\n Visualizar sinistro do Robin:"+seguradora.vizualizarSinistro("Robin")+"\n");
        System.out.printf("\n Listar sinistros:");
        seguradora.listarSinistros();
        System.out.printf("\nCalcular preço do Cliente PJ:"+clientePJ.calculaScore());
        System.out.printf("\nCalcular preço do Cliente PF:"+seguradora.calcularPrecoSeguroCliente(clientePF));
        System.out.printf("\n\nReceita total da seguradora:"+seguradora.receitaTotal());
        menu.select();
    
    }
    
}
