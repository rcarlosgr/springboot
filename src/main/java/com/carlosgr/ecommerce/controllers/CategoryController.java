package com.carlosgr.ecommerce.controllers;

import com.carlosgr.ecommerce.dto.ResponseDto;
import com.carlosgr.ecommerce.entities.Category;
import com.carlosgr.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> list(@RequestParam int page, @RequestParam String search) {
        Page<Category> categories = categoryService.list(page, search);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody Category category) {
        Category res = categoryService.save(category);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id) {
        ResponseDto responseDto = new ResponseDto();
        categoryService.delete(id);

        responseDto.setMessage("Registro eliminado con éxito.");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
