package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.vo.Member;
import com.jdbc.view.MemberView;

public class MemberController {
	public void connectDB() {

		int result = new MemberDao().connectDB();

		if (result > 0) {
			new MemberView().displaySuccess("DB성공");
		} else {
			new MemberView().displayError("검색된 결과가 없습니다.");
		}
	}

	public void selectAll() {
		ArrayList<Member> list = new MemberDao().selectAll();
		if (list != null && list.size() > 0) {
			new MemberView().displayList(list);
		} else
			new MemberView().displayError("실패");
	}

	public void selectOn(String str) {
		Member member = new MemberDao().selectOn(str);
		if (member != null) {
			new MemberView().displaym(member);
		} else
			new MemberView().displayError("실패");
	}

	public void insertMember() {
		Member member = new MemberView().inputMember();
		int result = new MemberDao().insertMember(member);
		if (result > 0) {
			new MemberView().displaySuccess("성공");
		} else {
			new MemberView().displayError("실패");
		}
	}
	
	public void updateMember(){
		Member member=new MemberView().updateMember();
		int result = new MemberDao().updateMember(member);
		if (result > 0) {
			new MemberView().displaySuccess("성공");
		} else {
			new MemberView().displayError("실패");
		}
		
	}

}
