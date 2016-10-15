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

	@Override
	public static boolean temIngredientes(char tamanho){
		if(tamanho == 'P'){ 
			if(cafeP <= Estoque.getCafe() && leiteP <= Estoque.getLeite() && chocolateP <= Estoque.getChocolate() && canelaP <= Estoque.getCanela()) return true;
		}
		else if(tamanho == 'M'){
			if(cafeM <= Estoque.getCafe() && leiteM <= Estoque.getLeite() && chocolateP <= Estoque.getChocolate() && canelaP <= Estoque.getCanela()) return true;
		}
		else if(cafeG <= Estoque.getCafe() && leiteG <= Estoque.getLeite() && chocolateP <= Estoque.getChocolate() && canelaP <= Estoque.getCanela()) return true;
		return false;
	}
}
