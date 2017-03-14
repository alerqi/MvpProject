package com.common.base.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by pz on 2017/03/15.
 */

public class StudentService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyBinder extends IManagerInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String sayHello() throws RemoteException {
            return  "hell everyone";
        }

        @Override
        public Student getStudent() throws RemoteException {
            return new Student();
        }
    }


}
