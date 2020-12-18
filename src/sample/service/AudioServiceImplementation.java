package sample.service;

import sample.model.Content;

import java.util.List;

public class AudioServiceImplementation implements ContentService {

    Content content;
    List<Content> listOfAudio;

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

    public Content getAudio(String audio){
        return content;
    };

    public List<Content> getAllAudio(){
        return listOfAudio;
    }
}