public class Cappucino extends CafeComLeite{
	double xCanela, xChocolate;
	
	public Cappucino(double preco, int tamanho, double xCafe, double xLeite, double xChocolate, double xCanela){
		super(preco,tamanho,xCafe, xLeite);
		this.xChocolate = xChocolate;
		this.xCanela = xCanela;
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
	
	public static double cafeNecessario(tamanho){
		if(tamanho == 'P') return cafeP;
		else if(tamanho == 'M') return cafeM;
		else return cafeG;
	}

	public static double chocolateNecessario(tamanho){
		if(tamanho == 'P') return chocolateP;
		else if(tamanho == 'M') return chocolateM;
		else return chocolateG;
	}

	public static double canelaNecessario(tamanho){
		if(tamanho == 'P') return canelaP;
		else if(tamanho == 'M') return canelaM;
		else return canelaG;
	}
}
