package jp.co.veritrans.airweb.mdk.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 決済結果を保持するBean
 */
public final class ResultsList {

    /**
     * 自身のクラス
     */
    private static ResultsList resultsList = new ResultsList();

    /**
     * 決済結果を格納するマップ
     */
    private final Map<String, Map<String, String>> list = new HashMap<String, Map<String, String>>();

    /**
     * 外部からインスタンス生成を禁止する
     *
     */
    private ResultsList() {
    }

    /**
     * インスタンスを返す
     *
     * @return インスタンス
     */
    public static ResultsList getInstance() {
        return resultsList;
    }

    /**
     * 決済結果を設定する
     *
     * @param key オーダーID
     * @param result 決済結果を格納したマップ
     */
    public void setResult(final String key, final Map<String, String> result) {
        list.put(key, result);
    }

    /**
     * 決済結果を取得する
     *
     * @param key オーダーID
     * @return 決済結果を格納したマップ
     */
    public Map<String, String> getResult(final String key) {
        return list.get(key);
    }

    /**
     * 決済結果を格納したマップを取得する
     *
     * @return 決済結果を格納したマップ
     */
    public Map<String, Map<String, String>> getResultList() {
        return list;
    }

}