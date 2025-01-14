package com.develogical;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class QueryProcessor {

    String patternString = ".*http://.*";
    Pattern addition = Pattern.compile("what is \\d+ plus \\d+");

    public String process(String query) {
        try {
            String[] queriesLower = query.toLowerCase().split(":", 2);
            String queryLower = queriesLower[queriesLower.length - 1].trim();
            if (queryLower.contains("shakespeare")) {
                return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                        "English poet, playwright, and actor, widely regarded as the greatest " +
                        "writer in the English language and the world's pre-eminent dramatist.";
            }
            if (queryLower.contains("neal stephenson")) {
                return "Neal Town Stephenson (born October 31, 1959) is an American writer known for his works of speculative fiction. His novels have been categorized as science fiction, historical fiction, cyberpunk, postcyberpunk, and baroque.\n" +
                        "Stephenson's work explores mathematics, cryptography, linguistics, philosophy, currency, and the history of science. He also writes non-fiction articles about technology in publications such as Wired. He has written novels with his uncle, George Jewsbury (\"J. Frederick George\"), under the collective pseudonym Stephen Bury.\n" +
                        "Stephenson has worked part-time as an advisor for Blue Origin, a company (founded by Jeff Bezos) developing a spacecraft and a space launch system,[1] and is also a cofounder of Subutai Corporation, whose first offering is the interactive fiction project The Mongoliad. He was Magic Leap's Chief Futurist from 2014 to 2020.";
            }

            if (queryLower.contains("what is your name")) {
                return "Stu";
            }

            if (queryLower.contains("what colour is a banana")) {
                return "yellow";
            }

            if (queryLower.contains("who played james bond in the film dr no")) {
                return "Sean Connery";
            }

            if (queryLower.contains("fibonacci")) {
                return fib(queryLower);
            }

            if (queryLower.contains("what is ") && queryLower.contains("plus")) {
                String[] numbers = queryLower.replace("what is ", "").replace("plus ", "").split(" ");
                return Integer.toString(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
            }

            if (queryLower.contains("what is ") && queryLower.contains("minus")) {
                String[] numbers = queryLower.replace("what is ", "").replace("minus ", "").split(" ");
                return Integer.toString(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]));
            }

            if (queryLower.contains("what is ") && queryLower.contains("multiplied by")) {
                String[] numbers = queryLower.replace("what is ", "").replace("multiplied by ", "").split(" ");
                return Integer.toString(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]));
            }

            if (queryLower.contains("what is ") && queryLower.contains("to the power of")) {
                String[] numbers = queryLower.replace("what is ", "").replace("to the power of ", "").split(" ");
                return Double.toString(Math.pow(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])));
            }

            if (queryLower.contains("which of the following numbers is the largest:")) {
                Stream<String> stringStream = Arrays.stream(queryLower.replace("which of the following numbers is the largest:", "").split(","));
                int result = stringStream.mapToInt(x -> Integer.parseInt(x.trim())).max().orElseGet(() -> 0);
                return Integer.toString(result);
            }
        } catch( Exception e) {
            System.out.println("BANG!! KNOW: " + query);
        }
        System.out.println("DONT KNOW: " + query);
        return "";
    }

    private String fib(String queryLower) {
        int nth = Integer.parseInt(queryLower.replace("th number in the fibonacci sequence", "").replace("what is the ", ""));

        return fibbonnaci(nth).toString();
    }

    public Integer fibbonnaci(int i) {
        if(i <= 2) return 1;

        return fibbonnaci(i -1) + fibbonnaci(i - 2);
    }
}
