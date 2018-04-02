package com.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.jdbc.controller.MemberController;
import com.jdbc.model.vo.Member;

public class MemberView {
	
	private Scanner sc=new Scanner(System.in);
	//private MemberController mc=new MemberView();
	
	public MemberView() {}

	public void mainMenu() {	//메뉴할때 do~while 쓴다.
		int choice=0;
		System.out.println("===================");
		do{
			
			System.out.println("0. DB연결정보확인");
			System.out.println("1. 전체회원조회");
			System.out.println("2. 회원정보조회");
			System.out.println("9. 프로그램 종료");
			System.out.println("입력: ");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 0:
				new MemberController().connectDB();
				break;
			case 1:
				new MemberController().selectAll();
				break;
			case 2:
				String id=new MemberView().select();
				new MemberController().selectOn(id);
				
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default:
				break;
			}
			
		}while(true);
	}


	public void displayError(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String msg) {
			System.out.println(msg);
		
	}

	public void displayList(ArrayList<Member> list) {
		System.out.println("================================================== 회원 조회결과 =====================================================\n");
		System.out.println("아이디\t이름\t성별\t나이 \t이메일\t전화번호\t\t주소\t\t\t취미\t\t가입일");
		for(Member m: list){
			System.out.println(m);
		}	
	}
	
	
	public String select(){
		System.out.println("아이디입력");
		String id=sc.next();
		return id;
	}

	public void displaym(Member member) {	System.out.println("================================================== 회원 조회결과 =====================================================\n");
	System.out.println("아이디\t이름\t성별\t나이 \t이메일\t전화번호\t\t주소\t\t\t취미\t\t가입일");
	System.out.println(member.toString());
		
	}
	
	
}
