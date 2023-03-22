package src;
public class Main {
    public static void main(String args[]){
        Seguradora seguradora;
        Sinistro sinistro,teste;
        Veiculo veiculo;
        Cliente cliente;

        seguradora = new Seguradora("Seguro", "3321", "maria@hotmail.com", "rua einstein,3453");
        sinistro = new Sinistro( "12/02/23","minha casa 2324");
        teste = new Sinistro( "12/02/23","testando o id do sinistro");
        veiculo = new Veiculo("ao3 3453", "fusca", "volksvagem");
        cliente = new Cliente("Nome do cliente", "019.082.980-06", "06/09/2002", 58, "rua dos bobos, 0");
        

        //Teste classe seguradora
        System.out.printf("Dados iniciais seguradora:\nNome: %s\nTelefone: %s\nEmail: %s\nEndereço: %s\n",seguradora.getNome(),seguradora.gettelefone(),seguradora.getemail(),seguradora.getendereço());
        seguradora.setNome("novo nome");
        seguradora.setemail("novo@email.com");
        seguradora.setendereço("sala ic00, Unicamp");
        seguradora.settelefone("12345678");
        System.out.printf("Dados novos seguradora:\nNome: %s\nTelefone: %s\nEmail: %s\nEndereço: %s\n\n",seguradora.getNome(),seguradora.gettelefone(),seguradora.getemail(),seguradora.getendereço());

        //Teste classe sinistro
        System.out.printf("Dados iniciais sinistro:\nData: %s\nEndereço: %s\nId: %d\n",sinistro.getdata(), sinistro.getendereço(), sinistro.getid());
        sinistro.setdata("01/02/03");
        sinistro.setenderço("Ciclo básico Unicamp");
        sinistro.setid(40);
        System.out.printf("Dados novos sinistro:\nData: %s\nEndereço: %s\nId: %d\n\n",sinistro.getdata(), sinistro.getendereço(), sinistro.getid());

        //Teste do mecanismo gerador de Id
        System.out.printf("Teste da criação de ID nos sinistros:\nData: %s\nEndereço: %s\nId: %d\n\n",teste.getdata(), teste.getendereço(), teste.getid());

        //Teste classe veiculo
        System.out.printf("Dados iniciais veiculo:\nPlaca: %s\nMarca: %s\nModelo: %s\n",veiculo.getplaca(),veiculo.getmarca(), veiculo.getmodelo());
        veiculo.setmarca("BMW");
        veiculo.setmodelo("X1");
        veiculo.setplaca("skz 0143");
        System.out.printf("Dados novos veiculo:\nPlaca: %s\nMarca: %s\nModelo: %s\n\n",veiculo.getplaca(),veiculo.getmarca(), veiculo.getmodelo());

        //Teste classe cliente
        System.out.printf("Dados iniciais cliente:\nNome: %s\nData de nascimento: %s\nCPF: %s\nEndereço: %s\nIdade: %d\n",cliente.getNome(), cliente.getdataNascimento(), cliente.getcpf(), cliente.getendereço(), cliente.getidade());
        cliente.setNome("Novo nome");
        cliente.setdataNascimento("01/02/2003");
        cliente.setcpf("835.986.600-73");
        cliente.setendereço("Ru Unicamp");
        cliente.setidade(38);
        System.out.printf("Dados iniciais cliente:\nNome: %s\nData de nascimento: %s\nCPF: %s\nEndereço: %s\nIdade: %d\n\n",cliente.getNome(), cliente.getdataNascimento(), cliente.getcpf(), cliente.getendereço(), cliente.getidade());
        System.out.printf("To string method:\n%s\n\n",cliente.tostring());
        
        //Para controle estou usando um CPF válido gerado automaticamente
        System.out.printf("Validar CPF method: %b\n\n",cliente.validarCPF(cliente.getcpf()));

    }
}
