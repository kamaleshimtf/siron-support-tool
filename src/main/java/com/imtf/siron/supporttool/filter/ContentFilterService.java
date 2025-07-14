package com.imtf.siron.supporttool.filter;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class ContentFilterService {

    public List<Pattern> compileContentFilterPatterns(List<String> sensitiveKeywords) {
        List<Pattern> patterns = new ArrayList<>();
        for (String keyword : sensitiveKeywords) {
            patterns.add(compileFileContentToRegex(keyword));
        }
        return patterns;
    }

    public Pattern compileFileContentToRegex(String keyword) {
        String regex;

        if (keyword.contains("*")) {
            regex = compileWildcard(keyword);
            if (!regex.startsWith(".*")) {
                regex = "^" + regex;
            }
            if (!regex.endsWith(".*")) {
                regex = regex + "($|\\z|\\Z)";
            }
        } else {
            regex = "^\\Q" + keyword + "\\E($|\\z|\\Z)";
        }

        return Pattern.compile(regex);
    }

    public String compileWildcard(String contentFilter) {
        Pattern regex = Pattern.compile("[^*]+|(\\*)");
        Matcher matcher = regex.matcher(contentFilter);
        StringBuilder finalWildCard = new StringBuilder();

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                matcher.appendReplacement(finalWildCard, ".*");
            } else {
                matcher.appendReplacement(finalWildCard,
                        Matcher.quoteReplacement("\\Q" + matcher.group(0) + "\\E"));
            }
        }

        matcher.appendTail(finalWildCard);
        return finalWildCard.toString();
    }
}
