package com.imtf.siron.supporttool.service;

import com.imtf.siron.supporttool.constant.SupportToolConfig;
import com.imtf.siron.supporttool.filter.ContentFilterService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@ApplicationScoped
public class SupportToolConfigService {

    private final Logger logger = LoggerFactory.getLogger(SupportToolConfigService.class);

    @Inject
    SupportToolConfig supportToolConfig;

    @Inject
    ContentFilterService contentFilterService;

    public List<Pattern> getSensitivePatterns() {
        List<String> getSensitiveListKeyword = getSensitiveListKeyWords();
        if (getSensitiveListKeyword.isEmpty()) {
            logger.info("No additional content filters configured for parameter support.contentFilter");
            return new ArrayList<>();
        }

        logger.info("Additional content filters configured for parameter support.contentFilter: {}", Arrays.toString(getSensitiveListKeyword.toArray()));

        return contentFilterService.compileContentFilterPatterns(getSensitiveListKeyword);
    }

    public List<String> getSensitiveListKeyWords() {
        return supportToolConfig.getContentFilter().stream()
                .filter(keyword -> keyword != null && !keyword.trim().isEmpty())
                .map(String::trim)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
