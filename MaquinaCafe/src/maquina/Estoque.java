package maquina;

public class Estoque{
	private static double cafe=10000, leite=10000, acucar=10000, chocolate=10000, canela=10000;

	public Estoque(){}

	public static void completaCafe(){
		cafe = 10000;
	}
	
	public static void completaLeite(){
		leite = 10000;
	}

	public static void completaChocolate(){
		chocolate = 10000;
	}

	public static void completaCanela(){
		canela = 10000;
	}

	public static void completaAcucar(){
		acucar = 10000;
	}

	public static void consomeCafe(double qtd){
		cafe -= qtd;
	}

	public static void consomeLeite(double qtd){
		leite -= qtd;
	}

	public static void consomeChocolate(double qtd){
		chocolate -= qtd;
	}

	public static void consomeCanela(double qtd){
		canela -= qtd;
	}

	public static void consomeAcucar(double qtd){
		acucar -= qtd;
	}

	public static double getCafe(){
		return cafe;
	}

	public static double getLeite(){
		return leite;
	}
	
	public static double getChocolate(){
		return chocolate;
	}

	public static double getCanela(){
		return canela;
	}

	public static double getAcucar(){ 
		return acucar;
	}
}
