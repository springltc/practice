package com.example.coding.spring.util;

import com.alibaba.fastjson.JSON;
import com.example.coding.spring.util.model.Address;
import com.example.coding.spring.util.model.City;
import com.example.coding.spring.util.model.User;

import java.util.Optional;

/**
 * @author liutc
 * @date 2026/1/9 11:03
 */
public class OptionUtil {

    public static void main(String[] args) {
        User user = new User();
        Address address = new Address();
        City city = new City();
        city.setCityCode("sh");
//        city.setCityName("上海");
        address.setCity(city);
        user.setAddress(address);

        City cityResult = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .orElse(null);
        System.out.println(JSON.toJSONString(cityResult));

        Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .ifPresent(c -> System.out.println(c.getCityName()));

        Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .map(x -> x.getCityName())
                .orElseThrow(() -> new RuntimeException("城市信息不存在"));
    }

}
