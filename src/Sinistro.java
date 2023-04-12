package src;
public class Sinistro {
    public static int casos = 1;
    private int id;
    private String data;
    private String endereço;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //Constructor
    public Sinistro(String data, String endereço, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.id = casos;
        casos+=1;
        this.data = data;
        this.endereço = endereço;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Setters e Getters
    public String getdata(){
        return data;
    }
    public void setdata(String data){
        this.data = data;
    }
    public String getendereço(){
        return endereço;
    }
    public void setenderço(String endereço){
        this.endereço = endereço;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public Seguradora getseguradora(){
        return seguradora;
    }
    public void setid(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public Veiculo getveiculo(){
        return veiculo;
    }
    public void setveiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public Cliente getcliente(){
        return cliente;
    }
    public void setcliente(Cliente cliente){
        this.cliente = cliente;
    }

    //to String method
    public String tostring(){
        String dados;
        dados = "ID: "+id+"\nData: "+data+"\nEndereço: "+endereço+"\n Nome Seguradora: "+seguradora.getNome()+"\nTelefone Seguradora:"+seguradora.getendereço()+"\nPlaca do veículo: "+veiculo.getplaca()+"\nModelo do veículo: "+veiculo.getmodelo()+"\nNome do Cliente: "+cliente.getNome()+"\n\n";
        return dados;
    }
}

