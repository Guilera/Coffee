package maquina;

public abstract class Bebida{
	private double preco;
	private char tamanho;
	private String status;
	private double acucar;

	public Bebida(double preco, char tamanho){
		this.tamanho = tamanho;
		this.preco = preco;
		status = "Pedida";
	}

	public double getPreco() {
		return preco;
	}

	public char getTamanho() {
		return tamanho;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void adicionaAcucar(int acucar){
		this.acucar = acucar;
		recalculaPreco();
	}

	public void recalculaPreco(){
		preco += acucar*0.10;
	}

	public boolean venda(double money){
		if((float)money >= (float)preco){
			status = "Vendida";
			fazBebida();
			Estoque.consomeAcucar(acucar);
			return true;
		}
		return false;
	}

	public abstract void fazBebida();

	public abstract boolean checaIngredientes();

}
