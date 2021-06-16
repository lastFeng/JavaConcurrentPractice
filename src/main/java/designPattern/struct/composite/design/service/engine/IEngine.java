package designPattern.struct.composite.design.service.engine;

import designPattern.struct.composite.design.model.aggregates.TreeRich;
import designPattern.struct.composite.design.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {
    /**
     * 决策处理
     * @param treeId
     * @param userId
     * @param treeRich
     * @param decisionMatter
     * @return
     */
    EngineResult process(final Long treeId, final String userId, TreeRich
            treeRich, final Map<String, String> decisionMatter);
}
