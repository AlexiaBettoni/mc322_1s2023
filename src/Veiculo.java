package src;
public class Veiculo {
    private String placa, marca, modelo;
    private int anoFabricacao;

    //Construtor
    public Veiculo(String placa, String modelo, String marca, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    //Setters e getters
    public String getplaca(){
        return placa;
    }
    public void setplaca(String placa){
        this.placa = placa;
    }
    public String getmarca(){
        return marca;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    public String getmodelo(){
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    public int getanoFabricacao(){
        return anoFabricacao;
    }
    public void setanoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }

    //to String
    public String toString() {
        String texto = "\nModelo do veículo: "+modelo +", marca: "+marca+ ", placa: "+ placa;
        return texto;
    }
}
