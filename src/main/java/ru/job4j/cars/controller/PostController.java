package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.SimplePostService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/posts")
@ThreadSafe
@AllArgsConstructor
public class PostController {

        private final SimplePostService postService;

        @GetMapping
        public String getAll(Model model, HttpSession httpSession) {
            var user = (User) httpSession.getAttribute("user");
            var posts = postService.findAll();
            model.addAttribute("posts", posts);
            return "/posts";
        }
    }
