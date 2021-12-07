package com.airlines;

public class Division {
	
	Integer col;
	Integer row;
	Boolean isFirstWindow;
	Boolean	isLastWindow;

	String div[][];
	public Division(Integer col,Integer row,Boolean isFirstWindow,Boolean	isLastWindow) {
		this.col=col;
		this.row=row;
		this.isFirstWindow=isFirstWindow;
		this.isLastWindow=isLastWindow;
		div=new String[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				
				if(j==0) {
					if(isFirstWindow)
						div[i][j]="W";
					else
						div[i][j]="A";
				}
				if(j+1==(col)) {
					if(isLastWindow)
						div[i][j]="W";
					else
						div[i][j]="A";
				}
				if(j!=0&&j+1!=(col)) {
					div[i][j]="M";
				}
				
			}
		}
	}

	
	
}
