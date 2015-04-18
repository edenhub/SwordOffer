import java.util.*;

public class Ran{

	public static void main(String[] args){
		Ran instance = new Ran();

		instance.run(new Dumper(){
			public void dump(int num){
				System.out.print(num+" ");
			}
		});
	}

	public interface Dumper{
		public void dump(int num);
	}

	public void run(Dumper dumper){
		boolean[] flags = new boolean[1001];

		Random random = new Random();

		int idx=0;

		while(idx<100){
			int curr = random.nextInt(1000)+1;
			if(!flags[curr]){
				flags[curr] = true;
				idx++;
			}
		}

		for(int i=1;i<=1000;i++){
			if(!flags[i])
				dumper.dump(i);
		}
	}
}