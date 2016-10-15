public class Estoque{
	private static double maxCafe=0, maxLeite=0, maxAcucar=0, maxChocolate=0, maxCanela=0;

	public Estoque(){}

	public void adicionaCafe(){
		maxCafe = 1000;
	}
	
	public void adicionaLeite(){
		maxLeite = 1000;
	}

	public void adicionaChocolate(){
		maxChocolate = 1000;
	}

	public void adicionaCanela(){
		maxCanela = 1000;
	}

	public void adicionaAcucar(){
		maxAcucar = 1000;
	}

	public void consomeCafe(double qtd){
		maxCafe = maxCafe - qtd;
	}

	public void consomeLeite(double qtd){
		maxLeite = maxLeite - qtd;
	}

	public void consomeChocolate(double qtd){
		maxChocolate = maxChocolate - qtd;
	}

	public void consomeCanela(double qtd){
		maxCanela = maxCanela - qtd;
	}

	public void consomeAcucar(double qtd){
		maxAcucar = maxAcucar - qtd;
	}

	public double getCafe(){
		return cafe;
	}

	public double getLeite(){
		return leite;
	}
	
	public double getChocolate(){
		return chocolate;
	}

	public double getCanela(){
		return canela;
	}
}
