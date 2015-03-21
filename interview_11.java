public class interview_11{
	private static final double ESP = 1e-7;
	public static void main(String[] args) throws Exception{
		interview_11 solution =  new interview_11();

		System.out.println(solution.power(2,-12));
	}

	public double power(double base,int exponent) throws Exception{
		if(cmpDouble(base,0.0) == 0) return 0.0;
		if(cmpDouble(exponent,0.0) == 0) throw new Exception("error exponent");
		if(cmpDouble(exponent,1.0) == 0) return base;

		boolean isNegative = (exponent < 0) ? true : false;

		if(isNegative)
			exponent = -exponent;

		double res = 1.0;

		for(int i=1;i<=exponent;i++)
			res *= base;

		if(isNegative)
			res = 1.0 / res;

		return res;
	}

	public int cmpDouble(double x,double y){
		if(x - y < -ESP) return 1;
		if(x - y > ESP) return -1;
		return 0;
	}
}