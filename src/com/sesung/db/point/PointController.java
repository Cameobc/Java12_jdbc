package com.sesung.db.point;

import java.util.Scanner;

import com.sesung.db.util.DBConnector;

public class PointController {
	
	private Scanner sc;
	private PointInput pi; 
	private PointDTO pointDTO;
	private PointView pv;
	
	public PointController() {
		sc = new Scanner(System.in);
		pi = new PointInput();
		pointDTO = new PointDTO();
		pv = new PointView();
	}
	
	public void start() throws Exception {
		//1.학생정보등록
		//2.종료
		boolean check = true;
		while(check) {
		System.out.println("1.학생정보등록");
		System.out.println("2.종          료");
		int select = sc.nextInt();
		
		switch(select) {
		case 1:
			pointDTO = pi.setPoint();
			int result = PointDAO.insert(pointDTO);
			String message = "동록실패";
			if(result>0) {
				message="등록성공";
			}
			pv.view(message);
			break;
		case 2:
			System.out.println("종료");
			check=!check;
			break;
			default:
		}
		}
	}

}
