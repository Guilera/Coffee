//polimorfismo calculaPreco() e ingredientes necessarios(?)
public abstract class Bebida{
	private double preco;
	private char tamanho;

	public Bebida(double preco, char tamanho){
		this.tamanho = tamanho;
		this.preco = preco;
	}
	
	public char getTamanho(){
		return tamanho;
	}

	public static double calculaPreco(char tamanho){
		if(tamanho == 'P') return 1;
		else if(tamanho == 'M') return 2;
		else return 3;
	}

	public static double leiteNecessario(tamanho){
		if(tamanho == 'P') return 0;
		else if(tamanho == 'M') return 0;
		else return 0;
	}
	
	public static double cafeNecessario(tamanho){
		if(tamanho == 'P') return 0;
		else if(tamanho == 'M') return 0;
		else return 0;
	}

	public static double chocolateNecessario(tamanho){
		if(tamanho == 'P') return 0;
		else if(tamanho == 'M') return 0;
		else return 0;
	}

	public static double canelaNecessario(tamanho){
		if(tamanho == 'P') return 0;
		else if(tamanho == 'M') return 0;
		else return 0;
	}
}
