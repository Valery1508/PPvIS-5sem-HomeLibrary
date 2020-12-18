package sample.service;

import sample.model.Content;

import java.util.List;

public class BookServiceImplementation implements ContentService {

    Content content;
    List<Content> listOfBooks;

    @Override
    public boolean add(String name, String data) {
        // some logic
        return false;
    }

    @Override
    public boolean edit(Content content) {
        // some logic
        return false;
    }

    @Override
    public boolean delete(Content content) {
        // some logic
        return false;
    }

    public Content getBook(String book){
        return content;
    };

    public List<Content> getAllBooks(){
        return listOfBooks;
    }
}
