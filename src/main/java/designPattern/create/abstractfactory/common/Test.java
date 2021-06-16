package designPattern.create.abstractfactory.common;

public class Test {
    public static void main(String[] args) {
        CacheService cacheService = new CacheServiceImpl();

        cacheService.set("user_name_01", "小傅哥", 1);
        String val01 = cacheService.get("user_name_01", 1);
        System.out.println("测试结果：" + val01);
    }
}
