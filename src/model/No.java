package model;

public class No<T> {
	
	private T valor;
	private No<T> proximo;
	private No<T> anterior;
	
	public No (T valor) {
		this.valor = valor;
		this.proximo = null;
		this.anterior = null;
	}
	
	public  T getValor() {
		return this.valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public No<T> getProximo() {
		return this.proximo;
	}
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	public No<T> getAnterior() {
		return this.anterior;
	}
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}	
	@Override
	public String toString() {
		return valor.toString();
	}
}
