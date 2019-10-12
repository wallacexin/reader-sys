package cn.wallace.readersys.controller;

import cn.wallace.readersys.entity.Book;
import cn.wallace.readersys.repository.ReadingListRepository;
import cn.wallace.readersys.service.ReadingListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/reader-sys")
public class ReadingListController {

    private Logger logger = LoggerFactory.getLogger(ReadingListController.class);

    @Autowired
    private ReadingListService readingListService;

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model){
        List<Book> books = this.readingListService.findByReader(reader);
        if(books != null){
            model.addAttribute("books",books);
        }
        return "readingList";
    }
    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader,Book book){
        book.setReader(reader);
        this.readingListService.save(book);
        return "redirect:/reader-sys/{reader}";
    }

}
