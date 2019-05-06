package ua.lviv.iot;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Виведіть та видаліть з тексту всі окличні речення,
 * котрі містять більше ніж 2 слова з дефісами.
 * Текст слід ввести з консолі
 */

public class StringProcessor {

    private List<String> resultsList;

    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public List<String> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<String> resultsList) {
        this.resultsList = resultsList;
    }

    public StringProcessor() {

    }

    public void readInputText() throws IOException {

        System.out.println("Print your text: ");

        Scanner scanner = new Scanner(System.in);

        this.userInput = scanner.nextLine();

        System.out.println("Your input is: " + userInput + "\n");

        scanner.close();

    }

    public List<String> myCustomRegex() {

        resultsList = new LinkedList<String>();

        Pattern pattern = Pattern.compile("[A-Z]+[A-Z , : a-z]+[-]+[A-Z a-z]+[-]+[A-Z a-z]+[!]");

        Matcher matcher = pattern.matcher(this.getUserInput());

        while (matcher.find()) {

            resultsList.add(matcher.group());

        }

        return resultsList;

    }

    public void showResults() {

        System.out.println("\n" + "Showing the results: ");

        if(resultsList.isEmpty()) {

            System.out.println("Bad text, no matches!");

        } else {

            System.out.println("Nice! Here the results: " + resultsList);
        }
    }

    public static void main(String[] args) throws IOException {

        StringProcessor sp = new StringProcessor();

        sp.readInputText();

        sp.myCustomRegex();

        sp.showResults();

    }
}