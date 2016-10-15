public class Cafe extends Bebida{
	private double xCafe;
	
	public Cafe(double preco, int tamanho, double xCafe){
		super(preco,tamanho);
		this.xCafe = xCafe;
	}

	@Override
	public static double calculaPreco(char tamanho){
		if(getTamanho == 'P') return precoP;
		else if(tamanho == 'M') return precoM;
		else return precoG;
	}

	public static double cafeNecessario(tamanho){
		if(tamanho == 'P') return cafeP;
		else if(tamanho == 'M') return cafeM;
		else return cafeG;
	}

}
	
	
