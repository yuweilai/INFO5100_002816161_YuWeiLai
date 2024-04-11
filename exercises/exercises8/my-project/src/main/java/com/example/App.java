package com.example;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class App {
    private static final String XML_DATA = "<BookShelf>" +
                                            "<Book>" +
                                                "<title>Java Programming</title>" +
                                                "<publishedYear>2020</publishedYear>" +
                                                "<numberOfPages>300</numberOfPages>" +
                                                "<authors>" +
                                                    "<author>John Doe</author>" +
                                                    "<author>Jane Smith</author>" +
                                                "</authors>" +
                                            "</Book>" +
                                            "<Book>" +
                                                "<title>Data Structures and Algorithms</title>" +
                                                "<publishedYear>2019</publishedYear>" +
                                                "<numberOfPages>400</numberOfPages>" +
                                                "<authors>" +
                                                    "<author>David Johnson</author>" +
                                                "</authors>" +
                                            "</Book>" +
                                            "<Book>" +
                                                "<title>Artificial Intelligence</title>" +
                                                "<publishedYear>2021</publishedYear>" +
                                                "<numberOfPages>500</numberOfPages>" +
                                                "<authors>" +
                                                    "<author>Emily Brown</author>" +
                                                    "<author>Michael Clark</author>" +
                                                "</authors>" +
                                            "</Book>" +
                                          "</BookShelf>";

    private static final JSONObject JSON_DATA = new JSONObject()
            .put("BookShelf", new JSONObject()
                    .put("Book", new JSONArray()
                            .put(new JSONObject()
                                    .put("title", "Java Programming")
                                    .put("publishedYear", 2020)
                                    .put("numberOfPages", 300)
                                    .put("authors", new JSONArray()
                                            .put("John Doe")
                                            .put("Jane Smith")))
                            .put(new JSONObject()
                                    .put("title", "Data Structures and Algorithms")
                                    .put("publishedYear", 2019)
                                    .put("numberOfPages", 400)
                                    .put("authors", new JSONArray()
                                            .put("David Johnson")))
                            .put(new JSONObject()
                                    .put("title", "Artificial Intelligence")
                                    .put("publishedYear", 2021)
                                    .put("numberOfPages", 500)
                                    .put("authors", new JSONArray()
                                            .put("Emily Brown")
                                            .put("Michael Clark")))));

    public static void main(String[] args) {
        // Parsing XML
        JSONObject xmlJsonObject = XML.toJSONObject(XML_DATA);
        System.out.println("XML Parsed Data:");
        System.out.println(xmlJsonObject.toString(4));

        // Parsing JSON
        JSONObject jsonData = new JSONObject(JSON_DATA.toString());

        // Printing
        System.out.println("\nJSON Parsed Data:");
        System.out.println(jsonData.toString(4));

        // Adding an entry
        JSONObject newBook = new JSONObject()
                .put("title", "New Book Title")
                .put("publishedYear", 2023)
                .put("numberOfPages", 350)
                .put("authors", new JSONArray()
                        .put("New Author 1")
                        .put("New Author 2"));
        JSONArray bookArray = jsonData.getJSONObject("BookShelf").getJSONArray("Book");
        bookArray.put(newBook);

        // Reprinting
        System.out.println("\nAfter adding a new book:");
        System.out.println(jsonData.toString(4));
    }
}
