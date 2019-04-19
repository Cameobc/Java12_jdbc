package com.sesung.db.point;

import java.lang.reflect.Member;
import java.util.Scanner;

public class PointInput {
	
	
	
	
	public PointDTO setPoint(){
		PointDTO pointDTO = new PointDTO();
		Scanner sc = new Scanner(System.in);
		System.out.println("학생번호");
		pointDTO.setNum(sc.nextInt());
		System.out.println("학생아이디");
		pointDTO.setSid(sc.next());
		System.out.println("국어점수");
		pointDTO.setKor(sc.nextInt());
		System.out.println("영어점수");
		pointDTO.setEng(sc.nextInt());
		System.out.println("수학점수");
		pointDTO.setMath(sc.nextInt());
		System.out.println("반번호");
		pointDTO.setBnum(sc.nextInt());
		pointDTO.setTotal(pointDTO.getEng()+pointDTO.getKor()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		return pointDTO;

	}

}
