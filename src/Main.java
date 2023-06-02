package src;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        //cadastros dos argumentos para teste das funções
        ArrayList<Frota> frota = new ArrayList<>();
        ArrayList<Seguro> seguros = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Sinistro> sinistro = new ArrayList<>();
        ArrayList<Condutor> condutores = new ArrayList<>();

        MenuOperacoes menu = MenuOperacoes.VOLTAR;
        LocalDate data1 = LocalDate.of(2023,06,17);
        LocalDate data2 = LocalDate.of(2023,02,17);
        Veiculo carro1 = new Veiculo("abc-1437", "fusca", "wv", 1997);
        Veiculo carro3 = new Veiculo("svt-1437", "fusca", "wv", 2000);
        Veiculo carro2 = new Veiculo("skz-1437", "fusca", "wv", 1991);
        Frota frota1 = new Frota(veiculos);
        Frota frota2 = new Frota(veiculos);

        Seguradora seguradora = new Seguradora("Connect Seguradora", "66666666", "connect@seguradora.com", "7 de setembro,3422", "92.606.812/0001-01", seguros, clientes);
        Cliente_pf cpf = new Cliente_pf("Carla", "Unicamp, 00", "33333333", "carlita@gmail.com", "76105644949", "mulher", "médio completo", data1, veiculos);
        Cliente_pj cnpj = new Cliente_pj("Disney", "Terra do nunca", "44446666", "pateta@disney.com", data2, "15.486.334/0001-94", frota);
        Sinistro sin = new Sinistro(data2, "221B Baker Street", seguradora, carro2, cnpj);
        Condutor condutor = new Condutor("mario", "999999999", "Yoshi's Valley", "mario@mariokart.com", "215.848.880-83", data2, sinistro);
        Seguro segPF = new SeguroPF(carro2, cpf, data1, data2, seguradora, sinistro);
        Seguro segPJ = new SeguroPJ(frota1, cnpj, data1, data2, seguradora, sinistro, 12, condutores);

        //teste dos métodos to string
        System.out.println(carro1.toString());
        System.out.println(seguradora.toString());
        System.out.println(cpf.toString());
        System.out.println(cnpj.toString());
        System.out.println(sin.toString());
        System.out.println(condutor.toString());
        System.out.println(segPF.toString());
        System.out.println(segPJ.toString());

        //teste de alguns métodos das classes
        System.out.printf("\n\nPlaca do carro 3:" + carro3.getplaca());
        cpf.cadastrarVeiculo(carro2);
        System.out.printf("\n\nLista de veículos do Cliente pf:" + cpf.getListaVeiculos());
        frota2.addVeiculo(carro3);
        cnpj.cadastrarFrota(frota2);
        System.out.printf("\n\nLista de frotas do Cliente pj:" + cnpj.getListaFrota());
        condutor.addSinistro(sin);
        System.out.printf("\n\nLista de Sinistros do condutor:" + condutor.getListaSinistros());
        seguradora.cadastrarCliente(cnpj);
        seguradora.gerarSeguro(segPJ);
        System.out.printf("\n\nLista de seguros por cliente da Seguradora:" + seguradora.getSegurosPorCliente(cnpj.getNome()));
        segPF.calcularValor();
        System.out.printf("\n\nCáclulo do valor do seguro:" + segPF.getValorMensal());
        System.out.println(segPJ.autorizarCondutor(condutor));
        System.out.printf("\n\nLista de condutores autorizados:" + segPJ.getCondutores());    

        menu.select();
    } 
}
