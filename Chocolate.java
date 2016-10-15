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

	@Override
	public static boolean temIngredientes(char tamanho){
		if(tamanho == 'P'){ 
			if(chocolateP <= Estoque.getChocolate() && leiteP <= Estoque.getLeite()) return true;
		}
		else if(tamanho == 'M'){
			if(chocolateM <= Estoque.getChocolate() && leiteM <= Estoque.getLeite()) return true;
		}
		else if(chocolateG <= Estoque.getChocolate() && leiteG <= Estoque.getLeite()) return true;
		return false;
	}

}
