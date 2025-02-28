package com.example.coding.设计模式;

import lombok.Data;

/**
 * @author liutc
 * @date 2025/1/4 10:08
 */
public class 装饰器模式 {

    // 定义饮料接口
    interface Beverage {
        String getDescription(); // 获取描述

        double getCost();        // 获取价格
    }

    // 实现基础饮料类 - 咖啡
    @Data
    public class Coffee implements Beverage {
        @Override
        public String getDescription() {
            return "Coffee";
        }

        @Override
        public double getCost() {
            return 5.0; // 咖啡基础价格
        }
    }

    // 创建装饰器基类
    abstract class BeverageDecorator implements Beverage {
        protected Beverage beverage; // 持有一个饮料对象

        public BeverageDecorator(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription();
        }

        @Override
        public double getCost() {
            return beverage.getCost();
        }
    }

    // 实现具体装饰器 - 奶油
    public class CreamDecorator extends BeverageDecorator {
        public CreamDecorator(Beverage beverage) {
            super(beverage);
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Cream";
        }

        @Override
        public double getCost() {
            return beverage.getCost() + 1.5; // 奶油价格
        }
    }

    // 实现具体装饰器 - 糖
    public class SugarDecorator extends BeverageDecorator {
        public SugarDecorator(Beverage beverage) {
            super(beverage);
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Sugar";
        }

        @Override
        public double getCost() {
            return beverage.getCost() + 0.5; // 糖价格
        }
    }

    // 测试代码
    public void test() {
        // 创建基础饮料 - 咖啡
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        // 添加奶油装饰
        coffee = new CreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        // 添加糖装饰
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        //添加糖和奶油
        coffee = new CreamDecorator(new SugarDecorator(coffee));
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }

    public static void main(String[] args) {
        装饰器模式 装饰器模式 = new 装饰器模式();
        装饰器模式.test();
    }
}
