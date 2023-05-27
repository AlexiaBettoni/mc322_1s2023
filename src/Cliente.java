package src;

public abstract class Cliente {
    private String nome, telefone, endereço, email;

    //Constructor
    public Cliente(String nome, String endereço, String telefone, String email){
        this.nome = nome;
        this.endereço = endereço;
        this.email = email;
        this.telefone = telefone;
    }

    //Getters e setters
    public String getEmail() {
        return email;
    }
    public String getEndereço() {
        return endereço;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    //To String
    public String toString() {
        String texto = "\nCliente: "+nome + ", telefone: "+ telefone;
        return texto;
    }

    

}
