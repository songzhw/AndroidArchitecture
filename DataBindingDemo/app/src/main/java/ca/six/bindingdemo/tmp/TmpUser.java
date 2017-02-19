package ca.six.bindingdemo.tmp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import ca.six.bindingdemo.BR;

/**
 * Created by songzhw on 2017-02-18
 */

public class TmpUser extends BaseObservable {
    public String name;
    public String desp;
    public boolean isMale;

    public TmpUser(String name, String desp, boolean isMale) {
        this.desp = desp;
        this.isMale = isMale;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TmpUser{" +
                "desp='" + desp + '\'' +
                ", name='" + name + '\'' +
                ", isMale=" +  (isMale ? "Male" : "Female") +
                '}';
    }

    public void setDesp(String desp) {
        this.desp = desp;
        notifyPropertyChanged(BR.desp);
    }

    public void setIsMale(boolean male) {
        isMale = male;
        notifyPropertyChanged(BR.male);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDesp() {
        return desp;
    }

    @Bindable
    public boolean isMale() {
        return isMale;
    }

    @Bindable
    public String getName() {
        return name;
    }
}
