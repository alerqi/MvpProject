package com.common.base.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pz on 2017/03/15.
 */

public class Student implements Parcelable {

    public Student(){}
    private String stuName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.stuName);
    }

    protected Student(Parcel in) {
        this.stuName = in.readString();
    }

    public  static  final Creator<Student> CREATOR =new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

}
