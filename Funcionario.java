public class Funcionario{
	private String nome, cpf, username, password;
	
	public Funcionario(String nome, String cpf, String username, String password){
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.password = password;
	}

	public void refilEstoque(){
		Estoque.completaEstoque();
	}

	public String getUsername(){
		return username;
	}

	public boolean logar(String pass){
		if(password.equals(pass)) return true;
		return false;
	}
	
	public void deslogar(){
		logado = false;
	}

