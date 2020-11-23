package com.luthfihariz.almasgocore.controller.dto.mapper;

import com.luthfihariz.almasgocore.controller.dto.request.SearchRequestDto;
import com.luthfihariz.almasgocore.controller.dto.response.SearchResponseDto;
import com.luthfihariz.almasgocore.controller.dto.response.SearchResultDto;
import com.luthfihariz.almasgocore.service.dto.SearchQuery;
import org.elasticsearch.action.search.SearchResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchQueryMapper {

    public static SearchQuery fromSearchRequestDto(SearchRequestDto searchRequestDto) {
        return new SearchQuery(searchRequestDto.getQuery(), searchRequestDto.getFilter(), searchRequestDto.getPage(), searchRequestDto.getSize());
    }

    public static SearchResponseDto toSearchResponseDto(SearchResponse searchResponse) {
        SearchResponseDto searchResponseDto = new SearchResponseDto();
        searchResponseDto.setTook(searchResponse.getTook().getMillis());
        searchResponseDto.setMaxScore((double) searchResponse.getHits().getMaxScore());
        searchResponseDto.setCount((int) searchResponse.getHits().getTotalHits().value);

        List<SearchResultDto> searchResults = Arrays.stream(searchResponse.getHits().getHits()).map(searchHit ->
                new SearchResultDto((double) searchHit.getScore(), searchHit.getSourceAsMap())).collect(Collectors.toList());

        searchResponseDto.setResults(searchResults);

        return searchResponseDto;
    }
}
