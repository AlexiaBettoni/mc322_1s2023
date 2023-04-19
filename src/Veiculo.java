package src;
public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
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

    //To String
    public String toString(){
        String dados;
        dados ="\n-----Dados veículo-----\nPlaca: "+placa+"\nModelo: "+modelo+".\nMarca: "+marca+".\nAno de Fabricação: "+anoFabricacao+".\n";
        return dados;
    }
}
