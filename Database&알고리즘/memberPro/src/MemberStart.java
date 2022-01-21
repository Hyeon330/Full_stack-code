import java.util.List;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberStart {
    Scanner sc = new Scanner(System.in);

    public void start() {
        while(true) {
            menuOutput();
            int menu = Integer.parseInt(sc.nextLine());
            switch(menu) {
            case 1:
            	//데이터베이스에서 회원정보 전체를 선택하여 콘솔에 출력
                //목록 출력
                memberAllList();
                break;
            case 2: // 회원등록
            	memberInsert();
                break;
            case 3:	// 회원정보수정
            	memberEdit();
                break;
            case 4:
            	memberDel();
                break;
            case 5:
                System.out.println("프로그램 종료");
                System.exit(0);	// 프로그램 종료
                break;
            default:
                System.out.println("메뉴를 잘못입력하셨습니다.");
                break;
            }
        }
    }
    
    //회원정보삭제
    public void memberDel() {
    	//삭제할 회원번호
    	System.out.print("삭제할 회원번호->");
    	int num = Integer.parseInt(sc.nextLine());
    	
    	MemberDAO dao = new MemberDAO();
    	int result = dao.memberDelete(num);
    	
    	if(result > 0) {
    		System.out.println(num+"번 회원이 삭제되었습니다.");
    	} else {
    		System.out.println(num+"번 회원 삭제실패");
    	}
    }
    
    //회원정보수정
  	public void memberEdit() {
  		MemberDTO dto = new MemberDTO();
  		//수정할 회원번호 입력받고
  		System.out.print("수정할 회원번호->");
  		dto.setNum(Integer.parseInt(sc.nextLine()));
  		
  		//연락처, 이메일 확인을 한 후
  		System.out.print("수정할 항목을 입력(1.연락처, 2.이메일)->");
  		String que = sc.nextLine();
  		switch (que) {
  		case "1":	// 연락처(tel)
  			System.out.print("수정할연락처->");
  			dto.setTel(sc.nextLine());
  			break;
  		case "2":	// 이메일(eamil)
  			System.out.print("수정할이메일->");
  			dto.setEmail(sc.nextLine());
  			break;
  		default:
  			break;
  		}
  		
  		//업데이트
  		MemberDAO dao = new MemberDAO();
  		int cnt = dao.memberUpdate(que, dto);
  		//결과
  		if(cnt>0) {	// 수정됨
  			System.out.println("회원정보 수정 완료.");
  		} else { // 수정 안됨
  			System.out.println("회원정보 수정을 실패하였습니다.");
  		}
  	}
	
	public void memberInsert() {
		// 등록할 회원 정보를 입력받아 DTO객체 setter를 한다.
		MemberDTO dto = new MemberDTO();
		
		System.out.print("이름->");
		dto.setUsername(sc.nextLine());
		System.out.print("연락처->");
		dto.setTel(sc.nextLine());
		System.out.print("이메일->");
		dto.setEmail(sc.nextLine());
		System.out.print("생년월일(ex:1900-10-10)->");
		dto.setBirth(sc.nextLine());
		System.out.print("성별(M,F)->");
		dto.setGender(sc.nextLine());
		
		MemberDAO dao = new MemberDAO();
		int result = dao.memberInsert(dto);
		if(result > 0) { // 회원등록
			System.out.println(dto.getUsername() + "의 정보가 등록되었습니다.");
		} else { // 등록실패
			System.out.println("회원등록이 실패하였습니다.");
		}
	}

    //전체 회원 목록 선택하기
    public void memberAllList() {
        MemberDAO dao = new MemberDAO();
        List<MemberDTO> list = dao.memberList();
        
        for (MemberDTO dto : list) {
			oneMemberOutput(dto);
		}
        System.out.println();
    }

    //1명의 회원을 출력하는 메소드
    public void oneMemberOutput(MemberDTO dto) {
        //번호, 이름, 연락처, email, 생일, 성별, 등록일
        System.out.printf("%5d %10s %20s %20s %10s %5s %20s\n"
                , dto.getNum(), dto.getUsername(), dto.getTel(), dto.getEmail()
                , dto.getBirth(), dto.getGender(), dto.getWritedate());
    }

    public void menuOutput() {
        System.out.println("[메뉴]\n1.회원목록 2.회원등록 3.회원수정 4.회원삭제 5.종료");
        System.out.print("==> ");
    }

    public static void main(String[] args) {
        new MemberStart().start();
    }

}