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
    public int avatar;

    public TmpUser(String name, String desp, boolean isMale, int avatar ) {
        this.desp = desp;
        this.isMale = isMale;
        this.name = name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "TmpUser{" +
                "avatar=" + avatar +
                ", name='" + name + '\'' +
                ", desp='" + desp + '\'' +
                ", isMale=" + isMale +
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

    @Bindable
    public int getAvatar(){
        return avatar;
    }
}
