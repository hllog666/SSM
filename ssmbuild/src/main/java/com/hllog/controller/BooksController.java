package com.hllog.controller;

import com.hllog.pojo.Books;
import com.hllog.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    @Qualifier("booksService")
    private BooksService booksService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> booksList = booksService.queryAllBook();
        model.addAttribute("list", booksList);
        return "allBook";
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books) {
        booksService.addBook(books);
        return "redirect:/books/allBook";
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(int id, Model model) {
        Books books = booksService.queryBookById(id);
        model.addAttribute("qbooks", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        booksService.updateBook(books);
        return "redirect:/books/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        booksService.deleteBookById(id);
        return "redirect:/books/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = booksService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        if (books == null) {
            list = booksService.queryAllBook();
            model.addAttribute("error", "未查到");
        } else {
            list.add(books);
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
