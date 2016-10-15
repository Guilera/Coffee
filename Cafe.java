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

	@Override
	public static boolean temIngredientes(char tamanho){
		if(tamanho == 'P'){ 
			if(cafeP <= Estoque.getCafe()) return true;
		}
		else if(tamanho == 'M'){
			if(cafeM <= Estoque.getCafe()) return true;
		}
		else if(cafeG <= Estoque.getCafe()) return true;
		return false;
	}

}
	
	
