package model;

import model.No;
import java.lang.Exception;

public class ListaCircular<T> {
	private No<T> ultimo = null;
	
	//append
	//getLast
	//remove
	//total
	
	public void append (T valor) {
		No<T> novo = new No<>(valor);
		if (this.ultimo == null) {
			this.ultimo = novo;
			novo.setAnterior(novo);
			novo.setProximo(novo);
		} else {
			No<T> buffer_ultimo = this.ultimo;
			No<T> buffer_proximo = this.ultimo.getProximo();
			novo.setAnterior(buffer_ultimo);
			buffer_ultimo.setProximo(novo);
			novo.setProximo(buffer_proximo);
			buffer_proximo.setAnterior(novo);
			this.ultimo = novo;
		}
	}
	public No<T> getLast() throws IllegalArgumentException {
		if (this.ultimo == null) {
			throw new IllegalArgumentException("Lista vazia.");
		} else {
			return this.ultimo;
		}
	}
	public void remove(No<T> remover) {
		No<T> anterior = remover.getAnterior();
		No<T> proximo = remover.getProximo();
		if (this.ultimo == remover && anterior == remover && proximo == remover) {
			//somente 1 elemento na lista
			this.ultimo = null;
			return;
		} 
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		if (this.ultimo == remover) {
			this.ultimo = anterior;
		}
		remover.setAnterior(null);
		remover.setProximo(null);
		remover.setValor(null);
	}
	public void remove() {
		remove ( getLast() );
	}
	public void remove(T remover) {
		if (this.ultimo.getValor() == remover) {
			No<T> buffer_proximo = this.ultimo.getProximo();
			No<T> buffer_anterior = this.ultimo.getAnterior();
			buffer_anterior.setProximo(buffer_proximo);
			buffer_proximo.setAnterior(buffer_anterior);
			this.ultimo.setValor(null);
			this.ultimo.setAnterior(null);
			this.ultimo.setProximo(null);
			this.ultimo = buffer_anterior;
		} else {
			No<T> buffer = this.ultimo;
			while (buffer.getProximo() != null) {
				buffer = buffer.getProximo();
				if (buffer.getValor() == remover) {
					No<T> buffer_anterior = buffer.getAnterior();
					No<T> buffer_proximo = buffer.getProximo();
					buffer_anterior.setProximo(buffer_proximo);
					buffer_proximo.setAnterior(buffer_anterior);
					buffer.setAnterior(null);
					buffer.setProximo(null);
					buffer.setAnterior(null);
				}
			}
		}		
		
	}
	public int total() {
		if (this.ultimo == null) {
			return 0;
		}
		No<T> buffer = this.ultimo.getProximo();
		int total = 1;
		while (buffer != this.ultimo) {
			total++;
			buffer = buffer.getProximo();
		}
		return total;
	}
	@Override
	public String toString() {
		if (this.ultimo == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.ultimo;
		builder.append(buffer.getValor());
		while (buffer.getProximo() != this.ultimo) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}
		builder.append("]");
		return builder.toString();
	}
}






