package jp.co.veritrans.airweb.mdk.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * マーチャント側暗号鍵を保持するBaen
 */
public final class EncryptKeyBox {

    /**
     * 自身のクラス
     */
    private static EncryptKeyBox keyBox = new EncryptKeyBox();

    /**
     * 暗号鍵を格納するマップ
     */
    private Map box = new HashMap();

    /**
     * 外部からインスタンス生成を禁止する
     * 
     */
    private EncryptKeyBox() {
    }

    /**
     * インスタンスを返す
     * 
     * @return インスタンス
     */
    public static EncryptKeyBox getInstance() {
        return keyBox;
    }

    /**
     * 暗号鍵を設定する
     * 
     * @param key オーダーID
     * @param databox 暗号鍵を格納したマップ
     */
    public void setBox(String key, Map databox) {
        box.put(key, databox);
    }

    /**
     * 暗号鍵を取得する
     * 
     * @param key オーダーID
     * @return 暗号鍵を格納したマップ
     */
    public Map getBox(String key) {
        return (Map)box.get(key);
    }

    /**
     * 暗号鍵を格納したマップを取得する
     * 
     * @return 暗号鍵を格納したマップ
     */
    public Map getBox() {
        return box;
    }

}