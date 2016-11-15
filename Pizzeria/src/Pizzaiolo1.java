
public class Pizzaiolo1 implements Runnable{
	private Lista lista;
	private Main main;
	private String pizza; 
	
	public Pizzaiolo1(Lista l, Main m){
		lista = l;
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
			pizza =lista.getUltima();
			main.aggiungi_cottura(pizza);
			try {
				Thread.sleep(15000);
				main.aggiungi_pronta(pizza);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
