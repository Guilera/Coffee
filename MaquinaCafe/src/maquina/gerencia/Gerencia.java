package maquina.gerencia;

import maquina.Bebida;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Gerencia implements IGerencia {
	private Map<String, Funcionario> users;
	private Funcionario logado;
	private ArrayList<Bebida> vendidas, canceladas;
	private double faturamento;
	private String log;

	public Gerencia() {
		users = new HashMap();
		logado = null;
		vendidas = new ArrayList<Bebida>();
		canceladas = new ArrayList<Bebida>();
		faturamento = 0;
		log = "";
	}

	@Override
	public boolean logar(String username, String pass) {
		logado = users.get(username.toLowerCase());
		if(logado != null && logado.getPassword().equalsIgnoreCase(pass)) {
			log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " " + logado.getNome() + " logou.\n";
			return true;
		}
		return false;
	}

	@Override
	public void deslogar() {
		if (logado != null) {
			log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " " + logado.getNome() + " logout.\n";
			logado = null;
		}
	}

	@Override
	public void addVendida(Bebida bebida){
		faturamento += bebida.getPreco();
		vendidas.add(bebida);
	}

	@Override
	public void addCancelada(Bebida bebida) {
		canceladas.add(bebida);
	}

	@Override
	public void recolheDinheiro() {
		log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " " + logado.getNome() + "Retirada de de R$"
				+ String.format("%.2f", faturamento) + ".\n";
		faturamento = 0;
	}

	@Override
	public boolean adicionaFuncionario(String nome, String cpf, String username, String senha) {
		if(logado instanceof Gerente){
			users.put(username.toLowerCase(), new Funcionario(nome, cpf, username, senha));
			log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " Funcionario " + nome
					+ " adicionado por " + logado.getNome() + ".\n";
			return true;
		}
		return false;
	}

	@Override
	public boolean adicionaGerente(String nome, String cpf, String username, String senha) {
		if(logado instanceof Gerente){
			users.put(username.toLowerCase(), new Gerente(nome, cpf, username, senha));
			log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " Gerente " + nome
					+ " adicionado por " + logado.getNome() + ".\n";
			return true;
		}
		return false;
	}

	@Override
	public void adicionaChaveMestre(String senha) {
		users.put("adm", new Gerente("Chave-Mestre", "", "adm", senha));
		log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " Chave Mestre adicionada.\n";
	}

	@Override
	public void venda(double valor) {
		faturamento += valor;
	}

	@Override
	public void excluirUser(String username) {
		if(users.containsKey(username.toLowerCase())){
			log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " usuario: " + users.get(username) + " excluido, por " + logado.getNome() + ".\n";
			users.remove(username);
		}
	}

	@Override
	public boolean isGerenteLogado() {
		return (logado instanceof Gerente);
	}

	@Override
	public double getFaturamento() {
		return faturamento;
	}

	public String getLog() {
		return log;
	}

	public void entradaLog(String s){
		log += new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + " " + s + ".\n";
	}
}
	
