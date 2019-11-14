package com.kp.utils;

import java.util.List;

/**
 * @author 1034683568@qq.com
 * @project_name ssm-maven
 * @date 2017-3-1
 */
public class Common {

    public static boolean isEmpty(List<String> noCacheMethod) {
        if (noCacheMethod == null || noCacheMethod.size() < 1)
            return true;
        return false;
    }

    public static boolean isEmpty(Object[] args) {
        if (args == null || args.length < 1)
            return true;
        return false;
    }

    public static boolean isCUR(Integer i) {
        if (i == null && i <= 0) {
            return false;
        } else if (i == 1) {
            return true;
        } else if (i > 1) {
            return false;
        }
        return false;
    }

    public static boolean isDelete(Integer i) {
        if (i == null && i <= 0) {
            return false;
        } else if (i >= 1) {
            return true;
        }
        return false;
    }
}
