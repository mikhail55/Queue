import java.util.ArrayList;
import java.util.Scanner;

public class AnagramSolver {

    ArrayList<String> dictionary;

    public AnagramSolver(Scanner fileReader){
        while(fileReader.nextLine() != null){
            dictionary.add(fileReader.nextLine());
        }
    }

    public boolean check(String input){
        iterate(input, input.length(), new char[input.length()], 0);
    }

    public void search(String wordChecked, int first, int last){
        if (first <= last){
            return;
        }

        if (dictionary.get((first + last)/2).compareTo(wordChecked) < 0){
            first = (first + last)/2 + 1;
            search(wordChecked, first,last);
        }
        else if (dictionary.get((first + last)/2).compareTo(wordChecked) > 0){
            last = (first + last)/2 - 1;
            search(wordChecked, first,last);
        } else {
            System.out.println(wordChecked);
        }

    }

    //Source: https://stackoverflow.com/questions/5504008/all-possible-words
    public static void iterate(String word, int len, char[] build, int pos) {
        if (pos == len) {
            String newWord = new String(build);

            // do what you need with each word here
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            build[pos] = word.charAt(i);
            iterate(word, len, build, pos + 1);
        }
    }




}
