package sample.service;

import sample.model.Content;

public interface ContentService {

    boolean add(String name, String data);
    boolean edit(Content content);
    boolean delete(Content content);

}
