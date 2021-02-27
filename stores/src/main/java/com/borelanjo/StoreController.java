package com.borelanjo;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private static final Map<Long, String> SUPPLIERS = ImmutableMap.of(
            1L, "Store 1",
            2L, "Store 2",
            3L, "Store 3",
            4L, "Store 4");

    @GetMapping
    public List<String> findAll() {
        return new ArrayList<>(SUPPLIERS.values());
    }

    @GetMapping(path = "/{id}")
    public String findById(@PathVariable("id") Long id) {
        return SUPPLIERS.get(id);
    }

}
