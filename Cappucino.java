public class Cappucino extends CafeComLeite{
	double xCanela, xChocolate;
	
	public Cappucino(double preco, int tamanho, double xCafe, double xLeite, double xChocolate, double xCanela){
		super(preco,tamanho,xCafe, xLeite);
		this.xChocolate = xChocolate;
		this.xCanela = xCanela;
	}

	@Override
	public static double calculaPreco(double acucar){
		if(getTamanho == 'P') return precoP + 0.05*acucar;
		else if(getTamanho() == 'M') return precoM + 0.05*acucar;
		else return precoG + 0.05*acucar;
	}
}
