package maquina.gerencia;

import maquina.Bebida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gerencia implements IGerencia {
	private Map<String, Funcionario> users;
	private Funcionario logado;
	private ArrayList<Bebida> vendidas, canceladas;

	public Gerencia() {
		users = new HashMap();
		logado = null;
		vendidas = new ArrayList<Bebida>();
		canceladas = new ArrayList<Bebida>();
	}

	@Override
	public boolean logar(String user, String pass) {
		logado = users.get(user);
		if(logado != null && logado.getPassword().equalsIgnoreCase(pass))
			return true;
		return false;
	}

	@Override
	public void deslogar() {
		if (logado != null)
			logado = null;
	}

	@Override
	public void addVendida(Bebida bebida){
		vendidas.add(bebida);
	}

	@Override
	public void addCancelada(Bebida bebida) {
		canceladas.add(bebida);
	}

	@Override
	public void refilEstoque() {

	}

	@Override
	public void recolheDinheiro() {

	}

	@Override
	public boolean adicionaFuncionario(String nome, String cpf, String username, String senha) {
		if(logado instanceof Gerente){
			users.put(username, new Funcionario(nome, cpf, username, senha));
			return true;
		}
		return false;
	}
	@Override
	public boolean adicionaGerente(String nome, String cpf, String username, String senha) {
		if(logado instanceof Gerente){
			users.put(username, new Gerente(nome, cpf, username, senha));
			return true;
		}
		return false;
	}

	@Override
	public void adicionaChaveMestre(String senha) {
		users.put("adm", new Gerente("Chave-Mestra", "", "adm", senha));
	}
}
	
