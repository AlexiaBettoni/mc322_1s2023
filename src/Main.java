package src;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Arrays;

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
        Seguradora seguradora;
        Sinistro sinistro;
        Veiculo veiculo;
        Veiculo[] veiculos, veiculos2, veiculos3, veiculos4;
        Cliente_pf clientePF, clientePFinv;
        Cliente_pj clientePJ, clientePJinv;
        LocalDate date = LocalDate.of(2020, 1, 8);

        //Cadastros
        seguradora = new Seguradora("Nossa casa","33333-2222" , "nossacasa@gmail.com.br", "Rua 7 de Setembro, 007");
        veiculos = new Veiculo[1];
        veiculo = new Veiculo("POP 030", "Batmovel", "Batman", 2002);
        veiculos[0] = new Veiculo("POP 030", "Batmovel", "Batman", 2002);
        veiculos2 = new Veiculo[1];
        veiculos2[0] = new Veiculo("POP 031", "Fusca", "WV", 2003);
        veiculos3 = new Veiculo[1];
        veiculos3[0] = new Veiculo("POP 032", "Vespa", "Piaggio", 2004);
        veiculos4 = new Veiculo[1];
        veiculos4[0] = inVeiculo();
        clientePF = new Cliente_pf("Robin", "Batcaverna", date, "Médio completo", "Homem", "média", veiculos, "355.796.820-00", date);
        clientePFinv = new Cliente_pf("Robinho", "Batcaverna", date, "Médio incompleto", "Homem", "média", veiculos2, "355.796.820-50", date);
        clientePJ = new Cliente_pj("House construçoes", "Rua prego, 333", veiculos3, "94.628.177/0001-80", date);
        clientePJinv = new Cliente_pj("House construçoes", "Rua prego, 333", veiculos4, "94.628.177/0001-00", date);
        sinistro = new Sinistro("03/02/01", "Rua Walt Disney, 32", seguradora, veiculo, clientePF);

        //Teste dos métodos to String
        System.out.println("\n\n--------Teste dos métodos to String-------\n");
        System.out.printf(sinistro.toString());
        System.out.printf(veiculo.toString());
        System.out.printf(clientePF.toString());
        System.out.printf(clientePJ.toString());
        
        //Para controle estou usando um CPF válido gerado automaticamente e depois com um cpf inválido
        System.out.println("\n\n--------Teste do Validar CPF e CNPJ-------\n");
        System.out.printf("Validar CPF method: %b\n",clientePF.validarCPF(clientePF.getcpf()));
        System.out.printf("Validar CPF method: %b\n",clientePFinv.validarCPF(clientePF.getcpf()));
        System.out.printf("Validar CNPJ method: %b\n",clientePJ.validarcnpj(clientePJ.getcnpj()));
        System.out.printf("Validar CNPJ method: %b\n",clientePJinv.validarcnpj(clientePJinv.getcnpj()));

        //Teste da classe seguradora
        System.out.println("\n\n--------Teste da classe Seguradora-------\nPrimeiro cadastrei um cpf e um cnpj e depois exclui o cpf\n");
        seguradora.cadastrarCliente(clientePF);
        seguradora.cadastrarCliente(clientePJ);
        System.out.printf("\n"+seguradora.listarClientes("ClientePJ")+"\n");
        System.out.printf("\n"+seguradora.listarClientes("ClientePF")+"\n");
        seguradora.removerCliente("Robin");
        System.out.printf("\n"+Arrays.toString(seguradora.listarClientes("ClientePF"))+"\n");
        seguradora.gerarSinistro("01/02/03", "Rua dos bobos, 0", seguradora, veiculo, clientePJinv);
        seguradora.listarSinistros();
        seguradora.vizualizarSinistro("House construçoes");   
    }
    
}
