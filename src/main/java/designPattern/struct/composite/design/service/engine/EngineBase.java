package designPattern.struct.composite.design.service.engine;

import designPattern.struct.composite.design.model.aggregates.TreeRich;
import designPattern.struct.composite.design.model.vo.EngineResult;
import designPattern.struct.composite.design.model.vo.TreeNode;
import designPattern.struct.composite.design.model.vo.TreeRoot;
import designPattern.struct.composite.design.service.logic.LogicFilter;
import designPattern.util.Logger;

import java.util.Map;

public abstract class EngineBase extends EngineConfig implements IEngine{
    private Logger logger = new Logger();

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId,
                                           Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();

        // 规则树根
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);

        //节点类型[NodeType]； 1⼦子叶、 2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{0} userId：{1} treeId：{2} treeNode：{3} ruleKey：{4} matterValue：{5}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }

        return treeNodeInfo;
    }
}
