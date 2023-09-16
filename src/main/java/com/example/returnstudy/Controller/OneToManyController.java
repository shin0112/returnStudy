package com.example.returnstudy.Controller;

import com.example.returnstudy.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OneToManyController {

    private final CategoryService categoryService;

    // http://localhost:8080/one-to-many
    @GetMapping("/one-to-many")
    public void OneToManyTest() {
        categoryService.OneToManyPostHashTagSave();
    }

}
