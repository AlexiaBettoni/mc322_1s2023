package src;
import java.util.Scanner;

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
    
    }
    
}
