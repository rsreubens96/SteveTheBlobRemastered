
public class Main {
	
	GUI gui = null;
	
	public Main(GUI gui) {
		this.gui = gui;
	}
	
	public void run() {
		gui.appendMain("What is your name?");
	}

}
