package designPattern.create.factory.design;

import designPattern.create.factory.design.store.ICommodity;
import designPattern.create.factory.design.store.impl.CardCommodityService;
import designPattern.create.factory.design.store.impl.CouponCommodityService;
import designPattern.create.factory.design.store.impl.GoodsCommodityService;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
