package com.qilin.cms.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.util.Map;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Created by gaohaiqing on 16-11-2.
 */
@BTrace
public class HelloWorld {

    @OnMethod(clazz = "", method = "")
    public static void hello(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,
                             @Self Object self, int newCapacity){
        println("成功进入"+ probeMethod +"方法了");
        String point = BTraceUtils.Strings.strcat(BTraceUtils.Strings.strcat(probeClass, "."), probeMethod);
        Class clazz = classForName("java.util.HashMap");

        Map.Entry[] table = (Map.Entry[])get(field(clazz,"table",true),self);
    }
}
