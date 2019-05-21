package flowable.service;

import flowable.service.util.Conn;
import org.flowable.common.engine.impl.interceptor.CommandExecutor;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.RuntimeServiceImpl;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/15
 * @time 15:45
 * @package flowable.service
 * @project 1008MyDemo
 * @description
 */
public class TaskTest {

    @Test
    public void start() {
        ProcessEngine engine = Conn.getEngine();
        RuntimeService runtimeService = engine.getRuntimeService();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "good");
        map.put("time", "20190517");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("roll-demo", map);
        String id = processInstance.getId();
        System.out.println("processInstanceId = " + id);
        // processInstanceId = 5001
    }

    /*
    taskId = 5008
{name=good, time=20190517}

taskId = 7504
{name=bad, time=20190517, info=edit name from good to bad}
     */
    @Test
    public void showTask() {
        ProcessEngine engine = Conn.getEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> list = taskService.createTaskQuery().includeProcessVariables().taskAssignee("zhang").processVariableValueEquals("time", "20190517").list();
        for (Task task : list) {
            String id = task.getId();
            System.out.println("taskId = " + id);
            Map<String, Object> variables = taskService.getVariables(task.getId());
            System.out.println(variables);
            Map<String, Object> processVariables = task.getProcessVariables();
            System.out.println("processVariables = " + processVariables);
        }

    }

    @Test
    public void complete() {
        ProcessEngine engine = Conn.getEngine();
        TaskService taskService = engine.getTaskService();
        Map<String, Object> map = new HashMap<>();
        map.put("info", "edit name from good to bad");
        map.put("name", "bad");
        taskService.complete("5008", map);
    }


    @Test
    public void back() {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
//                .setJdbcUrl("jdbc:mysql://129.204.42.164:3306/flowable?zeroDateTimeBehavior=convertToNull&ampuseSSL=false")
                .setJdbcUrl("jdbc:mysql://129.204.42.164:3306/flowable")
                .setJdbcUsername("root")
                .setJdbcPassword("zhangtianqi666888")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = cfg.buildProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        RuntimeServiceImpl runtimeServiceImpl = (RuntimeServiceImpl) runtimeService;
        CommandExecutor commandExecutor = runtimeServiceImpl.getCommandExecutor();
        String taskId = "";
        String targetActKey = "";
        commandExecutor.execute(new JumpCommandConfig(taskId, targetActKey));
    }
}
