package com.wzd.androidframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wolf.android.app.BaseActivity;
import com.wolf.android.http.OkHttpUtils;
import com.wolf.android.http.callback.StringCallback;
import com.wolf.android.tools.GsonUtil;
import com.wzd.androidframe.Setting.URLSetting;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends BaseActivity {

    private TextView mResultTv;

    @Override
    protected void initComponent() {
        mResultTv = (TextView) findViewById(R.id.http_result_tv);
    }

    @Override
    protected void initData() {
//        OkHttpUtils.get().url(URLSetting.baseApiUrl + "open/adverpic/getadverpicList/1/10").build().execute(new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//                Log.i("test", response);
//                mResultTv.setText(response);
//            }
//        });
        List<Person> persons = new ArrayList<Person>();
        Person person = new Person("wezadsfasd", 26);
        persons.add(person);
        persons.add(person);
        persons.add(person);
        persons.add(person);
        PersonList personList = new PersonList(persons);

        String personStr = GsonUtil.jsonString(personList);
        String personsStr = GsonUtil.jsonString(persons);
//        mResultTv.append(personStr + "\n");
        mResultTv.append(personsStr + "\n");
        PersonList personList1 = GsonUtil.jsonToBean(personStr, PersonList.class);
        mResultTv.append(personList1.toString() + "\n");
        List<Person> persons1 = personList1.getPersons();
        mResultTv.append(persons1.toString() + "\n");
        for (int i = 0; i < persons1.size(); i++) {
            mResultTv.append("name: " + persons1.get(i).getName() + "; age: " + persons1.get(i).getAge() + "\n");
        }
    }

    @Override
    protected int getMainContentViewId() {
        return R.layout.activity_main;
    }

    private class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private class PersonList {
        private List<Person> persons;

        public PersonList(List<Person> persons) {
            this.persons = persons;
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }

        @Override
        public String toString() {
            return "PersonList{" +
                    "persons=" + persons +
                    '}';
        }
    }
}
