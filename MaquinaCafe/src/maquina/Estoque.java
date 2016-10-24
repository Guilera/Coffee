package maquina;

public class Estoque{
	private static double cafe=1000, leite=1000, acucar=1000, chocolate=1000, canela=1000;

	public Estoque(){}

	public static void completaCafe(){
		cafe = 1000;
	}
	
	public static void completaLeite(){
		leite = 1000;
	}

	public static void completaChocolate(){
		chocolate = 1000;
	}

	public static void completaCanela(){
		canela = 1000;
	}

	public static void completaAcucar(){
		acucar = 1000;
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
