

import java.util.ArrayList;


public class Notifications {
  
	 private String[] message= new String[3];
	 private int type;
	/*-------------- C O N S T R U C T O R------------------*/

	public Notifications(int type, String info) {
		this.type = type;
		if (type==1) {
			
			message[0]=" ���� �������������� (����) �� (����) ����� ";
			
			
		}
		else if (type==2) {
			
			message[1]=" ���� ���������� �� (����) ����� ";
			
			
		}
		else if (type==3) {
			
			
			message[2]=" �������! ���� (��/���), ��������� ����� �� ������� ���� ������� (�������), ��� (���), ����(����),"
					+ "����������� ����� ���� ���� �� ������� ";
			
			
			
		}
	}
	
	public int getType() {
		return type;
	}
	
	public String[] getMessage() {
		return message;
	}
	
}
