import java.util.*;

public class interview_41{

	public static void main(String[] args){
		int[] lines = {1,2,4,7,11,15};
		int tgt = 15;
		interview_41 solution = new interview_41();
		Pair pair = solution.solute1(lines,tgt);

		if(pair != null){
			System.out.println(lines[pair.first]+" : "+lines[pair.second]);
		}

		List<Pair> listPair = solution.solute2(tgt);
		for(Pair p : listPair){
			System.out.println(p);
		}
	}

	public static class Pair{
		public int first,second;

		public Pair(int first,int second){
			this.first = first;
			this.second = second;
		}

		public String toString(){
			return first+" : "+second;
		}
	}

	public Pair solute1(int[] lines,int tgt){
		int head = 0,tail = lines.length - 1;

		while(head <= tail){
			int curr = lines[head] + lines[tail];

			if(curr > tgt){
				tail--;
			}else if(curr < tgt){
				head++;
			}else{
				return new Pair(head,tail);
			}
		}

		return null;
	}

	public List<Pair> solute2(int tgt){
		if(tgt < 3) return null;
		int head = 1,tail = 2;
		int bound = (tgt+1)/2;

		List<Pair> list = new ArrayList<Pair>();

		while(head < bound){
			int curr = calSeq(head,tail);
			if(curr == tgt){
				list.add(new Pair(head,tail));
			}

			while(curr > tgt && head < bound){
				head++;
				if(head >= tail) tail++;
				int cal = calSeq(head,tail);
				if(cal == tgt)
					list.add(new Pair(head,tail));
			}

			tail++;
		}


		return list;
	}

	public int calSeq(int first,int second){
		int res = (int)((first + second)*((second - first+1) / 2.0));
		return res;
	}
}