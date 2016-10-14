public class CafeComLeite extends Cafe{
	private double xLeite;
	
	public CafeComLeite(double preco, int tamanho, double xCafe, double xLeite){
		super(preco,tamanho,xCafe);
		this.xLeite = xLeite;
	}

	@Override
	public static double calculaPreco(double acucar){
		if(getTamanho == 'P') return precoP + 0.05*acucar;
		else if(getTamanho() == 'M') return precoM + 0.05*acucar;
		else return precoG + 0.05*acucar;
	}
}
	
