package src;
public class Sinistro {
    public static int casos = 1;
    private int id;
    private String data;
    private String endereço;

    //Constructor
    public Sinistro(String data, String endereço){
        this.id = casos;
        casos+=1;
        this.data = data;
        this.endereço = endereço;
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
}

