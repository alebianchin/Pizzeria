import java.util.ArrayList;

public class Lista {

	private ArrayList<String> listaPizze = new ArrayList();

	public void aggiungiPizza(String pizza){
		listaPizze.add(pizza);
	}
	public String getUltima(){
		String ultimaPizza = listaPizze.get(listaPizze.size()-1);
		listaPizze.remove(listaPizze.size()-1);
		return ultimaPizza;
		
	}
	public synchronized void pizzeInLista(){
		if(listaPizze.size()!=0){
			
		}else{
			
		}
	}
	
}
