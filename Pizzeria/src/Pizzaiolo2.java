
public class Pizzaiolo2  implements Runnable{
	private Lista lista;
	private Main main;
	
	
	
	public Pizzaiolo2(Lista lista2, Main m) {
		lista = lista2;
		main = m;
	}

	public synchronized void run() {
		while(true){
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("mi prendo la pizza");
			//lista.getUltima();
			main.aggiungi_cottura(lista.getUltima());
		}
	}
	
}
