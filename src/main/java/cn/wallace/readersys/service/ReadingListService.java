package cn.wallace.readersys.service;

import cn.wallace.readersys.entity.Book;
import cn.wallace.readersys.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingListService {


    @Autowired
    private ReadingListRepository readingListRepository;

    public List<Book> findByReader(String reader) {
        List<Book> books = readingListRepository.findByReader(reader);
        return books;
    }

    public void save(Book book) {
        readingListRepository.save(book);
    }
}
