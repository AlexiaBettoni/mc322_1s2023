package src;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        LocalDate data1 = LocalDate.of(2023,06,17);
        LocalDate   data2 = LocalDate.of(2023,02,17);
        Veiculo carro1 = new Veiculo("abc-1437", "fusca", "wv", 1997);
        Veiculo carro3 = new Veiculo("svt-1437", "fusca", "wv", 2000);
        Veiculo carro2 = new Veiculo("skz-1437", "fusca", "wv", 1991);
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Cliente_pf cpf = new Cliente_pf("Carla", "Unicamp, 00", "33333333", "carlita@gmail.com", "76105644949", "mulher", "médio completo", data1, veiculos);




    } 
}
