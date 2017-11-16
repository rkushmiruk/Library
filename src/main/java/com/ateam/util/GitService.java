package com.ateam.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class GitService {
    private static final Logger LOGGER = Logger.getLogger(GitService.class);
    private static final String GIT_DESCRIBE_ABBREV_0_TAGS = "git describe --abbrev=0 --tags";

    private GitService() {

    }

    public static String getGitTagVersion() {
        try {
            Process p = Runtime.getRuntime().exec(GIT_DESCRIBE_ABBREV_0_TAGS);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            return input.readLine();
        } catch (final IOException ex) {
            throw new RuntimeException();
        }
    }

    public static void logGitTagVersion() {
        LOGGER.info(getGitTagVersion());
    }
}
