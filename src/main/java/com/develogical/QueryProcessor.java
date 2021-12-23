package com.develogical;

import java.util.regex.Pattern;

public class QueryProcessor {

    String patternString = ".*http://.*";
    Pattern addition = Pattern.compile("what is \\d+ plus \\d+");

    public String process(String query) {
        String queryLower = query.toLowerCase().trim();
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

        if(queryLower.contains("what is your name")) {
            return "Stu";
        }

        if(queryLower.contains("what is ") && queryLower.contains("plus")) {
            String[] numbers = queryLower.replace("what is ", "").replace("plus ", "").split(" ");
            return Integer.toString(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
        }
        return "";
    }
}
