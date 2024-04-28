package controller;
import model.ListaCircular;
import model.No;

public class Metodos {
	public Metodos() {
		super();
	}
	public void teste() {
		ListaCircular lista = new ListaCircular();
		
		lista.append(3);
		lista.append(6);
		lista.append(9);

		System.out.println(lista.toString());;	
		
		//lista.remove(lista.getLast());
		//System.out.println(lista.toString());;	
		
		System.out.println(lista.total());
		
		lista.remove(9);
		System.out.println(lista.toString());;	
		System.out.println(lista.total());


	}
}
