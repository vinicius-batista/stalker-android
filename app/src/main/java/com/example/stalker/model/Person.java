package com.example.stalker.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String firstName;
    private String lastName;
    private String job;
    private String description;
    private int age;
    private String birthday;
    private String phone;

    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        job = in.readString();
        description = in.readString();
        age = in.readInt();
        birthday = in.readString();
        phone = in.readString();
    }

    public Person(String firstName, String lastName, String job, String description, int age, String birthday, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.description = description;
        this.age = age;
        this.birthday = birthday;
        this.phone = phone;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(job);
        dest.writeString(description);
        dest.writeInt(age);
        dest.writeString(birthday);
        dest.writeString(phone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
