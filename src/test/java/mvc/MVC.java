package mvc;

public class MVC extends Child{

	public static void main(String[] args) {
		
		for(int i=0;i<2; i++) {
			MVC mvc = new MVC();
			//mvc.mvc();
		}
		
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				MVC mvc = new MVC();
				mvc.mvc();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				MVC mvc = new MVC();
				mvc.mvc();
			}
		}).start();*/
	}
	
	public void mvc() {
		System.out.println("werwee");
		MVC mvc = new MVC();
		MVC mvc1 = new MVC();
		MVC mvc2 = new MVC();
		MVC mvc3 = new MVC();
		MVC mvc4 = new MVC();
		MVC mvc5 = new MVC();
		MVC mvc6 = new MVC();
	}
	
}
