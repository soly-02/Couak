

import java.util.ArrayList;


public class Notifications {
  
	 String[] message= new String[3];
	/*-------------- C O N S T R U C T O R------------------*/

	public Notifications(int type, String info) {
		
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
	
}
