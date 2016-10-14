public class Chocolate extends Bebida{
	private double xChocolate, xLeite;
	
	public Chocolate(double preco, char tamanho, double xChocolate, double xLeite){
		super(preco,tamanho);
		this.xChocolate = xChocolate;
		this.xLeite = xLeite;
	}

	@Override
	public static double calculaPreco(double acucar){
		if(getTamanho == 'P') return precoP + 0.05*acucar;
		else if(getTamanho() == 'M') return precoM + 0.05*acucar;
		else return precoG + 0.05*acucar;
	}
}
