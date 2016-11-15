import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;

public class Pizzaiolo1 implements Runnable{
	private Lista lista;
	private Main main;
	private ProgressBar p; 
	private String pizza; 
	
	public Pizzaiolo1(Lista l, Main m, ProgressBar p){
		this.p = p;
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
				for(int i=0;i<101;i++){
					Thread.sleep(10);
					final int index = i;
					Display.getDefault().asyncExec(new Runnable(){
						public void run(){
							p.setSelection(index);
						}
					});
					
				}
				main.aggiungi_pronta(pizza);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
