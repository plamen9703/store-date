package school.calander;

public enum Month {
	
	JANUARY(31,1),FEB(28,2),MARCH(31,3),
	APR(30,4),MAY(31,5),JUNE(30,6),
	JULY(31,7),	AUGUST(31,8),SEP(30,9),
	OCT(31,10),NOV(30,11),DEC(31,12),
	FEB_LEAP(29,2);
	private int numberOfDays;
	private int number;
//	public static Month JAN=new Month(31,1);
	private Month(int numberOfDays, int number) {
		this.numberOfDays=numberOfDays;
		this.number=number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public String toString() {
		return String.format("%d, %d", number, numberOfDays);
	}
}
