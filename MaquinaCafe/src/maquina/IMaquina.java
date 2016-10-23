package maquina;

public interface IMaquina {

    boolean logar(String username, String senha);

    void deslogar();

    boolean adicionaFuncionario(String nome, String cpf, String username, String senha);

    boolean adicionaGerente(String nome, String cpf, String username, String senha);

    void adicionaChaveMestre(String senha);
}
