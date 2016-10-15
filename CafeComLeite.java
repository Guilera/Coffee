public class CafeComLeite extends Cafe{
	private double xLeite;
	
	public CafeComLeite(double preco, int tamanho, double xCafe, double xLeite){
		super(preco,tamanho,xCafe);
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
	
	public static double cafeNecessario(tamanho){
		if(tamanho == 'P') return cafeP;
		else if(tamanho == 'M') return cafeM;
		else return cafeG;
	}

}
	
