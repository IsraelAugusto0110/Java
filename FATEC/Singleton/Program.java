package Singleton;

public class Program {

	public static void main(String[] args) {
		
		Teste ts = Teste.getTeste();
		Teste ts1 = Teste.getTeste();
		
		ts.setInformacao("este � ts");
		//ts1.setInformacao("este � ts1");
		
		System.out.println(ts1.getInformacao());
	}
}