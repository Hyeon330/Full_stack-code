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
            	//�����ͺ��̽����� ȸ������ ��ü�� �����Ͽ� �ֿܼ� ���
                //��� ���
                memberAllList();
                break;
            case 2: // ȸ�����
            	memberInsert();
                break;
            case 3:	// ȸ����������
            	memberEdit();
                break;
            case 4:
            	memberDel();
                break;
            case 5:
                System.out.println("���α׷� ����");
                System.exit(0);	// ���α׷� ����
                break;
            default:
                System.out.println("�޴��� �߸��Է��ϼ̽��ϴ�.");
                break;
            }
        }
    }
    
    //ȸ����������
    public void memberDel() {
    	//������ ȸ����ȣ
    	System.out.print("������ ȸ����ȣ->");
    	int num = Integer.parseInt(sc.nextLine());
    	
    	MemberDAO dao = new MemberDAO();
    	int result = dao.memberDelete(num);
    	
    	if(result > 0) {
    		System.out.println(num+"�� ȸ���� �����Ǿ����ϴ�.");
    	} else {
    		System.out.println(num+"�� ȸ�� ��������");
    	}
    }
    
    //ȸ����������
  	public void memberEdit() {
  		MemberDTO dto = new MemberDTO();
  		//������ ȸ����ȣ �Է¹ް�
  		System.out.print("������ ȸ����ȣ->");
  		dto.setNum(Integer.parseInt(sc.nextLine()));
  		
  		//����ó, �̸��� Ȯ���� �� ��
  		System.out.print("������ �׸��� �Է�(1.����ó, 2.�̸���)->");
  		String que = sc.nextLine();
  		switch (que) {
  		case "1":	// ����ó(tel)
  			System.out.print("�����ҿ���ó->");
  			dto.setTel(sc.nextLine());
  			break;
  		case "2":	// �̸���(eamil)
  			System.out.print("�������̸���->");
  			dto.setEmail(sc.nextLine());
  			break;
  		default:
  			break;
  		}
  		
  		//������Ʈ
  		MemberDAO dao = new MemberDAO();
  		int cnt = dao.memberUpdate(que, dto);
  		//���
  		if(cnt>0) {	// ������
  			System.out.println("ȸ������ ���� �Ϸ�.");
  		} else { // ���� �ȵ�
  			System.out.println("ȸ������ ������ �����Ͽ����ϴ�.");
  		}
  	}
	
	public void memberInsert() {
		// ����� ȸ�� ������ �Է¹޾� DTO��ü setter�� �Ѵ�.
		MemberDTO dto = new MemberDTO();
		
		System.out.print("�̸�->");
		dto.setUsername(sc.nextLine());
		System.out.print("����ó->");
		dto.setTel(sc.nextLine());
		System.out.print("�̸���->");
		dto.setEmail(sc.nextLine());
		System.out.print("�������(ex:1900-10-10)->");
		dto.setBirth(sc.nextLine());
		System.out.print("����(M,F)->");
		dto.setGender(sc.nextLine());
		
		MemberDAO dao = new MemberDAO();
		int result = dao.memberInsert(dto);
		if(result > 0) { // ȸ�����
			System.out.println(dto.getUsername() + "�� ������ ��ϵǾ����ϴ�.");
		} else { // ��Ͻ���
			System.out.println("ȸ������� �����Ͽ����ϴ�.");
		}
	}

    //��ü ȸ�� ��� �����ϱ�
    public void memberAllList() {
        MemberDAO dao = new MemberDAO();
        List<MemberDTO> list = dao.memberList();
        
        for (MemberDTO dto : list) {
			oneMemberOutput(dto);
		}
        System.out.println();
    }

    //1���� ȸ���� ����ϴ� �޼ҵ�
    public void oneMemberOutput(MemberDTO dto) {
        //��ȣ, �̸�, ����ó, email, ����, ����, �����
        System.out.printf("%5d %10s %20s %20s %10s %5s %20s\n"
                , dto.getNum(), dto.getUsername(), dto.getTel(), dto.getEmail()
                , dto.getBirth(), dto.getGender(), dto.getWritedate());
    }

    public void menuOutput() {
        System.out.println("[�޴�]\n1.ȸ����� 2.ȸ����� 3.ȸ������ 4.ȸ������ 5.����");
        System.out.print("==> ");
    }

    public static void main(String[] args) {
        new MemberStart().start();
    }

}