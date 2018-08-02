package com.roomdis.micros.kafka.common;

/**
 * Created by chengsh05 on 2018-07-31.
 */
public enum EServiceType {
    IMS("ims"),
    WEIBAO_BI("weibaobi"),WEIBAO_AI("weibaoai"), WEIBAO_DL("weibaodl"),
    GENERAL_BI("generalbi"),GENERAL_AI("generalai"),GENERAL_DL("generaldl"),
    KDB("robotkdb"),
    CSS_PRODUCER("cssproducer"),CSS_CONSUMER("cssconsumer");

    String service;
    EServiceType(String svr){
        this.service = svr;
    }
}
