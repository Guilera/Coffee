public class Chocolate extends Bebida{
	private double xChocolate, xLeite;
	
	public Chocolate(double preco, char tamanho, double xChocolate, double xLeite){
		super(preco,tamanho);
		this.xChocolate = xChocolate;
		this.xLeite = xLeite;
	}

	@Override
	public static double calculaPreco(char tamanho){
		if(tamanho == 'P') return precoP;
		else if(tamanho == 'M') return precoM;
		else return precoG;
	}

	public static double leiteNecessario(tamanho){
		if(tamanho == 'P') return leiteP;
		else if(tamanho == 'M') return leiteM;
		else return leiteG;
	}

	public static double chocolateNecessario(tamanho){
		if(tamanho == 'P') return chocolateP;
		else if(tamanho == 'M') return chocolateM;
		else return chocolateG;
	}

}
