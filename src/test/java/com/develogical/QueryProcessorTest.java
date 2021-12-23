package com.develogical;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutNealStephenson() throws Exception {
        assertThat(queryProcessor.process("Neal Stephenson"), containsString("Neal Town Stephenson (born October 31, 1959)"));
    }

    @Test
    public void knowsTheTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("Stu"));
    }

    @Test
    public void canDoAddition() {
        assertThat(queryProcessor.process("what is 13 plus 18"), containsString("31"));
    }
    @Test
    public void canDoAdditionWhitespace() {
        assertThat(queryProcessor.process(" what is 13 plus 18 "), containsString("31"));
    }
}
