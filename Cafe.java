public class Cafe extends Bebida{
	private double cafe;
	
	public Cafe(double preco, char tamanho){
		super(preco,tamanho);
		this.cafe = xCafe(tamanho);
	}


	public static double xCafe(char tamanho){
		switch(tamanho){
			case'P': return 16;
			case'M': return 32;
			case'G': return 48;
		}
		return 0;
	}

	public static boolean temIngrediente(char tamanho){
		return Estoque.getCafe() >= xCafe(tamanho);
	}

	public void setCafe(double cafe) {
		this.cafe = cafe;
	}
}
	
	
