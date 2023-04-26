package src;

//Enum com o menu de operações
public enum MenuOperacoes {
    CADASTRAR(1), EXCLUIR(2), SAIR(0);

    public final int operacao;
    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }
}
