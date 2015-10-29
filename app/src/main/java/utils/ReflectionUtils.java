package utils;

import java.lang.reflect.Field;

/**
 * Created by yanglinjie on 2015/7/20.
 */
public class ReflectionUtils {
    public static Object getInstance(Class c, String... args) {
        try {
            Object object = Class.forName(c.getName()).newInstance();
            Class<?> obj = object.getClass();
            Field[] fields = obj.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                for (int j = 0; j < args.length; j++) {
                    String str = args[j];
                    String strs[] = str.split(",");
                    if (strs[0].equals(fields[i].getName())) {
                        fields[i].set(object, strs[1]);
                        break;
                    }
                }
            }
            return object;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
