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

    //retorna o cliente com base no nome dele
    public static Cliente clienteporNome(Seguradora seg, String nome){
        Cliente cliente = null;
        for (Cliente clie: seg.getListaClientes()){
            if (clie.getNome()== nome){
                cliente = clie;
            }
        }
        return cliente;
    }

    public static Seguro SeguroporId(Seguradora seg, int id){
        Seguro cliente = null;
        for (Seguro clie: seg.getListaSeguros()){
            if (clie.getId()== id){
                cliente = clie;
            }
        }
        return cliente;
    }
    
    public static Seguro SeguroporCliente(Seguradora seg, Cliente nome){
        Seguro seguro = null;
        for (Seguro clie: seg.getListaSeguros()){
            if (clie.getCliente()== nome){
                seguro = clie;
            }
        }
        return seguro;
    }

    public static Sinistro SinistroporId(Seguro seg, int id){
        Sinistro cliente = null;
        for (Sinistro clie: seg.listaSinistros){
            if (clie.getid()== id){
                cliente = clie;
            }
        }
        return cliente;
    }

    //tranferência de seguro 
    public static boolean transferencia(String conta1, String conta2, Seguradora seguradora){
        Cliente cliente1 = clienteporNome(seguradora, conta1);
        Cliente cliente2 = clienteporNome(seguradora, conta2);
        if ( cliente1 == null || cliente2==null ){
            return false;
        }
        Seguro seg = SeguroporCliente(seguradora, cliente1);
        seg.setCliente(cliente2);
        return true;
    }

    //método para imprimir todos os sinistros de uma seguradora
    public static void printSinistros(Seguradora seg){
        for (Seguro seguro:seg.getListaSeguros()){
            for (Sinistro sin:seguro.getListaSinistros()){
                String string = sin.toString();
                System.out.println(string);
            }
        }
    }

    //método retorna todos os clientes pf ou pj da seguradora
    public static ArrayList<Cliente_pf> allPF(Seguradora seguradora){
        ArrayList<Cliente_pf> clientes = new ArrayList<Cliente_pf>();
        for (Cliente cliente: seguradora.getListaClientes()){
            if(cliente instanceof Cliente_pf == true){
                clientes.add((Cliente_pf)cliente);
            }
        }
        return clientes;
    }
    public static ArrayList<Cliente_pj> allPJ(Seguradora seguradora){
        ArrayList<Cliente_pj> clientes = new ArrayList<Cliente_pj>();
        for (Cliente cliente: seguradora.getListaClientes()){
            if(cliente instanceof Cliente_pj == true){
                clientes.add((Cliente_pj)cliente);
            }
        }
        return clientes;
    }

    //método para ter todas os veículos da seguradora
    public static ArrayList<Veiculo> allVeiculos(Seguradora seguradora){
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        for (Cliente_pf cpf:allPF(seguradora)){
            for (Veiculo veiculopf:cpf.getListaVeiculos()){
                veiculos.add(veiculopf);
            }
        }
        for (Cliente_pj cnpj:allPJ(seguradora)){
            for (Frota frota:cnpj.getListaFrota()){
                for(Veiculo veiculopj:frota.getListaVeiculos()){
                    veiculos.add(veiculopj);
                }
            }
        }
        return veiculos;
    }

    //método para pegar o veículo por placa 
    public static Veiculo veiculoPorPlaca(Seguradora seg, String placa){
        Veiculo carro = null;
        ArrayList<Veiculo> veiculos = allVeiculos(seg);
        for (Veiculo veiculo:veiculos){
            if (veiculo.getplaca()==placa){
                carro = veiculo;
            }
        }
        return carro;
    }

    public static boolean excluirVeiculo(Cliente cliente, Veiculo veiculo){
        boolean base;
        if (cliente instanceof Cliente_pf){
            Cliente_pf cpf = (Cliente_pf)cliente;
            base = cpf.removeVeiculo(veiculo);
            if (base == true){
                return true;
            }
        }
        if (cliente instanceof Cliente_pj){
            Cliente_pj cnpj = (Cliente_pj)cliente;
            for (Frota frota: cnpj.getListaFrota()){
                base = frota.removeVeiculo(veiculo);
                if (base == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static ArrayList<Veiculo> listarVeiculo(String nome, Seguradora seg){
        Cliente cliente= clienteporNome(seg, nome);
        if (cliente instanceof Cliente_pf){
            Cliente_pf cpf = (Cliente_pf)cliente;
            return cpf.getListaVeiculos();
        }
        if (cliente instanceof Cliente_pj){
            Cliente_pj cnpj = (Cliente_pj)cliente;
            ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
            for (Frota frota: cnpj.getListaFrota()){
                for (Veiculo carro: frota.getListaVeiculos()){
                    veiculos.add(carro);
                }
            }
            return veiculos;
        }
        return null;
    }

    public static ArrayList<Sinistro> sinistroPorCliente(Seguradora seg, String nome){
        Cliente cliente = clienteporNome(seg, nome);
        ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();
        for (Seguro seguro:seg.getListaSeguros()){
            if (seguro.getCliente() == cliente){
                sinistros = seguro.getListaSinistros();
                return sinistros;
            }
        }
        return sinistros;
    }
}
