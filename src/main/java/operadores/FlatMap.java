package operadores;

import rx.Observable;

public class FlatMap {
/*Se inscreve no observable e resolve o valor*/
	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		Observable<Integer> obs1  = Observable.create(subscriber->{
			System.out.println("Emitindo eventos abs1...");
			subscriber.onNext(10);
			waitFor(1000L);
			subscriber.onNext(20);
			waitFor(1000L);
			subscriber.onNext(30);
			System.out.println("Finalizou emissao obs1...");
			subscriber.onCompleted();
		});	
		
		@SuppressWarnings("deprecation")
		Observable<Integer> obs2  = Observable.create(subscriber->{
			System.out.println("Emitindo eventos obs2...");
			subscriber.onNext(100);
			waitFor(2000L);
			subscriber.onNext(200);
			waitFor(2000L);
			System.out.println("Finalizou emissao obs2...");
			subscriber.onCompleted();
		});	
		
		/*EXEMPLO PRATICO
		 * Observable.just(1) //recebe 1
			.flatMap(user-> 
				tarefa.map(tarefa -> new UserTarefa(user,tarefa))
			)			
			.subscribe(userTarefa->{
				
			});
		 * 
		 * 
		 * */
		
		Observable.just(1) //recebe 1
			.flatMap(number-> 
				obs1.map(result->number+result) //10,20,30
			)
			.flatMap(number->
				obs2.map(result->number+result) //100+11 = 111 primeiro resultado
			)
			.subscribe(System.out::println); //111
	}



	public static void waitFor(Long num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
