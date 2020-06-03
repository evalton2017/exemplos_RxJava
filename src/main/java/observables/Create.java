package observables;

import rx.Observable;
import rx.Subscriber;

public class Create {
	
	public static void main(String[] args) {
		
		Observable<Object> obs = Observable.create(subscriber ->{
			
			/*
			 * Exemplo rest
			 * SALVAR
			 * UserRepository.save(user);
			 * subscriber.onNext(user);
			 * subscriber.onComepleted();
			 * LISTAR
			 * List<User> users = userRepository.findAll();
			 * users.foreach(Subscriber::onNext);
			 * subscriber.onComepleted();
			 * */
			
			subscriber.onNext(1);
			subscriber.onNext(10);
			subscriber.onCompleted();
		});
	
		
		obs.subscribe(number->{
			System.out.println("On next: "+number);
		}, ex->{
			System.out.println("On error: "+ex.getMessage());
		},()->{
		
			System.out.println("Acabou");
		});
	
	}


}
