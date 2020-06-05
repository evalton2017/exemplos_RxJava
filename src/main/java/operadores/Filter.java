package operadores;

import rx.Observable;
/*
 * Filtra os valores */
public class Filter {

	public static void main(String[] args) {
		Observable.just(10,20,30,12,5,3,13)
			.filter(number->number%2!=0)
			.subscribe(System.out::println);
	}
}
