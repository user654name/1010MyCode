package flowable.service;

import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.FlowableEngineAgenda;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManager;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.engine.impl.util.ProcessDefinitionUtil;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityManager;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/15
 * @time 15:49
 * @package flowable.service
 * @project 1008MyDemo
 * @description
 */
public class JumpCommandConfig implements Command {
    protected String taskId;
    protected String targetAct;

    public JumpCommandConfig(String taskId, String targetAct) {
        this.targetAct = targetAct;
        this.taskId = taskId;
    }

    @Override
    public Object execute(CommandContext commandContext) {
        try {
            ExecutionEntityManager executionEntityManager = CommandContextUtil.getExecutionEntityManager();

            TaskEntityManager taskEntityManager = org.flowable.task.service.impl.util.CommandContextUtil.getTaskEntityManager();

            TaskEntity taskEntity = taskEntityManager.findById(taskId);

            ExecutionEntity executionEntity = executionEntityManager.findById(taskEntity.getExecutionId());

            Process process = ProcessDefinitionUtil.getProcess(executionEntity.getProcessDefinitionId());

            FlowElement flowElement = process.getFlowElement(targetAct);

            executionEntity.setCurrentFlowElement(flowElement);

            FlowableEngineAgenda agenda = CommandContextUtil.getAgenda();

            agenda.planAsyncTriggerExecutionOperation(executionEntity);

            CommandContextUtil.getIdentityLinkService().deleteIdentityLinksByTaskId(taskId);

            taskEntityManager.delete(taskId);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}
