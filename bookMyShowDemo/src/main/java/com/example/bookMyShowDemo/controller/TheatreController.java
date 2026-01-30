package com.example.bookMyShowDemo.controller;

import com.example.bookMyShowDemo.model.Show;
import com.example.bookMyShowDemo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    private ShowService showService;

    @PostMapping("/shows")
    public Show createShow(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @PutMapping("/shows/{id}")
    public Show updateShow(@PathVariable Long id, @RequestBody Show show) {
        return showService.updateShow(id, show);
    }

    @DeleteMapping("/shows/{id}")
    public void deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
    }
}