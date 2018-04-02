package com.jdbc.view;

import java.util.Scanner;

public class MemberView {
	
	private Scanner sc=new Scanner(System.in);
	//private MemberController mc=new MemberView();
	
	public MemberView() {}

	public void mainMenu() {	//메뉴할때 do~while 쓴다.
		int choice=0;
		System.out.println("===================");
		do{
			
			System.out.println("0. DB연결정보확인");
			System.out.println("9. 프로그램 종료");
			System.out.println("입력: ");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 0:
				break;
				
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default:
				break;
			}
			
		}while(true);
	}
	
}
