package com.airlines;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SeatAllocation {
	public static void main(String[] args) throws IOException {
		System.out.println("Airplane Seating Application\n");
		/**
		 * Getting Input from user: Size of plane and passengerCount
		 */
		String sizeOfPlane="[3,2], [4,3], [2,3], [3,4]";
		//String sizeOfPlane="[3,2], [4,3]";
		int passengerCount=32;
		System.out.println("Total Passengers :"+passengerCount);
		System.out.println("Flight Seating Specs :"+sizeOfPlane+"\n\n");
		
		/**
		 * Starting: Initialize list of 2d Array and assign into list.
		 */
		List<Division> listofDiv=new ArrayList<Division>();
		String[] divArr = sizeOfPlane.split(", " );
		int devLength=0;
		if(Objects.nonNull(divArr)) {
			devLength=divArr.length;
		}
		int maxRow=0;
		for (int i=0;i<devLength;i++) {
			String[] divIJ = divArr[i].split(",");
		
			if(Objects.nonNull(divIJ)&&divIJ.length==2) {
			
				Integer iObj=Integer.valueOf(divIJ[0].replace("[", ""));
				Integer jObj=Integer.valueOf(divIJ[1].replace("]", ""));
				if(i==0)
					listofDiv.add(new Division(iObj, jObj,true,false));
				else if(i+1==devLength) {
					listofDiv.add(new Division(iObj, jObj,false,true));
				}else {
					listofDiv.add(new Division(iObj, jObj,false,false));
				}
				//Finding Max row in all divs
				if(maxRow<jObj) {
					maxRow=jObj;
				}
				
			}
			
		}
		/**
		 * Ending: Initialize list of 2d Array and assign into list.
		 */
		
		/**
		 * Starting: Business Logic  to allocate passengers into seats based on business rules
		 */
		
		String seatType="A";
		for(int i=1;i<=passengerCount;i++) {

			if(seatType.equalsIgnoreCase("A")) {
				if(isAvailable(i,listofDiv,"A",maxRow)) {
					continue;
				}else {
					 seatType="W";
				}
			}
			if(seatType.equalsIgnoreCase("W")) {
				if(isAvailable(i,listofDiv,"W",maxRow)) {
					continue;
				}else {
					 seatType="M";
				}
			}
			if(seatType.equalsIgnoreCase("M")) {
				if(isAvailable(i,listofDiv,"M",maxRow)) {
					continue;
				}
			}
		}
		
		/**
		 * Ending: Business Logic  to allocate passengers into seats based on business rules
		 */

		
		
		   
	/**
	 * STARTING:Printing into console and file
	 */
		FileWriter fw = new FileWriter("output.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		  
		for(int i=0;i<maxRow;i++) {
			for (Division division : listofDiv) {
				boolean isFirst=true;
					for(int j=0;j<division.col&&i<division.row;j++) {
						String val="";
						if(isFirst){
							isFirst=false;
							 val=division.div[i][j];
						}else {
							 val=","+division.div[i][j];
							
						}
						System.out.print(val);
						bw.write(val);
						
					}
					System.out.print("\t\t");
					bw.write("\t\t");
			}
			System.out.println("");
			bw.write("\n");
		}
		
		
	   bw.close();
	
	/**
	 * Ending:Printing into console and file
	*/
				
		
		
	}
	/**
	 * 
	 * @param pid
	 * @param listofDiv
	 * @param type
	 * @param high
	 * @return isAvail
	 */
	public  static boolean isAvailable(int pid,List<Division> listofDiv,String type,int high) {
		
		for(int i=0;i<high;i++) {
			for (Division division : listofDiv) {
				for(int j=0;j<division.col&&i<division.row;j++) {
					if(!Util.isNumeric(division.div[i][j])) {
						if( division.div[i][j].equalsIgnoreCase(type)) {
							division.div[i][j]=String.valueOf(pid);
							return true;
							
						}
					}
				
				}
			}
		}
		return false;
		
	}
	
	

	

}
