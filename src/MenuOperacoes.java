package src;
import java.util.Scanner;

//Enum com o menu de operações
public enum MenuOperacoes {
    CADASTRAR(1), LISTAR(2), GERAR(4), EXCLUIR(3), TRANSFEERIR(5), CALCULAR(6), SAIR(0),CADPFPJ(11), CADVEI(12), CADSEG(13), VOLTAR(14),LISTARCLIENTESEG(21), LISTARSINSEG(22), LISTARSINCLI(23), LISTARVEICLI(24), LISTARVEISEG(25), EXCLUIRCLI(31), EXCLUIRVEI(32), EXCLUIRSIN(33);

    public final int operacao;
    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }
    public int getOperacao() {
        return this.operacao;
    }

    Scanner scan = new Scanner(System.in);

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
                System.out.println("Digite a sua escolha");
            case CALCULAR:
                System.out.println("Digite a sua escolha");
            case SAIR:
                System.out.println("Digite a sua escolha");
            default:
                System.out.println("Digite um valor válido");
        }
    }
    public void selectcad(){
        System.out.println("Digite a sua escolha entre as opções: \n11- Cadastrar Cliente PF ou PJ\n12- Cadastrar Veículo\n13- Cadastrar Seguradora\n14- Voltar");
        int valor = scan.nextInt();
        scan.nextLine();
        MenuOperacoes esse = MenuOperacoes.values()[valor];

        switch(esse){
            case CADPFPJ:
                System.out.println("Digite a sua escolha entre as opções: \n1- Cadastraar\n2- Listar\n3- Excluir\n4- Gerar\n5- Transferir\n6- Calcular\n0- Sair");
            case CADVEI:
                System.out.println("Digite a sua escolha");
            case CADSEG:
                System.out.println("Digite a sua escolha");
            case VOLTAR:
                select();
            default:
                System.out.println("Digite um valor válido");
        }
    }
    
    public void selectexc(){
        System.out.println("Digite a sua escolha entre as opções: \n31- Excluir Cliente\n32- Excluir Veículo\n33- Excluir Sinistro\n14- Voltar");
        int valor = scan.nextInt();
        scan.nextLine();
        MenuOperacoes esse = MenuOperacoes.values()[valor];

        switch(esse){
            case EXCLUIRCLI:
                System.out.println("Digite a sua escolha entre as opções: \n1- Cadastraar\n2- Listar\n3- Excluir\n4- Gerar\n5- Transferir\n6- Calcular\n0- Sair");
            case EXCLUIRSIN:
                System.out.println("Digite a sua escolha");
            case EXCLUIRVEI:
                System.out.println("Digite a sua escolha");
            case VOLTAR:
                select();
            default:
                System.out.println("Digite um valor válido");
        }
    }
    
    public void selectlist(){
        System.out.println("Digite a sua escolha entre as opções: \n21- Listar Cliente PF ou PJ por Seguradora\n22- Listar Sinistro por Seguradora\n23- Listar Sinistro por Cliente\n24- Listar Veículo por Cliente\n25- Listar Veículo por Seguradora\n14- Voltar Menu");
        int valor = scan.nextInt();
        scan.nextLine();
        MenuOperacoes esse = MenuOperacoes.values()[valor];
        
        switch(esse){
            case LISTARCLIENTESEG:
                System.out.println("Digite a sua escolha entre as opções: \n1- Cadastraar\n2- Listar\n3- Excluir\n4- Gerar\n5- Transferir\n6- Calcular\n0- Sair");
            case LISTARSINSEG:
                System.out.println("Digite a sua escolha");
            case LISTARSINCLI:
                System.out.println("Digite a sua escolha");
            case LISTARVEICLI:
                System.out.println("Digite a sua escolha");
            case LISTARVEISEG:
                System.out.println("Digite a sua escolha");
            case VOLTAR:
                select();
            default:
                System.out.println("Digite um valor válido");
        }
    }
}
