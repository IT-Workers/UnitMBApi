package mvc;

public class Child extends Parent{

	@Override
	protected void get() {
		super.get();
		System.out.println("ChildChildChildChildChildChild");
	}
}
