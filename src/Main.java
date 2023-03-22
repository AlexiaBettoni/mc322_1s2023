package src;
public class Main {
    static int casos;
    public static void main(String args[],int casos){
        Cliente cliente;
        Seguradora seguradora;
        Sinistro sinistro;
        Veiculo veiculo;

        cliente = new Cliente("Nome do cliente", "019.082.980-06", "06/09/2002", 58, "rua dos bobos, 0");
        seguradora = new Seguradora("Seguro", "3321", "maria@hotmail.com", "rua einstein,3453");
        sinistro = new Sinistro( casos , "12/02/23","minha casa 2324");
        veiculo = new Veiculo("ao3 3453", "fusca", "volksvagem");
        
        sinistro.getdata();
        cliente.getNome();
        seguradora.getemail();
        veiculo.getmodelo();

    }
}
