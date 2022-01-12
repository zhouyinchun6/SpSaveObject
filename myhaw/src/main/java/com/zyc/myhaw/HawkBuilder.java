package com.zyc.myhaw;

import android.content.Context;

import com.google.gson.Gson;

class HawkBuilder {

    /**
     * NEVER ever change STORAGE_TAG_DO_NOT_CHANGE and TAG_INFO.
     * It will break backward compatibility in terms of keeping previous data
     */
    private String spFileName;

    private Context context;
    private Storage cryptoStorage;
    private Converter converter;
    private Parser parser;
    private LogInterceptor logInterceptor;

    public HawkBuilder(Context context, String spFileName) {
        HawkUtils.checkNull("Context", context);

        this.context = context.getApplicationContext();
        this.spFileName = spFileName;
    }

    LogInterceptor getLogInterceptor() {
        if (logInterceptor == null) {
            logInterceptor = new LogInterceptor() {
                @Override
                public void onLog(String message) {
                    //empty implementation
                }
            };
        }
        return logInterceptor;
    }

    Storage getStorage() {
        if (cryptoStorage == null) {
            cryptoStorage = new SharedPreferencesStorage(context, spFileName);
        }
        return cryptoStorage;
    }

    Converter getConverter() {
        if (converter == null) {
            converter = new HawkConverter(getParser());
        }
        return converter;
    }

    Parser getParser() {
        if (parser == null) {
            parser = new GsonParser(new Gson());
        }
        return parser;
    }


    public Hawk build() {
        Hawk hawk = new Hawk();
        hawk.build(this);
        return hawk;
    }
}
