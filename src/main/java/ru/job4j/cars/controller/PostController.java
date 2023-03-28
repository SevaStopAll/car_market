package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.File;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/posts")
@ThreadSafe
@AllArgsConstructor
public class PostController {

        private final SimplePostService postService;
        private final SimpleEngineService engineService;
        private final SimpleBodyService bodyService;
        private final SimpleTransmissionService transmissionService;
        private final SimpleFileService fileService;
        private final SimpleCarService carService;

        @GetMapping
        public String getAll(Model model, HttpSession httpSession) {
            var user = (User) httpSession.getAttribute("user");
            var posts = postService.findAll();
            model.addAttribute("posts", posts);
            return "/posts";
        }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var postOptional = postService.findById(id);
        if (postOptional.isEmpty()) {
            model.addAttribute("message", "Объявление с указанным идентификатором не найдено");
            return "errors/404";
        }
        var post = postOptional.get();
        model.addAttribute("post", post);
        return "posts/one";
    }

    @GetMapping("/create")
    public String getCreationPage(Model model) {
        model.addAttribute("engines", engineService.findAll());
        model.addAttribute("bodies", bodyService.findAll());
        model.addAttribute("transmissions", transmissionService.findAll());
        return "posts/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Post post, @SessionAttribute User user, @RequestParam("carName") String carName,
                         @RequestParam("engineId") Integer engineId, @RequestParam("bodyId") Integer bodyId,
                         @RequestParam("transmissionId") Integer transmissionId, @RequestParam MultipartFile fileDto, Model model) {
        try {
            post.setUser(user);
            var car = new Car();
            car.setName(carName);
            car.setEngine(engineService.findById(engineId).get());
            car.setBody(bodyService.findById(bodyId).get());
            car.setTransmission(transmissionService.findById(transmissionId).get());
            carService.save(car);
            post.setCar(car);
            if(!fileDto.isEmpty()) {
            post.setFile(fileService.save(new FileDto(fileDto.getOriginalFilename(), fileDto.getBytes())));
            } else {
                post.setFile(fileService.getFile(10).get());
            }

            postService.create(post);
            return "redirect:/posts";
        } catch (Exception exception) {
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }

    @GetMapping("/finish/{id}")
    public String finishTask(@PathVariable int id) {
        Post post = postService.findById(id).get();
        post.setSold(true);
        postService.update(post);
        return "redirect:/posts";
    }
}
