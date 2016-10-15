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
	
	@Override
	public static boolean temIngredientes(char tamanho){
		if(tamanho == 'P'){ 
			if(cafeP <= Estoque.getCafe() && leiteP <= Estoque.getLeite()) return true;
		}
		else if(tamanho == 'M'){
			if(cafeM <= Estoque.getCafe() && leiteM <= Estoque.getLeite()) return true;
		}
		else if(cafeG <= Estoque.getCafe() && leiteG <= Estoque.getLeite()) return true;
		return false;
	}

	public static boolean temIngredientes2(char tamanho){
		if(tamanho == 'P'){ 
			if(cafeP2 <= Estoque.getCafe() && leiteP2 <= Estoque.getLeite()) return true;
		}
		else if(tamanho == 'M'){
			if(cafeM2 <= Estoque.getCafe() && leiteM2 <= Estoque.getLeite()) return true;
		}
		else if(cafeG2 <= Estoque.getCafe() && leiteG2 <= Estoque.getLeite()) return true;
		return false;
	}
		

}
	
