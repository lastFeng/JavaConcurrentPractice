package designPattern.create.factory.base.goods;

public class GoodsService {
    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + req.toString());
        return true;
    }
}
