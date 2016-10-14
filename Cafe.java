public class Cafe extends Bebida{
	private double xCafe;
	
	public Cafe(double preco, int tamanho, double xCafe){
		super(preco,tamanho);
		this.xCafe = xCafe;
	}

	@Override
	public static double calculaPreco(double acucar){
		if(getTamanho == 'P') return precoP + 0.05*acucar;
		else if(getTamanho() == 'M') return precoM + 0.05*acucar;
		else return precoG + 0.05*acucar;
	}
}
	
	
