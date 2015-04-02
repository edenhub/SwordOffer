import java.util.*;

public class interview_44{

	public static void main(String[] args){
		int[] cnt = {0,2,3,1,4};

		interview_44 solution = new interview_44();
		System.out.println(solution.solute(cnt));
	}

	public boolean solute(int[] cnt){
		quickSort(cnt,0,cnt.length-1);

		// System.out.println(Arrays.toString(cnt));

		if(hasPair(cnt)) return false;
		// System.out.println("--");
		return isLink(cnt);
	}

	public void quickSort(int[] cnt,int s,int e){
		if(s >= e) return;

		int idx = partition(cnt,s,e);
		quickSort(cnt,s,idx);
		quickSort(cnt,idx+1,e);
	}

	public int partition(int[] cnt,int s,int e){
		int tmp = cnt[s];
		int low = s,high = e;

		while(low < high){
			while(low < high && tmp <= cnt[high]) high--;
			cnt[low] = cnt[high];

			while(low < high && tmp >= cnt[low]) low++;
			cnt[high] = cnt[low];
		}

		cnt[low] = tmp;
		return low;
	}

	public boolean hasPair(int[] cnt){
		int len = cnt.length-1;

		int tmp = cnt[0];
		for(int i=1;i<=len;i++){
			if(tmp!=0 && tmp == cnt[i])
				return true;
			else
				tmp = cnt[i];
		}

		return false;
	}

	public boolean isLink(int[] cnt){
		int zeroNum = zeroCnt(cnt);
		// int step = 5 - zeroNum;

		boolean res = false;
		int s = 0;
		switch(zeroNum){
			case 0 :
				s = cnt[4] - cnt[0] + 1;
				if( s == 5) res = true;
				else res = false;
				break;
			case 1 :
				s = cnt[4] - cnt[1] + 1;
				if(s == 5 || s <= 4) res = true;
				else res = false;
				// System.out.println("-");
				break;
			case 2 :
				s = cnt[4] - cnt[2] + 1;
				if(s == 5 || s <= 3) res = true;
				else res = false;
				break; 
		}

		return res;
	}

	public int zeroCnt(int[] cnt){
		if(cnt[1] == 0) return 2;
		else if(cnt[0] == 0) return 1;
		else return 0;
	}
}