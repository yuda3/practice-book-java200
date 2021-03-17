package ridibooks.java200.chapter04;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        JSONObject jCPSite = new JSONObject();
        String jsonArrStr = "[ { \"no\": \"1\", \"Name\": \"Fargo Chan\" },{ \"no\": \"3\", \"Name\": \"Aaron Luke\" },{ \"no\": \"2\", \"Name\": \"Dilip Singh\" }]";
        String jsonArrStr1 = "[ { \"no\": 5, \"Name\": \"Fargo Chan\" },{ \"no\": 4, \"Name\": \"Aaron Luke\" },{ \"no\": 2, \"Name\": \"Dilip Singh\" }]";
        JSONParser jsonParser = new JSONParser();
        Object object = null;
        object = jsonParser.parse(jsonArrStr1);
        JSONArray jsonArr = (JSONArray) object;
        List<JSONObject> jsonValues = jABranchSort(jsonArr);
        System.out.println(jsonValues);
    }
    private static List<JSONObject> jABranchSort(JSONArray jABranch) {

        List<JSONObject> jsonValues = new ArrayList<>();
        for (Object aBranch : jABranch) {
            jsonValues.add((JSONObject) aBranch);
        }
        jsonValues.sort(new Comparator<>() {
            private static final String KEY_NAME = "no";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Long valA = 0L;
                Long valB = 0L;
                valA = (Long) a.get(KEY_NAME);
                valB = (Long) b.get(KEY_NAME);
                return valA.compareTo(valB);
            }
        });
        return jsonValues;
    }

    private static List<JSONObject> jABranchSort2(JSONArray jABranch) {

        List<JSONObject> jsonValues = new ArrayList<>();
        for (Object aBranch : jABranch) {
            jsonValues.add((JSONObject) aBranch);
        }
        jsonValues.sort(new Comparator<>() {
            private static final String KEY_NAME = "areaCode";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Long valA = 0L;
                Long valB = 0L;
                valA = (Long) a.get(KEY_NAME);
                valB = (Long) b.get(KEY_NAME);
                return valA.compareTo(valB);
            }
        });
        return jsonValues;
    }
    private List<JSONObject> jLoginInfoSort(JSONArray jALoginInFos) {
        List<JSONObject> jsonValues = new ArrayList<>();
        for (Object jALoginInFo : jALoginInFos) {
            jsonValues.add((JSONObject) jALoginInFo);
        }
        jsonValues.sort(new Comparator<>() {
            private static final String KEY_NAME = "no";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Long valA;
                Long valB;
                valA = (Long) a.get(KEY_NAME);
                valB = (Long) b.get(KEY_NAME);
                return valA.compareTo(valB);
            }
        });
        return jsonValues;
    }
}
