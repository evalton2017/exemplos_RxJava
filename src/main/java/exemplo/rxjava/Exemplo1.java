package exemplo.rxjava;

import java.util.Arrays;

import rx.Observable;

public class Exemplo1 {

	public static void main(String[] args) {
						
		Observable.range(1,100)
			.map(number->number*2)
			.filter(number->number%2==0)
			.subscribe(System.out::println);
		
		Observable.just(1,2)
			.subscribe(System.out::println);
		
		Observable.error(new RuntimeException());
		
		Observable.from(Arrays.asList("Duke","KACIA","EVALTON"))
				.subscribe(System.out::println);
	}
}
