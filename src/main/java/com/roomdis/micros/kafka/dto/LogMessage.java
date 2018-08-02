package com.roomdis.micros.kafka.dto;

/**
 * Created by chengsh05 on 2018-07-31.
 */
public class LogMessage {
    /*
     *服务类型，例如：IMS，BI等
     */
    private String serviceType;
    /*
     *服务器地址，IP:PORT，例如：10.130.207.221:8080
     */
    private String serverAddr;
    /*
     *日志产生的具体程序全路径
     */
    private String fullClassPath;
    /*
     *消息产生的时间
     */
    private String messageTime;
    /*
     *消息的具体内容。这个很重要，是json的字符串。兼容不同服务的消息格式。
     */
    private String content;
    /*
     *日志的级别，主要有INFO,WARN,ERROR,DEBUG等
     */
    private String level;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getFullClassPath() {
        return fullClassPath;
    }

    public void setFullClassPath(String fullClassPath) {
        this.fullClassPath = fullClassPath;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
