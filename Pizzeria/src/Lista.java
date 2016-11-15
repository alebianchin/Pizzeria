import java.util.ArrayList;

public class Lista {

	private ArrayList<String> listaPizze = new ArrayList<String>();
	private Main main;
	public Lista(Main m){
		main = m;
	}
	public synchronized void aggiungiPizza(String pizza){
		listaPizze.add(pizza);
		main.aggiungi(pizza);
		notifyAll();
		System.out.println(listaPizze.size());
	}
	public synchronized String getUltima(){
		while(listaPizze.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			String ultimaPizza = listaPizze.get(listaPizze.size()-1);
			System.out.println("ho preso la pizza");
			listaPizze.remove(listaPizze.size()-1);
			notifyAll();
			return ultimaPizza;
		
	}
	
	}

