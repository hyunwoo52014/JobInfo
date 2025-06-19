package data.dto.event;

import javax.swing.JCheckBox;

import data.dto.api.ApiDTO;
import data.dto.ui.work24.SortFieldDTO;
import data.dto.ui.work24.SortOrderByDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestWork24DTO extends ApiDTO {
	
	final String callTp = "L"; //호출할 페이지 타입을 반드시 설정합니다.(L: 목록, D:상세)
	final String returnType ="XML"; //xml 를 반드시 지정합니다.
	int startPage = 1;	// 기본값 1, 최대 1000 검색 시작위치를 지정할 수 있습니다.	최대 1000 까지 가능합니다.
	int display = 10; // 기본값 10, 최대 100 까지 가능합니다.
	String empCoNo;	// 채용기업번호
	
	/*(다중검색 가능) 기업 구분코드를 입력합니다.
	- 10 : 대기업
	- 20 : 공기업
	- 30 : 공공기관
	- 40 : 중견기업
	- 50 : 외국계기업
	*/
	JCheckBox[] coClcd;
	
	/* (다중검색 가능) 	고용형태를 입력합니다.
	- 10 : 정규직
	- 20 : 정규직전환
	- 30 : 비정규직
	- 40 : 기간제
	- 50 : 시간선택제
	- 60 기타
	 * */
	JCheckBox[] empWantedTypeCd;		 
	
	/* (다중검색 가능) 경력구분을 입력합니다.
	 - 10 : 경력무관
	 - 20 : 경력
	 - 30 : 신입
	 - 40 : 인턴
	 * */
	JCheckBox[] empWantedCareerCd;		 
	
	String jobsCd; //직종코드
	String empWantedTitle; //채용제목
	
	/* (다중검색 가능)	학력을 입력합니다.
	- 10 : 고졸
	- 20 : 대졸(2~3)
	- 30 : 대졸
	- 40 : 석사
	- 50 : 박사
	- 99 : 학력무관
	 */
	JCheckBox[] empWantedEduCd;
	
	/* 등록일 기준 정렬필드
	- regDt : 등록일
	- coNm : 회사명
	  해당 검색조건 미입력 시 자동으로 등록일 상향정렬 */
	SortFieldDTO sortField;	 	
	
	/* 등록일 기준 정렬방식
	 - desc : 상향정렬(defalut)
	 - asc : 하향정렬
	 해당 검색조건 미입력 시 자동으로 등록일 상향정렬
	 * */
	SortOrderByDTO sortOrderBy;	 	

	String busino; //사업자번호
}
