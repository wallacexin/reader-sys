package cn.wallace.readersys.service;

import cn.wallace.readersys.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReadingListServiceTest {

    private ReadingListService readingListService;

    @Before
    public void before() {
        this.readingListService = Mockito.mock(ReadingListService.class);
    }

    @Test
    public void findByReader() {
        Book book = new Book();
        book.setId(new Long(1));
        book.setReader("wallace");
        book.setAuthor("timmy");
        book.setDescription("nice");
        book.setIsbn("1234");
        book.setTitle("book");
        List<Book> books = new ArrayList<>();
        books.add(book);
        Mockito.when(readingListService.findByReader(Mockito.anyString())).thenReturn(books);
        List<Book> rsBooks = readingListService.findByReader("wallace");
        Assert.assertEquals("timmy",rsBooks.get(0).getAuthor());

  }

    @Test
    public void save() {
    }
}