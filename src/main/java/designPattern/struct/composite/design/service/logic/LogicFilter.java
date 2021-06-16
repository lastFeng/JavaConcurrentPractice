package designPattern.struct.composite.design.service.logic;

import designPattern.struct.composite.design.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

public interface LogicFilter {
    /***
     * 逻辑决策器
     * @param matterValue 决策值
     * @param treeNodeLineInfoList 决策节点
     * @return 下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList);

    /**
     * 逻辑决策值
     * @param treeId
     * @param useId
     * @param decisionMatter 决策内容
     * @return 决策值
     */
    String matterValue(Long treeId, String useId, Map<String, String> decisionMatter);
}
