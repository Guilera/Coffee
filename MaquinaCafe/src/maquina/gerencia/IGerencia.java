package maquina.gerencia;

import maquina.Bebida;

public interface IGerencia {

	boolean logar(String user, String pass);

	void deslogar();

	double getFaturamento();

	void recolheDinheiro();

	void addVendida(Bebida bebida);

	void addCancelada(Bebida bebida);

	boolean adicionaFuncionario(String nome, String cpf, String username, String senha);

	boolean adicionaGerente(String nome, String cpf, String username, String senha);

	void adicionaChaveMestre(String senha);

	void venda(double valor);

	void excluirUser(String username);

	boolean isGerenteLogado();

	void entradaLog(String s);

}