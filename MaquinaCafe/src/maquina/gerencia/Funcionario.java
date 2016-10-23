package maquina.gerencia;

public class Funcionario {
	private String nome, cpf, username, password;

	public Funcionario(String nome, String cpf, String username, String password) {
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean logar(String pass) {
		if (password.equals(pass)) return true;
		return false;
	}

	public void trocarSenha(String senhaAntiga, String senhaNova){
		if(senhaAntiga.equalsIgnoreCase(password)){
			this.password = senhaNova;
		}
	}
}