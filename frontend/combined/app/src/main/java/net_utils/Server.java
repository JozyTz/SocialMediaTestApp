package net_utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public interface Server {
    public void sendToServer(String url, JSONObject newUserObj, String methodType) throws JSONException;
    public void sendToServer(String url, JSONArray newUserArray, String methodType) throws JSONException;
    public void sendToServer(String url, JSONArray newUserArray, String methodType, net_utils.Volley listener) throws JSONException;
    public void addVolleyListener(net_utils.Volley logic);
}
