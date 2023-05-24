package src;
import java.util.ArrayList;

public class Frota {
    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(ArrayList<Veiculo> Carros) {
        this.listaVeiculos = Carros;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo carro){
        listaVeiculos.add(carro);
        return true;
    }
    public boolean removeVeiculo(Veiculo carro){
        listaVeiculos.remove(carro);
        return true;
    }

}
