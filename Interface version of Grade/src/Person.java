
public class Person {
	
	//final static int MAX = 100; =>  이전에는 실행 클래스에서 static 변수 선언해주었구나.. 여기다 하면 비효율적인가?
	String irum;
	String hakbun;
	
	Person(){}
}

/*
(문제) 성적 정보와 개인정보를 입력받아 출력하는 프로그램을 작성하시오.
<처리조건>
1. 입력 가능한 데이터 건수는 각각 최대100건으로한다.
2. 성적 정보와 개인정보 입력시 학번에 exit를 입력 받으면 입력을 종료한다.

<입출력 형식>
### 성적 입력 ###
학번 입력 => A001
이름 입력 => 이기자
국어 입력 => 77
영어 입력 => 77
수학 입력 => 88

학번 입력 => exit

### 개인정보 입력 ###
학번 입력 => A001
이름 입력 => 이기자
주소 입력 => 서울
전화번호 입력 => 010-1111-1111
이메일 입력 => lee@daum.net

학번 입력 => exit


             *** 성적표 ***
==========================================
학번      이름    국어    영어    수학    총점    평균   등급
==========================================
A001  이기자   77   77   88  242  80.67   우
==========================================

           *** 개인정보 ***
============================================
학번     이름       주소          전화번호              이메일
============================================
A001 이기자     서울   010-1111-1111   lee@daum.net
============================================

 */