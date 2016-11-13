import java.util.ArrayList;

public class Lista {

	private ArrayList<String> listaPizze = new ArrayList();
	private Main main;
	public Lista(Main m){
		main = m;
	}
	public void aggiungiPizza(String pizza){
		listaPizze.add(pizza);
		System.out.println(listaPizze.size());
	}
	public String getUltima(){
		
		if(listaPizze.size()>=0){
			String ultimaPizza = listaPizze.get(listaPizze.size());
			main.list_cottura.add(ultimaPizza);
			listaPizze.remove(listaPizze.size());
			return ultimaPizza;
		}else{ 
			return null;
		}
	
		
	}
	public synchronized void pizzeInLista(){
		if(listaPizze.size()==0){
			System.out.println("non ci sono pizze");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("ci sono pizze");
			notifyAll();
		}
	}

}
