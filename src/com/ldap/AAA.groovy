package com.ldap

/**
 * @author Tianqi.Zhang
 * @date 2019/1/14
 * @time 13:08
 * @package com.ldap
 * @project 1008MyDemo
 * @description
 */

 class AAA {
    static void main(String[] args) {
        // Using a simple println statement to print output to the console
        def providedUsername = ""
//        def logger = args[1]
        providedUsername = "zhangtianqi"
        def dn = ""
        if (providedUsername.endsWith(".sdc")){
            dn =  "uid=" + providedUsername + ",ou=partner,dc=coding,dc=com"
            println "dn = $dn"
        }else {
            dn =  "uid=" + providedUsername + ",dc=coding,dc=com"
            println "dn = $dn"
        }
    }
}