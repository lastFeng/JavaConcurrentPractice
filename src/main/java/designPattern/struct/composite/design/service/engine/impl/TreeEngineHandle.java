package designPattern.struct.composite.design.service.engine.impl;

import designPattern.struct.composite.design.model.aggregates.TreeRich;
import designPattern.struct.composite.design.model.vo.EngineResult;
import designPattern.struct.composite.design.model.vo.TreeNode;
import designPattern.struct.composite.design.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
