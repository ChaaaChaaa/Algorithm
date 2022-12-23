package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Q1302_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String [] books = new String[count];
        HashMap<String,Integer> sellingBookList = new HashMap<>();

        for (int i = 0; i < count; i++) {
            books[i] = br.readLine();
        }

        Arrays.sort(books);

        for(String book : books){
            Integer value = sellingBookList.getOrDefault(book,0);
            sellingBookList.put(book,++value);
        }

        int maxSelling = 0;
        String maxSellingBook = "";

        for(String book : books){
            Integer value = sellingBookList.get(book);
            if(value>maxSelling){
                maxSelling = value;
                maxSellingBook = book;
            }
        }
        System.out.println(maxSellingBook);
    }

}

