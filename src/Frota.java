package src;
import java.util.ArrayList;

public class Frota {
    //Criei um atributo Id para poder identificar as frotas dentro do mesmo cliente
    public static int casos = 1;
    final private int id;
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(ArrayList<Veiculo> Carros) {
        this.id = casos;
        casos+=1;
        this.listaVeiculos = Carros;
    }

    //getters e setters
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    public int getId() {
        return id;
    }

    //Método to string
    public void getveiculos(){
        for (Veiculo veiculo:listaVeiculos){
            System.out.printf("\nModelo e placa do veículo: "+veiculo.getmodelo()+" "+veiculo.getplaca());
        }
    }

    //Método para adicionar e remover veículos da frota
    public boolean addVeiculo(Veiculo carro){
        if (listaVeiculos.contains(carro)==false){
            listaVeiculos.add(carro);
            return true;
        }
        return false;
    }
    
    public boolean removeVeiculo(Veiculo carro){
        if (listaVeiculos.contains(carro)==true){
            listaVeiculos.remove(carro);
            return true;
        }
        return false;
    }
}
