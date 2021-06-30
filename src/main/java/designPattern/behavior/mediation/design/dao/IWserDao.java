package designPattern.behavior.mediation.design.dao;

import designPattern.behavior.mediation.design.po.Wser;

public interface IWserDao {
    Wser queryWserInfoById(Integer id);
}
