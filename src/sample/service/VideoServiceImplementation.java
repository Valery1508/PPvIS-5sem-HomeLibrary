package sample.service;

import sample.model.Content;

import java.util.List;

public class VideoServiceImplementation implements ContentService {

    Content content;
    List<Content> listOfVideo;

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

    public Content getVideo(String video){
        return content;
    };

    public List<Content> getAllVideo(){
        return listOfVideo;
    }
}
