package flowable.service;

import org.flowable.common.engine.impl.interceptor.CommandExecutor;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.RuntimeServiceImpl;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.junit.Test;

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
