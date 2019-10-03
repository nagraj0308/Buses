package com.nagraj.buses;

import java.util.List;

public class InterfaceClass {
    public interface ForModel{
        interface OnFinishedListener {


            void setRoutesData(List<Route> data);

        }

       void doSomething(OnFinishedListener onFinishedListener);

    }
    public interface ForPresenter{
        void getRoutesData();

    }
    public interface ForView{
        void getObject(List<Route> routes);


    }
}
