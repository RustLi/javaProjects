package org.lwl.designpatterns.chainofresponsibility;

import java.util.ArrayList;

public class ChainManagerClient {
    private ArrayList<Ratify> ratifies;

    public ChainManagerClient() {
        this.ratifies = new ArrayList<Ratify>();
    }

    /* 方法描述：为了展示“责任链模式”的真正的迷人之处（可扩展性），在这里构造该方法以便添加自定义的“责任人”
            *
            * @param ratify
      */
    public void addRatifys(Ratify ratify) {
        ratifies.add(ratify);
    }

    /**
     * 方法描述：执行请求
     *
     * @param request
     * @return
     */
    public Result execute(Request request) {
        ArrayList<Ratify> arrayList = new ArrayList<Ratify>();
        arrayList.addAll(ratifies);
        arrayList.add(new GroupLeader());
        arrayList.add(new Manager());
        arrayList.add(new DepartmentHeader());

        RealChain realChain = new RealChain(arrayList, request, 0);
        return realChain.proceed(request);
    }


}
