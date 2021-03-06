package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.CorpBoardVO;
import com.jslhrd.domain.CorpVO;
import com.jslhrd.domain.PageVO;

public interface CorpMapper {

	// 전체 목록 카운트
	public int corpCount();

	// 검색조건에 맞는 게시물 카운트
	public int corpSearchCount(PageVO vo);

	// 전체 목록 검색
	public List<CorpVO> corpList(PageVO vo);

	// 조건에 맞는 게시물 불러오기
	public List<CorpVO> corpListSearch(PageVO vo);

	// 병원 홈페이지 등록
	public void corpWrite(CorpVO vo);

	// 뷰처리
	public CorpVO corpView(int idx);

	// 조회수
	public void corpHits(int idx);

	// 수정처리
	public void corpModify(CorpVO vo);

	// 삭제처리

	// 파일찾기

	// 공지사항 불러오기
	public List<CorpBoardVO> corpboardList(int idx);
}
