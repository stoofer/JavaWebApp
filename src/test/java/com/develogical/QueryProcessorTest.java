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
    public void knowsMovieTrivia() throws Exception {
        assertThat(queryProcessor.process("e93c4010: who played James Bond in the film Dr No"), containsString("Sean Connery"));
    }

    @Test
    public void doesFibbonacci() throws Exception {
        assertThat(queryProcessor.process("what is the 4th number in the Fibonacci sequence"), containsString("3"));
    }

    @Test
    public void canDoAddition() {
        assertThat(queryProcessor.process("what is 13 plus 18"), containsString("31"));
    }
    @Test
    public void canDoAdditionWhitespace() {
        assertThat(queryProcessor.process(" what is 13 plus 18 "), containsString("31"));
    }
    @Test
    public void stripsQueryHeaderDoAdditionWhitespace() {
        assertThat(queryProcessor.process("ce42fdf0: what is 13 plus 18 "), containsString("31"));
    }

    @Test
    public void stripsQueryHeaderDoMultiplication() {
        assertThat(queryProcessor.process("ce42fdf0: what is 13 multiplied by 10 "), containsString("130"));
    }
    @Test
    public void stripsQueryHeaderDoSubtraction() {
        assertThat(queryProcessor.process("ce42fdf0: what is 13 minus 10 "), containsString("3"));
    }

    @Test
    public void mathToPowerOf() {
        assertThat(queryProcessor.process("194b9ee0: what is 14 to the power of 8"), containsString("1.475789056E9"));
    }

    @Test
    public void comparisonOfNumber() {
        String query = "ce42fdf0: which of the following numbers is the largest: 561, 24, 856";
        assertThat(queryProcessor.process(query), containsString("856"));
    }

    @Test
    public void whatColourIsABanana() {
        String query = "ce42fdf0: what colour is a banana";
        assertThat(queryProcessor.process(query), containsString("yellow"));
    }

    @Test
    public void fib() {
        assertThat(queryProcessor.fibbonnaci(1), is(1) );
        assertThat(queryProcessor.fibbonnaci(2), is(1) );
        assertThat(queryProcessor.fibbonnaci(3), is(2) );
        assertThat(queryProcessor.fibbonnaci(4), is(3) );
        assertThat(queryProcessor.fibbonnaci(5), is(5) );
    }
}
