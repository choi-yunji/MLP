package org.multicampus.mlp.SearchResult.service;

import java.util.List;

import org.multicampus.mlp.SearchResult.domain.BookingDto;
import org.multicampus.mlp.SearchResult.domain.SearchResultDto;

public interface SearchResultService {
	List<SearchResultDto> getList(SearchResultDto dto);
	int getTotalCnt(SearchResultDto dto);
	SearchResultDto getView(int id);
	public void booking(BookingDto dto);
	public int maxid();
}
