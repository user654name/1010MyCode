package com.ldap;

import javax.naming.NamingException;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author Tianqi.Zhang
 * @date 2019/1/14
 * @time 9:49
 * @package com.ldap
 * @project 1008MyDemo
 * @description
 */
public class LdapSun {
    public static void main(String[] args) {

        while (true) {
            login();
        }

    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名！");
        String username = scanner.next();
        System.out.println("请输入密码！");
        String credentials = scanner.next();

        /**
         * 用户名密码
         */
//        String username = "zhangtianqi";
//        String credentials = "123123";
        String factory = "com.sun.jndi.ldap.LdapCtxFactory";
        String url = "ldap://192.168.208.131:389/";
        String authentication = "simple";
        String dnPrincipal;
//        if (username.indexOf(".sdc") > 0) {
//            dnPrincipal = "uid=" + username + ",ou=partner,dc=coding,dc=com";
//
//        } else {
//            dnPrincipal = "uid=" + username + ",dc=coding,dc=com";
//        }
        dnPrincipal = "uid=" + username + ",ou=People,dc=coding,dc=com";
        System.out.println("唯一标示 dn = " + dnPrincipal);
        System.out.println("密码 credentials = " + credentials);

        LdapContext ldapContext = null;
        Hashtable env = null;
        Control[] controls = null;

        env = new Hashtable();
        //INITIAL_CONTEXT_FACTORY = "java.naming.factory.initial"
        env.put(LdapContext.INITIAL_CONTEXT_FACTORY, factory);
        //PROVIDER_URL = "java.naming.provider.url"
        env.put(LdapContext.PROVIDER_URL, url);
        // SECURITY_AUTHENTICATION = "java.naming.security.authentication"
        env.put(LdapContext.SECURITY_AUTHENTICATION, authentication);
        // SECURITY_PRINCIPAL = "java.naming.security.principal"
        env.put(LdapContext.SECURITY_PRINCIPAL, dnPrincipal);
        // SECURITY_CREDENTIALS = "java.naming.security.credentials"
        env.put(LdapContext.SECURITY_CREDENTIALS, credentials);


        try {
            ldapContext = new InitialLdapContext(env, controls);
            System.out.println("验证成功");
        } catch (NamingException e) {
            e.printStackTrace();
            System.out.println(" 出 错 NamingException ");
        } catch (Exception e) {
            System.out.println("抛出Exception ");
        } finally {
            System.out.println("------------------------------------------");
        }
    }

}
