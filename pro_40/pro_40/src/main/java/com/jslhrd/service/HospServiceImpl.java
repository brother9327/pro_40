package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jslhrd.domain.HospBoardVO;
import com.jslhrd.domain.HospVO;
import com.jslhrd.domain.PageVO;
import com.jslhrd.mapper.HospMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HospServiceImpl implements HospService {

	// 주입
	private HospMapper mapper;

	// 전체 목록 카운트
	@Override
	public int hospCount() {

		return mapper.hospCount();
	}

	// 검색조건에 맞는 게시물 카운트
	@Override
	public int hospSearchCount(PageVO vo) {
		// TODO Auto-generated method stub
		return mapper.hospSearchCount(vo);
	}

	// 전체 목록 검색
	@Override
	public List<HospVO> hospList(PageVO vo) {
		// TODO Auto-generated method stub
		return mapper.hospList(vo);
	}

	// 조건에 맞는 게시물 불러오기
	@Override
	public List<HospVO> hospListSearch(PageVO vo) {
		// TODO Auto-generated method stub
		return mapper.hospListSearch(vo);
	}

	// 등록처리
	@Override
	public void hospWrite(HospVO vo) {

		mapper.hospWrite(vo);

	}
	
	//조회수 증가
	@Override
	public void hospHits(int idx, HttpServletRequest request, HttpServletResponse response) {

		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("hospCookie" + idx)) {
				bool = true;
				break;
			}
		}
		String str = "" + System.currentTimeMillis();

		if (!bool) {
			info = new Cookie("hospCookie" + idx, str);
			info.setMaxAge(60 * 60 * 24);
			response.addCookie(info);
			mapper.hospHits(idx);
		}
	}
	
	//뷰처리
	@Override
	public HospVO hospView(int idx) {

		return mapper.hospView(idx);
	}

	@Override
	public List<HospBoardVO> hospboardList(int idx) {
		// TODO Auto-generated method stub
		return mapper.hospboardList(idx);
	}
	
	@Override
	public void hospModify(HospVO vo) {
	
		mapper.hospModify(vo);
		
	}
}
