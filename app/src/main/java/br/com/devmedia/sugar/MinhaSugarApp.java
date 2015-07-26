package br.com.devmedia.sugar;

import com.orm.SugarContext;

public class MinhaSugarApp extends OutraAppClasse {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}
