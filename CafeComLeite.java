public class CafeComLeite extends Cafe{
	private double leite;
	
	public CafeComLeite(double preco, char tamanho, double proporcaoLeite){
		super(preco,tamanho);
		super.setCafe(xCafe(tamanho, (1-proporcaoLeite)));
		this.leite = xLeite(tamanho, proporcaoLeite);
	}

	public static double xCafe(char tamanho, double proporcaoCafe){
		switch(tamanho){
			case'P': return 16*proporcaoCafe;
			case'M': return 32*proporcaoCafe;
			case'G': return 48*proporcaoCafe;
		}
		return 0;
	}

	public static double xLeite(char tamanho, double proporcaoLeite){
		switch(tamanho){
			case'P': return 16*proporcaoLeite;
			case'M': return 32*proporcaoLeite;
			case'G': return 48*proporcaoLeite;
		}
		return 0;
	}

	public static boolean temIngrediente(char tamanho, double proporcaoLeite){
		return Estoque.getCafe() >= xCafe(tamanho, 1-proporcaoLeite) && Estoque.getLeite() >= xLeite(tamanho, proporcaoLeite);
	}
}
	
