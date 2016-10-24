package maquina;

public interface IMaquina {

    boolean logar(String username, String senha);

    void deslogar();

    boolean adicionaFuncionario(String nome, String cpf, String username, String senha);

    boolean adicionaGerente(String nome, String cpf, String username, String senha);

    void adicionaChaveMestre(String senha);

    double getValorBebida(String tipo, char tamanho);

    double getTotal();

    void adicionaAcucar(int acucar);

    void processaBebida(String tipo, double preco, char tamanho, double proporcao);

    boolean checaIngrediente();

    boolean vendeBebida(double pagamento);

    void cancelar();

    boolean temBebidaEmProcesso();

    double getFaturamento();

    void excluirUser(String username);

    void recolherFaturamento();

    boolean isGerenteLogado();

    String getLog();

    void entradaLog(String s);
}
