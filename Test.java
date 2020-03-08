import java.io.FileNotFoundException;

class Test {

	public static void main(String[] args) throws FileNotFoundException{

		Legesystem legesystemet = new Legesystem();

		try{
			legesystemet.lesFil("inndata.txt");
		}
		catch (FileNotFoundException e){
			
		}
		System.out.println(legesystemet.pasienter.stoerrelse());

	}
}
