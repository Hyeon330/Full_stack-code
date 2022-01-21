package dao;

import java.util.ArrayList;
import java.util.List;

import dbConn.MysqlConnection;
import dto.MemberDTO;

public class MemberDAO extends MysqlConnection {
	
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			getConn();  // db����
			
			String sql = "select num, username, tel, email, birth, gender, writedate from member order by num";
//			String sql = "select * from member order by num";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setTel(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setBirth(rs.getString(5));
				dto.setGender(rs.getString(6));
				dto.setWritedate(rs.getString(7));
				
				list.add(dto);
				
			}
		} catch (Exception e) {
			System.out.println("ȸ�� ���� ���� �߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	
	//ȸ�����
	public int memberInsert(MemberDTO dto) {
		int result = 0; //����� ���Ͻ�ų ����
		try {
			getConn();
			
			String sql = "insert into member(username, tel, email, birth, gender) values(?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUsername()); // ���� ����
			ps.setString(2, dto.getTel());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getBirth());
			ps.setString(5, dto.getGender());
			
			// �߰��� ���ڵ��� ���� ��ȯ
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ȸ����Ͽ��ܹ߻�.....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}
	
	// ȸ������
	public int memberUpdate(String que, MemberDTO dto) {
		int result = 0;
		try {
			getConn();
			
			String sql = "update member set ";
			if(que.equals("1")) {
				sql += "tel=? where num=?";
				ps.setString(1, dto.getTel());
			} else if(que.equals("2")) {
				sql += "email=? where num=?";
				ps.setString(1, dto.getEmail());
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(2, dto.getNum());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ȸ������ ���ܹ߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	// ȸ������
	public int memberDelete(int num) {
		int result = 0;
		try {
			getConn();
			
			String sql = "delete from member where num=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ȸ������ ���ܹ߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return result;
	}
}
