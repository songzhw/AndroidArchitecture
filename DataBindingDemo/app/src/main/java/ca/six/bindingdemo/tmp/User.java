package ca.six.bindingdemo.tmp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import ca.six.bindingdemo.BR;

/**
 * Created by songzhw on 2017-02-18
 */

public class User extends BaseObservable {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> desp = new ObservableField<>();
    public ObservableBoolean isMale = new ObservableBoolean();
    public ObservableInt avatar = new ObservableInt();

    public User(String name, String desp, boolean isMale, int avatar) {
        this.desp.set(desp);
        this.isMale.set(isMale);
        this.name.set(name);
        this.avatar.set(avatar);
    }

    @Override
    public String toString() {
        return "TmpUser{" +
                "name=" + name.get() +
                ", desp=" + desp.get() +
                ", isMale=" + isMale.get() +
                ", avatar=" + avatar.get() +
                '}';
    }
}



//public class User extends BaseObservable {
//    public String name;
//    public String desp;
//    public boolean isMale;
//    public int avatar;
//
//    public User(String name, String desp, boolean isMale, int avatar ) {
//        this.desp = desp;
//        this.isMale = isMale;
//        this.name = name;
//        this.avatar = avatar;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "avatar=" + avatar +
//                ", name='" + name + '\'' +
//                ", desp='" + desp + '\'' +
//                ", isMale=" + isMale +
//                '}';
//    }
//
//    public void setDesp(String desp) {
//        this.desp = desp;
//        notifyPropertyChanged(BR.desp);
//    }
//
//    public void setIsMale(boolean male) {
//        isMale = male;
//        notifyPropertyChanged(BR.male);
//    }
//
//    public void setName(String name) {
//        this.name = name;
//        notifyPropertyChanged(BR.name);
//    }
//
//    @Bindable
//    public String getDesp() {
//        return desp;
//    }
//
//    @Bindable
//    public boolean isMale() {
//        return isMale;
//    }
//
//    @Bindable
//    public String getName() {
//        return name;
//    }
//
//    @Bindable
//    public int getAvatar(){
//        return avatar;
//    }
//}
