
public abstract class Person {
	String hakbun;
	String irum;
	
	Person(String hakbun ,String irum){
		this.hakbun = hakbun;
		this.irum = irum;
	}
	
	abstract void input();
	
	abstract void output();
}
