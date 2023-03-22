package src;
public class Sinistro {
    private int id;
    private String data;
    private String endereço;

    //Constructor
    public Sinistro( int id, String data, String endereço){
        this.id = id;
        id+=1;
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
    public void setenderço(int id){
        this.id = id;
    }
}

