package com.cmpe202_lab;

import java.util.Arrays;

public class CheckSum {
 public static boolean check(String cc) {
	 //Initializing an array to store all the digits of a credit card number
	 int[] array=new int[cc.length()];
	 int length= cc.length();
	 int index1=0;
	 int temp,temp2;
	 int sum = 0,oddsum=0;
	 long cardNo= Long.parseLong(cc);
	 while(cardNo> 0) {
		 temp= (int) (cardNo%10);
		 temp*=2;
		 if(temp>=10) {
			 temp2= temp%10;
			 temp /= 10;
			 temp2+=temp;
			 array[index1++]=temp2;
		 }
		 else
			 array[index1++]=temp; 
		 cardNo/=10;
	 }
	 
	 for(int i=0;i<length;i++) {
		 sum+= array[i];
	 }
	 for(int i=0;i<length;i+=2) {
		 oddsum+= array[i];
	 }
	 System.out.println(Arrays.toString(array));
	 sum+=oddsum;
	 if(oddsum%10==0)
	 return true;
	 return false;
 }
// 
// public static void main(String[] args) {
//	 check("5410000000000000");
// }
}
