package jp.co.veritrans.airweb.mdk.bean;

import java.io.Serializable;

/**
 * 暗号鍵を保持するBean
 */
public class EncryptionKey implements Serializable {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = -3719609333242086786L;

    /**
     * マーチャント暗号鍵
     */
    private String merchantEncryptionKey;

    /**
     * ブラウザ暗号鍵
     */
    private String browserEncryptionKey;

    /**
     * エラーメッセージ
     */
    private String errorMessage;

    /**
     * コンストラクタ
     */
    public EncryptionKey() {
    }

    /**
     * merchantEncryptionKeyの取得
     * 
     * @return the merchantEncryptionKey of String
     */
    public String getMerchantEncryptionKey() {
        return merchantEncryptionKey;
    }

    /**
     * merchantEncryptionKeyの設定
     * 
     * @param merchantEncryptionKey the
     *            merchantEncryptionKey to set
     */
    public void setMerchantEncryptionKey(String merchantEncryptionKey) {
        this.merchantEncryptionKey = merchantEncryptionKey;
    }

    /**
     * browserEncryptionKeyの取得
     * 
     * @return the browserEncryptionKey of String
     */
    public String getBrowserEncryptionKey() {
        return browserEncryptionKey;
    }

    /**
     * browserEncryptionKeyの設定
     * 
     * @param browserEncryptionKey the browserEncryptionKey
     *            to set
     */
    public void setBrowserEncryptionKey(String browserEncryptionKey) {
        this.browserEncryptionKey = browserEncryptionKey;
    }

    /**
     * errorMessageの取得
     * 
     * @return the errorMessage of String
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * errorMessageの設定
     * 
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
