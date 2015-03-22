import java.util.*;

public class interview_14{

	public static void main(String[] args){
		int[] datas = {2,9,3,2,12,21,43,22,9,10};

		interview_14 solution = new interview_14();
		System.out.println(Arrays.toString(datas));
		// solution.solute(datas);
		// System.out.println(Arrays.toString(datas));
		// solution.solute2(datas);
		// System.out.println(Arrays.toString(datas));

		solution.solute3(datas,new func(){
			public boolean cmp(int[] datas,int x){
				return (datas[x] & 0x1) == 1;
			}
		});
		System.out.println(Arrays.toString(datas));

	}

	public void solute(int[] datas){
		int len = datas.length;

		int i=0,j = len-1;

		while(i<j){
			if(datas[i] % 2 == 1)i++;
			else{
				int tmp = datas[j];
				datas[j--] = datas[i];
				datas[i] = tmp;
			}
		}

		// System.out.println(Arrays.toString(datas));
	}

	public void solute2(int[] datas){
		int len = datas.length;
		int i=0,j = len-1;

		while(i<j){
			while(i<j && (datas[i] & 0x1) == 1) i++;
			while(i<j && (datas[j] & 0x1) == 0) j--;

			if(i<j){
				int tmp = datas[j];
				datas[j] = datas[i];
				datas[i] = tmp;
			}
		}
	}

	public void solute3(int[] datas,func isEvent){
		int len = datas.length;
		int i=0,j = len -1;

		while(i<j){
			while(i<j && isEvent.cmp(datas,i)) i++;
			while(i<j && !isEvent.cmp(datas,j)) j--;

			if(i<j){
				int tmp = datas[j];
				datas[j] = datas[i];
				datas[i] = tmp;
			}
		}
	}

	public interface func{
		public boolean cmp(int[] datas,int x);
	}
}