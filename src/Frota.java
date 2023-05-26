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

    public void getveiculos(){
        for (Veiculo veiculo:listaVeiculos){
            System.out.printf("\nModelo e placa do veículo: "+veiculo.getmodelo()+" "+veiculo.getplaca());
        }
    }

}
