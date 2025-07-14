package com.imtf.siron.supporttool.constant;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@ApplicationScoped
public class SensitiveFileContents {

    private final List<String> sensitiveListKeyWords = new ArrayList<>();
    private final List<Pattern> sensitiveListPatterns = new ArrayList<Pattern>();

    public SensitiveFileContents() {
        initializeSensitiveFileContent();
    }

    private void initializeSensitiveFileContent() {
        sensitiveListKeyWords.add("PASSWORD");
        sensitiveListKeyWords.add("PASSWD");
        sensitiveListKeyWords.add("PWD");
        sensitiveListKeyWords.add("PASSWORT");
        sensitiveListKeyWords.add("URL");
        sensitiveListKeyWords.add("KEY_FILE");
        sensitiveListKeyWords.add("CRYPT");
        sensitiveListKeyWords.add("DB.PASS");
        sensitiveListKeyWords.add("SECRET");
        sensitiveListKeyWords.add("KYC_JMSPASS");

        sensitiveListPatterns.addAll(
                sensitiveListKeyWords.stream()
                        .map(keyword -> Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE))
                        .toList()
        );

        sensitiveListPatterns.add(
                Pattern.compile("(USER)(?!.*EXIT.*)(?!.*_CONSORTIUM_SERVER.*)", Pattern.CASE_INSENSITIVE)
        );
    }

    public void addCustomSensitivePatterns(List<Pattern> additionalPatterns) {
        sensitiveListPatterns.addAll(additionalPatterns);
    }
}
