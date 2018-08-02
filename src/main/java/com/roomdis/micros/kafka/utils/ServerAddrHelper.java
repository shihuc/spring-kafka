package com.roomdis.micros.kafka.utils;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by chengsh05 on 2018-07-31.
 */
public class ServerAddrHelper {

    public static String getTomcatPort() {
        try {
            MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
            String port = objectNames.iterator().next().getKeyProperty("port");
            return port;
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "00";
    }

    public static String getIpAddressAndPort() throws MalformedObjectNameException, NullPointerException, UnknownHostException {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String host = InetAddress.getLocalHost().getHostAddress();
        String port = objectNames.iterator().next().getKeyProperty("port");
        String addr = host + ":" + port;
        return addr;
    }
}
