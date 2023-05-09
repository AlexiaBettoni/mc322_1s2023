package src;
import java.util.Scanner;

//Enum com o menu de operações
public enum MenuOperacoes {
    SAIR(0),CADASTRAR(1), LISTAR(2), GERAR(4), EXCLUIR(3), TRANSFEERIR(5), CALCULAR(6),CADPFPJ(11), CADVEI(12), CADSEG(13), VOLTAR(14),LISTARCLIENTESEG(21), LISTARSINSEG(22), LISTARSINCLI(23), LISTARVEICLI(24), LISTARVEISEG(25), EXCLUIRCLI(31), EXCLUIRVEI(32), EXCLUIRSIN(33);

    public final int operacao;
    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }
    public int getOperacao() {
        return this.operacao;
    }

    Scanner scan = new Scanner(System.in);

    //Menu geral
    public void select(){
        System.out.println("Digite a sua escolha entre as opções: \n1- Cadastraar\n2- Listar\n3- Excluir\n4- Gerar\n5- Transferir\n6- Calcular\n0- Sair");
        int valor = scan.nextInt();
        scan.nextLine();
        MenuOperacoes esse = MenuOperacoes.values()[valor];

        switch(esse){
            case CADASTRAR:
                selectcad();
            case LISTAR:
                selectlist();
            case EXCLUIR:
                selectexc();
            case GERAR:
                break;
            case TRANSFEERIR:
                System.out.println("Digite o nome da conta de origem e depois o de destino");
            case CALCULAR:
                System.out.println("Digite o nome da conta para o cálculo do seguro");
            case SAIR:
                System.out.println("Agradeçemos a atenção, tenha um bom dia:)");
                break;
            default:
                System.out.println("Digite um valor válido");
                select();
        }
    }
    
    //Menu cadastro
    public void selectcad(){
        System.out.println("Digite a sua escolha entre as opções: \n11- Cadastrar Cliente PF ou PJ\n12- Cadastrar Veículo\n13- Cadastrar Seguradora\n14- Voltar");
        int valor = scan.nextInt();
        scan.nextLine();

        switch(valor){
            case 11:
                System.out.println("Digite 1 se for fazer cadastro de CPF e 2 se for cadastro de CNPJ");
                int tipo = scan.nextInt();
                scan.nextLine();
                if (tipo ==1){
                    System.out.println("Digite os dados para o seu cadastro de Cliente PF");
                } else if (tipo==2) {
                    System.out.println("Digite os dados para o seu cadastro de Cliente PJ");
                }
            case 12:
                System.out.println("Esse veículo vai para algum cliente? Se sim digite o CPF/CNPJ do cliente se não digite 1");
                int num = scan.nextInt();
                scan.nextLine();
                if (num ==1){
                    System.out.println("Digite os dados para o cadastro do Veículo");
                } else if (num==2) {
                    System.out.println("Digite os dados para o cadastro do Veículo");
                }
            case 13:
                System.out.println("Digite os dados para o cadastro da Seguradora");
            case 14:
                select();
            default:
                System.out.println("Digite um valor válido");
                selectcad();
        }
    }

    //Menu excluir
    public void selectexc(){
        System.out.println("Digite a sua escolha entre as opções: \n31- Excluir Cliente\n32- Excluir Veículo\n33- Excluir Sinistro\n14- Voltar");
        int valor = scan.nextInt();
        scan.nextLine();

        switch(valor){
            case 31:
                System.out.println("Digite o CPF/CNPJ do cliente a ser excluido");
            case 32:
                System.out.println("Digite o ID do sinistro a ser excluido");
            case 33:
                System.out.println("Digite a placa do veículo a ser excluido");
            case 14:
                select();
            default:
                System.out.println("Digite um valor válido");
                selectexc();
        }
    }
    
    //Menu listar
    public void selectlist(){
        System.out.println("Digite a sua escolha entre as opções: \n21- Listar Cliente PF ou PJ por Seguradora\n22- Listar Sinistro por Seguradora\n23- Listar Sinistro por Cliente\n24- Listar Veículo por Cliente\n25- Listar Veículo por Seguradora\n14- Voltar Menu");
        int valor = scan.nextInt();
        scan.nextLine();
        
        switch(valor){
            case 21:
                System.out.println("Digite 1 se quiser a listagem de clientes CPF e 2 se quiser a listagem de clientes CNPJ");
                int tipo = scan.nextInt();
                scan.nextLine();
                if (tipo ==1){
                    System.out.println("Lista clientes CPF");
                } else if (tipo==2) {
                    System.out.println("Lista clientes CNPJ");
                }
            case 22:
                System.out.println("Listagem dos sinistros da seguradora");
            case 23:
                System.out.println("Digite o CPF/CNPJ do cliente para ser listado os sinistros");
            case 24:
                System.out.println("Digite o CPF/CNPJ do cliente para ser listado os veículos ");
            case 25:
                System.out.println("Listagem do veículo da seguradora");
            case 14:
                select();
            default:
                System.out.println("Digite um valor válido");
        }
    }
}
