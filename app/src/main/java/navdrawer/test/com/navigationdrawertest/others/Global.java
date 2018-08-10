package navdrawer.test.com.navigationdrawertest.others;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

/**
 * Created by touchstone on 9/29/2016.
 */

public class Global extends MultiDexApplication {

    private String nameOfNgo;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void setNameOfNgo(String nameOfNgo) {
        this.nameOfNgo = nameOfNgo;
    }

    public String getNameOfNgo() {
        return nameOfNgo;
    }
}
