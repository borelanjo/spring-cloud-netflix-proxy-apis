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
@RequestMapping("/sellers")
public class SellerController {

    private static final Map<Long, String> SELLERS = ImmutableMap.of(
            1L, "Seller 1",
            2L, "Seller 2",
            3L, "Seller 3",
            4L, "Seller 4");

    @GetMapping
    public List<String> findAll() {
        return new ArrayList<>(SELLERS.values());
    }

    @GetMapping(path = "/{id}")
    public String findById(@PathVariable("id") Long id) {
        return SELLERS.get(id);
    }

}
