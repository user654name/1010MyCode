package flowable.service;

import flowable.service.util.Conn;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/22
 * @time 17:36
 * @package flowable.service
 * @project 1008MyDemo
 * @description
 */
public class SaveXml {
    public static void main(String[] args) {


        String xmlName = "roll-back-demo.bpmn20.xml";

        ProcessEngine engine = Conn.getEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource(xmlName).deploy();
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .deploymentId(deploy.getId())
                .singleResult();
        String name = processDefinition.getName();
        System.out.println("流程部署成功 ：· " + name);

    }
}
