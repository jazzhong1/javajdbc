package com.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.vo.Member;

public class MemberDao {

	public int connectDB() {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			String sql = "select * from member";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println(result);
			return result;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				stmt.close(); // DB랑 연결되어있는상태이기때문에
								// sqlexception 처리해줘야한다.
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}// method 끝

	public Member selectOn(String str) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "select * from member where member_id='" + str + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			rs.next();
			member = new Member();
			member.setMemberId(rs.getString("MEMBER_ID"));
			member.setMemberPwd(rs.getString("MEMBER_PWD"));
			member.setMemberName(rs.getString("MEMBER_NAME"));
			member.setGender(rs.getString("GENDER").charAt(0));
			member.setAge(rs.getInt("AGE"));
			member.setEmail(rs.getString("EMAIL"));
			member.setPhone(rs.getString("PHONE"));
			member.setAddress(rs.getString("ADDRESS"));
			member.setHobby(rs.getString("HOBBY"));
			member.setEnrollDate(rs.getDate("ENROLL_DATE"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return member;
	}

	public ArrayList<Member> selectAll() {

		ArrayList<Member> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			// @~~데이터베이스 IP주소이다.
			// 127.0.0.1 은 localhost와 같다.

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Member>();

			while (rs.next()) {

				Member member = new Member();

				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberPwd(rs.getString("MEMBER_PWD"));
				member.setMemberName(rs.getString("MEMBER_NAME"));
				member.setGender(rs.getString("GENDER").charAt(0));
				member.setAge(rs.getInt("AGE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setHobby(rs.getString("HOBBY"));
				member.setEnrollDate(rs.getDate("ENROLL_DATE"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertMember(Member member){
		Connection conn=null;
		Statement stmt=null;
		int result=0;
		String sql="insert into member values("
					+"'"+member.getMemberId()+"', "
					+"'"+member.getMemberPwd()+"',"
					+"'"+member.getMemberName()+"',"
					+"'"+member.getGender()+"',"
					+member.getAge()+","
					+"'"+member.getEmail()+"',"
					+"'"+member.getPhone()+"',"
					+"'"+member.getAddress()+"',"
					+"'"+member.getHobby()+"',"
					+"sysdate)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
			
			if(result>0){
				conn.commit();		//sql안날려도 commit,rollback 할수있다.
			}
			
			else{
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

}
