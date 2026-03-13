import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Подсчитать количество гласных (a, e, i, o, u)
        int count = 0;
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (char i: input.toCharArray()){
            if (arr.contains(i)){
                count += 1;
            }
        }
        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Вывести строку в обратном порядке
        StringBuilder reversed = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for (char i : input.toCharArray()) s.push(i);
        while (!s.isEmpty()) reversed.append(s.pop());
        System.out.println(reversed.toString());
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        boolean isPalindrome = false;
        String result = new StringBuilder(input).reverse().toString();
        isPalindrome = input.equalsIgnoreCase(result);
        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Подсчитать количество слов в предложении
        int wordCount = 0;
        String[] arr = sentence.split(" ");
        wordCount = arr.length;

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Удалить все пробелы из строки
        String noSpaces = "";
        String[] arr = input.split(" ");
        noSpaces = String.join("", arr);
        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Преобразовать первую букву каждого слова в заглавную
        String result = "";

        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++){
            result += Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1) + " ";
        }
        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Найти символ, который встречается чаще всего
        char mostFrequent = ' ';
        int high = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : input.toCharArray()){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (char key : map.keySet()){
            if (map.get(key) > high){
                high = map.get(key);
                mostFrequent = key;
            }
        }
        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // TODO: Проверить, являются ли две строки анаграммами (игнорировать пробелы и регистр)
        boolean areAnagrams = true;

        String first = str1.toLowerCase().replace(" ", "");
        String second = str2.toLowerCase().replace(" ", "");

        HashMap<Character, Integer> map = new HashMap<>();

        for (char i : first.toCharArray()){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (char i : second.toCharArray()){
            if (map.containsKey(i)){
                map.put(i, map.get(i) - 1);
            } else {
                areAnagrams = false;
            }
        }

        for (char key : map.keySet()){
            if (map.get(key) != 0) {
                areAnagrams = false;
            }
        }
        System.out.println(areAnagrams ? "Yes" : "No");
    }
}