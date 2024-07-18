package com.example.coding.base;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liutc
 * @date 2024/7/18 14:31
 */
public class MapD {

    public static void main(String[] args) {
       List<Prod> list = new ArrayList<>();
        Prod prod = new Prod();
        prod.setId(1);
        list.add(prod);

        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(Prod::getId, Prod::getName));
        System.out.println(collect);
    }

    @Data
    public static class Prod{
        private Integer id;
        private Integer name;
    }
}
