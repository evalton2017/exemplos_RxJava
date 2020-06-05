package operadores;

import rx.Observable;

/*
 * Transforma os itens emitidos para um observable*/
public class Map {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Observable<Integer> obs1 = Observable.create(subscriber->{
			System.out.println("Emitindo eventos...");
			subscriber.onNext(10);
			subscriber.onNext(20);
			subscriber.onNext(30);
			System.out.println("Finalizando emissão de eventos...");
			subscriber.onCompleted();
		});
		
		obs1
			.map(number->number+number)
			.map(number->number/2)
			.subscribe(System.out::println);
		
		/*
		Observable.just(10)
			.map(number->number*10)
			.subscribe(System.out::println);
			*/
	}

}
