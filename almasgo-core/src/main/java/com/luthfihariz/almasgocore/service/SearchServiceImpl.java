package com.luthfihariz.almasgocore.service;

import com.luthfihariz.almasgocore.repository.SearchableContentRepository;
import com.luthfihariz.almasgocore.service.dto.SearchQuery;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchableContentRepository searchableContentRepository;

    @Override
    public SearchHit[] search(SearchQuery searchQuery, Long engineId) throws IOException {
        return searchableContentRepository.search(searchQuery, engineId);
    }
}
