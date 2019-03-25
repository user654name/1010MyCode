package flowable.service;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;

import java.util.*;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/24
 * @time 18:51
 * @package flowable.service
 * @project 1008MyDemo
 * @description
 */
public class FlowOpts {


    static String PROCESS_ID = "roll-demo";
    static String PROCESS_INSTANCE_ID = "2501";
    static String TASK_ASSIGNEE = "zhang";


    @Test
    public void startTask() {
        RuntimeService runtimeService = getEngine().getRuntimeService();
        ProcessInstance processInstance =
                runtimeService
                        .startProcessInstanceByKey(PROCESS_ID, (Map<String, Object>) null);
        String name = processInstance.getName();
        String id = processInstance.getId();
        System.out.println("任务" + name + "已开启,流程实例ID :" + id);
        // 任务null已开启,流程实例ID :2501
    }


    @Test
    public void showTaskById() {
        TaskService taskService = getEngine().getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(TASK_ASSIGNEE).list();
        for (Task task : tasks) {
            System.out.println("task = " + task);
        }
    }

    @Test
    public void showTaskByProcessInstanceId() {

        System.out.println("PROCESS_INSTANCE_ID = " + PROCESS_INSTANCE_ID);
        TaskService taskService = getEngine().getTaskService();
        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(PROCESS_INSTANCE_ID).list();
        for (Task task : tasks) {
            System.out.println("task = " + task);
        }
    }


    /**
     * 完成该实例的任务
     */
    @Test
    public void completeTaskByProcessId() {
        System.out.println("PROCESS_INSTANCE_ID = " + PROCESS_INSTANCE_ID);

        TaskService taskService = getEngine().getTaskService();

        // 完成几次任务？
        loop(taskService, 6);


        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(PROCESS_INSTANCE_ID).list();
        for (Task task : tasks) {
            System.out.println("当前任务状态 : " + task);
        }
    }


    @Test
    public void rollBack() throws Exception {
        String taskId = "22523";


        TaskService taskService = getEngine().getTaskService();

        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(PROCESS_INSTANCE_ID).list();
        for (Task task : tasks) {
            System.out.println("当前任务状态 : " + task);
            taskId = task.getId();
        }

//        当前任务状态 : Task[id=5023, name=name-G]
        String currentActId = null;
        String targetActId = null;
        RuntimeService runtimeService = getEngine().getRuntimeService();
        HistoryService historyService = getEngine().getHistoryService();

        // 1 查询当前任务的actId
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String taskDefinitionKey = task.getTaskDefinitionKey();
        currentActId = taskDefinitionKey;
        System.out.println("taskDefinitionKey = " + taskDefinitionKey);


        // 2 查询当前流程实例的历史记录
        List<HistoricActivityInstance> hisRecords = historyService
                .createHistoricActivityInstanceQuery()
                .processInstanceId(PROCESS_INSTANCE_ID)
                .list();


        // 3 按时间将userTask封装
        TreeMap<Object, HistoricActivityInstance> hisMap = new TreeMap<>();
        for (HistoricActivityInstance instance : hisRecords) {
            Date startTime = instance.getStartTime();
            String activityType = instance.getActivityType();
            if (Objects.equals(activityType, "userTask")) {
                hisMap.put(startTime, instance);
            }
        }


        for (Object key : hisMap.keySet()) {
            HistoricActivityInstance instance = (HistoricActivityInstance) hisMap.get(key);
            System.out.println(key + "[遍历历史记录]taskId=" + instance.getTaskId() + ",actId=" + instance.getActivityId() + instance.getDeleteReason());
        }

        // 4 对删除标记进行处理
        Stack<HistoricActivityInstance> hisStack = new Stack<>();
        for (Object key : hisMap.keySet()) {
            HistoricActivityInstance instance = (HistoricActivityInstance) hisMap.get(key);

            boolean empty = hisStack.empty();

            if (empty) {
                // 栈空
                hisStack.push(instance);
                if (instance.getDeleteReason() != null) {
                    // 若有删除记录则出栈
                    hisStack.pop();
                }
            } else {
                // 栈不空
                String topElemActId = hisStack.peek().getActivityId();
                String instanceActId = instance.getActivityId();
                if (!Objects.equals(topElemActId, instanceActId)) {
                    // 和栈顶元素不一致 则入栈
                    hisStack.push(instance);
                }
                if (instance.getDeleteReason() != null) {
                    // 若有删除记录则出栈
                    hisStack.pop();
                }

            }
        }

        for (HistoricActivityInstance instance : hisStack) {
            System.out.println("[当前栈]taskId=" + instance.getTaskId() + ",actId=" + instance.getActivityId() + instance.getDeleteReason());
        }


        // 根据历史记录推算应回退的actId

        // 当前任务舍弃
        hisStack.pop();
        // 获取之前的任务
        HistoricActivityInstance instance = null;
        try {
            instance = hisStack.peek();
        } catch (Exception e) {
            Exception exception = new Exception("该任务无法继续回退");
            throw exception;
        }
        targetActId = instance.getActivityId();


        // 调用跳转api进行回退
        runtimeService
                .createChangeActivityStateBuilder()
                .processInstanceId(PROCESS_INSTANCE_ID)
                .moveActivityIdTo(currentActId, targetActId)
                .changeState();

        System.out.println("从状态" + currentActId + "跳转到了" + targetActId);


    }


    private void loop(TaskService taskService, int times) {
        for (int i = 0; i < times; i++) {
            List<Task> tasks = taskService.createTaskQuery()
                    .processInstanceId(PROCESS_INSTANCE_ID).list();
            for (Task task : tasks) {
                taskService.complete(task.getId());
                System.out.println("任务 : " + task + "已完成 ! ");
            }
        }
    }


    public static ProcessEngine getEngine() {
        // 连接
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable?serverTimezone=GMT")
                .setJdbcUsername("root")
                .setJdbcPassword("666888")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 引擎
        ProcessEngine processEngine = cfg.buildProcessEngine();

        return processEngine;
    }

}
