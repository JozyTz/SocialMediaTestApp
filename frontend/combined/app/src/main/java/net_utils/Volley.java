package net_utils;
import org.json.JSONArray;
import org.json.JSONException;

public interface Volley {
    public void onSuccess(java.lang.String s) throws JSONException;
    public void onSuccess(JSONArray arr) throws JSONException;
    public void onError(java.lang.String s);
}
