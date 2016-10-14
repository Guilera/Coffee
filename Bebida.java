public abstract class Bebida{
	private double preco;
	private char tamanho;

	public Bebida(double preco, char tamanho){
		this.tamanho = tamanho;
		this.preco = preco;
	}
	
	public char getTamanho(){
		return tamanho;
	}

	public static double calculaPreco(){
		return 10* 0.005*extraAcucar;
	}
	
}
