package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.vo.Member;
import com.jdbc.view.MemberView;

public class MemberController {
	public void connectDB(){
		
		int result=new MemberDao().connectDB();
			
		if(result>0){
			new MemberView().displaySuccess("DB성공");
		}
		else{
			new MemberView().displayError("검색된 결과가 없습니다.");
		}
	}

	public void selectAll() {
		ArrayList<Member> list=new MemberDao().selectAll();
		if(list!=null && list.size()>0){
			new MemberView().displayList(list);
		}
		else 
			new MemberView().displayError("실패");
	}
}
