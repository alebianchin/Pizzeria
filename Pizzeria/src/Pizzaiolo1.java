
public class Pizzaiolo1 implements Runnable{
	private Lista lista;
	
	public Pizzaiolo1(Lista l){
		lista = l;
	}
	
	public void run() {
		while(true){
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("mi prendo la pizza");
			lista.getUltima();
		}
	}
	
}
