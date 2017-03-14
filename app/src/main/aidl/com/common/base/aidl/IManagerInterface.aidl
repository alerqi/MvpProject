// IManagerInterface.aidl
package com.common.base.aidl;

// Declare any non-default types here with import statements
import com.common.base.aidl.Student;
interface IManagerInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

      String sayHello();
      Student getStudent();
}
