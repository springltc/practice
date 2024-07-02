package com.example.coding.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liutc
 * @date 2024/6/25 16:32
 */
public class SetD {

    @Data
    public static class SkuD {

        private Long skuId;
        private JSONObject dimensionValues;
    }

    public static void main(String[] args) {
//        List<SkuD> oldThirdSkus = new ArrayList<>();
//        List<SkuD> newThirdSkus = new ArrayList<>();
//        Map<Long, JSONObject> oldMap = oldThirdSkus.stream().filter(x -> Objects.nonNull(x.getSkuId())).collect(Collectors.toMap(SkuD::getSkuId, SkuD::getDimensionValues));
//        Map<Long, JSONObject> newMap = newThirdSkus.stream().filter(x -> Objects.nonNull(x.getSkuId())).collect(Collectors.toMap(SkuD::getSkuId, SkuD::getDimensionValues));

        HashMap<Long, Object> map = new HashMap<>();
        map.put(1L,null);
        map.keySet();

//        Set<Long> skuIds = oldMap.keySet();
//        Set<Long> skuIds = map.keySet();
//        HashSet<Long> objects = new HashSet<>();
//        objects.add(24L);
//        objects.add(34L);
//        skuIds.addAll(objects);

    }
}
