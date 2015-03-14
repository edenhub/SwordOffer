public class interview_3{

	public boolean solution(int[][] data,int target){
		if(data == null)
			return false;
		int rows = data.length,cols = data[0].length;

		if(rows == 0 || cols == 0)
			return false;
		int currR = rows,currC=cols;
		for(int r = 0;r<currR;r++){
			for(int c = currC - 1;c>=0;c--){
				if(data[r][c] == target)
					return true;

				if(data[r][c] > target){
					currC--;
					continue;
				}

				if(data[r][c] < target){
					break;
				}
			}
		}

		return false;
	}

	public static void main(String[] args){
		int[][] data = {
			{1,2,8,9},
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
		};

		boolean res = new interview_3().solution(data,7);
		System.out.println(res);
	}
}