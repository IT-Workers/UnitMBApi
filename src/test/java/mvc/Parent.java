package mvc;

import org.springframework.web.servlet.DispatcherServlet;

public class Parent extends DispatcherServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6626614872833694594L;
	public Parent() {
		System.out.println(this   + "=============" + this.hashCode());
	}
	protected void get() {
		System.out.println("ParentParentParentParent");
		System.out.println(getClass().getCanonicalName());
	}
}
