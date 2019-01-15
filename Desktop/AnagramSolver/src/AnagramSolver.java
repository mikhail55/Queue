import java.util.ArrayList;
import java.util.Scanner;

public class AnagramSolver {

    ArrayList<String> dictionary;

    public AnagramSolver(Scanner fileReader){
        dictionary = new ArrayList<String>();
        String lastLine = null;
        while(lastLine != "End of the dictionary"){
            try{

            lastLine = fileReader.nextLine();
                dictionary.add(lastLine);
            } catch (java.util.NoSuchElementException e){
                System.err.println("No line present");
                return;
            }


        }
    }

    public void check(Scanner inputReader){
        System.out.println("Enter an anagram: ");
        String input = inputReader.nextLine();
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
            System.out.println("Found word: " + wordChecked);
        }

    }

    //Source: https://stackoverflow.com/questions/5504008/all-possible-words
    private void iterate(String word, int len, char[] build, int pos) {
        if (pos == len) {
            String newWord = new String(build);
            search(newWord, 0, dictionary.size());
            // do what you need with each word here
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            build[pos] = word.charAt(i);
            iterate(word, len, build, pos + 1);
        }
    }




}
