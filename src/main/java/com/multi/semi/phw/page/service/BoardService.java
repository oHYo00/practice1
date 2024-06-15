package com.multi.spring.page.service;

import java.util.List;

import com.multi.spring.page.model.dto.BoardDTO;
import com.multi.spring.page.model.dto.PageDTO;

public interface BoardService {

	List<BoardDTO> selectAll(PageDTO pageDto);

	int selectCount();

}
