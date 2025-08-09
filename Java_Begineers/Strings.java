package Java_Begineers;

public class Strings {
    public static void main(String[] args) {
		StringBuilder sb= new StringBuilder("Akshay");
//		System.out.println(sb);
//		for(int i=0;i<sb.length();i++)
//		{
//			System.out.println(sb.charAt(i));
//		}
//		sb.setCharAt(0, 'L');
//		System.out.println(sb);
//		sb.insert(0,'L');
//		System.out.println(sb);
//		sb.delete(2, 3);
//		System.out.println(sb);
//		sb.append("a");
//		System.out.println(sb);
//		System.out.println(sb.length());
		
		
		for(int i=0;i<sb.length()/2;i++)
		{
			int front=i;
			int back=sb.length()-1-i; //6-1-0=5
			
			char frontChar=sb.charAt(front);
			char backChar=sb.charAt(back);
			
			sb.setCharAt(front, backChar);
			sb.setCharAt(back, frontChar);
		}
		System.out.println(sb);
		
	}
}
