package com.daniel.controller;

import com.daniel.pojo.Book;
import com.daniel.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private BookService bookService;

    @RequestMapping("searchBook.do")
    public ModelAndView searchBook(Book book)  {

        ModelAndView mav = new ModelAndView("searchBook");

        List<Book> all = bookService.findAll(book);

        mav.addObject("books",all);
        return mav;
    }

//    private Directory createIndex(IKAnalyzer analyzer) throws IOException {
//        Directory index = new RAMDirectory();
//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//        IndexWriter writer = new IndexWriter(index,config);
//        List<Book> books = bookService.listByBookType(1);
//        for (Book book : books) {
//            addDoc(writer,book);
//        }
//        writer.close();
//        return index;
//    }
//
//    private void addDoc(IndexWriter writer,Book book) throws IOException {
//        Document doc = new Document();
//        doc.add(new TextField("id",book.getId()+"",Field.Store.YES));
//        doc.add(new TextField("name",book.getName(),Field.Store.YES));
//        writer.addDocument(doc);
//    }

}
