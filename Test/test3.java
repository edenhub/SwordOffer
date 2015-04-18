import java.util.*;

public class test3{

	public static void main(String[] args){
		test3 t = new test3();
		t.run();
	}

	public void run(){
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
				System.out.print(i+" ");
		}
	}
}