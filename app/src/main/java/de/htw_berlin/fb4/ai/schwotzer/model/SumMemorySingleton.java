package de.htw_berlin.fb4.ai.schwotzer.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SumMemorySingleton implements SumMemory {
    private static final String SUM_KEY = "sumKey";
    private static SumMemory instance;
    private static Context ctx;
    private static final String FILENAME = "sumMemory";

    private SumMemorySingleton() {}

    public static SumMemory getSumMemoryInstance(Context ctx) {
        if(SumMemorySingleton.instance == null) {
            SumMemorySingleton.instance = new SumMemorySingleton();
        }

        SumMemorySingleton.ctx = ctx;

        return SumMemorySingleton.instance;
    }

    @Override
    public void save(int sum) {
        SharedPreferences sharedPreferences =
                ctx.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPreferences.edit();

        edit.putInt(SUM_KEY, sum);

        edit.commit();
    }

    @Override
    public int restore() {
        SharedPreferences sharedPreferences =
                ctx.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);

        return sharedPreferences.getInt(SUM_KEY, 0);
    }
}
