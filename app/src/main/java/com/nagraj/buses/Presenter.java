package com.nagraj.buses;

import java.util.List;

public  class Presenter implements InterfaceClass.ForPresenter,InterfaceClass.ForModel.OnFinishedListener {
    ModelActivity modelActivity;
    InterfaceClass.ForView viewInterface;
    InterfaceClass.ForModel modelView;

    public Presenter(InterfaceClass.ForView viewInterface) {
        this.viewInterface = viewInterface;
        modelView = new ModelActivity();
    }
    @Override
    public void getRoutesData(){
        modelView.doSomething(this);

    }
    @Override
   public void setRoutesData(List<Route> data){
        viewInterface.getObject(data);


    }

}
