package com.airlines;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SeatAllocation {
	public static void main(String[] args) {
		System.out.println("Airplane Seating Application");
		/**
		 * Getting Input from user: Size of plane and passengerCount
		 */
		String sizeOfPlane="[3,2], [4,3], [2,3], [3,4]";
		int passengerCount=36;
		
		/**
		 * Initialize list of 2d Array and assign into list.
		 */
		List<Division> listofDiv=new ArrayList<Division>();
		String[] divArr = sizeOfPlane.split(", " );
		int devLength=0;
		if(Objects.nonNull(divArr)) {
			devLength=divArr.length;
		}
		for (int i=0;i<devLength;i++) {
			String[] divIJ = divArr[i].split(",");
		
			if(Objects.nonNull(divIJ)&&divIJ.length==2) {
				//System.out.println("i,j:"+divIJ[0]+divIJ[1]);
				Integer iObj=Integer.valueOf(divIJ[0].replace("[", ""));
				Integer jObj=Integer.valueOf(divIJ[1].replace("]", ""));
				
				//Division div1=new Division(iObj, jObj,true,false);
				if(i==0)
					listofDiv.add(new Division(iObj, jObj,true,false));
				else if(i+1==devLength) {
					listofDiv.add(new Division(iObj, jObj,false,true));
				}else {
					listofDiv.add(new Division(iObj, jObj,false,false));
				}
				
			}
			
			
		}
		
		
		String seatType="A";
		for(int i=1;i<=passengerCount;i++) {

			if(seatType.equalsIgnoreCase("A")) {
				if(isAvailable(i,listofDiv,"A")) {
					continue;
				}else {
					 seatType="W";
				}
			}
			if(seatType.equalsIgnoreCase("W")) {
				if(isAvailable(i,listofDiv,"W")) {
					continue;
				}else {
					 seatType="M";
				}
			}
			if(seatType.equalsIgnoreCase("M")) {
				if(isAvailable(i,listofDiv,"M")) {
					continue;
				}
			}
		}
		
//		isAvailable(1,listofDiv,"A");
//		isAvailable(2,listofDiv,"A");
	
		
		
	
		
		
		for (Division division : listofDiv) {
			//division.print();
			System.out.println("");
			
				for(int i=0;i<division.row;i++) {
					for(int j=0;j<division.col;j++) {
						//System.out.print(division.div[i][j]+",("+i+","+j+") ");
						System.out.print(division.div[i][j]+",");
						
					}
					System.out.println("\t\t");
				}
			
			
		}
		
		
		
	}
	
	public  static boolean isAvailable(int pid,List<Division> listofDiv,String type) {
		boolean isAvail=false;
		
		int high=4;
		
		
		for(int i=0;i<high;i++) {
		for (Division division : listofDiv) {
			
		
				//System.out.println("division.row,col:"+division.row+","+division.col);
			
				
				for(int j=0;j<division.col&&i<division.row&&!isAvail;j++) {
					
					
					if(!Util.isNumeric(division.div[i][j])) {
						if( division.div[i][j].equalsIgnoreCase(type)) {
							division.div[i][j]=String.valueOf(pid);
							isAvail=true;
							
							
						}
					}
					
					//System.out.print(division.div[i][j]+",("+i+","+j+")\t");
					
					
				
				//System.out.println("");
			
			
			}
		}
		}
		
			
		
		
		return isAvail;
		
	}
	
	

	

}
