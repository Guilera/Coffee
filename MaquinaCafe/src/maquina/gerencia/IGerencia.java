package maquina.gerencia;

import maquina.Bebida;

public interface IGerencia {
	boolean logar(String user, String pass);

	void deslogar();

	void refilEstoque();

	void recolheDinheiro();

	void addHistorico(Bebida bebida);

	boolean adicionaFuncionario(String nome, String cpf, String username, String senha);

	boolean adicionaGerente(String nome, String cpf, String username, String senha);

	void adicionaChaveMestre(String senha);

}